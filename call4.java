import java.sql.*;
import java.util.*;
public class call4
{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Connection con;
		CallableStatement cst;
		ResultSet rs;
		String url="jdbc:mysql://localhost:3306/company";
		try{
			System.out.println("Enter Designation:");
			String de = sc.nextLine();
			con = DriverManager.getConnection(url,"root","tnrao");
			cst = con.prepareCall("{call p_add51(?)}");
			cst.setString(1,desig);
			rs = cst.executeQuery();
			while(rs.next()){
				int empno = rs.getInt("empno");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String desig= rs.getString("desig");
				
				System.out.println("empno:" + empno);
				System.out.println("Firstname:" + fname);
				System.out.println("Lastname" + lname);
				System.out.println("designation:" + desig);
			}
			
			con.close();
			cst.close();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/*DELIMITER //

CREATE PROCEDURE p_add51(IN desigx varchar(10))
BEGIN
    SELECT * FROM emp2 WHERE desig = desigx;
END //

DELIMITER ;*/
