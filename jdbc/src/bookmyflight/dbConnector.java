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
			ResultSet result = statement.executeQuery("SELECT flight_id, airline_name, arrival_time, departure_time from flights where source = "+source +" and destination = " + destination + "order by price");
			String temp;
			while(result.next()) {
				temp = result.getString("flight_id") + "," + result.getString("airline_name") +"," +  result.getString("arrival_time")+"," + result.getString("departure_time");
				data.add(temp);
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static void main(String[] args) {
		dbConnector db = new dbConnector();
		db.connect();
		System.out.println(db.getFlight("kochi", "trivandrum").get(0));
	}
}

