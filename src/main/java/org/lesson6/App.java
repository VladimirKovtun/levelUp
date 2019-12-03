package org.lesson6;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println(System.getenv("M2_HOME"));
        AuthorDataBaseConnection db = new AuthorDataBaseConnection();
        db.addAuthor("Ivan", "Golovach", 30);
        db.printAllAuthors();

    }
}
