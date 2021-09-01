package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXML;



import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class Inventory {
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();


    public static void addProduct(Product product){
        allProducts.add(product);
    }

    public static void addPart(Part part){
        allParts.add(part);
    }

    public static ObservableList<Product> getAllProducts(){

        return allProducts;
    }

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }




}



