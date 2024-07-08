package com.polenta.core.sorting.impl;

import com.polenta.core.data.Row;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.sorting.SorterMocker;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopDownMergeSorterTest extends TopDownMergeSorter {
	
	@Test
	public void testSort1() throws PolentaException {
		List<Row> unsortedRows = SorterMocker.mockSetOfNames();
		
		List<Row> sorted = sort(unsortedRows, "name desc");
		assertEquals(unsortedRows.size(), sorted.size());
		assertEquals("Z", sorted.get(0).get("name").value());
		assertEquals("T", sorted.get(1).get("name").value());
		assertEquals("M", sorted.get(2).get("name").value());
		assertEquals("C", sorted.get(3).get("name").value());
		assertEquals("A", sorted.get(4).get("name").value());
		
	}
	
	@Test
	public void testSort2() throws PolentaException {
		List<Row> unsortedRows = SorterMocker.mockSetOfIDs();

		List<Row> sorted = sort(unsortedRows, "id");
		assertEquals(unsortedRows.size(), sorted.size());
		for (int i = 1; i <= 10; i++) {
			assertEquals(i, sorted.get(i - 1).get("id").value());
		}
	}

}
