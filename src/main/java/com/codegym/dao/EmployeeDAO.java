package com.codegym.dao;

import com.codegym.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/final_test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "19091995@xk0305";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee values (?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id = ?;";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set name = ?, address = ?, phone_number=?,salary=?,department =?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhoneNumber());
            ps.setDouble(5, employee.getSalary());
            ps.setString(6, employee.getDepartment());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Employee selectEmployee(String id) {
        Employee employee = null;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String add = rs.getString("address");
                String pN = rs.getString("phone_number");
                Double salary = rs.getDouble("salary");
                String dep = rs.getString("department");
                employee = new Employee(id, name,email, add, pN, salary, dep);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String add = rs.getString("address");
                String pN = rs.getString("phone_number");
                Double salary = rs.getDouble("salary");
                String dep = rs.getString("department");
                employees.add(new Employee(id, name,email, add, pN, salary, dep));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            ps.setString(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection cn = getConnection(); PreparedStatement ps = cn.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getPhoneNumber());
            ps.setDouble(5, employee.getSalary());
            ps.setString(6, employee.getDepartment());

            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
