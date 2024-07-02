package com.polenta.core.catalog;

import com.polenta.core.data.DataType;
import com.polenta.core.object.ObjectType;

import java.util.LinkedHashMap;
import java.util.Map;

public class CatalogItem {

	private String name;
	private ObjectType type;
	private Map<String, DataType> definitions;
	
	public CatalogItem(String name, ObjectType type) {
		this.name = name.toUpperCase();
		this.type = type;
		this.definitions = new LinkedHashMap<String, DataType>();
	}

	public CatalogItem(ObjectType type, String name, Map<String, DataType> _definitions) {
		this.name = name;
		this.type = type;
		this.definitions = new LinkedHashMap<String, DataType>();
		this.definitions.putAll(_definitions);
	}

	public String getName() {
		return name;
	}

	public ObjectType getType() {
		return type;
	}
	
	public void addDefinitionKey(String key, DataType value) {
		definitions.put(key.toUpperCase(), value);
	}
	
	public boolean hasDefinitionKey(String key) {
		return definitions.containsKey(key.toUpperCase());
	}
	
	public DataType getDefinitionValue(String key) {
		return definitions.get(key);
	}
	
}
