/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Entites;

import Models.Author;
import Models.Author1;

import db.JDBCConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author 84563
 */
public class AuthorEntity {

     public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet rs = null;
    public static int myIndex;
    public static int id;

    public static ObservableList<Author1> GetAll() {
        ObservableList<Author1> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM authors";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            for (int i = 1; rs.next(); i++) {
                Author1 author = new Author1();

                author.setIndex(i);
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setDob(rs.getString("dob"));
                author.setSign_name(rs.getString("sign_name"));
                author.setCreatedAt(rs.getString("createdAt"));
                author.setUpdatedAt(rs.getString("updatedAt"));

                list.add(author);
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }

        return null;
    }

    public static Author1 GetAuthorWithId(int id) {
        String sql = "SELECT * FROM authors WHERE id = ?";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Author1 author = new Author1();

                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setDob(rs.getString("dob"));
                author.setSign_name(rs.getString("sign_name"));
                author.setCreatedAt(rs.getString("createdAt"));
                author.setUpdatedAt(rs.getString("updatedAt"));

                return author;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }

        return null;
    }
    
    public static Author1 GetAuthorWithName(String name) {
        String sql = "SELECT * FROM authors WHERE name = ?";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Author1 author = new Author1();

                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setDob(rs.getString("dob"));
                author.setSign_name(rs.getString("sign_name"));
                author.setCreatedAt(rs.getString("createdAt"));
                author.setUpdatedAt(rs.getString("updatedAt"));

                return author;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }

        return null;
    }

    public static ObservableList<Author1> Search(String name) {
        ObservableList<Author1> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM authors WHERE name like ?";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");

            rs = preparedStatement.executeQuery();

            for (int i = 1; rs.next(); i++) {
                Author1 author = new Author1();

                author.setIndex(i);
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setDob(rs.getString("dob"));
                author.setSign_name(rs.getString("sign_name"));
                author.setCreatedAt(rs.getString("createdAt"));
                author.setUpdatedAt(rs.getString("updatedAt"));

                list.add(author);
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }

        return null;
    }

    public static boolean Add(Author1 author) {
        String sql = "INSERT INTO authors"
                + "(name, dob ,signName, createdAt, updatedAt) "
                + "VALUES(?, ?, ?, ?, ?)";

//      set time at present with accuracy approximately is millis
        long milis = System.currentTimeMillis();
        Date preDate = new Date(milis);

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setDate(2, convertStringToDate(author.getDob()));
            preparedStatement.setString(3, author.getSign_name());
            preparedStatement.setDate(4, preDate);
            preparedStatement.setDate(5, preDate);
            preparedStatement.executeUpdate();

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean Update(Author1 author) {
        String sql = "UPDATE authors SET name = ?, dob = ?, signName = ?,  WHERE (`id` = ?);";

//      set time at present with accuracy approximately is millis
        long milis = System.currentTimeMillis();
        Date preDate = new Date(milis);

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setDate(2, convertStringToDate(author.getDob()));
            preparedStatement.setString(3, author.getSign_name());
            preparedStatement.setDate(4, preDate);
            preparedStatement.setInt(1, author.getId());
            preparedStatement.executeUpdate();

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean Delete(int id) {
        String sql = "Delete from authors WHERE id = ?";

        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private static Date convertStringToDate(String date) {
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        LocalDate localdate = LocalDate.of(year, month, day);
        Date newDate = Date.valueOf(localdate);

        return newDate;
    }
    
        public static void Updated(TableView<Author> table,Author author) {
//validated
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        if (author.getTxtName().getText().equals("")) {
            author.getValidate1().setVisible(true);
        } else if (!p.matcher(author.getTxtName().getText()).find()) {
            author.getValidate1().setVisible(true);
            author.getValidate1().setText("Wrong format Name. Please try again.");
        }else{
            author.getValidate1().setText("");
        }

        if (author.getTxtSignName().getText().equals("")) {
            author.getValidate2().setVisible(true);
        } else if (!p.matcher(author.getTxtSignName().getText()).find()) {
            author.getValidate2().setVisible(true);
            author.getValidate2().setText("Wrong format SignName. Please try again.");
        }else{
            author.getValidate2().setText("");
        }
//Update data
        if (p.matcher(author.getTxtName().getText()).find() && p.matcher(author.getTxtSignName().getText()).find()) {
            System.out.println("//////////////////aaaaaaaaaaaa");
            myIndex = table.getSelectionModel().getSelectedIndex();
            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            JDBCConnect.getJDBCConnection();
            String sql = "UPDATE `authors` SET `name` = ?, signName = ? WHERE (`id` = ?);";
            try {
                connection = JDBCConnect.getJDBCConnection();
                preparedStatement = connection.prepareCall(sql);
                preparedStatement.setString(1, author.getTxtName().getText());
                preparedStatement.setString(2, author.getTxtSignName().getText());
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Authors Manager");
                alert.setContentText("Updated!");
                alert.showAndWait();
            } catch (SQLException | NullPointerException e ) {
            }
        }
    }

            public static ObservableList<Author> tableData(String sql) {
        JDBCConnect.getJDBCConnection();
        ObservableList<Author> authors = FXCollections.observableArrayList();
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareCall(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                authors.add(new Author(rs.getString("id"), rs.getString("name"), rs.getString("dob"), rs.getString("signName"),rs.getString("createdAt"), rs.getString("updatedAt")));
            }
        } catch (SQLException | NullPointerException ex) {
        }
        return authors;
    }
   
}
