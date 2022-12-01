/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import Entites.Sign_upEntity;
import Models.SignUp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author 84563
 */
public class SignUpController implements Initializable {
    @FXML
    private Text label_username,label_password,label_fullname,label_email,label_date_birth,label_mobile ,validate1,validate2,validate3,validate4,validate5,validate6;

    @FXML
    private TextField inp_username,inp_fullname, inp_email,inp_mobile;
    @FXML
    private PasswordField inp_password;

    @FXML
    private DatePicker inp_date_birth;

    @FXML
    private void switchToSignIn() throws IOException {
        App.setRoot("SignIn");
    }

    @FXML
    private void Validate() throws IOException {
        SignUp dataSignUp = new SignUp(inp_username, inp_fullname, inp_email, inp_mobile, inp_password, inp_date_birth, validate1, validate2, validate3, validate4, validate5, validate6);
        Sign_upEntity.Validated(dataSignUp);
//8.2 004
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validate1.setVisible(false);
        validate2.setVisible(false);
        validate3.setVisible(false);
        validate4.setVisible(false);
        validate5.setVisible(false);
        validate6.setVisible(false);
    }

}
