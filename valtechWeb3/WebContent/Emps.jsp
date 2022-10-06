<%@page import="java.util.List"%>
<%@page import="com.valtech.dao.Employee"%>
<%@page import="com.valtech.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, td, thead {
  border: 2lpx solid;
}

table {
  width: 70%;
  border-collapse: collapse;
}
</style>
</head>
<body>
<% List<Employee> emps=(List<Employee>) request.getAttribute("emps");%>
<table>
<thead>
    <tr>
        <td> Id</td>
        <td> Name</td>
        <td> Age</td>
        <td> Gender</td>
        <td> Salary</td>
        <td> Operations</td>
    </tr>
</thead>
<tbody>
    <%for(Employee e:emps){ %>
    <tr>
        <td> <%=e.getId() %></td>
        <td> <%=e.getName() %></td>
        <td><%=e.getAge() %></td>
        <td> <%=e.getGender() %></td>
        <td> <%=e.getSalary()%></td>
        <td> <a href="empClrt?empId=<%= e.getId() %>"><button>View Details</button></a>
        
        <form action="empClrt?empId=<%= e.getId() %>" method ="post" >
        
		<input  name="submit" type="submit" value="Update Employee"/>
		</form>
        
         
        <a href="empClrt?submit=delete&empId=<%=e.getId()%>"><button>Delete</button></a>
        
        </td>
    </tr>
    <%} %>
</tbody>
</table>
<br>
<form action="empClrt" method ="post">
<input name="submit" type="submit" value="New Employee"/>
</form>

</body>
</html>

