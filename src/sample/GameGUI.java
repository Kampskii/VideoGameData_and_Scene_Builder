package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Video Game Data & Scene Builder");
        primaryStage.setScene(new Scene(root, 854, 423));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
