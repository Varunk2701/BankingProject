package bankingSys;

import java.sql.*;

public class Deposit {
	
	void depositAmount(long x, int amount) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "system";
			String password = "geek";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			if(con != null) {
				
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM accounts WHERE account_number = ?");
				pstmt.setLong(1, x);
				
				ResultSet rs = pstmt.executeQuery();
				
						
				
				while (rs.next()) {
					
					if(rs.getLong(1) == x) {
						pstmt = con.prepareStatement("UPDATE accounts SET balance = ? WHERE account_number = ?");
						pstmt.setInt(1, (amount+rs.getInt(5)));
						pstmt.setLong(2, x);
						
						pstmt.executeUpdate();
						
						System.out.println("Your Updated Balance is : " + (amount+rs.getInt(5)));
						
					}
					
				}
				
				
			} else {
				System.out.println("Connection interrupted !!");
			}
		} 
		catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
}





