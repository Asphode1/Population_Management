package com.lele.cnpm.database.connect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestSQLServer {


  public static void main(String[] args) throws FileNotFoundException {
    
    FileInputStream DatabaseConfig = new FileInputStream("./DatabaseConfig.txt");
    Scanner scanner = new Scanner(DatabaseConfig);
    try {
      String serverName = DBConnection.readConfiguration(scanner.nextLine()).replace("\\", "\\\\");
      String password = DBConnection.readConfiguration(scanner.nextLine());
      System.out.println(serverName.toString());
      System.out.println(password);
  } finally {
      try {
          scanner.close();
          DatabaseConfig.close();
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  }
  }
}
