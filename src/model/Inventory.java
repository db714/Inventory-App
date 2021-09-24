package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXML;



import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class Inventory {
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    //private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
   // private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();

    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    public static void addPart(Part part) {
        allParts.add(part);
    }

    public static ObservableList<Product> getAllProducts() {

        return allProducts;
    }

   /* public static ObservableList<Product> getFilteredProducts() {

        return filteredProducts;
    }

    public static ObservableList<Part> getFilteredParts() {

        return filteredParts;
    }*/


    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static void updateProduct(int id, Product product) {

        int index = -1;

        for (Product x : getAllProducts()) {
            index++;


            if (x.getId() == id) {

                allProducts.set(index, product);


                return;
            }
        }





    }



    public static void updatePart(int id, Part part) {

        int index = -1;

        for (Part x : getAllParts()) {
            index++;


            if (x.getId() == id) {

                allParts.set(index, part);


                return;
            }
        }
    }

    public static void deleteProduct(Product product){

        allProducts.remove(product);

    }

    public static void deletePart(Part part){

        allParts.remove(part);

    }
}




