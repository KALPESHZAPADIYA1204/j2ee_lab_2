import java.sql.*;
public class call3{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		ResultSet rs;
		String url="jdbc:mysql://localhost:3306/company";
		try{
			con = DriverManager.getConnection(url,"root","tnrao");
			cst = con.prepareCall("{call p_add41(?)}");
			cst.setInt(1,6);
			rs = cst.executeQuery();
			while(rs.next()){
				String desig = rs.getString("desig");
				System.out.println("Designation:" + desig);
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

CREATE PROCEDURE p_add41(IN empnox INT)
BEGIN
    SELECT desig FROM emp2 WHERE empno= empnox;
END //

DELIMITER ;
 ;*/
