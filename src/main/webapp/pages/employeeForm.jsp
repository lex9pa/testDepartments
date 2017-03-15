<jsp:useBean id="employee" scope="request" type="java.lang.Object"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set value="/" var="Main"/>
<c:set value="/department/list" var="Department"/>
<c:set value="/employee/list" var="Employee"/>
<c:set value="/employee/save" var="EmployeeSave"/>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href=${Main}>Home</a></li>
    <li role="presentation"><a href=${Department}>Department List</a></li>
    <li role="presentation"><a href=${Employee}>Employee List</a></li>
</ul>
<form method="post" action=${EmployeeSave}>
    <input id="id" type="hidden" name="id" value="${employee.id}"/>
    <div class="form-group">
        <input type="text" name="name" class="form-control" placeholder="Name"
               value="${employee.employeeName}"/>
    </div>
    <div class="form-group">
        <input type="text" name="surname" class="form-control" placeholder="Surname"
               value="${employee.employeeSurname}"/>
    </div>
    <div class="form-group">
        <input type="email" name="email" class="form-control" placeholder="E-mail" value="${employee.employeeEmail}"/>
    </div>
    <div class="form-group">
        <label for="Birthday">Birthday</label>
        <input id="Birthday" type="date" name="birthday" class="form-control"
               value="${employee.employeeBirthday}"/>
    </div>
    <div class="form-group">
        <input type="number" name="salary" class="form-control" placeholder="Salary"
               value="${employee.employeeSalary}"/>
    </div>
    <div class="form-group">
        <input type="number" name="departmentId" class="form-control" placeholder="Department ID"
               value="${employee.departmentId}"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
