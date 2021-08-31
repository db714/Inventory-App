package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

//TODO might need to change radio button labels for each fxml screen
public class Modify_Part {

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

    @FXML
    public void onActionmodPartIH(ActionEvent event) {

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

    @FXML
    public void onActionmodPartOS(ActionEvent event) {

    }

    @FXML
    public void onActionmodPartPrice(ActionEvent event) {

    }

    @FXML
    public void onActionmodPartSave(ActionEvent event) {

    }

}
