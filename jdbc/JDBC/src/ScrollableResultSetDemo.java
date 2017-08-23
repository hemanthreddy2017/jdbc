import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ScrollableResultSetDemo {

	public static void main(String[] args) {
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");

				// Create a scrollable result set


				Statement stmt = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM stud");


				// Move cursor forward


				while (resultSet.next()) {


				// Get data at cursor


				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));

				}


				// Move cursor backward


				while (resultSet.previous()) {


				// Get data at cursor


				
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));


				}


				// Move cursor to the first row


				System.out.println(resultSet.first());


				// Move cursor to the last row


				System.out.println(resultSet.last());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			// Move cursor to the end, after the last row


			//System.out.println(resultSet.afterLast());


			// Move cursor to the beginning, before the first row.


			//System.out.println(resultSet.beforeFirst());
	}

}
