/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author PC
 */
public class Author {
    private String id,name,dob,signName, createdAt, updatedAt;
    private TextField txtName,txtSignName , txtCreatedAt,txtUpdatedAt;
    private Text validate1, validate2;

    public Author() {
    }

    public Author(TextField txtName, TextField txtSignName, Text validate1, Text validate2) {
        this.txtName = txtName;
        this.txtSignName = txtSignName;
        this.validate1 = validate1;
        this.validate2 = validate2;
    }
    
    public Author(String id, String name, String dob, String signName, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.signName = signName;
        this.createdAt = createAt;
        this.updatedAt = updateAt;
    }

    public TextField getTxtCreatedAt() {
        return txtCreatedAt;
    }

    public void setTxtCreatedAt(TextField txtCreatedAt) {
        this.txtCreatedAt = txtCreatedAt;
    }

    public TextField getTxtUpdatedAt() {
        return txtUpdatedAt;
    }

    public void setTxtUpdatedAt(TextField txtUpdatedAt) {
        this.txtUpdatedAt = txtUpdatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public TextField getTxtSignName() {
        return txtSignName;
    }

    public void setTxtSignName(TextField txtSignName) {
        this.txtSignName = txtSignName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", signName=" + signName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    }
