package valtechWeb3;

import java.util.List;
import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.ranges.RangeException;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;
@WebServlet(urlPatterns= {"/empClrt"})
public class EmployeeControllerServlet extends HttpServlet {
    private EmployeeDAO dao;
    @Override
    public void init() throws ServletException {
        dao=new EmployeeDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit=req.getParameter("submit");
        //String submit=req.getParameter("submit");
        try {
            if("New Employee".equals(submit)) {
                req.getRequestDispatcher("CreateEmployee.jsp").forward(req, resp);
                return;
            }
            
            if("Update Employee".equals(submit)) {
                req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, resp);
                return;
            }
        if("save".equals(submit)) {
            Employee e=new Employee();
            e.setId(dao.getValidId());
            e.setName(req.getParameter("name"));
            e.setAge(Integer.parseInt(req.getParameter("age")));
            e.setGender(Integer.parseInt(req.getParameter("gender")));
            e.setSalary(Float.parseFloat(req.getParameter("salary")));
            dao.saveEmployee(e);
        }
        
        if("update".equals(submit)) {
        	//String empId =req.getParameter("empId");
        	
            Employee e=new Employee();
            e.setId(Integer.parseInt(req.getParameter("Id")));
            e.setName(req.getParameter("name"));
            e.setAge(Integer.parseInt(req.getParameter("age")));
            e.setGender(Integer.parseInt(req.getParameter("gender")));
            e.setSalary(Float.parseFloat(req.getParameter("salary")));
//            e.setId(dao.getValidId());
           // e.setId(1);
            dao.updateEmployee(e);
        }
        
        req.setAttribute("emps", dao.getEmployee());
        req.getRequestDispatcher("Emps.jsp").forward(req, resp);
    }catch(Exception ex) {
        throw new RuntimeException(ex);
    }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //login here and forwarded to jsp page
        try {
        	String empId =req.getParameter("empId");
        String submit=req.getParameter("submit");
       
        if(empId==null) {
        	
            loadEmployeesAndGoToEmps(req, resp);
            return;
        }
        int id=Integer.parseInt(req.getParameter("empId"));
        
        if("delete".equals(submit)) {
        	dao.deleteEmployee(id);
        	loadEmployeesAndGoToEmps(req, resp);
            return;
        }
        
        
        Employee e=dao.getEmployeeById(id);
        req.setAttribute("e", e);
        req.getRequestDispatcher("emp.jsp").forward(req, resp);
        ;
        }catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

	private void loadEmployeesAndGoToEmps(HttpServletRequest req, HttpServletResponse resp)
			throws Exception, ServletException, IOException {
		List<Employee> emps=dao.getEmployee();
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("Emps.jsp").forward(req, resp);
	}
}