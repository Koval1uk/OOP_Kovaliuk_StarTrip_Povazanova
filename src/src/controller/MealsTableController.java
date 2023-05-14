package src.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import src.db.DatabaseMeal;
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
import src.mode.Restaurants;
import src.view.tm.MealTM;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class MealsTableController {
    public AnchorPane mealsContext;
    public TableView<MealTM> tblMeals;
    public TableColumn colRmNum;
    public TableColumn colMealType;
    public TableColumn colMealTime;
    public TableColumn colPortion;
    public TableColumn colPrice;
    public TableColumn colOption;
    public TableColumn colMealStatus;
    public JFXTextField txtRnum;
    public JFXTextField txtMlTime;
    public JFXTextField txtPortion;
    public JFXTextField txtPrice;
    public JFXTextField txtMLType;
    public JFXButton btnSaveMeal;
    public TextField searchMalabar;

    public void initialize() {
        setCellValueFactories();
        loadAllMeals();

        tblMeals.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setCellValueFactories() {
        colRmNum.setCellValueFactory(new PropertyValueFactory("roomNum"));
        colMealType.setCellValueFactory(new PropertyValueFactory("mealType"));
        colMealTime.setCellValueFactory(new PropertyValueFactory("mealTime"));
        colPortion.setCellValueFactory(new PropertyValueFactory("portion"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
        colMealStatus.setCellValueFactory(new PropertyValueFactory("box"));
    }

    private void loadAllMeals() {
        ObservableList<MealTM> obList = FXCollections.observableArrayList();
        for (Restaurants m : DatabaseMeal.restaurantsTable) {
            MealTM tm = new MealTM(m.getRoomNum(), m.getMealType(), m.getMealTime(), m.getPortion(), m.getPrice(), createDeleteButton(m, obList), new CheckBox());
            obList.add(tm);
        }
        setTableViewItems(obList);
    }

    private Button createDeleteButton(Restaurants m, ObservableList<MealTM> obList) {
        Button btn = new Button("Delete");
        btn.setOnAction((e) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You sure ?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)) {
                DatabaseMeal.restaurantsTable.remove(m);
                obList.removeIf(tm -> tm.getRoomNum().equals(m.getRoomNum()));
            }
        });
        return btn;
    }

    private void setTableViewItems(ObservableList<MealTM> obList) {
        FilteredList<MealTM> filterData = createFilteredData(obList);
        SortedList<MealTM> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(tblMeals.comparatorProperty());
        tblMeals.setItems(sortedData);
    }

    private FilteredList<MealTM> createFilteredData(ObservableList<MealTM> obList) {
        FilteredList<MealTM> filterData = new FilteredList<>(obList, b -> true);
        searchMalabar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(meal -> matchMeal(meal, newValue));
        });
        return filterData;
    }

    private boolean matchMeal(MealTM meal, String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return true;
        }
        String lowerCaseFilter = filterText.toLowerCase();
        return meal.getRoomNum().toLowerCase().contains(lowerCaseFilter) ||
                meal.getMealType().toLowerCase().contains(lowerCaseFilter) ||
                meal.getMealTime().toLowerCase().contains(lowerCaseFilter) ||
                String.valueOf(meal.getPortion()).toLowerCase().contains(lowerCaseFilter) ||
                String.valueOf(meal.getPrice()).toLowerCase().contains(lowerCaseFilter);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene("AdminDashBoard"));
        stage.centerOnScreen();
    }

    private void changeScene(String resource) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene(resource));
    }

    private Stage getStage() {
        return (Stage) mealsContext.getScene().getWindow();
    }

    private Scene createScene(String resource) throws IOException {
        return new Scene(loadFXML(resource));
    }

    private Parent loadFXML(String resource) throws IOException {
        return FXMLLoader.load(getClass().getResource("../view/" + resource + ".fxml"));
    }

    public void saveMealDetailsOnAction(ActionEvent actionEvent) {
        if (btnSaveMeal.getText().equals("SAVE DETAILS")) {
            DatabaseMeal.restaurantsTable.add(new Restaurants(
                    txtRnum.getText(),
                    txtMLType.getText(),
                    txtMlTime.getText(),
                    Integer.parseInt(txtPortion.getText()),
                    Double.parseDouble(txtPrice.getText())
            ));
        } else {
            updateMealDetails();
        }
        loadAllMeals();
    }

    private void updateMealDetails() {
        for (Restaurants ml : DatabaseMeal.restaurantsTable) {
            if (ml.getRoomNum().equals(txtRnum.getText())) {
                ml.setMealType(txtMLType.getText());
                ml.setMealTime(txtMlTime.getText());
                ml.setPortion(Integer.parseInt(txtPortion.getText()));
                ml.setPrice(Double.parseDouble(txtPrice.getText()));
                return;
            }
        }
    }

    private void setData(MealTM tt) {
        btnSaveMeal.setText("UPDATE DETAILS");
        txtRnum.setText(tt.getRoomNum());
        txtMLType.setText(tt.getMealType());
        txtMlTime.setText(tt.getMealTime());
        txtPortion.setText(String.valueOf(tt.getPortion()));
        txtPrice.setText(String.valueOf(tt.getPrice()));
    }

    public void addNewMealOnAction(ActionEvent actionEvent) {
        btnSaveMeal.setText("SAVE DETAILS");
    }
}