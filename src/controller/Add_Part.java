package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class Add_Part implements Initializable {

    Stage stage;
    Parent scene;
    private static int next_ID = 1;

    @FXML
    private TextField addPartIDTxt;

    @FXML
    private TextField addPartNameTxt;

    @FXML
    private TextField addPartInvTxt;

    @FXML
    private TextField addPartPriceTxt;

    @FXML
    private TextField addPartMaxTxt;

    @FXML
    private TextField addPartMinTxt;

    @FXML
    private Button addPartSaveBut;

    @FXML
    private Button addPartCancelBut;

    @FXML
    private RadioButton addPartIHRB;

    @FXML
    private ToggleGroup sourceTog;

    @FXML
    private RadioButton addPartOSRB;

    @FXML
    private TextField addPartMacIDTxt;
    @FXML
    private Label sourceLabel;

    /**
     * onActionPartCancel method disregards adding a new part and returns to main screen
     * @param actionEvent user click cancel button
     * @throws IOException
     */
    @FXML
    public void onActionPartCancel(javafx.event.ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();

    }

    @FXML
    public void onActionPartID(ActionEvent event) {

    }

    /**
     * onActionPartIH method changes source label to MachineID when InHouse radio button is clicked
     * @param event user clicks InHouse button
     */
    @FXML
    public void onActionPartIH(ActionEvent event) {

        addPartIHRB.setOnAction(value-> {sourceLabel.setText("Machine ID");});

    }


    @FXML
    public void onActionPartInv(ActionEvent event) {

    }

    @FXML
    public void onActionPartMacID(ActionEvent event) {

    }

    @FXML
    public void onActionPartMax(ActionEvent event) {

    }

    @FXML
    public void onActionPartMin(ActionEvent event) {

    }

    @FXML
    public void onActionPartName(ActionEvent event) {

    }

    /**
     * onActionPartOS method changes source label to Company Name when Outsource radio button is clicked
     * @param event user clicks OutSource button
     */
    @FXML
    public void onActionPartOS(ActionEvent event) {


        addPartOSRB.setOnAction(value-> {sourceLabel.setText("Company Name");});

    }

    @FXML
    public void onActionPartPrice(ActionEvent event) {

    }

    /**
     * onActionPartSave method saves new part and returns to main screen
     * @param actionEvent user clicks save button error is thrown if fields are incorrect
     * @throws IOException
     */
    @FXML
    public void onActionPartSave(javafx.event.ActionEvent actionEvent) throws IOException {


        try{
        //Parses the text fields and converts them to the appropriate primitive
            //TODO take away parsing and add static int
        int id = next_ID++;
        String name = addPartNameTxt.getText();
        int stock = Integer.parseInt(addPartInvTxt.getText());
        double price = Double.parseDouble(addPartPriceTxt.getText());
        int min = Integer.parseInt(addPartMinTxt.getText());
        int max = Integer.parseInt(addPartMaxTxt.getText());


        //To make it easier, make variable names above match the object variable names
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");


            if (Integer.parseInt(addPartMaxTxt.getText()) < Integer.parseInt(addPartMinTxt.getText())) {
                alert.setContentText("Max value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(addPartInvTxt.getText()) > Integer.parseInt(addPartMaxTxt.getText())) {
                alert.setContentText("Inventory value cannot be greater than Max value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(addPartInvTxt.getText()) < Integer.parseInt(addPartMinTxt.getText())) {
                alert.setContentText("Inventory value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }



         else{
                if (addPartIHRB.isSelected() == true) {
                    System.out.println("in house worked");
                    int machineId = Integer.parseInt(addPartMacIDTxt.getText());
                    Inventory.addPart(new InHouse(id, name, stock, price, min, max, machineId));
                }

                if (addPartOSRB.isSelected() == true) {
                    System.out.println("this worked");
                    String companyName = addPartMacIDTxt.getText();
                    Inventory.addPart(new Outsourced(id, name, stock, price, min, max, companyName));
                }
            }


        //----This block of code takes you back to main after you input new object----
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();}

        catch(NumberFormatException numEx){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Please enter valid values in text fields");
            error.showAndWait();
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        addPartIHRB.setSelected(true);
        addPartIHRB.setOnAction(value-> {sourceLabel.setText("Machine ID");});
        addPartIHRB.setSelected(false);
        addPartOSRB.setSelected(true);
        addPartOSRB.setOnAction(value-> {sourceLabel.setText("Company Name");});
        addPartOSRB.setSelected(false);
        addPartIHRB.setSelected(true);
        addPartIHRB.setOnAction(value-> {sourceLabel.setText("Machine ID");});


    }
}
