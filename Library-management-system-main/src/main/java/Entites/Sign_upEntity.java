/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entites;

import Models.SignUp;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 *
 * @author 84563
 */
public class Sign_upEntity {

    public static void Validated(SignUp sign) throws IOException {

        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Pattern pPassword = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        Pattern number = Pattern.compile("^[0-9]+$");
        Pattern len = Pattern.compile("^[0-9]{10}+$");
        Pattern pEmail = Pattern.compile("^\\S+@\\S+\\.\\S+$");

        if (!sign.getInp_username().getText().isEmpty() && !p.matcher(sign.getInp_username().getText()).find()) {
            sign.getValidate1().setVisible(true);
            sign.getValidate1().setText("Wrong format Username. Please try again.");
        } else if (sign.getInp_username().getText().isEmpty()) {
            sign.getValidate1().setVisible(true);
        } else {
            sign.getValidate1().setText("");
        }

        if (!sign.getInp_password().getText().isEmpty() && !number.matcher(sign.getInp_password().getText()).find()) {
            sign.getValidate2().setVisible(true);
            sign.getValidate2().setText("Wrong format Password. Please try again.");
        } else if (sign.getInp_password().getText().equals("")) {
            sign.getValidate2().setVisible(true);
        } else {
            sign.getValidate2().setText("");
        }

        if (!sign.getInp_fullname().getText().isEmpty() && !p.matcher(sign.getInp_fullname().getText()).find()) {
            sign.getValidate3().setVisible(true);
            sign.getValidate3().setText("Wrong format Full Name. Please try again.");
        } else if (sign.getInp_fullname().getText().equals("")) {
            sign.getValidate3().setVisible(true);
        } else {
            sign.getValidate3().setText("");
        }

        if (!sign.getInp_email().getText().isEmpty() && !pEmail.matcher(sign.getInp_email().getText()).find()) {
            sign.getValidate4().setVisible(true);
            sign.getValidate4().setText("Wrong format email. Please try again.");
        } else if (sign.getInp_email().getText().equals("")) {
            sign.getValidate4().setVisible(true);
        } else {
            sign.getValidate4().setText("");
        }

        sign.getValidate5().setVisible(true);
        String data = null;
        try {
            LocalDate date = sign.getInp_date_birth().getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date_form = date.format(formatter);
            data = date_form;
            sign.getValidate5().setText("");

        } catch (NullPointerException n) {
        } catch (RuntimeException e) {
        }

        if (!sign.getInp_mobile().getText().isEmpty() && !len.matcher(sign.getInp_mobile().getText()).find()) {
            sign.getValidate6().setVisible(true);
            sign.getValidate6().setText("Wrong format mobile. Please try again.");
        } else if (sign.getInp_mobile().getText().equals("")) {
            sign.getValidate6().setVisible(true);
        } else {
            sign.getValidate6().setText("");
        }

        if (p.matcher(sign.getInp_username().getText()).find() && number.matcher(sign.getInp_password().getText()).find() && p.matcher(sign.getInp_fullname().getText()).find() && pEmail.matcher(sign.getInp_email().getText()).find() && len.matcher(sign.getInp_mobile().getText()).find()) {
            AccountEntity.Add(sign);
        }

    }
}
