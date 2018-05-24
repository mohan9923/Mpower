
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class sampleDB {

	
	
	static Connection conn = null;
	static Statement stmt = null;
	public static void main (String[]args) throws Exception {
		String JDBC_DRIVER = "com.mysql.cj.jdbc.driver";
		String DB_URL = "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
	    String USER= "root";
		String PASS= "root";
	try {
		Class.forName(JDBC_DRIVER);
	} catch  (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	stmt = conn.createStatement();
	PreparedStatement st=conn.prepareStatement ("CREATE DATABASE DBSAM");
	st.executeUpdate();
	System.out.println("Database is being created.");
	}
	
public void createTable() throws Exception {
	System.out.println("Creating tables for the Database : ");
//	System.out.println("Give table name : ");
//	String tablename=sc.next();
	
	PreparedStatement st=conn.prepareStatement("CREATE TABLE dept (deptid INT NOT NULL,deptname VARCHAR(45) NOT NULL,deptloc VARCHAR(45) NOT NULL, PRIMARY KEY (`deptid`));");
	st.executeUpdate();
	st.close();
//	
	PreparedStatement st1=conn.prepareStatement("CREATE TABLE employe (empid INT NOT NULL,empname VARCHAR(45) NOT NULL,empnumber VARCHAR(45) NOT NULL,empdept INT NOT NULL,INDEX Key_idx (empdept) VISIBLE,FOREIGN KEY (empdept) REFERENCES dept (deptid) ON DELETE NO ACTION ON UPDATE NO ACTION);");
//	PreparedStatement st1=con.prepareStatement("CREATE TABLE employe (empid INT NOT NULL,empname VARCHAR(45) NOT NULL,empnumber VARCHAR(45) NOT NULL,empdept INT NOT NULL,INDEX 'Foreign Key_idx` (`empdept` ASC) VISIBLE,CONSTRAINT `Foreign Key` FOREIGN KEY (`empdept`) REFERENCES `testdata`.`dept` (`deptid`) ON DELETE NO ACTION ON UPDATE NO ACTION);");
	st1.executeUpdate();
	st1.close();
//	
	conn.close();
	System.out.println("tables got created");
	
     }
}
	
	
