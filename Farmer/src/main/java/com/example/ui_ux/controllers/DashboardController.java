package com.example.ui_ux.controllers;

import java.io.IOException;

import com.example.ui_ux.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {

  @FXML
  private Button checkinButton;

  @FXML
  private Button infoButton;

  @FXML
  private Button logoutButton;

  @FXML
  private Button workButton;

  @FXML
  void checkin(ActionEvent event) {

  }

  @FXML
  void logout(ActionEvent event) throws IOException {
    AnchorPane root = FXMLLoader.load(Application.class.getResource("SignInScreen.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }

  @FXML
  void viewInfo(ActionEvent event) throws IOException {
    AnchorPane root = FXMLLoader.load(Application.class.getResource("FarmerInfoScreen.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }

  @FXML
  void workView(ActionEvent event) throws IOException {
    AnchorPane root = FXMLLoader.load(Application.class.getResource("WorkInfoScreen.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }

}
