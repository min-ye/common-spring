package com.lia.common.spring;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class CommonObject {
   public abstract String fetchObjectName();
   
   public abstract String getPropertyValue(String propertyName) throws Exception;
   
   public abstract void setValue(String propertyName, String propertyValue) throws Exception;
   
   public abstract void importModel(Map<String, Object> item) throws Exception;
   
   public abstract Map<String, String> exportPropertyMap();
   
   public abstract Map<String, String> exportKeyPropertyMap();
   
   public abstract Map<String, String> exportValuePropertyMap();
   
   public abstract List<String> fetchPropertyName();
   
   public abstract Object[] fetchObject();
   
   public abstract String fetchDescription();
   
   protected String getPropertyValueString(String value) {
      return String.format("'%s'", value);
   }
   
   protected String getPropertyValueString(int value) {
      return String.format("%d", value);
   }
   
   protected String getPropertyValueString(double value) {
      return String.format("%d", value);
   }
   
   protected String getPropertyValueString(UUID value) {
      return String.format("'%s'", value.toString());
   }
   
   protected String convertToString(Object obj){
      return obj.toString();
   }
   
   protected UUID convertToUUID(Object obj) {
      UUID value = (UUID) obj;
      return value;
   }
   
   protected Integer convertToInteger(Object obj) {
      Integer value = (Integer) obj;
      return value;
   }
   
   protected Short convertToShort(Object obj) {
      Short value = (Short) obj;
      return value;
   }
   
   protected Double convertToDouble(Object obj) {
      Double value = (Double) obj;
      return value;
   }
   
   protected Float convertToFloat(Object obj) {
      Float value = (Float) obj;
      return value;
   }

}
