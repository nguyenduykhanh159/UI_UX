package com.example.ui_ux.controllers;

import java.io.IOException;
import java.util.Objects;

import com.example.ui_ux.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewInfoController {

  @FXML
  private Button returnButton;

  @FXML
  void returnDashboard(ActionEvent event) throws IOException {
    AnchorPane root = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("DashboardScreen.fxml")));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }

}
