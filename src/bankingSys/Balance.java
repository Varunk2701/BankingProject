package bankingSys;

import java.sql.*;

public class Balance {
	
	void checkBalance(long x) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "system";
			String password = "geek";
			
			try {
				Connection con = DriverManager.getConnection(url, userName, password);
				
				if(con!=null) {
					
					PreparedStatement pstmt = con.prepareStatement("Select * from accounts where account_number = ?");
					
					pstmt.setLong(1, x);
					
					ResultSet rs = pstmt.executeQuery();
					
					while (rs.next()) {
						
						if(rs.getLong(1) == x) {
							pstmt = con.prepareStatement("Select * from accounts");
							
							pstmt.executeUpdate();
							
							
							
							System.out.println("Your Balance is : " + (rs.getInt(5)));
							
						}
						
					}
					
				}
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
