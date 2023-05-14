package src.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField pwdPassword;
    public Button adminBtn;
    public Button receptionBtn;
    public AnchorPane loginformcontext;

    private static final String ADMIN_USERNAME = "admin";
    private static final String RECEPTIONIST_USERNAME = "recep";
    private static final String PASSWORD = "1234";
    private static final int MAX_ATTEMPTS = 5;

    private int attemptsLogAdmin = 0;
    private int attemptsLogReceptionist = 0;

    public void LogInAdminOnAction(ActionEvent actionEvent) throws IOException {
        if (adminBtn.getText().equals("LOG IN ADMIN")) {
            login(ADMIN_USERNAME, ++attemptsLogAdmin);
        } else if (adminBtn.getText().equals("LOG IN  RECEPTION")) {
            login(RECEPTIONIST_USERNAME, ++attemptsLogReceptionist);
        }
    }

    private void login(String expectedUserName, int attempts) throws IOException {
        if (attempts < MAX_ATTEMPTS) {
            if (isCorrectCredentials(expectedUserName)) {
                changeScene(expectedUserName.equals(ADMIN_USERNAME) ? "AdminDashBoard" : "ReceptionistDashBoard");
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again !").show();
            }
        } else {
            txtUserName.setVisible(false);
            pwdPassword.setVisible(false);
        }
    }

    private boolean isCorrectCredentials(String expectedUserName) {
        return txtUserName.getText().equals(expectedUserName) && pwdPassword.getText().equals(PASSWORD);
    }

    private void changeScene(String resource) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene(resource));
    }

    private Stage getStage() {
        return (Stage) loginformcontext.getScene().getWindow();
    }

    private Scene createScene(String resource) throws IOException {
        return new Scene(loadFXML(resource));
    }

    private Parent loadFXML(String resource) throws IOException {
        return FXMLLoader.load(getClass().getResource("../view/" + resource + ".fxml"));
    }

    public void LogInReceptionistOnAction(ActionEvent actionEvent) {
        String temp = adminBtn.getText();
        adminBtn.setText(receptionBtn.getText());
        receptionBtn.setText(temp);
    }
}
