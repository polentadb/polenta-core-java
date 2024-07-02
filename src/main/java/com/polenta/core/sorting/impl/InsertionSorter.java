package com.polenta.core.sorting.impl;

import com.polenta.core.data.Row;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.sorting.Sorter;

import java.util.List;

public class InsertionSorter extends Sorter {

	public List<Row> sort(List<Row> list, String criteria) throws PolentaException {
		for (int i = 1; i < list.size(); i++) {
			for (int j = i; j > 0 && (compare(list.get(j), list.get(j - 1), criteria) < 0); j--) {
				exchange(list, j, j -1);
			}
		}
		return list;
	}

}
