package com.polenta.core.object.behavior;

import com.polenta.core.data.ResultSet;
import com.polenta.core.data.Value;
import com.polenta.core.exception.PolentaException;

import java.util.List;
import java.util.Map;

public interface Selectable {

	public ResultSet select(List<String> selectFields, Map<String, Value> whereConditions, List<String> orderByFields) throws PolentaException;
	
}
