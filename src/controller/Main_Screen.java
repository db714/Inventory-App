package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Product;
import model.InHouse;
import model.Outsourced;
import model.Part;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.net.URL;
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

    public void onActionPartAdd(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Add_Part.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();
    }

    public void onActionMainExit(ActionEvent actionEvent) {

        System.exit(0);
    }

    public void onActionPartDel(ActionEvent actionEvent) {

       Inventory.deletePart((partMainTableview.getSelectionModel().getSelectedItem()));
    }


    public void onActionPartMod(ActionEvent actionEvent) throws IOException {

        //to use loader() methods you must first instantiate
        FXMLLoader loader = new FXMLLoader();
        //identifying the destination location
        loader.setLocation(getClass().getResource("/view/Modify_Part.fxml"));
        //loading(with the loader instance)
        loader.load();
        //creating an instance for the second controller so methods can be used from that class
        Modify_Part modProdController = loader.getController();
        //sending selected items from the tableview to place in the modProd controller screen
        modProdController.receivePart(partMainTableview.getSelectionModel().getSelectedItem());


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

    public void onActionProdDel(ActionEvent actionEvent) {
        Inventory.deleteProduct((prodMainTableview.getSelectionModel().getSelectedItem()));
    }

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

    public void onActionProdMod(ActionEvent actionEvent) throws IOException {

        //to use loader() methods you must first instantiate
        FXMLLoader loader = new FXMLLoader();
        //identifying the destination location
        loader.setLocation(getClass().getResource("/view/Modify_Product.fxml"));
        //loading(with the loader instance)
        loader.load();
        //creating an instance for the second controller so methods can be used from that class
        Modify_Product modProdController = loader.getController();
        //sending selected items from the tableview to place in the modProd controller screen
        modProdController.receiveProduct(prodMainTableview.getSelectionModel().getSelectedItem());
        //****TESTING****
        modProdController.receiveTable();
        modProdController.receiveModSlctTable();


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

    @FXML
    void onActionProdSrch(ActionEvent event) {
        String input = prodMainTxt.getText();

        int index = -1;

        for (Product x : Inventory.getAllProducts()) {
            index++;

            //using '.equals()' to compare strings
            if (x.getName().equals(input) || Integer.toString(x.getId()).equals(input)) {
                prodMainTableview.getSelectionModel().select(x);


                return;
            }
        }
    }


    @FXML
    void onActionPartSrch(ActionEvent event) {
        String input = partMainTxt.getText();

        int index = -1;

        for (Part x : Inventory.getAllParts()) {
            index++;

            //using '.equals()' to compare strings
            if (x.getName().equals(input) || Integer.toString(x.getId()).equals(input)) {
                partMainTableview.getSelectionModel().select(x);


                return;

            }
        }
    }
}