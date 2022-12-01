/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entites;

import Models.Account;
import Models.Accountdb;
import Models.Book;
import Models.Bookdb;
import Models.Borrowing;
import Models.Status_Borrow;
import db.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author 84563
 */
public class BorrowingEntity {

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet rs = null;
    public static int id, myIndex, manaId;

    @FXML
    private Label sessionUsername;

//    @FXML
//    public static void Add(ActionEvent event, String bname, String signName) throws IOException {
//        String sql = "Insert into authors(name,signName) values(?,?)";
//        try {
//            connection = JDBCConnect.getJDBCConnection();
//            preparedStatement = connection.prepareCall(sql);
//            preparedStatement.setString(1, bname);
//            preparedStatement.setString(2, signName);
//            preparedStatement.executeUpdate();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Test Connection");
//
//            alert.setHeaderText("Authors Manager");
//            alert.setContentText("Add!");
//            alert.showAndWait();
//        } catch (SQLException e) {
//        }
//
//    }
    @FXML
    public static void Delete(int id) {
        String sql = "UPDATE `borrow` SET `status_acction` = 0 WHERE (`id` = ?);";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Borrow Manager");
            alert.setContentText("Deleted!");
            alert.showAndWait();
        } catch (SQLException | NullPointerException e) {
        }
    }

    public static void Validate(Borrowing borrow) {
        borrow.getValidate2().setVisible(true);
        borrow.getValidate4().setVisible(true);

        try {
            LocalDate dateBorrow = borrow.getBorrowID().getValue();
            LocalDate dateRefund = borrow.getRefundD().getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date1 = dateBorrow.format(formatter);
            if (!date1.isEmpty()) {
                borrow.getValidate2().setText("");
            }
        } catch (NullPointerException n) {
        } catch (RuntimeException e) {
        }

        try {
            LocalDate dateBorrow = borrow.getBorrowID().getValue();
            LocalDate dateRefund = borrow.getRefundD().getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date2 = dateRefund.format(formatter);
            if (!date2.isEmpty()) {
                borrow.getValidate4().setText("");
            }
        } catch (NullPointerException n) {
        } catch (RuntimeException e) {
        }

        if (borrow.getAccountId().equals("0")) {
            borrow.getValidate1().setVisible(true);
        } else {
            borrow.getValidate1().setText("");
        }

        if (borrow.getBookId().equals("0")) {
            borrow.getValidate3().setVisible(true);
        } else {
            borrow.getValidate3().setText("");
        }

        if (borrow.getStatusId().equals("0")) {
            borrow.getValidate5().setVisible(true);
        } else {
            borrow.getValidate5().setText("");
        }
    }

    public static void Update(TableView<Borrowing> table, Borrowing borrow) {
        BorrowingEntity.Validate(borrow);
        if (!borrow.getAccountId().equals("0") && !borrow.getBookId().equals("0") && !borrow.getStatusId().equals("0")) {
            JDBCConnect.getJDBCConnection();
            String sql_borrow = "UPDATE `borrow` SET `borrowAt` = ?,refundAt = ?,statusId = ? WHERE (`id` = ?);";
            String sql_manage_lib = "UPDATE `manage_book` SET `accountId` = ?, `bookId` = ? WHERE (`id` = ?);";
            try {
                myIndex = table.getSelectionModel().getSelectedIndex();
                id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                manaId = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getManageId()));
                LocalDate dateBorrow = borrow.getBorrowID().getValue();
                LocalDate dateRefund = borrow.getRefundD().getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String date1 = dateBorrow.format(formatter);
                String date2 = dateRefund.format(formatter);
                if (!date1.isEmpty() && !date2.isEmpty()) {
                    connection = JDBCConnect.getJDBCConnection();
                    preparedStatement = connection.prepareCall(sql_borrow);
                    preparedStatement.setString(1, date1);
                    preparedStatement.setString(2, date2);
                    preparedStatement.setString(3, borrow.getStatusId());
                    preparedStatement.setInt(4, id);
                    preparedStatement.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Test Connection");
                    alert.setHeaderText("Borrow Manager");
                    alert.setContentText("Updated!");
                    alert.showAndWait();
                }
            } catch (SQLException | NullPointerException e) {
            } catch (RuntimeException r) {
            }
            try {
                connection = JDBCConnect.getJDBCConnection();
                preparedStatement = connection.prepareCall(sql_manage_lib);
                preparedStatement.setString(1, borrow.getAccountId());
                preparedStatement.setString(2, borrow.getBookId());
                preparedStatement.setInt(3, manaId);
                preparedStatement.executeUpdate();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    public static ObservableList<Borrowing> tableData(String sql) {
        ObservableList<Borrowing> borrow = FXCollections.observableArrayList();
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                borrow.add(new Borrowing(rs.getString("id"), rs.getString("UID"), rs.getString("bookName"), rs.getString("borrowAt"), rs.getString("refundAt"), rs.getString("time_out"), rs.getString("stautsName"), rs.getString("username"), rs.getString("statusId"), rs.getString("accountId"), rs.getString("bookId"), rs.getString("manageId")));
            }
        } catch (SQLException | NullPointerException ex) {
        }
        return borrow;
    }

    public static void data_Status(ComboBox<Status_Borrow> txtStatus) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall("SELECT * FROM status_borrow;");
            rs = preparedStatement.executeQuery();
            ObservableList<Status_Borrow> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Status_Borrow(rs.getInt("id"), rs.getString("name")));
            }
            txtStatus.setItems(list);
            txtStatus.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Status_Borrow> arg0, Status_Borrow arg1, Status_Borrow arg2) -> {
                if (arg2 != null) {
                    System.out.println("Select status : " + arg2.getId());
                }
            });
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static void data_Books(ComboBox<Bookdb> txtBook) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall("SELECT * FROM books;");
            rs = preparedStatement.executeQuery();
            ObservableList<Bookdb> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Bookdb(rs.getString("id"), rs.getString("name")));
            }
            txtBook.setItems(list);
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static void data_Account(ComboBox<Accountdb> txtAccount) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall("SELECT * FROM accounts;");
            rs = preparedStatement.executeQuery();
            ObservableList<Accountdb> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Accountdb(rs.getString("id"), rs.getString("username")));
            }
            txtAccount.setItems(list);
        } catch (SQLException | NullPointerException ex) {
        }
    }

    public static int selectAccountIndex(ComboBox txtAccount) {
        int accountID = 0, bookID, StatusID;
        for (int i = 0; i < txtAccount.getItems().size(); i++) {
            if (txtAccount.getItems().get(i) == txtAccount.getValue()) {
                accountID = (i + 1);
                break;
            }
        }
        return accountID;
    }

    public static int selectBookIndex(ComboBox txtBook) {
        int bookID = 0;
        for (int i = 0; i < txtBook.getItems().size(); i++) {
            if (txtBook.getItems().get(i) == txtBook.getValue()) {
                bookID = (i + 1);
                break;
            }
        }
        return bookID;
    }

    public static int selectStatusIndex(ComboBox txtStatus) {
        int StatusID = 0;
        for (int i = 0; i < txtStatus.getItems().size(); i++) {
            if (txtStatus.getItems().get(i) == txtStatus.getValue()) {
                StatusID = (i + 1);
                break;
            }
        }
        return StatusID;
    }
}
