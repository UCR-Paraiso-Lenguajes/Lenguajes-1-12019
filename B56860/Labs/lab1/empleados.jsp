<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Empleados</title>
<style>
    .table{
        padding: 2;
        border: dotted 3px;
        border-color: black dotted;
    }
</style>
</head>
	<body>   
	    <h2><a href="/insertarempleado">Insertar Empleado</a></h2>
	   
	    <table>
	       <tr>
	               <th>Id</th>
	               <th>Name</th>  
	        </tr>
	        <c:forEach items="${empleados}" var="empleado">
	        <tr>
	            <td><c:out value="${empleado.getId()}"/></td>
	            <td><c:out value="${empleado.getNombre()}"/></td>  
	        </tr>
	        </c:forEach>
	    </table>
	</body>