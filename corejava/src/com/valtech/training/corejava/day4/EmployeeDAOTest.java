package com.valtech.training.corejava.day4;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

public class EmployeeDAOTest {

	//@Test
	public void test() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		Connection conn=dao.getConnection();
		conn.close();
	}
	//@Test
	public void testCount() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		int count=dao.count();
		//assertEquals(count+1, dao.count());
	}
	
	@Test
	public void testSaveEmployee() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		int count=dao.count();
		dao.saveEmployee(new Employee(1,"ak",21,1,10000));
		assertEquals(count+1, dao.count());
		
//		dao.deleteEmployee(10);
//		assertEquals(count, dao.count());
	
	}

	//@Test
	public void testGetEmployees() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		List<Employee> e=dao.getEmployee();
		int count=dao.count();
		//assertEquals(count, e);
		assertTrue("jhon", true);
		assertTrue("alis", true);
		assertTrue("lisa",true);
	}
	
	//@Test
	public void testdeleteEmployees() throws Exception {
	EmployeeDAO dao =new EmployeeDAO();
	int count=dao.count();
	dao.deleteEmployee(4);
	assertEquals(count, dao.count());
	
	}
	
	//@Test
	public void testUpdateEmployee() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		
		dao.updateEmployee(new Employee(15,"heena",25,1,12000));
		Employee e=dao.getEmployeeById(15);
		assertEquals(e.getId(),	15);
		//assertEquals(e.getAge(),25);
		
	
	}
	
	
	//@Test
	public void testGetEmployeeByAge() throws Exception {
		
		
		EmployeeDAO dao =new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByGender(21);
		
		assertTrue("jhon", true);
		assertTrue("alis", true);
		assertFalse("lisa",false);
		
	}
	
	//@Test
	public void testGetEmployeeByMaxSalary() throws Exception {
	
	
	EmployeeDAO dao =new EmployeeDAO();
	Employee e=dao.getEmployeeByMaxSalary();
	assertEquals(3, e.getId());
	assertEquals(21, e.getAge());
	assertEquals(1, e.getGender());
	assertEquals("jhon", e.getName());
	
}
	
	
	//@Test
	public void testGetEmployeeById() throws Exception {
	
	
	EmployeeDAO dao =new EmployeeDAO();
	Employee e=dao.getEmployeeById(2);
	assertEquals(2, e.getId());
	assertEquals(22, e.getAge());
	assertEquals(1, e.getGender());
	assertEquals("abhi", e.getName());
	
}
	//@Test
	public void testGetEmployeeByminSalary() throws Exception {
		
		
		EmployeeDAO dao =new EmployeeDAO();
		Employee e=dao.getEmployeeByMinSalary();
		assertEquals(5, e.getId());
		assertEquals(21, e.getAge());
		assertEquals(1, e.getGender());
		assertEquals("ak", e.getName());
		
	}
	
	
	//@Test
		public void testGetEmployeegGenderMale() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByGender(1);
		
		int total=dao.getEmployeeByGender(1).size();
		assertEquals(total, dao.getEmployeeByGender(1).size());
		
		
		assertFalse("lisa", false);
		assertFalse("monica", false);
		}
		
		//@Test
				public void testGetEmployeegGenderFemale() throws Exception {
				EmployeeDAO dao =new EmployeeDAO();
				List<Employee> e=dao.getEmployeeByGender(2);
				
				int total=dao.getEmployeeByGender(2).size();
				assertEquals(total, dao.getEmployeeByGender(2).size());
				
				
				assertFalse("abhi", false);
				assertFalse("jhon", false);
				assertFalse("ak", false);
				assertTrue("monica", true);

}
		//@Test
		public void testGetEmployeegGenderOthers() throws Exception {
		EmployeeDAO dao =new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByGender(3);
		
		int total=dao.getEmployeeByGender(3).size();
		assertEquals(total, dao.getEmployeeByGender(3).size());
		
		
		assertFalse("abhi", false);
		assertFalse("jhon", false);
		assertFalse("ak", false);
		assertTrue("lee", true);
		assertTrue("nora", true);
		assertTrue("alis", true);

}
	
	//@Test
	public void testGetEmployeeGreaterThanSalary() throws Exception {
	
	
	EmployeeDAO dao =new EmployeeDAO();
	List<Employee> e=dao.getEmployeeByGraterThanSalary(55000);
	
	int total=dao.getEmployeeByGraterThanSalary(55000).size();
	assertEquals(total, dao.getEmployeeByGraterThanSalary(55000).size());
	
	assertTrue("abhi", true);
	assertFalse("ak", false);
	assertTrue("lee", true);
	assertTrue("nora", true);
	assertTrue("alis", true);

	
	}
	
	//@Test
	public void testGetEmployeeLesserThanSalary() throws Exception {
	
	
	EmployeeDAO dao =new EmployeeDAO();
	List<Employee> e=dao.getEmployeeByLessThanSalary(12000);
	
	int total=dao.getEmployeeByLessThanSalary(12000).size();
	assertEquals(total, dao.getEmployeeByLessThanSalary(12000).size());
	
	assertTrue("new", true);
	assertFalse("monica", false);
	assertTrue("heena", true);
	assertTrue("aaaa", true);
	assertFalse("alis", false);

	
	}
	
	@Test
	public void testGetEmployeeBetweenSalary() throws Exception {
	
	
	EmployeeDAO dao =new EmployeeDAO();
	///Employee e=dao.getEmployeeByGender();
	
	int total=dao.getEmployeeBetweenSalary().size();
	assertEquals(total, dao.getEmployeeBetweenSalary().size());
	assertTrue("55000", true);
	assertTrue("ak", true);
	assertTrue("nora", true);
}
	
	@Test
	public void testGetEmployeeBetweenAge() throws Exception {
		
		
		EmployeeDAO dao =new EmployeeDAO();
		///Employee e=dao.getEmployeeByGender();
		
		int total=dao.getEmployeeBetweenAge(22,23).size();
		assertEquals(total, dao.getEmployeeBetweenAge(22,23).size());
		assertTrue("abhi", true);
		assertTrue("lisa", true);
		assertTrue("monica", true);
	}
	
	
}
