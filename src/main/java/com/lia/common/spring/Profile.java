package com.lia.common.spring;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.io.File;

public class Profile {
   public String getConfigValue(String json, String key) throws Exception {
      JSONObject obj = new JSONObject(json);
      String output = obj.get(key).toString();
      return output;
   }

   public String readProperty(String filePath,String key) {
      Properties props = new Properties();
      try {
         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
         props.load(in);
         String value = props.getProperty (key);
            //System.out.println(key+value);
            return value;
      }
      catch (Exception e) {
         //e.printStackTrace();
         return "";
      }
   }

   public static void writeProperty(String fileName,String parameterName,String parameterValue) throws Exception {
      File file = new File(fileName);
      if (!file.exists()) {
         if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
         }
         file.createNewFile();
      }
      Properties properties = new Properties();
      try {
         InputStream input = new FileInputStream(fileName);
         properties.load(input);
         OutputStream output = new FileOutputStream(fileName);
         properties.setProperty(parameterName, parameterValue);
         properties.store(output, "Update '" + parameterName + "' value");
      }
      catch (IOException e) {
         System.err.println("Visit "+fileName+" for updating "+parameterName+" value error");
      }
   }
}