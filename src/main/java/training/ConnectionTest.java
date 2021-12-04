package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String selectQuery = "select * from trainees";
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytraining", "root", "123456");

		if (conn != null) {
			System.out.println("Connected to the database!");
		} else {
			System.out.println("Failed to make connection!");
		}
		//insert data
		stmt = (Statement) conn.createStatement();
		String query1 = "INSERT INTO trainees " + "VALUES (9,'divya','varun')";
		stmt.executeUpdate(query1);
		System.out.println("Record Inserted Successfully");
		
		//update data
		String query2 = "UPDATE trainees set name='hema' where id=2";
		stmt.executeUpdate(query2);
		System.out.println("updated Successfully");
		
		//Select data
		ResultSet result = stmt.executeQuery(selectQuery);
		while(result.next()) {
			System.out.println(result.getInt("id")+" "+result.getString("name")+" "+result.getString("father name"));

		}
		conn.close();

	}

}
