/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author 84563
 */
public class SignUp {
    //data form
    private TextField inp_username, inp_fullname, inp_email, inp_mobile;
    private PasswordField inp_password;
    private DatePicker inp_date_birth;
    private Text  validate1, validate2, validate3, validate4, validate5, validate6;

    public SignUp(TextField inp_username, TextField inp_fullname, TextField inp_email, TextField inp_mobile, PasswordField inp_password, DatePicker inp_date_birth, Text validate1, Text validate2, Text validate3, Text validate4, Text validate5, Text validate6) {
        this.inp_username = inp_username;
        this.inp_fullname = inp_fullname;
        this.inp_email = inp_email;
        this.inp_mobile = inp_mobile;
        this.inp_password = inp_password;
        this.inp_date_birth = inp_date_birth;
        this.validate1 = validate1;
        this.validate2 = validate2;
        this.validate3 = validate3;
        this.validate4 = validate4;
        this.validate5 = validate5;
        this.validate6 = validate6;
    }

    public TextField getInp_username() {
        return inp_username;
    }

    public void setInp_username(TextField inp_username) {
        this.inp_username = inp_username;
    }

    public TextField getInp_fullname() {
        return inp_fullname;
    }

    public void setInp_fullname(TextField inp_fullname) {
        this.inp_fullname = inp_fullname;
    }

    public TextField getInp_email() {
        return inp_email;
    }

    public void setInp_email(TextField inp_email) {
        this.inp_email = inp_email;
    }

    public TextField getInp_mobile() {
        return inp_mobile;
    }

    public void setInp_mobile(TextField inp_mobile) {
        this.inp_mobile = inp_mobile;
    }

    public PasswordField getInp_password() {
        return inp_password;
    }

    public void setInp_password(PasswordField inp_password) {
        this.inp_password = inp_password;
    }

    public DatePicker getInp_date_birth() {
        return inp_date_birth;
    }

    public void setInp_date_birth(DatePicker inp_date_birth) {
        this.inp_date_birth = inp_date_birth;
    }

    public Text getValidate1() {
        return validate1;
    }

    public void setValidate1(Text validate1) {
        this.validate1 = validate1;
    }

    public Text getValidate2() {
        return validate2;
    }

    public void setValidate2(Text validate2) {
        this.validate2 = validate2;
    }

    public Text getValidate3() {
        return validate3;
    }

    public void setValidate3(Text validate3) {
        this.validate3 = validate3;
    }

    public Text getValidate4() {
        return validate4;
    }

    public void setValidate4(Text validate4) {
        this.validate4 = validate4;
    }

    public Text getValidate5() {
        return validate5;
    }

    public void setValidate5(Text validate5) {
        this.validate5 = validate5;
    }

    public Text getValidate6() {
        return validate6;
    }

    public void setValidate6(Text validate6) {
        this.validate6 = validate6;
    }

    @Override
    public String toString() {
        return "SignUp{" + "inp_username=" + inp_username + ", inp_fullname=" + inp_fullname + ", inp_email=" + inp_email + ", inp_mobile=" + inp_mobile + ", inp_password=" + inp_password + ", inp_date_birth=" + inp_date_birth + ", validate1=" + validate1 + ", validate2=" + validate2 + ", validate3=" + validate3 + ", validate4=" + validate4 + ", validate5=" + validate5 + ", validate6=" + validate6 + '}';
    }
    
    
}
