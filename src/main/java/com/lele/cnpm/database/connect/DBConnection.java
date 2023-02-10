package com.lele.cnpm.database.connect;

import java.sql.Connection;

import com.lele.cnpm.src.utils.Preference;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnection {
  private static DBConnection db;
  private Connection conn = null;

  public DBConnection() throws Exception {

    String serverName = Preference.getValue("com.lele.db.servername");
    String user = Preference.getValue("com.lele.db.username");
    String password = Preference.getValue("com.lele.db.password");
    final int port = 1433;
    final String databaseName = "QuanLyNhanKhau";
    SQLServerDataSource ds = new SQLServerDataSource();
    ds.setUser(user);
    ds.setPassword(password);
    ds.setServerName(serverName);
    ds.setPortNumber(port);
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

  public Connection getConnection() {
    return this.conn;
  }
}
