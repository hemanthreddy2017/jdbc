import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;


public class CallableStatementDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			CallableStatement cs = con.prepareCall("{call pone(?,?)}");
			cs.registerOutParameter(2, Types.INTEGER);
			cs.setInt(1, 5);
			cs.execute();
			int result = cs.getInt(2);
			System.out.println(result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
