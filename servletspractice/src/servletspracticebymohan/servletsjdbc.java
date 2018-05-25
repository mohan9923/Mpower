package servletspracticebymohan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class servletsjdbc {
	public void insert(String name,String password,String confirm_password,String phone_number, String Emergency_contact,String country) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String DB_URL="jdbc:mysql://localhost:3306/registration?verifyServerCertificate=false&useSSL=true";
		Connection con = DriverManager.getConnection(DB_URL, "root","root");
		
		PreparedStatement ps= con.prepareStatement("Insert into employees values(?,?,?,?,?,?)");

		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, confirm_password);
		ps.setString(4, phone_number);
		ps.setString(5, Emergency_contact);
		ps.setString(6, country);
		ps.executeUpdate();
		
	}
}
