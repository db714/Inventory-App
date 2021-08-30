package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Inventory;
import model.Product;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

// TODO remove (((xmlns="http://javafx.com/javafx/16" from Main_Screen.fxml)))
public class Main_Screen implements Initializable {
   /* @FXML
    private TableView<?> partMainTableview;

    @FXML
    private TableColumn<?, ?> partIDMainCol;

    @FXML
    private TableColumn<?, ?> partNameMainCol;

    @FXML
    private TableColumn<?, ?> partInvMainCol;

    @FXML
    private TableColumn<?, ?> partPriceMainCol;

    @FXML
    private TableView<?> prodMainTableview;

    @FXML
    private TableColumn<?, ?> prodIDMainCol;

    @FXML
    private TableColumn<?, ?> prodNameMainCol;

    @FXML
    private TableColumn<?, ?> prodInvMainCol;

    @FXML
    private TableColumn<?, ?> prodPriceMainCol;
*/
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
   public void initialize(URL url, ResourceBundle rb){

   }

    public void onActionPartAdd(javafx.event.ActionEvent actionEvent) {
    }

    public void onActionMainExit(ActionEvent actionEvent) {
        System.out.println("This should exit the program!!!!");
    }

    public void onActionPartDel(ActionEvent actionEvent) {
    }

    public void onActionPartMod(ActionEvent actionEvent) {
    }

    public void onActionProdDel(ActionEvent actionEvent) {
    }

    public void onActionProdAdd(ActionEvent actionEvent) {
    }

    public void onActionProdMod(ActionEvent actionEvent) {
    }

    //productTableView.setItems(Inventory.getAllProducts());
 //   }
}
