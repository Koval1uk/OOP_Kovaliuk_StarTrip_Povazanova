package src.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import src.db.DatabaseMaintain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.mode.deletingMethod;
import src.view.tm.CleanerTM;


import java.io.IOException;

public class MaintainRoomController {
    public AnchorPane maintainRoomContext;
    public TableView<CleanerTM> tblMaintain;
    public TableColumn colRoomNum;
    public TableColumn colCleanTime;
    public TableColumn colRmAvailable;
    public TableColumn colCleanStatus;
    public JFXTextField txtTime;
    public JFXButton btnSave;

    public void initialize() {
        colRoomNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colCleanTime.setCellValueFactory(new PropertyValueFactory("time"));
        colRmAvailable.setCellValueFactory(new PropertyValueFactory("availability"));
        colCleanStatus.setCellValueFactory(new PropertyValueFactory("cleanStatus"));

        tblMaintain.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });

        loadAllCleaners();
    }

    private void setData(CleanerTM tm) {
        btnSave.setText("UPDATE TIME");
        txtTime.setText(tm.getTime());
    }

    private void loadAllCleaners() {
        ObservableList<CleanerTM> obList = FXCollections.observableArrayList();
        for (deletingMethod c : DatabaseMaintain.deleteTable) {
            CleanerTM tm = createCleanerTM(c);
            obList.add(tm);
        }
        tblMaintain.setItems(obList);
    }

    private CleanerTM createCleanerTM(deletingMethod c) {
        ComboBox<String> comBox = new ComboBox<>();
        comBox.getItems().addAll("AVAILABLE ROOM", "NOT AVAILABLE ROOM");

        CheckBox chkBox = new CheckBox("CLEANED");
        return new CleanerTM(c.getRoomNum(), c.getTime(), comBox, chkBox);
    }

    public void backToHomeRecepOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene("ReceptionistDashBoard"));
        stage.centerOnScreen();
    }

    private Stage getStage() {
        return (Stage) maintainRoomContext.getScene().getWindow();
    }

    private Scene createScene(String resource) throws IOException {
        return new Scene((Parent) loadFXML(resource));
    }

    private Object loadFXML(String resource) throws IOException {
        return FXMLLoader.load(getClass().getResource("../view/" + resource + ".fxml"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("UPDATE TIME")) {
            updateCleanerTime(txtTime.getText());
        }
    }

    private void updateCleanerTime(String time) {
        for (deletingMethod tm : DatabaseMaintain.deleteTable) {
            if (tm.getTime().equals(time)) {
                tm.setTime(time);
            }
        }
    }

    public void addTimeOnAction(ActionEvent actionEvent) {
        btnSave.setText("SAVE TIME");
    }
}