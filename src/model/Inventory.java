package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXML;



import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class Inventory {
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /**
     * addProduct method adds new product to products list
     * @param product
     */
    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    /**
     * addPart method adds new part to parts list
     * @param part
     */
    public static void addPart(Part part) {
        allParts.add(part);
    }

    /**
     * getAllProducts method returns all product from list
     * @return
     */
    public static ObservableList<Product> getAllProducts() {

        return allProducts;
    }


    /**
     * getAllParts method returns all parts from list
     * @return
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * updateProduct method updates product already in list
     * @param id
     * @param product
     */
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


    /**
     * updatePart method updates part already in list
     * @param id
     * @param part
     */
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

    /**
     * deleteProduct method deletes product from list
     * @param product
     */
    public static void deleteProduct(Product product){

        allProducts.remove(product);

    }

    /**
     * deletePart method deletes part from list
     * @param part
     */
    public static void deletePart(Part part){

        allParts.remove(part);

    }
}




