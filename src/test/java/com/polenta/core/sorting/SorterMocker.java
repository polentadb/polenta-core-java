package com.polenta.core.sorting;

import com.polenta.core.data.IntegerValue;
import com.polenta.core.data.Row;
import com.polenta.core.data.StringValue;

import java.util.ArrayList;
import java.util.List;

public class SorterMocker {

	public static List<Row> mockSetOfNames() {
		List<Row> unsortedRows = new ArrayList<>();
		
		Row row1 = new Row();
		row1.set("name", new StringValue("Z"));
		unsortedRows.add(row1);
		
		Row row2 = new Row();
		row2.set("name", new StringValue("A"));
		unsortedRows.add(row2);

		Row row3 = new Row();
		row3.set("name", new StringValue("C"));
		unsortedRows.add(row3);

		Row row4 = new Row();
		row4.set("name", new StringValue("T"));
		unsortedRows.add(row4);

		Row row5 = new Row();
		row5.set("name", new StringValue("M"));
		unsortedRows.add(row5);

		return unsortedRows;
	}

	public static List<Row> mockSetOfIDs() {
		List<Row> unsortedRows = new ArrayList<>();
		
		Row row1 = new Row();
		row1.set("id", new IntegerValue(1));
		unsortedRows.add(row1);
		
		Row row2 = new Row();
		row2.set("id", new IntegerValue(10));
		unsortedRows.add(row2);

		Row row3 = new Row();
		row3.set("id", new IntegerValue(3));
		unsortedRows.add(row3);

		Row row4 = new Row();
		row4.set("id", new IntegerValue(5));
		unsortedRows.add(row4);

		Row row5 = new Row();
		row5.set("id", new IntegerValue(7));
		unsortedRows.add(row5);

		Row row6 = new Row();
		row6.set("id", new IntegerValue(8));
		unsortedRows.add(row6);

		Row row7 = new Row();
		row7.set("id", new IntegerValue(6));
		unsortedRows.add(row7);

		Row row8 = new Row();
		row8.set("id", new IntegerValue(4));
		unsortedRows.add(row8);

		Row row9 = new Row();
		row9.set("id", new IntegerValue(9));
		unsortedRows.add(row9);

		Row row10 = new Row();
		row10.set("id", new IntegerValue(2));
		unsortedRows.add(row10);
		
		return unsortedRows;
	}

}
