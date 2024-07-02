package com.polenta.core.sorting.impl;

import com.polenta.core.data.Row;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.sorting.Sorter;

import java.util.List;

public class SelectionSorter extends Sorter {

	public List<Row> sort(List<Row> list, String criteria) throws PolentaException {
		for (int i = 0; i < list.size(); i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (compare(list.get(j), list.get(min), criteria) < 0) {
					min = j;
				}
			}
			exchange(list, i, min);
		}
		return list;
	}
	
	

}
