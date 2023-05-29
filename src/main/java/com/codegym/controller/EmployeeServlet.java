package com.codegym.controller;

import com.codegym.dao.EmployeeDAO;
import com.codegym.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Employee existingEmployee = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String add = request.getParameter("address");
        String pN = request.getParameter("phone_number");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String dep = request.getParameter("department");
        Employee newEmployee = new Employee(name, email, add, pN, salary, dep);
        employeeDAO.insertEmployee(newEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String add = request.getParameter("address");
        String pN = request.getParameter("phone_number");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String dep = request.getParameter("department");

        Employee book = new Employee(id, name, add, pN, salary, dep);
        employeeDAO.updateEmployee(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        employeeDAO.deleteEmployee(id);

        List<Employee> listEmployee = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
