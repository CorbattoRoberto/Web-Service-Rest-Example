package it.euris.academy.webservicerest.utility;

import it.euris.academy.webservicerest.data.enums.ShipmentType;

import java.math.BigDecimal;
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

  public static ShipmentType stringToShipmentType(String value) {
    for(ShipmentType shipmentTypeValue : ShipmentType.values()){
      if (shipmentTypeValue.name().equalsIgnoreCase(value))
        return shipmentTypeValue;
    }
    return null;
  }

  public static BigDecimal stringToBigDecimal(String value){
    return value == null ? null : new BigDecimal(value);
  }

  public static String bigDecimalToString(BigDecimal value){
    return value == null ? null : value.toString();
  }

  public static Boolean stringToBoolean(String value){
    return value == null ? null : Boolean.valueOf(value);
  }

  public static String booleanToString(Boolean value){
    return value == null ? null : value.toString();
  }

  public static String shipmentTypeToString(ShipmentType value) {
    return value== null ? null : value.name();
  }

}
