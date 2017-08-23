import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionManagement {

	public static void main(String[] args) {
		int []rows=null;
		Statement st = null;
		Connection con =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			con.setAutoCommit(false);
			st = con.createStatement();
			st.addBatch("insert into newtable values(2,'hai',90)");
			
			st.addBatch("insert into newtable values(3,'hai',90)");
			con.setSavepoint();
			st.addBatch("insert into newtable values(5,hemanth,30)");
			rows = st.executeBatch();

			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
			} catch (SQLException | NullPointerException e1) {
				
				System.out.println(e1);
			}
		
			System.out.println(e);
		}
		int noOfRowsEffected =0;
		for(int n:rows)
		{
			noOfRowsEffected+=n;
		}
			System.out.println(noOfRowsEffected);

	}

}
