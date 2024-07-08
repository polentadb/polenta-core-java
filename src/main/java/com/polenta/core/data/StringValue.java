package com.polenta.core.data;

import com.polenta.core.exception.PolentaException;

public class StringValue implements Value<String> {

  private String value;

  public StringValue(String value) {
    this.value = value;
  }

  public static Value instance(String value) throws PolentaException {
    return new StringValue(value.substring(1, value.length() - 1));
  }

  @Override
  public String value() {
    return value;
  }

  public int compareTo(Value other) throws PolentaException {
    if (other == null) {
      return 1;
    }
    if (!other.getClass().isAssignableFrom(StringValue.class)) {
      throw new PolentaException("Objects of different types cannot be compared.");
    }
    StringValue typedOther = (StringValue)other;
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
