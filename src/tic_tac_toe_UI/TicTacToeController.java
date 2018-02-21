package tic_tac_toe_UI;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class TicTacToeController extends TicTacToeMechanics {

    @FXML
    private Button startButton;

    @FXML
    private MenuItem newGameMenuItem, closeMenuItem;

    @FXML
    private Label gameInfoLabel, player2, player1, lblScore1, lblScore2;

    @FXML
    private GridPane hashBox;

    @FXML
    private Pane box7, box8, box5, box6, box3, box4, box1, box2, box0,
            linesPane;

    @FXML
    protected Line line258Win, line147Win, line036Win, line246Win, line678Win,
            line345Win, line012Win, line048Win;




    //x and o win counter
    protected int xCounter = 0;
    protected int oCounter = 0;
    protected String playerOne = "";
    protected String playerTwo = "";

    //get images
    Image x = new Image("x.png");
    Image o = new Image("o.png");
    //add images to ImageView
    ImageView xView = new ImageView(x);
    ImageView oView = new ImageView(o);
    ImageView xView1 = new ImageView(x);
    ImageView oView1 = new ImageView(o);
    ImageView xView2 = new ImageView(x);
    ImageView oView2 = new ImageView(o);
    ImageView xView3 = new ImageView(x);
    ImageView oView3 = new ImageView(o);
    ImageView xView4 = new ImageView(x);
    ImageView oView4 = new ImageView(o);
    ImageView xView5 = new ImageView(x);
    ImageView oView5 = new ImageView(o);
    ImageView xView6 = new ImageView(x);
    ImageView oView6 = new ImageView(o);
    ImageView xView7 = new ImageView(x);
    ImageView oView7 = new ImageView(o);
    ImageView xView8 = new ImageView(x);
    ImageView oView8 = new ImageView(o);

    protected boolean gameStartedOnce = true;

    @FXML
    void newGameMenuItem(ActionEvent event) {

        if(!gameOver){

            gameOver();

        }

        setMessage("It is X's turn");
        newGame();

    }

    @FXML
    void handlecloseMenuItem(ActionEvent event) {
        JFrame frame = new JFrame();
        String message = "are you sure you want to exit the game?";
        int answer = JOptionPane.showConfirmDialog(frame, message);
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(1);
            // User clicked YES.
        } else if (answer == JOptionPane.NO_OPTION) {

            // User clicked NO.
        }


    }

    @FXML
    void handleStartButton(ActionEvent event) {

        //following code sets the player names only in the begining of the game
        if(gameStartedOnce){
            player1.setText(JOptionPane.showInputDialog("Player 1 name:", "Player 1"));
            player2.setText(JOptionPane.showInputDialog("Player 2 name:", "Player 2"));
            gameStartedOnce = false;
        }


        //make start button disappear
        setStartButton(false);

        //make tick tac toe hash appear
        gameInfoLabel.setText("It is X's turn");
        player1.setStyle("-fx-font-weight: bold");
        linesPane.setVisible(true);
        linesPane.setManaged(true);

        newGame();

    }

    @FXML
    void handleHash(MouseEvent event) {

        if(event.getTarget() == box0){

            handleClick(0);

        }else if(event.getTarget() == box1){

            handleClick(1);

        }else if(event.getTarget() == box2){

            handleClick(2);

        }else if(event.getTarget() == box3){

            handleClick(3);

        }else if(event.getTarget() == box4){

            handleClick(4);

        }else if(event.getTarget() == box5){

            handleClick(5);

        }else if(event.getTarget() == box6){

            handleClick(6);

        }else if(event.getTarget() == box7){

            handleClick(7);

        }else if(event.getTarget() == box8){

            handleClick(8);

        }

    }

    public void setMessage(String message){

        gameInfoLabel.setText(message);

    }

    @Override
    //draw x or o
    public void drawLetter(int currentPosition){

        if(isX){

            if(currentPosition == 0){
                box0.getChildren().add(xView);

            }
            if(currentPosition == 1){
                box1.getChildren().add(xView1);

            }
            if(currentPosition == 2){
                box2.getChildren().add(xView2);

            }
            if(currentPosition == 3){
                box3.getChildren().add(xView3);

            }
            if(currentPosition == 4){
                box4.getChildren().add(xView4);

            }
            if(currentPosition == 5){
                box5.getChildren().add(xView5);

            }if(currentPosition == 6){
                box6.getChildren().add(xView6);

            }
            if(currentPosition == 7){
                box7.getChildren().add(xView7);

            }
            if(currentPosition == 8){
                box8.getChildren().add(xView8);

            }

        }

        if(!isX){



            if(currentPosition == 0){
                box0.getChildren().add(oView);

            }
            if(currentPosition == 1){
                box1.getChildren().add(oView1);

            }
            if(currentPosition == 2){
                box2.getChildren().add(oView2);

            }
            if(currentPosition == 3){
                box3.getChildren().add(oView3);

            }
            if(currentPosition == 4){
                box4.getChildren().add(oView4);

            }
            if(currentPosition == 5){
                box5.getChildren().add(oView5);

            }if(currentPosition == 6){
                box6.getChildren().add(oView6);

            }
            if(currentPosition == 7){
                box7.getChildren().add(oView7);

            }
            if(currentPosition == 8){
                box8.getChildren().add(oView8);

            }

        }

    }
    @Override
    //switch turns for x and o
    public void switchTurns(){

        if(!gameTied){

            if(isX){
                currentLetter = 'o';
                isX = false;
                player2.setStyle("-fx-font-weight: bold");
                player1.setStyle("");
                setMessage("It is O's turn");

            }else{
                currentLetter = 'x';
                isX = true;
                player1.setStyle("-fx-font-weight: bold");
                player2.setStyle("");
                setMessage("It is X's turn");
            }

        }

    }

    @Override
    //display results to players
    public void printResults(){

        if(xWon){
            //x wins
            xCounter++;
            lblScore1.setText(String.valueOf(xCounter));
            if(xCounter == 1 && oCounter == 0)
                lblScore2.setText(String.valueOf(oCounter));
            setMessage("X Won!");

            showLine();

        }else if(oWon){
            //o wins
            oCounter++;
            lblScore2.setText(String.valueOf(oCounter));
            if(oCounter == 1 && xCounter == 0)
                lblScore1.setText(String.valueOf(xCounter));
            setMessage("O Won!");

            showLine();

        }else if(gameTied){
            //tie game
            setMessage("Tie Game!");
        }

    }

    @Override
    public void refreshWindow(){

        box0.getChildren().remove(xView);
        box0.getChildren().remove(oView);
        box1.getChildren().remove(xView1);
        box1.getChildren().remove(oView1);
        box2.getChildren().remove(xView2);
        box2.getChildren().remove(oView2);
        box3.getChildren().remove(xView3);
        box3.getChildren().remove(oView3);
        box4.getChildren().remove(xView4);
        box4.getChildren().remove(oView4);
        box5.getChildren().remove(xView5);
        box5.getChildren().remove(oView5);
        box6.getChildren().remove(xView6);
        box6.getChildren().remove(oView6);
        box7.getChildren().remove(xView7);
        box7.getChildren().remove(oView7);
        box8.getChildren().remove(xView8);
        box8.getChildren().remove(oView8);

        line012Win.setVisible(false);
        line345Win.setVisible(false);
        line678Win.setVisible(false);
        line036Win.setVisible(false);
        line147Win.setVisible(false);
        line258Win.setVisible(false);
        line048Win.setVisible(false);
        line246Win.setVisible(false);

    }

    @Override
    public void showStartButton(){

        setStartButton(true);
        startButton.setText("New Game");

    }

    public void setStartButton(boolean makeVisible){

        if(makeVisible){

            startButton.setVisible(true);
            startButton.setManaged(true);

        }else{

            startButton.setVisible(false);
            startButton.setManaged(false);

        }

    }
    public void showLine(){


        //is x wins
        if(xPositionsOccupied[0] && xPositionsOccupied[1]
                && xPositionsOccupied[2]){
            line012Win.setVisible(true);
        }
        if(xPositionsOccupied[3] && xPositionsOccupied[4]
                && xPositionsOccupied[5]){
            line345Win.setVisible(true);
        }
        if(xPositionsOccupied[6] && xPositionsOccupied[7]
                && xPositionsOccupied[8]){
            line678Win.setVisible(true);
        }
        if(xPositionsOccupied[0] && xPositionsOccupied[3]
                && xPositionsOccupied[6]){
            line036Win.setVisible(true);
        }
        if(xPositionsOccupied[1] && xPositionsOccupied[4]
                && xPositionsOccupied[7]){
            line147Win.setVisible(true);
        }
        if(xPositionsOccupied[2] && xPositionsOccupied[5]
                && xPositionsOccupied[8]){
            line258Win.setVisible(true);
        }
        if(xPositionsOccupied[0] && xPositionsOccupied[4]
                && xPositionsOccupied[8]){
            line048Win.setVisible(true);
        }
        if(xPositionsOccupied[2] && xPositionsOccupied[4]
                && xPositionsOccupied[6]){
            line246Win.setVisible(true);
        }

        //if o wins
        if(oPositionsOccupied[0] && oPositionsOccupied[1]
                && oPositionsOccupied[2]){
            line012Win.setVisible(true);
        }
        if(oPositionsOccupied[3] && oPositionsOccupied[4]
                && oPositionsOccupied[5]){
            line345Win.setVisible(true);
        }
        if(oPositionsOccupied[6] && oPositionsOccupied[7]
                && oPositionsOccupied[8]){
            line678Win.setVisible(true);
        }
        if(oPositionsOccupied[0] && oPositionsOccupied[3]
                && oPositionsOccupied[6]){
            line036Win.setVisible(true);
        }
        if(oPositionsOccupied[1] && oPositionsOccupied[4]
                && oPositionsOccupied[7]){
            line147Win.setVisible(true);
        }
        if(oPositionsOccupied[2] && oPositionsOccupied[5]
                && oPositionsOccupied[8]){
            line258Win.setVisible(true);
        }
        if(oPositionsOccupied[0] && oPositionsOccupied[4]
                && oPositionsOccupied[8]){
            line048Win.setVisible(true);
        }
        if(oPositionsOccupied[2] && oPositionsOccupied[4]
                && oPositionsOccupied[6]){
            line246Win.setVisible(true);
        }


    }

}
