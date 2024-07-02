package com.polenta.core.executor.impl;

import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;
import com.polenta.core.object.behavior.Alterable;
import com.polenta.core.store.Store;

import java.util.Map;

public class AlterExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		try {
			((Alterable)Store.getInstance().get(null)).alter(null);;
		} catch (ClassCastException e) {
			throw new InvalidStatementException("ALTER is not supported by this object type.");
		}
		
		return success();
	}
	
}
