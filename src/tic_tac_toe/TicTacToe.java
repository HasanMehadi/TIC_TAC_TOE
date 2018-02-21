package tic_tac_toe;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class TicTacToe extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("tic_tac_toe_UI/ticTacToe.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);
        stage.getIcons().add(new Image("Tic-Tac-Toe-Game-grey.ico"));



        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
