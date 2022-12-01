/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import Models.Borrowing;
import Entites.BorrowingEntity;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class ManagementBorrowingController implements Initializable {
    private Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
    @FXML
    private Label labelClock;
    
    int id, myIndex, manaId;
    @FXML
    private TableView<Borrowing> table;

    @FXML
    private TextField txtID, txtTimeOut, txtSearch;

    @FXML
    private ComboBox txtAccount, txtBook, txtStatus;

    @FXML
    private DatePicker txtBorrowAt, txtRefundAt;

    @FXML
    private Text validate1, validate2, validate3, validate4, validate5;

    @FXML
    private TableColumn<Borrowing, String> ColID, ColUID, ColBook, ColBorrow, ColRefund, ColTime, ColStatus;

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            labelClock.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    
    public void buttonSave() throws IOException {
        String accountId = String.valueOf(BorrowingEntity.selectAccountIndex(txtAccount));
        String bookId = String.valueOf(BorrowingEntity.selectBookIndex(txtBook));
        String statusId = String.valueOf(BorrowingEntity.selectStatusIndex(txtStatus));
        Borrowing borrow = new Borrowing(id, manaId, txtBorrowAt, txtRefundAt, validate1, validate2, validate3, validate4, validate5, statusId, accountId, bookId);
        BorrowingEntity.Update(table, borrow);
    }

    public void buttonDelete() throws IOException {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        BorrowingEntity.Delete(id);
    }

    public void buttonResert() {
        txtBorrowAt.setValue(null);
        txtID.clear();
        txtRefundAt.setValue(null);
        txtTimeOut.clear();
        txtAccount.setValue(null);
        txtBook.setValue(null);
        txtStatus.setValue(null);
    }

    public void data_Box() {
        BorrowingEntity.data_Account(txtAccount);
        BorrowingEntity.data_Books(txtBook);
        BorrowingEntity.data_Status(txtStatus);
    }

    public void buttonResearch() {
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColUID.setCellValueFactory(new PropertyValueFactory<>("UID"));
        ColBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        ColBorrow.setCellValueFactory(new PropertyValueFactory<>("borrowAt"));
        ColRefund.setCellValueFactory(new PropertyValueFactory<>("refundAt"));
        ColTime.setCellValueFactory(new PropertyValueFactory<>("time_out"));
        ColStatus.setCellValueFactory(new PropertyValueFactory<>("stautsName"));
        if (!txtSearch.getText().equals("")) {
            String sql = "Select bw.id,a.UID, b.name as bookName,bw.borrowAt,bw.refundAt ,bw.time_out,sb.name as stautsName,a.username,bw.statusId,mb.accountId, mb.bookId,bw.manageId from borrow as bw\n"
                    + " join status_borrow as sb on bw.statusId = sb.id\n"
                    + " join manage_book as mb on bw.manageId = mb.id\n"
                    + " join accounts as a on mb.accountId = a.id\n"
                    + " join books as b on mb.bookId = b.id where bw.id = " + txtSearch.getText() + " and bw.status_acction = 1";
            table.setItems(BorrowingEntity.tableData(sql));
        } else {
            String sql_join = "Select bw.id,a.UID, b.name as bookName,bw.borrowAt,bw.refundAt ,bw.time_out,sb.name as stautsName,a.username,bw.statusId,mb.accountId, mb.bookId,bw.manageId from borrow as bw\n"
                    + " join status_borrow as sb on bw.statusId = sb.id\n"
                    + " join manage_book as mb on bw.manageId = mb.id\n"
                    + " join accounts as a on mb.accountId = a.id\n"
                    + " join books as b on mb.bookId = b.id where bw.status_acction = 1";
            table.setItems(BorrowingEntity.tableData(sql_join));
        }
        try {
            table.setRowFactory(tv -> {
                TableRow<Borrowing> myRow = new TableRow<>();
                myRow.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        myIndex = table.getSelectionModel().getSelectedIndex();
                        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                        txtID.setText(table.getItems().get(myIndex).getUID());
                        txtBorrowAt.setValue(LocalDate.parse(table.getItems().get(myIndex).getBorrowAt()));
                        txtTimeOut.setText(table.getItems().get(myIndex).getTime_out());
                        txtRefundAt.setValue(LocalDate.parse(table.getItems().get(myIndex).getRefundAt()));
                        int AccounId = Integer.parseInt(table.getItems().get(myIndex).getAccountId());
                        int StaId = Integer.parseInt(table.getItems().get(myIndex).getStatusId());
                        int BookId = Integer.parseInt(table.getItems().get(myIndex).getBookId());
                        txtAccount.getSelectionModel().select(AccounId - 1);
                        txtBook.getSelectionModel().select(BookId - 1);
                        txtStatus.getSelectionModel().select(StaId - 1);
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
    public void initialize(URL location, ResourceBundle resources) {
        this.buttonResearch();
        this.data_Box();
        validate1.setVisible(false);
        validate2.setVisible(false);
        validate3.setVisible(false);
        validate4.setVisible(false);
        validate5.setVisible(false);
        this.initClock();
    }

}
