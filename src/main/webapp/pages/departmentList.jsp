<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set value="/" var="Main"/>
<c:set value="/department/list" var="Department"/>
<c:set value="/employee/list" var="Employee"/>
<c:set var="delete" value="/department/delete"/>
<c:set var="create" value="/department/form"/>
<jsp:useBean id="departmentList" scope="request" type="java.util.List"/>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href=${Main}>Home</a></li>
    <li role="presentation" class="active"><a href=${Department}>Department List</a></li>
    <li role="presentation"><a href=${Employee}>Employee List</a></li>
</ul>
<p></p>

<table class="table table-bordered">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td><a class="btn btn-default" href="${create}" role="button">Add</a></td>
    </tr>
    <c:forEach items="${departmentList}" var="department">
        <tr>
            <td><c:out value="${department.id}"/></td>
            <td><c:out value="${department.departmentName}"/></td>
            <td><c:url value="${delete}" var="del">
                <c:param name="id" value="${department.id}"/>
            </c:url>
                <a class="btn btn-default" href="${del}" role="button">Delete</a>
            </td>
            <td><c:url value="${create}" var="edit">
                <c:param name="id" value="${department.id}"/>
            </c:url>
                <a class="btn btn-default" href="${edit}" role="button">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
