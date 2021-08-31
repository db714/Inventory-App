package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.EventObject;

public class Add_Part {

    Stage stage;
    Parent scene;

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

    @FXML
    public void onActionPartIH(ActionEvent event) {

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

    @FXML
    public void onActionPartOS(ActionEvent event) {

    }

    @FXML
    public void onActionPartPrice(ActionEvent event) {

    }

    @FXML
    public void onActionPartSave(ActionEvent event) {

    }

}
