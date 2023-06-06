package ir.gambaloo.controller;


import ir.gambaloo.Main;
import ir.gambaloo.module.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SignupPageController {


    @FXML
    private TextField addressFLD;

    @FXML
    private TextField emailFLD;

    @FXML
    private Label errorLBL;

    @FXML
    private PasswordField passwordFLD;

    @FXML
    private TextField phonenumberFLD;

    @FXML
    private TextField usernameFLD;

    @FXML
    void signUPBTN ( ActionEvent event ) throws IOException {
        String username = usernameFLD.getText ( );
        String phonenumber = phonenumberFLD.getText ( );
        String email = emailFLD.getText ( );
        String password = passwordFLD.getText ( );
        String address = addressFLD.getText ( );
        if ( username.length ( ) < 3 || username.contains ( " " )) {
            errorLBL.setText ( "Invalid username" );
        } else if ( phonenumber.length ( ) == 10 ) {
            errorLBL.setText ( "Invalid phonenumber" );
        } else if ( ! email.contains ( "@" ) ) {
            errorLBL.setText ( "Your email must contains @. " );
        } else if ( password.length ( ) < 8 || password.contains ( " " ) ) {
            errorLBL.setText ( "Invalid password" );
        } else if ( address.equals ( "" ) ) {
            errorLBL.setText ( "Fill in the blanks." );
        } else {
            Main.printWriter.println ( - 2 );
            Main.printWriter.flush ( );
            Main.printWriter.println ( username );
            Main.printWriter.flush ( );
            if ( Main.reciver.nextInt ( ) == - 1 ) {
                errorLBL.setText ( "This username is already exist." );
            } else {
                Main.printWriter.println ( phonenumber );
                Main.printWriter.flush ( );
                if ( Main.reciver.nextInt ( ) == - 1 ) {
                    errorLBL.setText ( "This phonenumber is already exist." );
                } else {
                    Main.printWriter.println ( email );
                    Main.printWriter.flush ( );
                    if ( Main.reciver.nextInt ( ) == - 1 ) {
                        errorLBL.setText ( "This email is already exist." );
                    } else {

                        User user = new User ( email , username , password , phonenumber , address );
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream ( Main.socket.getOutputStream ( ) );
                        objectOutputStream.writeObject ( user );
                        objectOutputStream.flush ( );
                        errorLBL.setText ( "Signup successfully" );
                        //Node source= (Node) event.getSource();
                        //source.getScene().getWindow().hide();
                    }
                }
            }
        }
    }
}












