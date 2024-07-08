package com.polenta.core.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultSet {

	private List<String> fields;
	private List<Map<String, Value>> rows;

	public ResultSet(List<String> fields, List<Row> rows) {
		this.fields = new LinkedList<>();
		this.fields.addAll(fields);
		
		this.rows = new LinkedList<>();
		this.rows.addAll(rows.stream().map(row -> row.asMap()).collect(Collectors.toList())); 
	}

	public List<String> getFields() {
		return fields;
	}

	public List<Map<String, Value>> getRows() {
		return rows;
	}
	
}
