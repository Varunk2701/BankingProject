package bankingSys;

import java.sql.*;
import java.util.*;

public class Createaccount {
	
	long createNewAccount(long id, String name, String address, String city, String state, String email, long phone) {
		Random rand = new Random();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "system";
			String password = "geek";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			if(con != null) {
				long accno = rand.nextInt(999999999);
				String sql = "insert into CUSTOMER " + " (customer_id, customer_name, customer_address, customer_city, customer_state, customer_phone, customer_email, account_number)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setLong(1, id);
				stmt.setString(2, name);
				stmt.setString(3, address);
				stmt.setString(4, city);
				stmt.setString(5, state);
				stmt.setLong(6, phone);
				stmt.setString(7, email);
				stmt.setLong(8, accno);
				
				stmt.executeUpdate();
					
				String sql1 = "insert into accounts" + "(account_number, customer_id, balance)" + " values(?, ?, ?)";
				
				PreparedStatement stmt1 = con.prepareStatement(sql1);
				
				stmt1.setLong(1, accno);
				stmt1.setLong(2, id);
				stmt1.setInt(3, 0);
				
				stmt1.executeUpdate();
				
				System.out.println("You have successfully created your account\nYour Acc No. is :");
				return accno;
				
			}
			else {
				System.out.println("Connection failed");
				return 0;
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return 0;
		
	}
}
