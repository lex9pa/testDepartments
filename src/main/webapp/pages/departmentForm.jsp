<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set value="/" var="Main"/>
<c:set value="/department/list" var="Department"/>
<c:set value="/employee/list" var="Employee"/>
<c:set value="/department/save" var="DepartmentSave"/>
<jsp:useBean id="department" scope="request" type="com.skobeev.project.model.Department"/>
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
<form method="post" action=${DepartmentSave}>
    <input id="id" type="hidden" name="id" value="${department.id}"/>
    <div class="form-group">
        <input class="form-control" type="text" name="name" placeholder="Name"
               value="${department.departmentName}"/>
    </div>
    <p>
        <small>${error.departmentName}</small>
    </p>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>