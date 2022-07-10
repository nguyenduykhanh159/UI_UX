package com.example.ui_ux.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.ui_ux.entity.DBConnect;
import com.example.ui_ux.entity.Work;

public class WorkDAO {

  private static final String TABLE_WORK = "work";

  public List<Work> getListWorkByStatus(int status) {
    List<Work> workList = new ArrayList<>();
    Statement statement = null;
    try {
      Connection connection = DBConnect.getConnection();
      String sql = "select * from " + TABLE_WORK + " where status = " + status;
      statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);
      try {
        while(resultSet.next()) {
          Work work = new Work(resultSet.getString("work").trim(), resultSet.getString("time_start").trim(),
            resultSet.getString("time_finish").trim(), resultSet.getString("workplace").trim(),
            resultSet.getString("description").trim());
          workList.add(work);
        }
      } finally {
        closeResultSet(resultSet);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeStatement(statement);
    }

    return workList;
  }

  private void closeStatement(Statement statement) {
    try {
      if (statement != null)
        statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void closeResultSet(ResultSet result) {
    try {
      result.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
