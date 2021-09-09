package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import org.w3c.dom.ls.LSOutput;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 1100, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        //Test product object
        Product product1 = new Product(1,"Toy", 3, 5.99, 1,2);
        Product product2 = new Product(5,"Car", 2, 34565.99, 1,7);

        //adding test product1 above to observable list
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);


        //Test part object
        Part part1 = new InHouse(1,"Toy", 3, 17.99, 1,2, 2);
        Part part2 = new InHouse(5,"Basketball", 6, 20.99, 1,2, 2);

        //adding test part1 above to observable list
        Inventory.addPart(part1);

        //Test assPart object
        Part assPart1 = part1;


        //adding test assPart1 above to observable list
        Product.addAssPart(part1);

        //adding an allPart to assPart


        launch(args);
    } {

    }




}
