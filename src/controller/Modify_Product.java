package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Modify_Product {

    Stage stage;
    Parent scene;

    @FXML
    private TextField modProIDTxt;

    @FXML
    private TextField modProNameTxt;

    @FXML
    private TextField modProInvTxt;

    @FXML
    private TextField modProPriceTxt;

    @FXML
    private TextField modProMinTxt;

    @FXML
    private TextField modProMaxTxt;

    @FXML
    private TextField modProSearchTxt;

    @FXML
    private Button modProAddBut;

    @FXML
    private Button modProRmvBut;

    @FXML
    private Button modProCnclBut;

    @FXML
    private Button modProSaveBut;

    @FXML
    private TableView<?> modProSlctTable;

    @FXML
    private TableColumn<?, ?> modProSlctPartIDCol;

    @FXML
    private TableColumn<?, ?> modProSlctPartNameCol;

    @FXML
    private TableColumn<?, ?> modProSlctPartInvCol;

    @FXML
    private TableColumn<?, ?> modProSlctPartPriceCol;

    @FXML
    private TableView<?> modProdAssPTable;

    @FXML
    private TableColumn<?, ?> modProdAssPIDCol;

    @FXML
    private TableColumn<?, ?> modProdAssPNameCol;

    @FXML
    private TableColumn<?, ?> modProdAssPInvCol;

    @FXML
    private TableColumn<?, ?> modProdAssPPrideCol;

    @FXML
    void onActionModProAdd(ActionEvent event) {

    }

    @FXML
    void onActionModProCncl(javafx.event.ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionModProID(ActionEvent event) {

    }

    @FXML
    void onActionModProInv(ActionEvent event) {

    }

    @FXML
    void onActionModProMax(ActionEvent event) {

    }

    @FXML
    void onActionModProMin(ActionEvent event) {

    }

    @FXML
    void onActionModProName(ActionEvent event) {

    }

    @FXML
    void onActionModProPrice(ActionEvent event) {

    }

    @FXML
    void onActionModProRmv(ActionEvent event) {

    }

    @FXML
    void onActionModProSave(ActionEvent event) {

    }

    @FXML
    void onActionModProSearch(ActionEvent event) {

    }

}
