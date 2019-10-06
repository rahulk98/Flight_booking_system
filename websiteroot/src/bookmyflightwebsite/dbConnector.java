package bookmyflightwebsite;

import java.sql.*;
import java.util.ArrayList;



public class dbConnector {
	
	Connection connection;

	public Boolean connect() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookmyflight",
					"rahulk", "rahulk");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getPrice(String f) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result1 = statement.executeQuery("SELECT * from flights where flight_no = '"+f +"'");
			return Integer.parseInt(result1.getString("price"));

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<String> getFlight(String source, String destination, String date , int c) {
		
		try {
			Statement statement = connection.createStatement();
			ArrayList<String> data = new ArrayList<>();
			ResultSet result = statement.executeQuery("SELECT flight_no, airline_name, arrival_time, departure_time, price, arrival_date from flights where source = "+ "'" +source +"'"+" and destination = " +"'"+ destination +"' and departure_date = '" + date + "' and no_of_seats_available > "+ c +"  order by price");
			String temp;
			while(result.next()) {
				temp = result.getString("flight_no") + "," + result.getString("airline_name") +"," +  result.getString("arrival_time")+"," + result.getString("departure_time")+","+result.getString("price")+","+result.getString("arrival_date");
				data.add(temp);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int createUser(String username, String password, String name, String email, String phone) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result1 = statement.executeQuery("SELECT * from registered_users where username = '"+username+"' or "+"email = '"+email+"'" + "or phone = '"+phone+"'");
			
			if(result1.next()) {
				if(result1.getString("username").equals(username)){
					return -1;
				}
				else if(result1.getString("email").equals(email)) {
					return -2;
				}
				else {
					return -3;
				}
			}
			
			else {
				int result2 = statement
						.executeUpdate("INSERT INTO registered_users (username, password, name, email, phone) VALUES ('"
								+ username + "','" + password + "','" + name + "','" + email + "','" + phone + "')");
				int v = statement.executeUpdate("INSERT INTO wallet (username) VALUES ('" + username + "'");
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

	public int getBalance(String username) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT balance from wallet where username = '" + username + "'");
			result.next();
			return Integer.parseInt(result.getString("balance"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<String> getBookingDetail(String username) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from bookings where username = '" + username + "'");
			String temp;
			ArrayList<String> data = new ArrayList<>();
			while (result.next()) {
				temp = result.getString("booking_id") + "," + result.getString("flight_no") + ","
						+ result.getString("amount") + "," + result.getString("date_of_travel") + ","
						+ result.getString("no_of_travellers");
				data.add(temp);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int addBalance(int val, String username) {
		try{
			Statement statement = connection.createStatement();
			int v = val + getBalance(username);
			return statement.executeUpdate("update wallet set balance = " + v + " where username = '" + username + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static void main(String[] args) {
		dbConnector db = new dbConnector();
		db.connect();
		db.addBalance(10, "rahulk");
	}
}

