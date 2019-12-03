package org.lesson6;

import java.sql.*;

public class AuthorDataBaseConnection {

    public Connection getConnection() throws SQLException {
        //URL:
        //jdbc:<vendor_name>://<host>:<port>/<database_name>?=;
        return DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5432/book_store", "postgres", "1234"
        );
    }

    public void printAllAuthors() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from author;");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt(4);
                System.out.println(name + " " + lastName + " " + age);
            }

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    public void addAuthor(String name, String lastName, int age) {
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT into author(name, last_name, age) values (?, ?, ?);"
            );
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected);

        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }
}
