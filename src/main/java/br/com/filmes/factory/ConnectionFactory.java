package br.com.filmes.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //  estático
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bdfilmes";
        String user = "root";
        String password = "admin";

        return DriverManager.getConnection(url, user, password);
    }

}
