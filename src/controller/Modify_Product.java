package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Modify_Product implements Initializable {

    Stage stage;
    Parent scene;

    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();

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
    private TableView<Part> modProSlctTable;

    @FXML
    private TableColumn<Part, Integer> modProSlctPartIDCol;

    @FXML
    private TableColumn<Part, String> modProSlctPartNameCol;

    @FXML
    private TableColumn<Part, Integer> modProSlctPartInvCol;

    @FXML
    private TableColumn<Part, Double> modProSlctPartPriceCol;

    @FXML
    private TableView<Part> modProdAssPTable;

    @FXML
    private TableColumn<Part, Integer> modProdAssPIDCol;

    @FXML
    private TableColumn<Part, String> modProdAssPNameCol;

    @FXML
    private TableColumn<Part, Integer> modProdAssPInvCol;

    @FXML
    private TableColumn<Part, Double> modProdAssPPrideCol;

    /**
     * onActionModProAdd method adds part to selected part table
     * @param event user clicks add button
     */
    @FXML
    void onActionModProAdd(ActionEvent event) {

        Part selectedPart = modProSlctTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        if(selectedPart != null){
        associatedPartsList.add(selectedPart);
        }

        if(selectedPart == null){alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select part to add");
            alert.showAndWait();}



    }

    /**
     * onActionModProCncl method disregards changes made to product and returns to main screen
     * @param actionEvent user clicks cancel button
     * @throws IOException
     */
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

    /**
     * onActionModProRmv method removes associated part from table
     * @param event user click remove button
     */
    @FXML
    void onActionModProRmv(ActionEvent event) {
        Part selectedPart = modProdAssPTable.getSelectionModel().getSelectedItem();
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
     * onActionModProSave method saves changes to product object and returns to main screen
     * @param actionEvent user clicks save button error is thrown in fields have incorrect values
     * @throws IOException
     */
    @FXML
    void onActionModProSave(javafx.event.ActionEvent actionEvent) throws IOException {

        try {


            //Parses the text fields and converts them to the appropriate primitive
            int id = Integer.parseInt(modProIDTxt.getText());
            String name = modProNameTxt.getText();
            int stock = Integer.parseInt(modProInvTxt.getText());
            double price = Double.parseDouble(modProPriceTxt.getText());
            int min = Integer.parseInt(modProMinTxt.getText());
            int max = Integer.parseInt(modProMaxTxt.getText());

            //To make it easier, make variable names above match the object variable names
            //Inventory.updateProduct(id, new Product(id, name, stock, price, min, max));

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");

            //TODO something needs to go here that actually saves the associated parts table to the associated parts list
            if (Integer.parseInt(modProMaxTxt.getText()) < Integer.parseInt(modProMinTxt.getText())) {
                alert.setContentText("Max value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(modProInvTxt.getText()) > Integer.parseInt(modProMaxTxt.getText())) {
                alert.setContentText("Inventory value cannot be greater than Max value!");
                alert.showAndWait();
                return;
            }
            if (Integer.parseInt(modProIDTxt.getText()) < Integer.parseInt(modProMinTxt.getText())) {
                alert.setContentText("Inventory value cannot be less than Min value!");
                alert.showAndWait();
                return;
            }
            else {
                Product p = new Product(id, name, stock, price, min, max);
                Inventory.updateProduct(id, p);

                System.out.println(associatedPartsList.size());


                for (int i = 0; i < associatedPartsList.size(); i++) {
                    p.addAssPart(associatedPartsList.get(i));
                    System.out.println(p.getAssParts());

                }

            }
            //Inventory.addProduct(new Product(id, name, stock, price, min, max));

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
     * onActionModProSearch method uses search bar to find parts listed in parts table
     * @param event uses inputs ID or Name to find match error is thrown if no match
     */
    @FXML
    void onActionModProSearch(ActionEvent event) {

        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        String input = modProSearchTxt.getText();
        for(Part x : Inventory.getAllParts()){
            if(x.getName().contains(input) || Integer.toString(x.getId()).contains(input)) {
                filteredParts.add(x);
            }
        }
        modProSlctTable.setItems(filteredParts);

        if (filteredParts.isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Part not found");
            error.showAndWait();}
        return;


    }

    /**
     * receiveProduct method loads product variables into text fields
     * @param product
     */
    public void receiveProduct(Product product){
        //Getting different value getters and placing them inside text fields (sometimes converting ints to strings)
        modProIDTxt.setText(String.valueOf(product.getId()));
        modProNameTxt.setText(product.getName());
        modProInvTxt.setText(String.valueOf(product.getStock()));
        modProPriceTxt.setText(String.valueOf(product.getPrice()));
        modProMaxTxt.setText(String.valueOf(product.getMax()));
        modProMinTxt.setText(String.valueOf(product.getMin()));
    }

    /**
     * receiveTable loads all parts into table
     */
    public void receiveTable(){
        modProSlctTable.setItems(Inventory.getAllParts());

        modProSlctPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProSlctPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProSlctPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProSlctPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * receiveModSlctTable loads associated parts into table
     * @param product
     */
    public void receiveModSlctTable(Product product){

        Product p = product;
        modProdAssPTable.setItems(p.getAssParts());

        modProdAssPIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdAssPNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdAssPInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdAssPPrideCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsList = p.getAssParts();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


}


