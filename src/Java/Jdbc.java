package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	Connection con;
	Statement stmt;

	Jdbc()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			System.out.println("cannot connecct to database");
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		

	}

	public ResultSet retrive(String query) throws SQLException {
		try {
		ResultSet rs2 = stmt.executeQuery(query);

		return rs2;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	public int update(String query) throws SQLException {
		try {
		int i= stmt.executeUpdate(query);
	     return i;
		}catch(Exception e) {
			e.printStackTrace();
			}
		return 0;
	}
	public int insert(String query, int i, String k,int j, String l) throws SQLException {
	
		  PreparedStatement st = con.prepareStatement(query);
		  st.setInt(1, i);
			st.setString(2, k);
			st.setInt(3, j);
			st.setString(4, l);
			
			
			int res = st.executeUpdate();
	     return res;
		
	}

	

}
