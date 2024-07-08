package com.polenta.core.data;

import com.polenta.core.exception.DataConvertionException;
import com.polenta.core.exception.PolentaException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValue implements Value<Date> {

  private Date value;

  public DateValue(Date value) {
    this.value = value;
  }

  private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

  public static Value instance(String value) throws PolentaException {
    try {
      var convertedValue = DATE_FORMATTER.parse(value);
      return new DateValue(convertedValue);
    } catch (Exception e) {
      throw new DataConvertionException("Error converting string to date");
    }
  }

  @Override
  public Date value() {
    return value;
  }

  public int compareTo(Value other) throws PolentaException {
    if (other == null) {
      return 0;
    }
    if (!other.getClass().isAssignableFrom(DateValue.class)) {
      throw new PolentaException("Objects of different types cannot be compared.");
    }
    DateValue typedOther = (DateValue)other;
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
