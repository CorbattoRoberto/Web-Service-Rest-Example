package it.euris.academy.webservicerest.utility;

import java.time.LocalDateTime;

public class DataConversionUtils {

  private DataConversionUtils(){}

  public static String numberToString(Number value){
    return value == null ? null : value.toString();
  }

  public static Integer stringToInteger(String value){
    return value == null ? null : Integer.parseInt(value);
  }

  public static LocalDateTime stringToLocalDateTime(String value){
    return value == null ? null : LocalDateTime.parse(value);
  }

  public static String localDateTimeToString(LocalDateTime value){
    return value == null ? null : value.toString();
  }

}
