package com.polenta.core.data;

import com.polenta.core.exception.DataConvertionException;
import com.polenta.core.exception.PolentaException;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DataType {
	
	STRING, DATE , INTEGER, DOUBLE;
	
	public Object convert(String value) throws PolentaException {
		switch (this) {
		case STRING:
			return convertString(value);
		case DATE:
			return convertDate(value);
		case INTEGER:
			return convertInteger(value);
		case DOUBLE:
			return convertDouble(value);
		default:
			throw new PolentaException("Polenta could not find a type converter");
		}
	}

	static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
	
	protected Object convertString(String value) throws PolentaException {
		return value.substring(1, value.length() - 1);
	}

	protected Object convertInteger(String value) throws PolentaException {
		try {
			Integer convertedValue = Integer.parseInt(value);
			return convertedValue;
		} catch (Exception e) {
			throw new DataConvertionException("Error converting string to integer");
		}
	}

	protected Object convertDouble(String value) throws PolentaException {
		try {
			Double convertedValue = Double.parseDouble(value);
			return convertedValue;
		} catch (Exception e) {
			throw new DataConvertionException("Error converting string to double");
		}
	}

	protected Object convertDate(String value) throws PolentaException {
		try {
			Date convertedValue = DATE_FORMATTER.parse(value);
			return convertedValue;
		} catch (Exception e) {
			throw new DataConvertionException("Error converting string to date");
		}
	}

}
