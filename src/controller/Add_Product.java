package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Add_Product implements Initializable {
    Product product;
    Stage stage;
    Parent scene;
    //TODO added this list to add product
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

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
    private TableView<Part> addProdPartTable;

    @FXML
    private TableColumn<Part, Integer> addProdPartIDCol;

    @FXML
    private TableColumn<Part, String> addProdPartNameCol;

    @FXML
    private TableColumn<Part, Integer> addProdPartInvCol;

    @FXML
    private TableColumn<Part, Double> addProdPartPriceCol;

    @FXML
    private TableView<Part> addProdSlctPartTable;

    @FXML
    private TableColumn<Part, Integer> addProdAssPartIDCol;

    @FXML
    private TableColumn<Part, String> addProdAssPartNameCol;

    @FXML
    private TableColumn<Part, Integer> addProdAssPartInvCol;

    @FXML
    private TableColumn<Part, Double> addProdAssPartPriceCol;


    @Override
    public void initialize(URL location, ResourceBundle rb){

        //product.getAssParts();
        System.out.println("made it to the initializer");

        //addProdSlctPartTable.setItems(product.getAssParts());
    }

    @FXML
    void onActionAddProdAdd(ActionEvent event) {
        //TODO changed the class to an instance operation

        product.addAssPart(addProdPartTable.getSelectionModel().getSelectedItem());

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

        try {
            //Parses the text fields and converts them to the appropriate primitive
            int id = Integer.parseInt(addProdIDTxt.getText());
            //int id = 0;
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

        catch(NumberFormatException numEx) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Please enter valid values in text fields");
            error.showAndWait();
        }


    }

    @FXML
    void onActionAddProdSrch(ActionEvent event) {

    }


    public void receiveTableTwo(){
        addProdPartTable.setItems(Inventory.getAllParts());

        addProdPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void receiveSlctTable(){
//TODO changed the class to an instance operation

        //addProdSlctPartTable.setItems(Product.getAssParts());

        addProdAssPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdAssPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdAssPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdAssPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}

