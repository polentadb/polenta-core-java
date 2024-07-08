package com.polenta.core.data;

import com.polenta.core.exception.DataConvertionException;
import com.polenta.core.exception.PolentaException;

public class FloatValue implements Value<Float> {

  private Float value;

  public FloatValue(Float value) {
    this.value = value;
  }

  public static Value instance(String value) throws PolentaException {
    try {
      var convertedValue = Float.parseFloat(value);
      return new FloatValue(convertedValue);
    } catch (Exception e) {
      throw new DataConvertionException("Error converting string to double");
    }
  }

  @Override
  public Float value() {
    return value;
  }

  public int compareTo(Value other) throws PolentaException {
    if (other == null) {
      return 0;
    }
    if (!other.getClass().isAssignableFrom(FloatValue.class)) {
      throw new PolentaException("Objects of different types cannot be compared.");
    }
    FloatValue typedOther = (FloatValue)other;
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
