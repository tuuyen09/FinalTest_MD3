<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2023
  Time: 10:13 AM
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
        <a href="employee?action=users">List all employee</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/employee?action=create">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit employee</h2>
            </caption>
            <c:if test="${employee!=null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Name</th>
                <td> <input type="text" name="name" size="45"
                            value="<c:out value='${employee.name}' />"/></td>
            </tr>
            <tr>
                <th>Email</th>
                <td> <input type="text" name="email" size="45"
                            value="<c:out value='${employee.email}' />"/></td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>
                    <input type="text" name="phone_number" size="45"
                           value="<c:out value='${employee.phoneNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salary</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="<c:out value='${employee.salary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Department</th>
                <td>
                    <input type="text" name="department" size="45"
                           value="<c:out value='${employee.department}' />"
                    />
                </td>
            </tr>
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
