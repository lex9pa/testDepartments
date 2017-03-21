<jsp:useBean id="departmentList" scope="request" type="java.util.List"/>
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
        <label for="Name">Name</label>
        <input id="Name" type="text" name="name" class="form-control" placeholder="Name"
               value="${employee.employeeName}"/>
    </div>
    <p>
        <small>${error.employeeName}</small>
    </p>
    <div class="form-group">
        <label for="surname">Surname</label>
        <input id="surname" type="text" name="surname" class="form-control" placeholder="Surname"
               value="${employee.employeeSurname}"/>
    </div>
    <p>
        <small>${error.employeeSurname}</small>
    </p>
    <div class="form-group">
        <label for="email">E-mail</label>
        <input id="email" type="email" name="email" class="form-control" placeholder="E-mail"
               value="${employee.employeeEmail}"/>
    </div>
    <p>
        <small>${error.employeeEmail}</small>
    </p>
    <div class="form-group">
        <label for="Birthday">Birthday</label>
        <input id="Birthday" type="date" name="birthday" class="form-control"
               value="${employee.employeeBirthday}"/>
    </div>
    <p>
        <small>${error.employeeBirthday}</small>
    </p>
    <div class="form-group">
        <label for="salary">Salary</label>
        <input id="salary" type="number" name="salary" class="form-control" placeholder="Salary"
               value="${employee.employeeSalary}"/>
    </div>
    <p>
        <small>${error.employeeSalary}</small>
    </p>
    <div class="form-group">
        <label for="department">Department</label>
        <select id="department" name="departmentId">
            <c:forEach items="${departmentList}" var="department">
                <option value="${department.id}"><c:out value="${department.departmentName}"/></option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
