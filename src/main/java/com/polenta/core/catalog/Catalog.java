package com.polenta.core.catalog;

import com.polenta.core.exception.ObjectAlreadyExistsException;
import com.polenta.core.exception.PolentaException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Catalog {
	
	private Catalog() {
		
	}
	
	private static Catalog INSTANCE = new Catalog();
	
	public static Catalog getInstance() {
		return INSTANCE;
	}
	
	private Map<String, CatalogItem> items = new LinkedHashMap<String, CatalogItem>();
	
	public boolean contains(String objectName) {
		return items.containsKey(objectName);
	}

	public void add(CatalogItem item) throws PolentaException {
		if (items.containsKey(item.getName())) {
			throw new ObjectAlreadyExistsException("Polenta catalog already has an object with name " + item.getName().toUpperCase() + ".");
		} else {
			items.put(item.getName(), item);
		}
	}
	
	public CatalogItem get(String name) {
		return items.get(name);
	}

	public void remove(String name) {
		items.remove(name);
	}
	
}
