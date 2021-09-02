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
import model.Inventory;
import model.Product;

import java.io.IOException;

public class Add_Product {

    Stage stage;
    Parent scene;

    @FXML
    private TextField addProdIDTxt;

    @FXML
    private TextField addProdNameTxt;

    @FXML
    private TextField addProdInvTxt;

    @FXML
    private TextField addProdPriceTxt;

    @FXML
    private TextField addProdMinTxt;

    @FXML
    private TextField addProdMaxTxt;

    @FXML
    private TextField addProdSrchTxt;

    @FXML
    private Button addProdAddBut;

    @FXML
    private Button addProdRmvBut;

    @FXML
    private Button addProdCnclBut;

    @FXML
    private Button addProdSaveBut;

    @FXML
    private TableView<?> addProdPartTable;

    @FXML
    private TableColumn<?, ?> addProdPartIDCol;

    @FXML
    private TableColumn<?, ?> addProdPartNameCol;

    @FXML
    private TableColumn<?, ?> addProdPartInvCol;

    @FXML
    private TableColumn<?, ?> addProdPartPriceCol;

    @FXML
    private TableView<?> addProdSlctPartTable;

    @FXML
    private TableColumn<?, ?> addProdAssPartIDCol;

    @FXML
    private TableColumn<?, ?> addProdAssPartNameCol;

    @FXML
    private TableColumn<?, ?> addProdAssPartInvCol;

    @FXML
    private TableColumn<?, ?> addProdAssPartPriceCol;

    @FXML
    void onActionAddProdAdd(ActionEvent event) {

    }

    @FXML
    void onActionAddProdCncl(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionAddProdID(ActionEvent event) {

    }

    @FXML
    void onActionAddProdInv(ActionEvent event) {

    }

    @FXML
    void onActionAddProdMax(ActionEvent event) {

    }

    @FXML
    void onActionAddProdMin(ActionEvent event) {

    }

    @FXML
    void onActionAddProdName(ActionEvent event) {

    }

    @FXML
    void onActionAddProdPrice(ActionEvent event) {

    }

    @FXML
    void onActionAddProdRmv(ActionEvent event) {

    }

    @FXML
    void onActionAddProdSave(javafx.event.ActionEvent actionEvent) throws IOException {
        //Parses the text fields and converts them to the appropriate primitive
        int id = Integer.parseInt(addProdIDTxt.getText());
        String name = addProdNameTxt.getText();
        int stock = Integer.parseInt(addProdInvTxt.getText());
        double price = Double.parseDouble(addProdPriceTxt.getText());
        int min = Integer.parseInt(addProdMinTxt.getText());
        int max = Integer.parseInt(addProdMaxTxt.getText());

        //To make it easier, make variable names above match the object variable names
        Inventory.addProduct(new Product(id, name, stock, price, min, max));

        //----This block of code takes you back to main after you input new object----
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();


    }

    @FXML
    void onActionAddProdSrch(ActionEvent event) {

    }

}

