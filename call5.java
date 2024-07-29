import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class call5 {
    public static void main(String[] args) {
    	  
        
        Scanner sc = new Scanner(System.in);
        
        Pcall5 obj = new call5();
        
        while (true) {
            System.out.println("Click 1 To Insert Record...");
            System.out.println("Click 2 To Update Record...");
            System.out.println("Click 3 To Delete Record...");
            System.out.println("Click 4 To View Record...");
            System.out.println("Click 5 To Exit");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.doInsert();
                    break;
                case 2:
                    obj.doUpdate();
                    break;
                case 3:
                    obj.doDelete();
                    break;
                case 4:
                    obj.doView();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    public void doInsert() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
		         		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
		         		
			            String sql = "insert into emp2 values(?,?,?,?)";
			            
			            System.out.print("Enter The empno:");
			            int empnox = sc.nextInt();
			            
			            System.out.println("Enter The Firstname:");
			            String fnamex = sc.nextLine();
			            
			            System.out.print("Enter The Lastname:");
			            String lnamex = sc.nextLine();
			            
			            System.out.print("Enter The Designation:");
                		String desigx = sc.nextLine();
                		
			            pst = con.prepareStatement(sql);
			            
			            pst.setInt(1,empnox);
			            pst.setString(2,fnamex);
			            pst.setString(3,lnamex);
			            pst.setString(4,desigx);
			            pst.executeUpdate();
			            System.out.println("Record Inserted...");
			            
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doUpdate() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            
			            String sql = "update emp2 set fname = ? where empno= ?";
			            
			            System.out.println("Enter empno:");
			            int empnox = sc.nextInt();
			            
			            System.out.println("Enter FirtsName:");
			            String fnamex = sc.nextLine();
			            
			            pst = con.prepareStatement(sql);
			            
			            pst.setInt(2,empnox);
			            pst.setString(1,fnamex);
			            
			            System.out.println("Record Updated...");
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doDelete() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            String sql = "delete from emp2 where empno = ?";
			            int empnox = sc.nextInt();
			            
			            
			            System.out.print("Enter The empno:");
			            pst.setInt(1,empnox);
			            pst = con.prepareStatement(sql);
			            System.out.println("Record Deleted...");
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doView() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            String sql = "select * from emp2 where empno = ?";
			            int empnox = sc.nextInt();
			            pst = con.prepareStatement(sql);
			            pst.setInt(1,empnox);
			            rs = pst.executeQuery();
			            while(rs.next()){
			                int empno = rs.getInt("empno");
				String fname = rs.getString("fname");
				String lname= rs.getString("lname");
				String desig = rs.getString("design");
				
				System.out.println("Id:" + empno);
				System.out.println("Name:" + fname);
				System.out.println("Designation:" + lname);
				System.out.println("City:" + desig);
			            }
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
        
    }
    }
               

               
