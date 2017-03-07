<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<c:set value="/" var="Main"/>
<c:set value="/department/list" var="Department"/>
<c:set value="/employee/list" var="Employee"/>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href=${Main}>Home</a></li>
    <li role="presentation"><a href=${Department}>Department List</a></li>
    <li role="presentation"><a href=${Employee}>Employee List</a></li>
</ul>

</body>
</html>
