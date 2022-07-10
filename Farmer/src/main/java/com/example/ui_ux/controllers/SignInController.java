package com.example.ui_ux.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.ui_ux.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController implements Initializable {

  @FXML
  private Button deleteButton;

  @FXML
  private TextField idTextField;

  @FXML
  private Button login;

  @FXML
  void clickID(ActionEvent event) {
    deleteButton.setDisable(false);
    Object node = event.getSource();
    Button button = (Button) node;
    idTextField.setText(idTextField.getText() + button.getText());
  }

  @FXML
  void clickToLogin(ActionEvent event) throws IOException
  {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Lỗi");
    alert.setHeaderText("Lỗi Đăng Nhập");
    if (idTextField.getText() == null || idTextField.getText().isEmpty()) {
      alert.setContentText("Không được bỏ trống mã số");
      alert.showAndWait();
    } else if (idTextField.getText().equals("111")) {
      alert.setContentText("Mã số không đúng");
      alert.showAndWait();
    } else {
      AnchorPane root = FXMLLoader.load(Application.class.getResource("DashboardScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setTitle("WELCOME TO HI_10");
      stage.setScene(scene);
      stage.centerOnScreen();
      stage.show();
    }
  }

  @FXML
  void deleteID(ActionEvent event) {
    if (idTextField.getText().length() == 0) {
      deleteButton.setDisable(true);
    } else {
      idTextField.setText(idTextField.getText().substring(0, idTextField.getText().length() - 1));
      if (idTextField.getText().length() == 0) {
        deleteButton.setDisable(true);
      }
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    deleteButton.setDisable(true);
  }
}