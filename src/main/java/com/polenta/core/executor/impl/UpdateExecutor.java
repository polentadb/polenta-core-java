package com.polenta.core.executor.impl;

import com.polenta.core.catalog.Catalog;
import com.polenta.core.catalog.CatalogItem;
import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;
import com.polenta.core.object.behavior.Updatable;
import com.polenta.core.store.Store;

import java.util.Map;

public class UpdateExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		String objectName;
		try {
			objectName = statement.trim().toUpperCase().split(" ")[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidStatementException("Object name must be defined on UPDATE statement.");
		}
		
		CatalogItem catalogItem = Catalog.getInstance().get(objectName);  

		if (catalogItem == null) {
			throw new InvalidStatementException("Object does not exist.");
		}

		try {
			((Updatable)Store.getInstance().get(objectName)).update(null, null);
		} catch (ClassCastException e) {
			throw new InvalidStatementException("UPDATE is not supported by this object type.");
		}
		
		return success();
	}

}
