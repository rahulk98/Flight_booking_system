package bookmyflight;

import java.sql.*;
import java.util.ArrayList;



public class dbConnector {
	
	Connection connection;

	public Boolean connect() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookmyflight",
					"rahulk", "rahulk");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> getFlight(String source, String destination) {
		
		try {	
			Statement statement = connection.createStatement();
			ArrayList<String> data = new ArrayList<>();
			ResultSet result = statement.executeQuery("SELECT flight_no, airline_name, arrival_time, departure_time from flights where source = "+ "'" +source +"'"+" and destination = " +"'"+ destination +"'"+ "order by price");
			String temp;
			while(result.next()) {
				temp = result.getString("flight_no") + "," + result.getString("airline_name") +"," +  result.getString("arrival_time")+"," + result.getString("departure_time");
				data.add(temp);
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int createUser(String username, String password, String name, String email, String phone) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * from registered_users where username = '"+username+"'");
			if(result.next()) {
				return -1;
			}
			else {
				int result2 = statement.executeUpdate("INSERT INTO registered_users (username, password, name, email, phone) VALUES ('"+ username+"','"+password+"','"+name+"','"+email+"','"+phone+"')");
				return result2;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Boolean authenticateUser(String username, String password) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT password from registered_users where username = '"+ username+"'");
			if(!result.next()) {
				return false;
			}
			else {
				if(result.getString("password").equals(password)) {
					return true;
				}
				else {
					return false;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		dbConnector db = new dbConnector();
		db.connect();
		
		System.out.println(db.authenticateUser("ample", "sample"));
	}
}

