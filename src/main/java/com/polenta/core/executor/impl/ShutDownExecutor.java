package com.polenta.core.executor.impl;

//import com.polenta.core.Polenta;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;

import java.util.Map;

public class ShutDownExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		//Polenta.shutdown();
		return success();
	}
	
}
