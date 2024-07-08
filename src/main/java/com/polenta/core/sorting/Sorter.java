package com.polenta.core.sorting;

import com.polenta.core.data.Row;
import com.polenta.core.data.Value;
import com.polenta.core.exception.PolentaException;

import java.util.List;

public abstract class Sorter {
	
	public abstract List<Row> sort(List<Row> unsorted, String criteria) throws PolentaException;
	
	protected int compare(Row map1, Row map2, String criteria) throws PolentaException {
		//for now only one field is supported
		var field = criteria.split(" ")[0];
		String direction;
		try {
			direction = criteria.split(" ")[1];
		} catch (Exception e) {
			direction = "ASC";
		}
		var compare = compareObjects(map1.get(field), map2.get(field));
		if (direction.equalsIgnoreCase("DESC")) {
			compare = compare * -1;
		}
		return compare;
	}
	
	public int compareObjects(Value object1, Value object2) throws PolentaException {
		if (object1 == null) {
			if (object2 == null) {
				return 0;
			} else {
				return -1;
			}
		}
		return object1.compareTo(object2);
	}
	
	protected void exchange(List<Row> list, int a, int b) {
		var mapA = list.get(a);
		var mapB = list.get(b);
		list.set(a, mapB);
		list.set(b, mapA);
	}
	
}
