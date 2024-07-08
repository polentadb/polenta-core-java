package com.polenta.core.executor.impl;

import com.polenta.core.catalog.Catalog;
import com.polenta.core.catalog.CatalogItem;
import com.polenta.core.data.ResultSet;
import com.polenta.core.data.Value;
import com.polenta.core.exception.InvalidStatementException;
import com.polenta.core.exception.PolentaException;
import com.polenta.core.executor.StatementExecutor;
import com.polenta.core.object.behavior.Selectable;
import com.polenta.core.store.Store;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectExecutor implements StatementExecutor {

	public Map<String, Object> execute(String statement) throws PolentaException {
		String objectName = extractObjectName(statement);
		if (objectName == null) {
			throw new InvalidStatementException("SELECT statement must have a FROM clause");
		}
		
		CatalogItem catalogItem = Catalog.getInstance().get(objectName);  

		if (catalogItem == null) {
			throw new InvalidStatementException("Object does not exist.");
		}
		
		List<String> selectFields = extractSelectFields(statement);
		if (selectFields == null || selectFields.isEmpty()) {
			throw new InvalidStatementException("SELECT must list fields to be returned.");
		}
		
		Map<String, Value> whereConditions = extractWhereConditions();
		
		List<String> orderByFields = extractOrderByFields(statement);
		if (orderByFields.size() > 1) {
			throw new InvalidStatementException("ORDER BY does not support (yet!) more than a field.");
		}
		
		for (String orderField: orderByFields) {
			if (!selectFields.contains(orderField.split(" ")[0])) {
				throw new InvalidStatementException("Field in ORDER BY clausule needs to be listed on SELECT clausule.");
			}
		}

		ResultSet resultSet;
		
		try {
			resultSet = ((Selectable)Store.getInstance().get(objectName)).select(selectFields, whereConditions, orderByFields);
		} catch (ClassCastException e) {
			throw new InvalidStatementException("INSERT is not supported by this object type.");
		}
		
		Map<String, Object> map = success();
		map.put("FIELDS", resultSet.getFields());
		map.put("ROWS", resultSet.getRows());
		
		return map;
	}
	
	protected String extractObjectName(String statement) throws PolentaException {
		try {
			if (!statement.contains("FROM")) {
				return null;
			} else if ((!statement.contains("WHERE")) && (!statement.contains("ORDER BY"))) {
				return statement.substring(statement.indexOf("FROM") + 5).trim();
			} else if ((statement.indexOf("WHERE") > 0) && (!statement.contains("ORDER BY"))) {
				return statement.substring(statement.indexOf("FROM") + 5, statement.indexOf("WHERE")).trim();
			} else if ((!statement.contains("WHERE")) && (statement.indexOf("ORDER BY") > 0)) {
				return statement.substring(statement.indexOf("FROM") + 5, statement.indexOf("ORDER BY")).trim();
			} else if ((statement.indexOf("WHERE") > 0) && (statement.indexOf("ORDER BY") > 0)) {
				return statement.substring(statement.indexOf("FROM") + 5, statement.indexOf("WHERE")).trim();
			}
		} catch (Exception e) {
			throw new PolentaException("Polenta couldn't parse SELECT and extract object name.");
		}
		return null;
	}

	protected List<String> extractSelectFields(String statement) throws PolentaException {
		List<String> fields = new ArrayList<String>();
		try {
			String selectFields = statement.trim().substring(statement.indexOf("SELECT") + 6, statement.indexOf("FROM"));
			for (String field: selectFields.split(",")) {
				fields.add(field.trim());
			}
		} catch (Exception e) {
			throw new PolentaException("Polenta couldn't parse SELECT and extract selected fields.");
		}
		return fields;
	}

	protected Map<String, Value> extractWhereConditions() throws PolentaException {
		Map<String, Value> conditions = new LinkedHashMap<>();
		return conditions;
	}

	protected List<String> extractOrderByFields(String statement) throws PolentaException {
		List<String> fields = new ArrayList<String>();
		if (statement.indexOf("ORDER BY") == -1) {
			return fields;
		}
		try {
			String orderByFields = statement.trim().substring(statement.indexOf("ORDER BY") + 8);
			if (orderByFields == null || orderByFields.trim().length() == 0) {
				return fields;
			}
			for (String field: orderByFields.split(",")) {
				fields.add(field.trim());
			}
		} catch (Exception e) {
			throw new PolentaException("Polenta couldn't parse ORDER BY and extract selected fields.");
		}
		return fields;
	}

}
