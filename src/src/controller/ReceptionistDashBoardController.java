package src.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class ReceptionistDashBoardController {
    public AnchorPane receptionContext;

    public void reserveRoomWindowOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/ReserveRoom.fxml")))));

    }

    public void maintainRoomWindowOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/MaintainRoom.fxml")))));
        
    }


    public void LogOutOnActionAIN(ActionEvent actionEvent) throws IOException {
        Alert alert =  new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure You Want To Log Out?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            Stage stage = (Stage) receptionContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/LoginForm.fxml")))));

        }else {}
    }
}
