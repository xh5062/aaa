import java.sql.*;


public class TestPrepStmt {

	public static void main(String[] args) {
		/*
		if(args.length != 3) {
			System.out.println("Parameter Error! Please Input Again!");
			System.exit(-1);
		}
		
		int deptno = 0;
		
		try {
			deptno = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Parameter Error! Deptno should be Number Format!");
			System.exit(-1);
		}
		*/

		
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "peter", "peter");
			pstmt = conn.prepareStatement("insert into student values (?, ?, ?, ?,?)");
			pstmt.setInt(1, 1);
			pstmt.setString(2, "zhang wen");
			pstmt.setInt(3, 89);
			pstmt.setInt(4, 89);
			pstmt.setInt(5, 89);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
