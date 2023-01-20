package com.lele.cnpm.database.connect;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnection {
  private static DBConnection db;
  private Connection conn = null;

  /**
   * Khởi tạo một kết nối tới database lưu trữ dữ liệu
   * @throws Exception
   */
  public DBConnection() throws Exception {
    SQLServerDataSource ds = new SQLServerDataSource();
    ds.setUser("sa");
    ds.setPassword("luongluong");
    ds.setServerName("DESKTOP-9J07U8P\\SQLEXPRESS");
    ds.setServerName("ASPHODEL\\MSSQLSERVER01");
    ds.setPortNumber(1433);
    ds.setDatabaseName("QuanLyNhanKhau");
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
