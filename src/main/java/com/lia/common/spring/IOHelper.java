package com.lia.common.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lia.common.spring.exception.CancelInputException;

public class IOHelper {
   private Boolean ide = true;
   private java.io.Console c = System.console();
   private BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
   private String _quitIdent = " ";
   public String readLine(String prompt) throws IOException, CancelInputException{
      String input = "";
      if (ide){
         System.out.println(prompt);
         input = b.readLine();
         /*if (input.length() == 0){
            System.out.print("Are you want to exit? (Y/N):");
            input = b.readLine();
            if (input.toString().equals("Y")) {
               throw new CancelInputException();
            }
            else {
               input = "";
            }
         }*/
      }
      else {
         input = c.readLine(prompt);
         /*if (input.length() == 0){
            System.out.print("Are you want to exit? (Y/N):");
            input = b.readLine();
            if (input.toString().toUpperCase().equals("Y")) {
               throw new CancelInputException();
            }
            else {
               input = "";
            }
         }*/
      }
      return input;
   }
   
   public void writeLine(String message) {
      if (ide){
         System.out.println(message);
      }
      else {
         c.printf(message);
      }
   }
   
   public void writeLine(List<String> message) {
      if (ide){
         System.out.println("--------------------------------------------------");
      }
      else {
         c.printf("------------------------------------------------");
      }
      for (String m : message) {
         if (ide){
            System.out.println(m);
         }
         else {
            c.printf(m);
         }
      }
   }
   
   public int readStringChoose(Map<Integer, String> option) throws Exception{
      writeLine("--------------------------------------------------");
      boolean choosed = false;
      String result = "";
      Integer index = -1;
      while (!choosed){
         for (Map.Entry<Integer, String> entry : option.entrySet()) {
            writeLine(String.format("%d: %s;", entry.getKey(), entry.getValue()));
         }
         writeLine(String.format("%s: quit;", _quitIdent));
         writeLine("--------------------------------------------------");
         result = readLine("Please choose:");
         
         if (result.equals(" ")) {
            throw new CancelInputException();
         }
         try{
               index = Integer.parseInt(result);
               if (option.containsKey(index)) {
                  choosed = true;
               }
            
         }
         catch (Exception ex) {
            writeLine(ex.getMessage());
            choosed = false;
         }
      }
      return index;
   }
   
   public int readObjectChoose(Map<Integer, CommonObject> option) throws Exception{
      writeLine("--------------------------------------------------");
      boolean choosed = false;
      String result = "";
      Integer index = -1;
      while (!choosed){
         for (Entry<Integer, CommonObject> entry : option.entrySet()) {
            writeLine(String.format("%d: %s;", entry.getKey(), entry.getValue().fetchDescription()));
         }
         writeLine(String.format("%s: quit;", _quitIdent));
         writeLine("--------------------------------------------------");
         result = readLine("Please choose:");
         if (result.equals(" ")) {
            throw new CancelInputException();
         }
         try{
               index = Integer.parseInt(result);
               if (option.containsKey(index)) {
                  choosed = true;
               }
            
         }
         catch (Exception ex) {
            writeLine(ex.getMessage());
            choosed = false;
         }
      }
      return index;
   }
}
