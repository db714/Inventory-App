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
    private static int next_ID = 1;
    //TODO added this list to add product
    //private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();

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

    /***
     * OnActionAddProdAdd method adds a part to the associated parts table.
     * @param event user clicks the add button.
     */
    @FXML
    void onActionAddProdAdd(ActionEvent event) {
        Part selectedPart = addProdPartTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);


        if(selectedPart != null){
        associatedPartsList.add(selectedPart);
        }
        //product.addAssPart(addProdPartTable.getSelectionModel().getSelectedItem());

        if(selectedPart == null){

            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select part to add");
            alert.showAndWait();
        }
    }



    /***
     * OnActionAddProdCancel method closes the scene, returning user to the Main Screen.
     * @param actionEvent user clicks the cancel button.
     * @throws IOException possible exception.
     */
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

    /**
     * onActonAddProdRmv method removes associated part from table
     * @param event
     */
    @FXML
    void onActionAddProdRmv(ActionEvent event) {

        Part selectedPart = addProdSlctPartTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        if(selectedPart != null){
            associatedPartsList.remove(selectedPart);}

        if(selectedPart == null){

            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select part to remove");
            alert.showAndWait();
        }

    }

    /**
     * onActionAddProdSave method saves new product object and returns to main screen
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    void onActionAddProdSave(javafx.event.ActionEvent actionEvent) throws IOException {


            //Parses the text fields and converts them to the appropriate primitive
            //int id = Integer.parseInt(addProdIDTxt.getText();

        try {
            int id = next_ID++;
            String name = addProdNameTxt.getText();
            int stock = Integer.parseInt(addProdInvTxt.getText());
            double price = Double.parseDouble(addProdPriceTxt.getText());
            int min = Integer.parseInt(addProdMinTxt.getText());
            int max = Integer.parseInt(addProdMaxTxt.getText());


            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");

            //TODO something needs to go here that actually saves the associated parts table to the associated parts list
            if (Integer.parseInt(addProdMaxTxt.getText()) < Integer.parseInt(addProdMinTxt.getText())) {
                alert.setContentText("Max value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(addProdInvTxt.getText()) > Integer.parseInt(addProdMaxTxt.getText())) {
                alert.setContentText("Inventory value cannot be greater than Max value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(addProdInvTxt.getText()) < Integer.parseInt(addProdMinTxt.getText())) {
                alert.setContentText("Inventory value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }

                else {
                //To make it easier, make variable names above match the object variable names
                Product p = new Product(id, name, stock, price, min, max);
                Inventory.addProduct(p);

                for (int i = 0; i < associatedPartsList.size(); i++) {
                    p.addAssPart(associatedPartsList.get(i));
                    System.out.println(p.getAssParts());
                }
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
     * onActionAddProdSrch method uses search bar to find an item contained in parts table either by ID or Name
     * @param event
     */
    @FXML
    void onActionAddProdSrch(ActionEvent event) {

        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        String input = addProdSrchTxt.getText();
        for(Part x : Inventory.getAllParts()){
            if(x.getName().contains(input) || Integer.toString(x.getId()).contains(input)) {
                filteredParts.add(x);
            }
        }
        addProdPartTable.setItems(filteredParts);

        if (filteredParts.isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Part not found");
            error.showAndWait();}
        return;


    }

    /**
     * receiveTableTwo method sends information to populate all parts table on addProduct page
     */
    public void receiveTableTwo(){
        addProdPartTable.setItems(Inventory.getAllParts());

        addProdPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * receiveSlctTable method sends information to populate associated parts table on addProduct page
     */
    public void receiveSlctTable(){
//

        //addProdSlctPartTable.setItems(Product.getAssParts());
        addProdSlctPartTable.setItems(associatedPartsList);

        addProdAssPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdAssPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdAssPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdAssPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}

