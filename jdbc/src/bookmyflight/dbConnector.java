package bookmyflight;

import java.sql.*;



public class dbConnector {
	
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookmyflight", "rahulk","rahulk")){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from registered_users");
			System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", "username", "name","email","phone");
			while(resultSet.next()) {
				System.out.printf("%-30.30s  %-30.30s  %-30.30s  %-30.30s%n", 
							resultSet.getString("username"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failure");
			e.printStackTrace();
		}
	}
}

