package com.codegym.dao;

import com.codegym.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    void insertEmployee(Employee employee) throws SQLException;
    Employee selectEmployee(String id);
    List<Employee> selectAllEmployee();
    boolean deleteEmployee(String id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
}
