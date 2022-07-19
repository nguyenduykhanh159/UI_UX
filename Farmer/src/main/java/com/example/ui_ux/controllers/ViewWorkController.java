package com.example.ui_ux.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import com.example.ui_ux.Application;
import com.example.ui_ux.dao.WorkDAO;
import com.example.ui_ux.entity.Work;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewWorkController implements Initializable {

  @FXML
  private Button complete;

  @FXML
  private RadioButton completeButton;

  @FXML
  private RadioButton incompleteButton;

  @FXML
  private RadioButton isCheckingButton;

  @FXML
  private ToggleGroup isCompleteGroup;

  @FXML
  private Button returnButton;

  @FXML
  private TableView<Work> workTable;

  @FXML
  private TableColumn<Work, String> timeFinish;

  @FXML
  private TableColumn<Work, String> timeStart;

  @FXML
  private TableColumn<Work, String> work;

  @FXML
  private TableColumn<Work, String> workplace;

  @FXML
  private TableColumn<Work, String> description;

  private ObservableList<Work> oblistWork;

  private List<Work> workList;

  private WorkDAO workDAO = new WorkDAO();

  @FXML
  void returnDashboard(ActionEvent event) throws IOException
  {
    AnchorPane root = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("DashboardScreen.fxml")));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("WELCOME TO HI_10");
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }

  @FXML
  void viewCheckingWork(ActionEvent event) {
    setValueForTable(-1);
    complete.setDisable(true);
  }

  @FXML
  void viewCompleteWork(ActionEvent event) {
    setValueForTable(1);
    complete.setDisable(true);
  }

  @FXML
  void viewIncompleteWork(ActionEvent event) {
    setValueForTable(0);
    complete.setDisable(false);
  }
  
  @FXML
  void changeChecking(ActionEvent event) {
    Work work = workTable.getSelectionModel().getSelectedItem();

    Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
    alertConfirm.setTitle("Cập nhật trạng thái công việc");
    alertConfirm.setHeaderText("Bạn có chắc chắn muốn cập nhật trạng thái công việc?");
    alertConfirm.setContentText(work.getWork());

    Optional<ButtonType> option = alertConfirm.showAndWait();
    if (option.get() == ButtonType.OK) {
      workDAO.updateWorkStatus(work.getId());
      Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
      alertInfo.setTitle("Cập nhật trạng thái công việc");
      alertInfo.setHeaderText("Trạng thái công việc đã được cập nhật");
      alertInfo.setContentText("Công việc đang chờ phê duyệt");
      alertInfo.showAndWait();
    } else {
      return;
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    completeButton.setSelected(true);
    setValueForTable(1);
    complete.setDisable(true);
  }

  public void setValueForTable(int status) {
    workList = workDAO.getListWorkByStatus(status);
    oblistWork = FXCollections.observableList(workList);
    work.setCellValueFactory(new PropertyValueFactory<>("work"));
    timeStart.setCellValueFactory(new PropertyValueFactory<>("timeStart"));
    timeFinish.setCellValueFactory(new PropertyValueFactory<>("timeFinish"));
    workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
    description.setCellValueFactory(new PropertyValueFactory<>("description"));

    workTable.setItems(oblistWork);
  }
}