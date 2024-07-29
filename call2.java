import java.sql.*;
public class call2{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		String url="jdbc:mysql://localhost:3306/company";
		try{
			con = DriverManager.getConnection(url,"root","tnrao");
			cst = con.prepareCall("{call p_add31(?,?,?,?)}");
			cst.setInt(1,4);
			cst.setString(2,"Rahul");
			cst.setString(3,"Zapadiya");
			cst.setString(4,"Engineer");
			cst.execute();
			System.out.println("Record Inserted...");
			con.close();
			cst.close();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/*CREATE PROCEDURE p_add31(IN empno int, IN fname varchar(10), IN lname varchar(10), IN desig varchar(10))
BEGIN
INSERT INTO emp2 (empno, fname, lname, desig) VALUES (empno, fname, lname, desig);
END //
DELIMITER ;*/
