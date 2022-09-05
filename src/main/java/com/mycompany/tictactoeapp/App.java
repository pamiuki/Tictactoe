/**
 * Created by Paul Asong
 */
package com.mycompany.tictactoeapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    private TextField tfDisplay;
    private  Button[][] btns;
    private Board board;
    private Label state;
    private Button playAgain;

    @Override
    public void init() throws Exception {
      board = new Board();

    }

    @Override
    public void start(Stage window) {
        GridPane btnsPane = new GridPane();
        btnsPane.setPadding(new Insets(10, 10, 10, 10));
        btnsPane.setAlignment(Pos.CENTER);
        btnsPane.setHgap(5);
        btnsPane.setVgap(5);
        
        playAgain = new Button("Play Again");
        playAgain.setStyle("-fx-background-color: pink");
        playAgain.setOnAction(event -> {
            for (int i = 0; i < btns.length; ++i) {
                for (int j = 0; j < btns[i].length; ++j) {
                    btns[i][j].setText("");
                    board.remove();
                    tfDisplay.setText("Turn: X");
                    gameStart();
                }
            }
        });
        state = new Label();
        btns = new Button[3][3];
        Controls handler = new Controls();

      
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
             btns[i][j] = new Button();
             btns[i][j].setOnAction(handler);
             btns[i][j].setPrefSize(90, 50);
             btns[i][j].setFont(Font.font("Monospaced", 40));
             btnsPane.add(btns[i][j], j, i);
            }
        }

        tfDisplay = new TextField("Turn: X");
        tfDisplay.setAlignment(Pos.CENTER_RIGHT);
        tfDisplay.setEditable(false);

        BorderPane root = new BorderPane();
        root.setTop(tfDisplay);
        root.setCenter(btnsPane);
        root.setBottom(playAgain);

        Scene view = new Scene(root, 300, 300);
        window.setTitle("Tic Tac Toe");
        window.setScene(view);
        window.show();

    }

    private class Controls implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Button btn = ((Button) event.getSource());

            if (tfDisplay.getText().contains("X") && btn.getText().isEmpty()) {
                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns[i].length; j++) {
                        if (btns[i][j].equals(btn)) {
                            btn.setText("X");
                            
                            board.addCells(i, j, "X");
                            if ((compute() && state.getText().equals("X")) ) {
                                tfDisplay.setText("X won");
                                gameOver();
                            } else {
                            tfDisplay.setText("Turn: Y");
                            }
                        }
                    }
                }

            } else if (tfDisplay.getText().contains("Y") && btn.getText().isEmpty()) {
                for (int i = 0; i < btns.length; i++) {
                    for (int j = 0; j < btns[i].length; j++) {
                        if (btns[i][j].equals(btn)) {
                            board.addCells(i, j, "Y");
                            btn.setText("Y");
                            if ((compute() && state.getText().equals("Y")) ) {
                                tfDisplay.setText("Y won");
                                gameOver();
                            } else {
                            tfDisplay.setText("Turn: X");
                            }
                        }
                    }
                }
                
            }
        }
    }

   private boolean compute() {
       if (board.row().equals("X")) {
           
           state.setText("X");
           
           return true;
       }else if ("Y".equals(board.row())) {

           state.setText("Y");
           return true;
       }else if (board.column().equals("X")) {
           state.setText("X");
           return true;
       } else if (board.column().equals("Y")) {
           state.setText("Y");
           return true;
       } else if (board.diagonal().equals("X")) {
           state.setText("X");
           return true;
       } else if (board.diagonal().equals("Y")) {
           state.setText("Y");
           return true;
       }
       return false;
   }
   
   public void gameOver() {
       for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
             btns[i][j].setDisable(true);
            }
        }
   }
   
   public void gameStart() {
       for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
             btns[i][j].setDisable(false);
            }
        }
   }

    public static void main(String[] args) {
        launch(App.class);

    }

}
