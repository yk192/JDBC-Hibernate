package Bi;
/*
 * Параметры подключения к БД
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/имяБД";
    private static final String DB_USERNAME = "ИмяПользователя";
    private static final String DB_PASSWORD = "Пароль";

    public Connection getConnection() {
	Connection connection = null;
	try {
	    Class.forName(DB_DRIVER);
	    connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	    System.out.println("Connection Ok");
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	    System.out.println("Connection Error!!!");
	}

	return connection;

    }

}
