import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			PreparedStatement ps = con
					.prepareStatement("insert into imgtable values(?,?)");
			ps.setString(1, "abc");

			FileInputStream fin = new FileInputStream("/home/trainee/Desktop/68a3843a-5bc3-46ee-bda4-bcc8a9e68e0d-original.jpeg");
			ps.setBinaryStream(2, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
