package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Inventory;
import model.Product;
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
        Product product1 = new Product(1,"Toy", 5.99, 5, 1,2);

        //adding test product1 above to observable list
        Inventory.addProduct(product1);

        launch(args);
    } {

    }




}
