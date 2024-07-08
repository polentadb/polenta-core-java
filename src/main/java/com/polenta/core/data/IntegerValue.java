package com.polenta.core.data;

import com.polenta.core.exception.DataConvertionException;
import com.polenta.core.exception.PolentaException;

public class IntegerValue implements Value<Integer> {

  private Integer value;

  public IntegerValue(Integer value) {
    this.value = value;
  }

  public static Value instance(String value) throws PolentaException {
    try {
      var convertedValue = Integer.parseInt(value);
      return new IntegerValue(convertedValue);
    } catch (Exception e) {
      throw new DataConvertionException("Error converting string to integer");
    }
  }

  @Override
  public Integer value() {
    return value;
  }

  public int compareTo(Value other) throws PolentaException {
    if (other == null) {
      return 0;
    }
    if (!other.getClass().isAssignableFrom(IntegerValue.class)) {
      throw new PolentaException("Objects of different types cannot be compared.");
    }
    IntegerValue typedOther = (IntegerValue)other;
    if (this.value.equals(typedOther.value)) {
      return 0;
    }
    return this.value.compareTo(typedOther.value);
  }

  @Override
  public String toString() {
    return value.toString();
  }

}
