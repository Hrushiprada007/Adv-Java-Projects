package in.hrushiit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmployees {
	   private static final String DB_URL="jdbc:mysql://localhost:3306/employeeForm";
	   
	   private static final String DB_UNAME="root";
	   
	   private static final String DB_PWD = "Hrushi@2003";
	   
	   public static void main(String[] args)throws Exception{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Employee's work_location:");
		String work_location = scn.next();
		
		System.out.println("Enter Employee's Department:");
		String dept = scn.next();
		
		System.out.println("Enter Employee's gender:");
		String gender = scn.next();
		
		StringBuilder  sql =new StringBuilder("select * from   EmployeeForm where 1=1"); //1=1 means always true
		
		if((dept!=null && !dept.equals("null"))) {
		//if((dept!=null && !dept.equals("\\s"))) {
			sql.append(" and emp_dept= ?");
		}
		if((work_location != null && !work_location.equals("null"))) {
		//if((work_location!=null && !work_location.equals("\\s"))) {
			sql.append(" and work_location = ?");
			
		}
		if((gender !=null && !gender.equals("null"))){
		//if((gender !=null && !gender.equals("\\s"))){
			sql.append(" and emp_gender = ?");
		}
		System.out.println(sql.toString());
		
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		int index = 1;
		
		if((dept!=null && !dept.equals("null"))) {
		//if((dept!=null && !dept.equals("\\s"))) { //you can pass space replace of null, not working that space
			pstmt.setString(index, dept);
			index ++;
		}
		if((work_location != null && !work_location.equals("null"))) {
		//if((work_location != null && !work_location.equals("\\s"))) {
			pstmt.setString(index, work_location);
			index ++;
		}
		if((gender !=null && !gender.equals("null"))){
		//if((gender !=null && !gender.equals("\s\s"))){
			pstmt.setString(index, gender);
		}
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"-- "+rs.getString(2)+"--- "+rs.getDouble(3)+"---- "+rs.getString(4)+"---- "+rs.getString(5)+"----- "+rs.getString(6));
		}
		
	} 
}
