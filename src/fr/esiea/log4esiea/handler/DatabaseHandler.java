package fr.esiea.log4esiea.handler;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler implements Handler {

	public DatabaseHandler() {
		super();
	}

	@Override
	public void print(String message) {
		String url = "jdbc:mysql://localhost:3307";
		String login = "kokumo";
		String password = "password";
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, password);
			st = cn.createStatement();
			String sql = "INSERT INTO log4esiea.Log "
					+ " (log_date, log_level, log_local, log_message) "
					+ " VALUES (NOW(), 'DEBUG', 'MAIN.main', '" + message + "');";
			st.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
