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

        //adding test product1 above to observable list
        Inventory.addProduct(product1);


        //Test part object
        Part part1 = new InHouse(1,"Toy", 3, 17.99, 1,2, 2);

        //adding test part1 above to observable list
        Inventory.addPart(part1);

        launch(args);
    } {

    }




}
