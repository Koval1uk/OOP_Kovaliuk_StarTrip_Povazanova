package src.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class AdminDashBoardController {

    public AnchorPane dashBoardContext;

    public void openWindowRoomOnAction(ActionEvent actionEvent) throws IOException {
        changeScene("roomTable");
    }

    public void openWindowMealOnAction(ActionEvent actionEvent) throws IOException {
        changeScene("restaurantsTable");
    }

    public void openWindowIncomeOnAction(ActionEvent actionEvent) throws IOException {
        changeScene("paymentStatTable");
    }

    public void logOutHomeOnAction(ActionEvent actionEvent) throws IOException {
        if (confirmLogout()) {
            changeScene("LoginForm");
        }
    }

    private void changeScene(String resource) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene(resource));
        stage.centerOnScreen();
    }

    private Stage getStage() {
        return (Stage) dashBoardContext.getScene().getWindow();
    }

    private Scene createScene(String resource) throws IOException {
        return new Scene(loadFXML(resource));
    }

    private Parent loadFXML(String resource) throws IOException {
        return FXMLLoader.load(getClass().getResource("../view/" + resource + ".fxml"));
    }

    private boolean confirmLogout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure You Want To Log Out?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.YES;
    }
}

