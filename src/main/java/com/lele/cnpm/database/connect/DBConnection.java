package com.lele.cnpm.database.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnection {
  private static DBConnection db;
  private Connection conn = null;

  public static String readConfiguration(String src) {
      char[] srca = src.toCharArray();
      int i = 0;
      while (srca[i] != '"') i++;
      int j = i+1;
      while (srca[j] != '"') j++;
      StringBuilder serverName = new StringBuilder();
      for (int k =i+1; k<j; k++) serverName.append(srca[k]);
      return serverName.toString();
  }

  /**
   * Khởi tạo một kết nối tới database lưu trữ dữ liệu
   * @throws Exception
   */
  public DBConnection() throws Exception {
    String user = "sa", password , serverName, databaseName = "QuanLyNhanKhau";
    int portNumber = 1433;
    FileInputStream DatabaseConfig = new FileInputStream("./DatabaseConfig.txt");
    Scanner scanner = new Scanner(DatabaseConfig);
    try {
        serverName = readConfiguration(scanner.nextLine()).replace("\\", "\\\\");
        password = readConfiguration(scanner.nextLine());
    } finally {
      try {
          scanner.close();
          DatabaseConfig.close();
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  }
    SQLServerDataSource ds = new SQLServerDataSource();
    ds.setUser(user);
    ds.setPassword(password);
    ds.setServerName(serverName);
    ds.setPortNumber(portNumber);
    ds.setDatabaseName(databaseName);
    ds.setEncrypt("true");
    ds.setTrustServerCertificate(true);

    conn = ds.getConnection();
  }

  public static DBConnection getDBConnection() {
    if (db == null)
      try {
        db = new DBConnection();
      } catch (Exception e) {
        System.out.println(e.getMessage() + " Sai o getDBConnection()");
        e.printStackTrace();
      }
    return db;
  }

  /**
   * @return kết nối tới database
   */
  public Connection getConnection() {
    return this.conn;
  }
}
