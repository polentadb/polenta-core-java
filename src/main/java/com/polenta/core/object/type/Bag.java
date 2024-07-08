package com.polenta.core.object.type;

import com.polenta.core.data.ResultSet;
import com.polenta.core.data.Row;
import com.polenta.core.data.Value;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.object.behavior.Insertable;
import com.polenta.core.object.behavior.Selectable;
import com.polenta.core.sorting.SortingExecutor;
import com.polenta.core.store.Storable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bag implements Insertable, Selectable, Storable {
	
	private Map<Integer, Row> rows = new LinkedHashMap<>();
	
	public ResultSet select(List<String> selectFields, Map<String, Value> whereConditions, List<String> orderByFields) throws PolentaException {
		//missing: validate if fields used on all clauses are valid to this bag
		List<Row> filteredRows = filterRows(this.rows, whereConditions);
		
		ResultSet resultSet;
		if (orderByFields != null && !orderByFields.isEmpty()) {
			List<Row> orderedRows = SortingExecutor.sort(filteredRows, orderByFields.get(0));
			resultSet = new ResultSet(selectFields, orderedRows);
		} else {
			resultSet = new ResultSet(selectFields, filteredRows);
		}

		return resultSet;
	}
	
	protected List<Row> filterRows(Map<Integer, Row> allRows, Map<String, Value> whereConditions) {
		List<Row> filteredRows = new ArrayList<>();
		filteredRows.addAll(allRows.values());
		return filteredRows;
	}

	public synchronized void insert(Row row) {
		rows.put(rows.size() + 1, row);
	}

}
