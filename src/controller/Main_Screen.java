package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import model.Product;
import model.InHouse;
import model.Outsourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

// TODO remove (((xmlns="http://javafx.com/javafx/16" from Main_Screen.fxml)))
public class Main_Screen implements Initializable {

    Stage stage;
    Parent scene;




    @FXML
    private TableView<Part> partMainTableview;

    @FXML
    private TableColumn<Part, Integer> partIDMainCol;

    @FXML
    private TableColumn<Part, String> partNameMainCol;

    @FXML
    private TableColumn<Part, Integer> partInvMainCol;

    @FXML
    private TableColumn<Part, Double> partPriceMainCol;

    @FXML
    private TableView<Product> prodMainTableview;

    @FXML
    private TableColumn<Product, Integer> prodIDMainCol;

    @FXML
    private TableColumn<Product, String> prodNameMainCol;

    @FXML
    private TableColumn<Product, Integer> prodInvMainCol;

    @FXML
    private TableColumn<Product, Double> prodPriceMainCol;

    @FXML
    private Button mainExitBut;

    @FXML
    private Button partAddMainBut;

    @FXML
    private Button partDelMainBut;

    @FXML
    private Button partModMainBut;

    @FXML
    private Button prodDelMainBut;

    @FXML
    private Button prodAddMainBut;

    @FXML
    private Button prodModMainBut;

    @FXML
    private TextField partMainTxt;

    @FXML
    private TextField prodMainTxt;

   /* @FXML
    void onActionMainExit(ActionEvent event) {
        System.out.println("This Exits the System");
    }

    @FXML
    void onActionPartAdd(ActionEvent event) {

    }

    @FXML
    void onActionPartDel(ActionEvent event) {

    }

    @FXML
    void onActionPartMod(ActionEvent event) {

    }

    @FXML
    void onActionProdAdd(ActionEvent event) {

    }

    @FXML
    void onActionProdDel(ActionEvent event) {

    }

    @FXML
    void onActionProdMod(ActionEvent event) {

    }
*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        prodMainTableview.setItems(Inventory.getAllProducts());


        prodIDMainCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodNameMainCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodInvMainCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPriceMainCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        partMainTableview.setItems(Inventory.getAllParts());

        partIDMainCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameMainCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvMainCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceMainCol.setCellValueFactory(new PropertyValueFactory<>("price"));






    }

    /**
     * onActionPartAdd method loads addPart page
     * @param actionEvent user clicks add button
     * @throws IOException
     */
    public void onActionPartAdd(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Add_Part.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();
    }

    /**
     * onActionMainExit method exits the application
     * @param actionEvent user clicks exit button
     */
    public void onActionMainExit(ActionEvent actionEvent) {

        System.exit(0);
    }

    /**
     * onActionPartDel method deletes part specified
     * @param actionEvent user clicks delete button error is thrown if nothing is selected
     */
    public void onActionPartDel(ActionEvent actionEvent) {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirm Dialog");
        confirmation.setContentText("Do you want to delete this part?");

        Optional<ButtonType> result = confirmation.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {

            Inventory.deletePart((partMainTableview.getSelectionModel().getSelectedItem()));
        }
    }

    /**
     * onActionPartMod method modifies part specified
     * @param actionEvent user clicks modify button error is thrown if nothing is selected
     * @throws IOException
     */
    public void onActionPartMod(ActionEvent actionEvent) throws IOException {
    try {
        //to use loader() methods you must first instantiate
        FXMLLoader loader = new FXMLLoader();
        //identifying the destination location
        loader.setLocation(getClass().getResource("/view/Modify_Part.fxml"));
        //loading(with the loader instance)
        loader.load();
        //creating an instance for the second controller so methods can be used from that class
        Modify_Part modProdController = loader.getController();
        //sending selected items from the tableview to place in the modProd controller screen
        Part p = partMainTableview.getSelectionModel().getSelectedItem();
        modProdController.receivePart(p);


        //casting to the button on main
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        //telling program where we want it to go once button is clicked
        //scene = FXMLLoader.load(getClass().getResource("/view/Modify_Product.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();
    }
    catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select part to modify");
            alert.showAndWait();
        }


    }

    /**
     * onActionProdDel method deletes product specified
     * @param actionEvent user clicks Delete button error is thrown if nothing specified
     */
    public void onActionProdDel(ActionEvent actionEvent) {
        Product selectedProduct = prodMainTableview.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if( selectedProduct != null) {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirm Dialog");
            confirmation.setContentText("Do you want to delete this product?");

            Optional<ButtonType> result = confirmation.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK && selectedProduct.getAssParts().isEmpty() == true) {
                Inventory.deleteProduct((prodMainTableview.getSelectionModel().getSelectedItem()));
            }

            else{alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Must remove ALL associated parts before delete");
                alert.showAndWait();}
        }

        else{
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select Product to delete");
            alert.showAndWait();
        }
    }

    /**
     * onActionProdAdd loads addProduct page
     * @param actionEvent user click add button
     * @throws IOException
     */
    public void onActionProdAdd(ActionEvent actionEvent) throws IOException {

        FXMLLoader loaderAdd = new FXMLLoader();
        loaderAdd.setLocation(getClass().getResource("/view/Add_Product.fxml"));
        loaderAdd.load();
        Add_Product addProdController = loaderAdd.getController();
        addProdController.receiveTableTwo();
        addProdController.receiveSlctTable();


        //casting to the button on main
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        Parent scene = loaderAdd.getRoot();
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();


    }

    /**
     * onActionProdMod method loads modifyProduct page so that product selected can be modified
     * @param actionEvent user clicks modify error is thrown if nothing selected
     * @throws IOException
     */
    public void onActionProdMod(ActionEvent actionEvent) throws IOException {
        try {
            //to use loader() methods you must first instantiate
            FXMLLoader loader = new FXMLLoader();
            //identifying the destination location
            loader.setLocation(getClass().getResource("/view/Modify_Product.fxml"));
            //loading(with the loader instance)
            loader.load();
            //creating an instance for the second controller so methods can be used from that class
            Modify_Product modProdController = loader.getController();
            //sending selected items from the tableview to place in the modProd controller screen
            //TODO this line is new
            Product p = prodMainTableview.getSelectionModel().getSelectedItem();
            //modProdController.receiveProduct(prodMainTableview.getSelectionModel().getSelectedItem());
            modProdController.receiveProduct(p);
            //****TESTING****
            modProdController.receiveTable();

            modProdController.receiveModSlctTable(p);


            //casting to the button on main
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            //telling program where we want it to go once button is clicked
            //scene = FXMLLoader.load(getClass().getResource("/view/Modify_Product.fxml"));
            //program makes new scene
            stage.setScene(new Scene(scene));
            //new scene starts
            stage.show();
        }

        catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select product to modify");
            alert.showAndWait();
        }


    }

    /*public ObservableList<Product> filter(String name){
        for(Product x : Inventory.getAllProducts()){
            if(x.getName().contains(name)){
                Inventory.getFilteredProducts().add(x);
            }

        }
        return Inventory.getFilteredProducts();

    }*/

    /**
     * onActionProdSrch method uses search bar to find products contained in table
     * @param event user types either ID or name error is displayed if nothing found
     */
    @FXML
    void onActionProdSrch(ActionEvent event) {
    //made new obList to insert filtered items into and then  displayed new list on tableview
      ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
      String input = prodMainTxt.getText();
      for(Product x : Inventory.getAllProducts()){
          if(x.getName().contains(input) || Integer.toString(x.getId()).contains(input)){
              filteredProducts.add(x);
          }
      }
      prodMainTableview.setItems(filteredProducts);

        if (filteredProducts.isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Part not found");
            error.showAndWait();}

      return;




        /*String input = prodMainTxt.getText();

        int index = -1;

        for (Product x : Inventory.getAllProducts()) {
            index++;

            //using '.equals()' to compare strings
            if (x.getName().contains(input) || Integer.toString(x.getId()).contains(input)) {
                prodMainTableview.getSelectionModel();
                        //select(x);


                return;
            }
        }*/
    }

    /**
     * onActionPartSrch method uses search bar to find products contained in table
     * @param event user types either ID or name error is displayed if nothing found
     */
    @FXML
    void onActionPartSrch(ActionEvent event) {

        //made new obList to insert filtered items into and then  displayed new list on tableview
        ObservableList<Part> filteredParts = FXCollections.observableArrayList();
        String input = partMainTxt.getText();
        for(Part x : Inventory.getAllParts()){
            if(x.getName().contains(input) || Integer.toString(x.getId()).contains(input)) {
                filteredParts.add(x);
            }
        }
        partMainTableview.setItems(filteredParts);

        if (filteredParts.isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Part not found");
            error.showAndWait();}
        return;


        /*String input = partMainTxt.getText();

        int index = -1;

        for (Part x : Inventory.getAllParts()) {
            index++;

            //using '.equals()' to compare strings
            if (x.getName().equals(input) || Integer.toString(x.getId()).equals(input)) {
                partMainTableview.getSelectionModel().select(x);


                return;

            }
        */
    }
}