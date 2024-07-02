package com.polenta.core.sorting.impl;

import com.polenta.core.data.Row;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.sorting.Sorter;

import java.util.List;

public class ShellSorter extends Sorter {

	public List<Row> sort(List<Row> list, String criteria) throws PolentaException {
		int h = 1;
		while (h < (list.size() / 3)) { 
			h = (h * 3) + 1;
		}
		while (h >= 1) {
			for (int i = h; i < list.size(); i++) {
				for (int j = i; j >= h && (compare(list.get(j), list.get(j - h), criteria) < 0); j = j - h) {
					exchange(list, j, j -h);
				}
			}
			h = h / 3;
		}
		
		
		return list;
	}

}
