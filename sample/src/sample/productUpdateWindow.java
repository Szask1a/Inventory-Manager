package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class productUpdateWindow extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("empUpdateWindow.fxml"));
        primaryStage.setTitle("Billing System");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("https://i.imgur.com/b0s2e6S.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
