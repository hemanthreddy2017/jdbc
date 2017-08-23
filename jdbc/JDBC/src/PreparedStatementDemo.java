import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class PreparedStatementDemo {

	public static void main(String[] args) {
		int n = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement ps = con.prepareStatement("insert into newtable values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("give id");
			ps.setInt(1, sc.nextInt());
			System.out.println("give name");
			ps.setString(2, sc.next());
			System.out.println("give marks");
			ps.setInt(3, sc.nextInt());
			n = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (n!=0){
			System.out.println("inserted");
		}else{
			System.out.println("not inserted");
		}
	}

}
