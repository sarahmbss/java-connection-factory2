package bancoDados;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static String databasename = "ecommerce_roupas";
	static String username = "root";
	static String password = "9876";
	static String url = "jdbc:mysql://localhost:3306/" + databasename + "?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
