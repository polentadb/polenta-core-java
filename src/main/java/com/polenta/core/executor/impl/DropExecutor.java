package com.polenta.core.executor.impl;

import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;
import com.polenta.core.store.Store;

import java.util.Map;

public class DropExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		String objectName;
		try {
			objectName = statement.trim().toUpperCase().split(" ")[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidStatementException("Object name must be defined on CREATE statement.");
		}

		Store.getInstance().remove(objectName);
		
		return success();
	}

}
