package com.polenta.core.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Row {
	
	private Map<String, Value> columns = new LinkedHashMap<>();

	public Row() {}

	public Row(Map<String, Value> columns) {
		this.columns.putAll(columns);
	}
	
	public void set(String column, Value value) {
		columns.put(column, value);
	}
	
	public Value get(String column) {
		return columns.get(column);
	}

	public Map<String, Value> asMap() {
		return columns;
	}
	
}
