import java.sql.*;
public class call1{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		String url="jdbc:mysql://localhost:3306/company";
		try
		{
			con = DriverManager.getConnection(url,"root","tnrao");
			cst = con.prepareCall("{call p_addin2()}");
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
/*CREATE PROCEDURE p_addin2()
BEGIN
INSERT INTO emp2 (epmno, fname, lname,desig) VALUES (1, "kalpesh", "Zapadiya", "developer");
END //
DELIMITER ;*/
