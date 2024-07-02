package com.polenta.core.executor.impl;

import com.polenta.core.catalog.Catalog;
import com.polenta.core.catalog.CatalogItem;
import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;
import com.polenta.core.object.behavior.Deletable;
import com.polenta.core.store.Store;

import java.util.Map;

public class DeleteExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		String objectName;
		try {
			objectName = statement.trim().toUpperCase().split(" ")[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidStatementException("Object name must be defined on DELETE statement.");
		}
		
		CatalogItem catalogItem = Catalog.getInstance().get(objectName);  

		if (catalogItem == null) {
			throw new InvalidStatementException("Object does not exist.");
		}

		try {
			((Deletable)Store.getInstance().get(objectName)).delete(null);
		} catch (ClassCastException e) {
			throw new InvalidStatementException("DELETE is not supported by this object type.");
		}
		
		return success();
	}

}
