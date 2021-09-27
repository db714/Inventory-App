package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Modify_Part implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TextField modPartIDTxt;

    @FXML
    private TextField modPartNameTxt;

    @FXML
    private TextField modPartInvTxt;

    @FXML
    private TextField modPartPriceTxt;

    @FXML
    private TextField modPartMaxTxt;

    @FXML
    private TextField modPartMinTxt;

    @FXML
    private Button modPartSaveBut;

    @FXML
    private Button modPartCancelBut;

    @FXML
    private RadioButton modPartIHRB;

    @FXML
    private ToggleGroup sourceTog;

    @FXML
    private RadioButton modPartOSRB;

    @FXML
    private TextField modPartMacIDTxt;

    @FXML
    private Label modSourceLabel;

    /**
     * onActionmodPartCancel method disregards changes made to part and returns to main screen
     * @param actionEvent user clicks cancel button
     * @throws IOException
     */

    @FXML
    public void onActionmodPartCancel(javafx.event.ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();

    }

    @FXML
    public void onActionmodPartID(ActionEvent event) {

    }

    /**
     * onActionPartIH method sets modSourceLabel to Machine ID when IH radio button is clicked
     * @param event user clicks InHouse radio button
     */
    @FXML
    public void onActionmodPartIH(ActionEvent event) {

        modPartIHRB.setOnAction(value-> {modSourceLabel.setText("Machine ID");});

    }

    @FXML
    public void onActionmodPartInv(ActionEvent event) {

    }

    @FXML
    public void onActionmodPartMacID(ActionEvent event) {

    }

    @FXML
    public  void onActionmodPartMax(ActionEvent event) {

    }

    @FXML
    public void onActionmodPartMin(ActionEvent event) {

    }

    @FXML
    public void onActionmodPartName(ActionEvent event) {

    }

    /**
     * onActionmodPartOS method sets modSourceLabel to Company Name when OS radio button is clicked
     * @param event user click OS radio button
     */
    @FXML
    public void onActionmodPartOS(ActionEvent event) {

        modPartOSRB.setOnAction(value-> {modSourceLabel.setText("Company Name");});

    }

    @FXML
    public void onActionmodPartPrice(ActionEvent event) {

    }

    /**
     * onActionmodPartSave method saves changes made to part and returns to main screen
     * @param actionEvent user clicks save button error is thrown if fields are incorrect
     * @throws IOException
     */
    @FXML
    public void onActionmodPartSave(javafx.event.ActionEvent actionEvent) throws IOException {
        boolean rb = modPartIHRB.isSelected();

        try {
            //Parses the text fields and converts them to the appropriate primitive
            int id = Integer.parseInt(modPartIDTxt.getText());
            String name = modPartNameTxt.getText();
            int stock = Integer.parseInt(modPartInvTxt.getText());
            double price = Double.parseDouble(modPartPriceTxt.getText());
            int min = Integer.parseInt(modPartMinTxt.getText());
            int max = Integer.parseInt(modPartMaxTxt.getText());
            //int machineId = Integer.parseInt(modPartMacIDTxt.getText());

            //To make it easier, make variable names above match the object variable names
            if(rb == true){

                int machineId = Integer.parseInt(modPartMacIDTxt.getText());
                Inventory.updatePart(id, new InHouse(id, name, stock, price, min, max, machineId));

            }

            if(rb == false){

                String companyName = modPartMacIDTxt.getText();
                Inventory.updatePart(id, new Outsourced(id, name, stock, price, min, max, companyName));

            }

            //----This block of code takes you back to main after you input new object----
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            //telling program where we want it to go once button is clicked
            scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
            //program makes new scene
            stage.setScene(new Scene((Parent) scene));
            //new scene starts
            stage.show();
        }

        catch(NumberFormatException numEx) {

            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Please enter valid values in text fields");
            error.showAndWait();
        }
    }

    /**
     * receivePart method sets part variables into text fields
     * @param part
     */
    public void receivePart(Part part){
        //Getting different value getters and placing them inside text fields (sometimes converting ints to strings)
        modPartIDTxt.setText(String.valueOf(part.getId()));
        modPartNameTxt.setText(part.getName());
        modPartInvTxt.setText(String.valueOf(part.getStock()));
        modPartPriceTxt.setText(String.valueOf(part.getPrice()));
        modPartMaxTxt.setText(String.valueOf(part.getMax()));
        modPartMinTxt.setText(String.valueOf(part.getMin()));

        if(part instanceof InHouse){
            modPartMacIDTxt.setText(String.valueOf(((InHouse)part).getMachineId()));
            modPartIHRB.setSelected(true);
            modSourceLabel.setText("Machine ID");
        }

        if(part instanceof Outsourced){
        modPartMacIDTxt.setText(String.valueOf(((Outsourced)part).getCompanyName()));
            modPartOSRB.setSelected(true);
            modSourceLabel.setText("Company Name");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        modPartOSRB.setSelected(true);
        modPartIHRB.setOnAction(value-> {modSourceLabel.setText("Machine ID");});
        modPartIHRB.setSelected(false);
        modPartOSRB.setSelected(true);
        modPartOSRB.setOnAction(value-> {modSourceLabel.setText("Company Name");});
        modPartIHRB.setSelected(false);
        modPartIHRB.setSelected(true);
        modPartMacIDTxt.setOnAction(value-> {modSourceLabel.setText("Company Name");});

    }
}
