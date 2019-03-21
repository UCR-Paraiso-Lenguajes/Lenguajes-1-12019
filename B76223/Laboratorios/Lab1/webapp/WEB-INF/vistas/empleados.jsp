<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
	<a href="/insertarempleado">Insertar Empleado</a>
		<table>
				<th>
					<td>Id</td>
					<td>Nombre</td>  
				</th>
			<c:forEach items="${empleados}" var="empleado">
				<tr>
					<td><c:out value="${empleado.getId()}"/></td>
					<td><c:out value="${empleado.getNombre()}"/></td>  
				</tr>
			</c:forEach>
		</table>
	</body>
</html> 