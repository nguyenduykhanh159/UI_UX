package com.example.ui_ux;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application
{
  @Override
  public void start(Stage stage) throws IOException
  {
    AnchorPane root = FXMLLoader.load(Application.class.getResource("SignInScreen.fxml"));
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args)
  {
    launch();
  }
}