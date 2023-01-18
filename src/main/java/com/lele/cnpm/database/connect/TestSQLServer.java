package com.lele.cnpm.database.connect;

import java.sql.Connection;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.*;

public class TestSQLServer {
  public static void main(String[] args) {
    SQLServerDataSource ds = new SQLServerDataSource();
    ds.setUser("sa");
    ds.setPassword("luongluong");
    ds.setServerName("ASPHODEL\\MSSQLSERVER01");
    ds.setPortNumber(1433);
    ds.setDatabaseName("QuanLyNhanKhau");
    ds.setEncrypt("true");
    ds.setTrustServerCertificate(true);

    try {
      Connection conn = ds.getConnection();
      System.out.println(conn);

    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
