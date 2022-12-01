/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import Entites.AuthorEntity;
import Models.Author;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author 84563
 */
public class ManagementAuthorsController implements Initializable {
    private Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

    @FXML
    private Label labelClock;
    int id, myIndex;

    @FXML
    private TextField txtId,txtName, txtSignName, txtCreatedAt,txtUpdatedAt, textSearch;

    @FXML
    private TableView<Author> table;

    @FXML
    private Text validate1, validate2, validate3, validate4;

    @FXML
    private TableColumn<Author, String> IDColumn, NameColumn, SignNameColumn, DobColumn, CreatedColumn,UpdateColumn;

    public void buttonSave() throws IOException {
        Author author = new Author(txtName,txtSignName ,validate1, validate2);
        AuthorEntity.Updated(table,author);
    }

    public void buttonDelete() throws IOException {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        AuthorEntity.Delete( id);
    }

    public void buttonResert() {
        txtId.clear();        
        txtName.clear();
        txtSignName.clear();
        txtCreatedAt.clear();
        txtUpdatedAt.clear();
    }

        private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            labelClock.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    
    public void buttonResearch() {
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        DobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        SignNameColumn.setCellValueFactory(new PropertyValueFactory<>("signName"));
        CreatedColumn.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        UpdateColumn.setCellValueFactory(new PropertyValueFactory<>("updatedAt"));
        if (!textSearch.getText().equals("")) {
            String sql = "Select * from authors as a WHERE a.name like '%" + textSearch.getText() + "%'" + " and a.status_acction = 1";
            table.setItems(AuthorEntity.tableData(sql));
        } else {
            String sql = "Select * from authors as a where a.status_acction = 1";
            table.setItems(AuthorEntity.tableData(sql));
        }
        try {
            table.setRowFactory(tv -> {
                TableRow<Author> myRow = new TableRow<>();
                myRow.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        myIndex = table.getSelectionModel().getSelectedIndex();
                        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                        txtId.setText(table.getItems().get(myIndex).getId());
                        txtName.setText(table.getItems().get(myIndex).getName());
                        txtSignName.setText(table.getItems().get(myIndex).getSignName());
                        txtCreatedAt.setText(table.getItems().get(myIndex).getCreatedAt());
                        txtUpdatedAt.setText(table.getItems().get(myIndex).getUpdatedAt());
                    }
                });
                return myRow;
            });
        } catch (NullPointerException n) {
        }
    }

       @FXML
    private void switchToAdminDashboard() throws IOException {
        App.setRoot("AdminDashboard");
    }
    
    @FXML
    private void switchToManagementAuthors() throws IOException {
        App.setRoot("ManagementAuthors");
    }
    
    @FXML
    private void switchToManagementBooks() throws IOException {
        App.setRoot("ManagementBooks");
    }
    
    @FXML
    private void switchToManagementCategories() throws IOException {
        App.setRoot("ManagementCategories");
    }
    
    @FXML
    private void switchToManagementPublishing() throws IOException {
        App.setRoot("ManagementPublishing");
    }
    
    @FXML
    private void switchToManagementAccounts() throws IOException {
        App.setRoot("ManagementAccounts");
    }
    
    @FXML
    private void SignOut() throws Exception {
        App.setRoot("SignIn");
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.buttonResearch();
        validate1.setVisible(false);
        validate2.setVisible(false);
        validate3.setVisible(false);
        validate4.setVisible(false);
        this.initClock();
    }

}
