<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2023
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employee?action=create">Add new employee</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of employee</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td><c:out value="${employee.id}"></c:out></td>
                <td><c:out value="${employee.name}"></c:out></td>
                <td><c:out value="${employee.email}"></c:out></td>
                <td><c:out value="${employee.address}"></c:out></td>
                <td><c:out value="${employee.phoneNumber}"></c:out></td>
                <td><c:out value="${employee.salary}"></c:out></td>
                <td><c:out value="${employee.department}"></c:out></td>
                <td>
                    <a href="employee?action=edit&id=${employee.id}">Edit</a>
                    <a href="/employee?action=delete&id=${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
