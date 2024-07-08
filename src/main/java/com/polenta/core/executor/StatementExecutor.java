package com.polenta.core.executor;

import com.polenta.core.exception.PolentaException;

import java.util.HashMap;
import java.util.Map;

public interface StatementExecutor {

	Map<String, Object> execute(String statement) throws PolentaException;

	default Map<String, Object> success() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("STATUS", "SUCCESS");
		return map;
	}
	
}
