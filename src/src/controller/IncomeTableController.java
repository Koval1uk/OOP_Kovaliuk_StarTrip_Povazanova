package src.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import src.db.DatabaseIncome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.mode.PaymentStat;
import src.view.tm.IncomeTM;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public class IncomeTableController {
    public AnchorPane incomeContext;

    public TableView<IncomeTM> tblIncome;

    public TableColumn colMonth;
    public TableColumn colRmCgh;
    public TableColumn colMlCgh;
    public TableColumn colSvCgh;
    public TableColumn colOption;
    public TableColumn colMonthIncome;
    public TableColumn colAnualIncome;

    public JFXTextField txtMonth;
    public JFXTextField txtRoomCgh;
    public JFXTextField txtMealCgh;
    public JFXTextField txtServiceCgh;
    public JFXButton btnSaveIncome;
    public Label mealTblTotal;
    public Label serviceTotal;
    public Label roomTotal;
    public Label annualIncome;
    public Label monthlyIncomeAvg;

    ArrayList<Double> arrayList1=new ArrayList<Double>();
    ArrayList<Double> arrayList2=new ArrayList<Double>();
    ArrayList<Double> arrayList3=new ArrayList<Double>();

    double tempMeal=0;
    double tempService=0;
    double tempRoom=0;




    public void initialize() {
        setupTableColumns();
        loadAllIncome();
        totaldata();

        tblIncome.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    public void totaldata() {


        for (int i = 0; i<DatabaseIncome.paymentStatTable.size(); i++){

            arrayList1.add(DatabaseIncome.paymentStatTable.get(i).getMealCgh());

            tempMeal=tempMeal+arrayList1.get(i);

            mealTblTotal.setText(String.valueOf(tempMeal));
        }


        for (int i = 0; i<DatabaseIncome.paymentStatTable.size(); i++) {

            arrayList2.add(DatabaseIncome.paymentStatTable.get(i).getServiceCgh());

            tempService = tempService + arrayList2.get(i);

            serviceTotal.setText(String.valueOf(tempService));
        }


        for (int i = 0; i<DatabaseIncome.paymentStatTable.size(); i++) {

            arrayList3.add(DatabaseIncome.paymentStatTable.get(i).getRoomCgh());

            tempRoom = tempRoom + arrayList3.get(i);

            roomTotal.setText(String.valueOf(tempRoom));

        }

    }

    private void setData(IncomeTM tm) {
        btnSaveIncome.setText("UPDATE DETAILS");
        txtMonth.setText(tm.getMonth());
        txtRoomCgh.setText(String.valueOf(tm.getRoomCgh()));
        txtMealCgh.setText(String.valueOf(tm.getMealCgh()));
        txtServiceCgh.setText(String.valueOf(tm.getServiceCgh()));
    }

    private void loadAllIncome() {
        ObservableList<IncomeTM> obList= FXCollections.observableArrayList();

        for(PaymentStat i: DatabaseIncome.paymentStatTable){
            Button button =new Button("Delete");
            IncomeTM tm= new IncomeTM(i.getMonth(),i.getRoomCgh(),i.getMealCgh(), i.getServiceCgh(),button,i.getMonthAll(),i.getYearAll());
            obList.add(tm);



            button.setOnAction((e)->{

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure ?",
                        ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if(buttonType.get().equals(ButtonType.YES)){
                    //delete to alert action
                    DatabaseIncome.paymentStatTable.remove(i);
                    obList.remove(tm);
                }
            });
        }
        tblIncome.setItems(obList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        changeScene("AdminDashBoard");
    }

    private void changeScene(String resource) throws IOException {
        Stage stage = getStage();
        stage.setScene(createScene(resource));
        stage.centerOnScreen();
    }

    private Stage getStage() {
        return (Stage) incomeContext.getScene().getWindow();
    }

    private Scene createScene(String resource) throws IOException {
        return new Scene((Parent) loadFXML(resource));
    }

    private Object loadFXML(String resource) throws IOException {
        return FXMLLoader.load(getClass().getResource("../view/" + resource + ".fxml"));
    }

    private void setupTableColumns() {
        colMonth.setCellValueFactory(new PropertyValueFactory("month"));
        colRmCgh.setCellValueFactory(new PropertyValueFactory("roomCgh"));
        colMlCgh.setCellValueFactory(new PropertyValueFactory("mealCgh"));
        colSvCgh.setCellValueFactory(new PropertyValueFactory("serviceCgh"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        if(btnSaveIncome.getText().equals("SAVE DETAILS")){

            PaymentStat i1=new PaymentStat(
                    txtMonth.getText(),
                    Double.parseDouble(txtRoomCgh.getText()),
                    Double.parseDouble(txtMealCgh.getText()),
                    Double.parseDouble(txtServiceCgh.getText())
            );
            DatabaseIncome.paymentStatTable.add(i1);
            loadAllIncome();

        }else{

            for(PaymentStat ii: DatabaseIncome.paymentStatTable){
                if(ii.getMonth().equals(txtMonth.getText())){
                    ii.setRoomCgh(Double.parseDouble(txtRoomCgh.getText()));
                    ii.setMealCgh(Double.parseDouble(txtMealCgh.getText()));
                    ii.setServiceCgh(Double.parseDouble(txtServiceCgh.getText()));

                    loadAllIncome();
                    return;
                }
            }
        }

        PaymentStat i1 = new PaymentStat(
                txtMonth.getText(),
                Double.parseDouble(txtRoomCgh.getText()),
                Double.parseDouble(txtMealCgh.getText()),
                Double.parseDouble(txtServiceCgh.getText())
        );

        DatabaseIncome.paymentStatTable.add(i1);
        loadAllIncome();

    }

    public void addNewOnAction(ActionEvent actionEvent) {
        btnSaveIncome.setText("SAVE DETAILS");
    }


    public void monthlyIncomeOnAction(ActionEvent actionEvent) {
        double monthAvg=((tempMeal+tempRoom+tempService)/(12.00));

        monthlyIncomeAvg.setText(String.valueOf(monthAvg));

    }

    public void annuallyIncomeOnAction(ActionEvent actionEvent) {
        double annual=tempMeal+tempRoom+tempService;

        annualIncome.setText(String.valueOf(annual));



    }
}