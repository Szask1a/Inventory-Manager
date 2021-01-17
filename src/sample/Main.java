package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Inventory Manager");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("https://i.imgur.com/7a3xGoS.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
