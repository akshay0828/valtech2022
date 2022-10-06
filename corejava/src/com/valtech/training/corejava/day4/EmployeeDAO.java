package com.valtech.training.corejava.day4;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;

import org.omg.CORBA.PUBLIC_MEMBER;

import oracle.jdbc.replay.ReplayableConnection.StatisticsReportType;

public class EmployeeDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
		final String TABLE_NAME="vemp";
		
		public void deleteEmployee(int id) throws Exception{
			Connection conn =getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from "+TABLE_NAME+" where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		}
		
		
		
		
		
		public List <Employee> getEmployee()throws Exception{
			
			Connection conn=getConnection();
			PreparedStatement ps= conn.prepareStatement("select * from "+TABLE_NAME);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		}
		
		public void saveEmployee(Employee e) throws Exception {
			Connection con =getConnection();
			   PreparedStatement ps=con.prepareStatement("Insert Into "+TABLE_NAME+" (id, name,age,gender,salary) VALUES (?,?,?,?,?)");
			   setdata(e, ps);
			
			
			int rowsAffected=ps.executeUpdate();
			con.close();
		}
		
		public void updateEmployee(Employee e) throws Exception{
			Connection conn=getConnection();
			
			PreparedStatement ps=conn.prepareStatement("Update "+TABLE_NAME+" set name=?,age=?,gender=?,salary=? where id=? ");
			//PreparedStatement ps=conn.prepareStatement("Insert Into "+TABLE_NAME+" (id, name,age,gender,salary) VALUES (?,?,?,?,?)");
					//ps.setInt(1, e.getId());	
			ps.setInt(5, e.getId());
			ps.setString(1, e.getName());
			ps.setInt(2, e.getAge());
			ps.setInt(3, e.getGender());
			ps.setDouble(4, e.getSalary());
			ps.executeUpdate();
			conn.close();
		}
		
		Employee getEmployeeById(int id) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			//JTable.setModel( DbUtils.resultSetToTableModel(rs));
			if(rs.next()) {
				Employee e = employeeFromResultset(rs);
				conn.close();
				return e;
				
			} else {
				return null;
			}
		
		}
		
		
		
		public List <Employee> getEmployeeByAge(int age) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where age=?");
			ps.setInt(1,age);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		}
		
		
		
		public List <Employee> getEmployeeBetweenAge(int age1,int age2) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where age BETWEEN ? AND ?");
			ps.setInt(1,age1);
			ps.setInt(2,age2);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		
		}
		
		
		
		Employee getEmployeeByMaxSalary() throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" WHERE salary=(SELECT MAX(salary) FROM "+TABLE_NAME+" )");
			//ps.setFloat(1,salary);
			ResultSet rs=ps.executeQuery();
			//JTable.setModel( DbUtils.resultSetToTableModel(rs));
			if(rs.next()) {
				Employee e = employeeFromResultset(rs);
				conn.close();
				return e;
				
			} else {
				return null;
			}
		
		}
		
		
		Employee getEmployeeByMinSalary() throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" WHERE salary=(SELECT MIN(salary) FROM "+TABLE_NAME+" )");
			//ps.setFloat(1,salary);
			ResultSet rs=ps.executeQuery();
			//JTable.setModel( DbUtils.resultSetToTableModel(rs));
			if(rs.next()) {
				Employee e = employeeFromResultset(rs);
				conn.close();
				return e;
				
			} else {
				return null;
			}
		
		}
		
		public List <Employee> getEmployeeBetweenSalary() throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where salary BETWEEN (SELECT min(salary) FROM "+TABLE_NAME+") And (SELECT max(salary) FROM "+TABLE_NAME+")");
//			ps.setInt(1,sal1);
//			ps.setInt(2,sal2);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		
		}
		
		
		
		
		public List <Employee> getEmployeeByGraterThanSalary(int Greatersalary) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where salary>=?");
			ps.setInt(1,Greatersalary);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		}

		public List <Employee> getEmployeeByLessThanSalary(int Lessersalary) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where salary<=?");
			ps.setInt(1,Lessersalary);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		}
		
		
		
		public List <Employee> getEmployeeByGender(int gender) throws Exception{
			Connection conn = getConnection();
			PreparedStatement ps=conn.prepareStatement("Select * from "+TABLE_NAME+" where gender=?");
			ps.setInt(1,gender);
			ResultSet rs=ps.executeQuery();
			List<Employee>employee = new ArrayList<>();
			while (rs.next()) {
				employee.add(employeeFromResultset(rs));
			}
			
			conn.close();
			return employee;
		
		}
		
		
		

		private Employee employeeFromResultset(ResultSet rs) throws SQLException {
			Employee e= new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setGender(rs.getInt(4));
			e.setSalary(rs.getFloat(5));
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount(); 
			while (rs.next()) {
				//Print one row          
				for(int i = 1 ; i <= columnsNumber; i++){

				      System.out.print(rs.getString(i) + " "); //Print one element of a row

				}

				  System.out.println();//Move to the next line to print the next row.           

				    }
			return e;
			

		}
		
		

		private void setdata(Employee e, PreparedStatement ps) throws SQLException {
			
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getAge());
			ps.setInt(4, e.getGender());
			ps.setDouble(5, e.getSalary());
			
		};
	
	   public int count() throws Exception {
		   Connection con =getConnection();
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("SELECT count(id) from "+TABLE_NAME);
		   if(rs.next()) {
			   int count=rs.getInt(1);
			   System.out.println(rs.getInt(1));
			   con.close();
			   return count;
		   }else {
			   con.close();
			   return -1;
		   }
	   }
		
	
	
	static Connection getConnection() throws Exception{
	
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe","valtrg6","valtrg6");
	}

}
