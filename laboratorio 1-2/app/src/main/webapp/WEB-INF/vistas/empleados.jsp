<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>




<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<table>
				<tr><a href=insertarempleado >  
					<th>Id</th>
					<th>Nombre</th> insertar empleado </a>
				</tr>
			<c:forEach items="${empleados}" var="empleado">
				<tr>
					<td><c:out value="${empleado.getId()}"/></td>
					<td><c:out value="${empleado.getNombre()}"/></td>  
				</tr>
			</c:forEach>
		</table>
	</body>
</html>