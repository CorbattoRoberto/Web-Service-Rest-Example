package it.euris.academy.webservicerest.utility;

public class DataConversionUtils {

  private DataConversionUtils(){}

  public static String numberToString(Number value){
    return value == null ? null : value.toString();
  }

  public static Integer stringToInteger(String value){
    return value == null ? null : Integer.parseInt(value);
  }

}
