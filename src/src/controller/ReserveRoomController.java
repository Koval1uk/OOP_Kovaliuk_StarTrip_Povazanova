package src.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import src.db.DatabaseReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.mode.User;
import src.view.tm.CustomerTM;


import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class ReserveRoomController {
    public AnchorPane reserveRoomContextt;

    public TableView<CustomerTM> tblCustomer;

    public TableColumn colCusName;
    public TableColumn colCusNic;
    public TableColumn colTPNum;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colRoomNum;
    public TableColumn colRoomAvailable;
    public TableColumn colMealPlan;
    public TableColumn colCancelOption;
    
    public JFXTextField txtCusName;
    public JFXTextField txtCusNic;
    public JFXTextField txtTpNum;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtRoomNum;
    public JFXButton btnSaveDetails;
    public TextField searchCustomer;


    @FXML
    public void initialize() {
        initializeTableColumns();
        loadAllCustomers();
        setupSelectionListener();
    }

    private void initializeTableColumns() {

        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCusNic.setCellValueFactory(new PropertyValueFactory("id"));
        colTPNum.setCellValueFactory(new PropertyValueFactory("tpNum"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colRoomNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colRoomAvailable.setCellValueFactory(new PropertyValueFactory("availableBox"));
        colMealPlan.setCellValueFactory(new PropertyValueFactory("mealBox"));
        colCancelOption.setCellValueFactory(new PropertyValueFactory("btn"));


    }

    private void setupSelectionListener() {
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(CustomerTM tm) {
        btnSaveDetails.setText("UPDATE DETAILS");
        txtCusName.setText(tm.getName());
        txtCusNic.setText(tm.getId());
        txtTpNum.setText(tm.getTpNum());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        txtRoomNum.setText(tm.getRoomNum());
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTM> customers = FXCollections.observableArrayList();
        for (User c : DatabaseReservation.userTable) {
            customers.add(createCustomerTM(c));
        }
        tblCustomer.setItems(customers);
        setupSearchFilter(customers);
    }

    private CustomerTM createCustomerTM(User c) {
        ComboBox availableBox = createComboBox("AVAILABLE ROOM", "NOT AVAILABLE ROOM");
        ComboBox mealBox = createComboBox("FRENCH", "CHINESE", "LOCAL");
        Button btn = createCancelButton(c);

        return new CustomerTM(c.getName(), c.getId(), c.getTpNum(), c.getEmail(), c.getAddress(), c.getRoomNum(), availableBox, mealBox, btn);
    }

    private ComboBox createComboBox(String... items) {
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(items);
        return comboBox;
    }

    private Button createCancelButton(User c) {
        Button btn = new Button("CANCEL REQUEST");
        btn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You sure ?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                DatabaseReservation.userTable.remove(c);
                loadAllCustomers();
            }
        });
        return btn;
    }

    private void setupSearchFilter(ObservableList<CustomerTM> customers) {
        FilteredList<CustomerTM> filteredData = new FilteredList<>(customers, b -> true);
        searchCustomer.textProperty().addListener((observable, oldValue, newValue) -> updateSearchFilter(filteredData, newValue));
        SortedList<CustomerTM> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblCustomer.comparatorProperty());
        tblCustomer.setItems(sortedData);
    }

    private void updateSearchFilter(FilteredList<CustomerTM> filterData, String newValue) {
        filterData.setPredicate(customer -> isMatch(customer, newValue));
    }

    private boolean isMatch(CustomerTM customer, String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return true;
        }
        String lowerCaseFilter = filterText.toLowerCase();
        if (customer.getName().toLowerCase().contains(lowerCaseFilter)
                || customer.getId().toLowerCase().contains(lowerCaseFilter)
                || customer.getTpNum().toLowerCase().contains(lowerCaseFilter)
                || customer.getEmail().toLowerCase().contains(lowerCaseFilter)
                || customer.getAddress().toLowerCase().contains(lowerCaseFilter)
                || customer.getRoomNum().toLowerCase().contains(lowerCaseFilter)) {
            return true;
        }
        return false;
    }

    @FXML
    public void backToHomeRecepOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) reserveRoomContextt.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/ReceptionistDashBoard.fxml")))));
        stage.centerOnScreen();
    }

    @FXML
    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSaveDetails.getText().equals("SAVE DETAILS")) {
            User c1 = new User(
                    txtCusName.getText(),
                    txtCusNic.getText(),
                    txtTpNum.getText(),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    txtRoomNum.getText()
            );
            DatabaseReservation.userTable.add(c1);
        } else {
            updateCustomer();
        }
        loadAllCustomers();
    }

    private void updateCustomer() {
        for (User tm : DatabaseReservation.userTable) {
            if (tm.getName().equals(txtCusName.getText())) {
                tm.setId(txtCusNic.getText());
                tm.setTpNum(txtTpNum.getText());
                tm.setEmail(txtEmail.getText());
                tm.setAddress(txtAddress.getText());
                tm.setRoomNum(txtRoomNum.getText());
                return;
            }
        }
    }

    @FXML
    public void btnAddNewCustomerOnAction(ActionEvent actionEvent) {
        btnSaveDetails.setText("SAVE DETAILS");
    }
}
