module com.example.ui_ux {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens com.example.ui_ux to javafx.fxml;
  exports com.example.ui_ux;
  exports com.example.ui_ux.controllers;
  opens com.example.ui_ux.controllers to javafx.fxml;
  opens com.example.ui_ux.entity to javafx.base;
}