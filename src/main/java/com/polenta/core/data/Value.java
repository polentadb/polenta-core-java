package com.polenta.core.data;

import com.polenta.core.exception.PolentaException;

public interface Value<T> {

  public T value();

  int compareTo(Value other) throws PolentaException;

}
