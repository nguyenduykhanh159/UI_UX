package com.example.ui_ux.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CloseDB {
  public static void closeStatement(PreparedStatement statement) {
    try {
      if (statement != null)
        statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void closeResultSet(ResultSet result) {
    try {
      result.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
