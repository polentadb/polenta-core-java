package com.polenta.core.store;

import com.polenta.core.catalog.Catalog;
import com.polenta.core.catalog.CatalogItem;
import com.polenta.core.data.DataType;
import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.object.ObjectType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Store {

	private Map<String, Storable> store = new LinkedHashMap<String, Storable>();
	
	private static Store INSTANCE = new Store();
	
	public static Store getInstance() {
		return INSTANCE;
	}
	
	private Store() {
		
	}

	public synchronized Storable add(ObjectType type, String name) throws PolentaException {
		return add(type, name, null);
	}

	public synchronized Storable add(ObjectType type, String name, Map<String, DataType> fields) throws PolentaException {
		Storable storable = type.create();
		store.put(name, storable);
		
		CatalogItem catalogItem = new CatalogItem(type, name, fields);
		Catalog.getInstance().add(catalogItem);
		
		return storable;
	}
	
	public synchronized void remove(String name) throws PolentaException {
		CatalogItem catalogItem = Catalog.getInstance().get(name);  

		if (catalogItem == null) {
			throw new InvalidStatementException("Object does not exist.");
		}
		
		Catalog.getInstance().remove(name);
		this.store.remove(name);
	}
	
	public Storable get(String name) {
		return store.get(name);
	}

}
