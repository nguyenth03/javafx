/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import db.JDBCConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author 84563
 */
public class SignInController {

    @FXML
    TextField inp_username;

    @FXML
    PasswordField inp_password;

    @FXML
    Button buttonSignIn;

    @FXML
    private void switchToSignUp() throws IOException {
        App.setRoot("SignUp");
    }

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet rs = null;

    @FXML
    private void switchToLogin() throws IOException {
        String sql = "Select * from accounts where username = ?";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, inp_username.getText());
            rs = preparedStatement.executeQuery();
            Pattern p = Pattern.compile("^[a-z]+$");
            Pattern pPassword = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
            Pattern t = Pattern.compile("^[0-9]+$");

            if (inp_username.getText().equals("") || inp_password.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Empty Username/Password. Please try again.");
                alert.show();
            }else if (!inp_username.getText().equals("") && !p.matcher(inp_username.getText()).find()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong format username. Please try again.");
                alert.show();
            }else if (!t.matcher(inp_password.getText()).find()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong format password. Please try again.");
                alert.show();
            }else if (!rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User  not exist!");
                alert.show();
            } else {
                String retrievedPassword = rs.getString("password");
                if (retrievedPassword.equals(inp_password.getText())) {
                    App.setRoot("ManagementAuthors");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Password did not match!");
                    alert.show();
                }
            }
        } catch (SQLException e) {
        } 

    }

}
