<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2023
  Time: 10:03 AM
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
        <a href="employee?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/employee?action=create">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add new employee</h2>
            </caption>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" id="name" size="45"/></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" id="email" size="45"/></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" id="address" size="45"/></td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td><input type="text" name="phone_number" id="phone_number" size="45"/></td>
            </tr>
            <tr>
                <th>Salary</th>
                <td><input type="text" name="salary" id="salary" size="45"/></td>
            </tr>
            <tr>
                <th>Department</th>
                <td><input type="text" name="department" id="department" size="45"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
