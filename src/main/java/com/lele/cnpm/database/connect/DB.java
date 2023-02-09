package com.lele.cnpm.database.connect;

import java.sql.Connection;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.InputStream;

public class DB {
  private static DB db;
  private Connection conn = null;

  public DB() throws Exception {
    try (InputStream input = DB.class.getClassLoader().getResourceAsStream("/config.properties")) {
      Properties props = new Properties();
      props.load(input);
      String serverName = props.getProperty("com.lele.db.servername");
      String user = props.getProperty("com.lele.db.username");
      String password = props.getProperty("com.lele.db.password");
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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static DB getDB() {
    if (db == null)
      try {
        db = new DB();
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
