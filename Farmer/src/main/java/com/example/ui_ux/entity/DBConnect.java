package com.example.ui_ux.entity;

import java.sql.*;

import com.example.ui_ux.utils.Configs;

public class DBConnect {
  private static Connection connect;

  public static Connection getConnection() {
    if (connect != null) {
      return connect;
    } try {
      Class.forName("org.postgresql.Driver");
      connect = DriverManager.getConnection(Configs.DB_URL, Configs.DB_USERNAME, Configs.DB_PASSWORD);
      System.out.println("Connect Successfully");
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Connect Failure");
    }

    return connect;
  }
}
