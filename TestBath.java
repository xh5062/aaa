import java.sql.*;
public class TestBatch {

张维行到此一游
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test", "peter", "peter");
		Statement stmt = conn.createStatement();
		stmt.addBatch("insert into dept2 values (51, '500', 'haha')");
		stmt.addBatch("insert into dept2 values (52, '500', 'haha')");
		stmt.addBatch("insert into dept2 values (53, '500', 'haha')");
		stmt.executeBatch();
		stmt.close();
		
		/*
		PreparedStatement ps = conn.prepareStatement("insert into dept2 values (?, ?, ?)");
		ps.setInt(1, 61);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();
		
		ps.setInt(1, 62);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();
		
		ps.setInt(1, 63);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();
		
		ps.executeBatch();
		ps.close();
		*/
		
		conn.close();

	}

}
