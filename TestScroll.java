import java.sql.*;

public class TestScroll {
	public static void main(String args[]) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "peter", "peter");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt
					.executeQuery("select * from emp order by sal");
			rs.next();
			System.out.println(rs.getInt(1));
			rs.last();
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());
			rs.previous();
			System.out.println(rs.getString(1));
			rs.absolute(6);
			System.out.println(rs.getString(1));
			rs.close();
			stmt.close();
			conn.close();
		} catch ( ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
