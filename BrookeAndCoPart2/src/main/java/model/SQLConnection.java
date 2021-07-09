package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SQLConnection {

	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;

	public SQLConnection() {
		this.connection = null;
		this.statement = null;
		this.resultSet = null;
	}

	
	 public void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://31.170.160.154","u579109085_admin","Admin2021**");  
			statement = connection.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			 connection.close();
			 statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query) throws SQLException{

		resultSet = statement.executeQuery(query);
			
        return resultSet;
	}
	
	public int executeUpdate(String query) {
		int resultSet = 0;
		try {
			resultSet = statement.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
}
