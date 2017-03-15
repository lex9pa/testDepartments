<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set value="/" var="Main"/>
<c:set value="/department/list" var="Department"/>
<c:set value="/employee/list" var="Employee"/>
<c:set value="/employee/form" var="employeeCreate"/>
<c:set var="delete" value="/employee/delete"/>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href=${Main}>Home</a></li>
    <li role="presentation"><a href=${Department}>Department List</a></li>
    <li role="presentation" class="active"><a href=${Employee}>Employee List</a></li>
</ul>
<p></p>
    <table class="table table-bordered">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Surname</td>
            <td>e-mail</td>
            <td>Birth Day</td>
            <td>Salary</td>
            <td>Department's id</td>
            <td><a class="btn btn-default" href="${employeeCreate}" role="button">Add</a></td>
            <td></td>
        </tr>
        <jsp:useBean id="employeeList" scope="request" type="java.util.List"/>
        <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td><c:out value="${employee.id}"/></td>
            <td><c:out value="${employee.employeeName}"/></td>
            <td><c:out value="${employee.employeeSurname}"/></td>
            <td><c:out value="${employee.employeeEmail}"/></td>
            <td><c:out value="${employee.employeeBirthday}"/></td>
            <td><c:out value="${employee.employeeSalary}"/></td>
            <td><c:out value="${employee.departmentId}"/></td>
            <td><c:url value="${delete}" var="del">
                <c:param name="id" value="${employee.id}"/>
            </c:url>
                <a class="btn btn-default" href="${del}" role="button">Delete</a>
            </td>
            <td><c:url value="${employeeCreate}" var="edit">
                <c:param name="id" value="${employee.id}"/>
            </c:url>
                <a class="btn btn-default" href="${edit}" role="button">Edit</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
