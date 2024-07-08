package com.polenta.core.data;

import com.polenta.core.exception.PolentaException;

public enum DataType {
	
	STRING, DATE , INTEGER, FLOAT;
	
	public Value convert(String value) throws PolentaException {
		switch (this) {
		case STRING:
			return StringValue.instance(value);
		case DATE:
			return DateValue.instance(value);
		case INTEGER:
			return IntegerValue.instance(value);
		case FLOAT:
			return FloatValue.instance(value);
		default:
			throw new PolentaException("Polenta could not find a type converter");
		}
	}

}
