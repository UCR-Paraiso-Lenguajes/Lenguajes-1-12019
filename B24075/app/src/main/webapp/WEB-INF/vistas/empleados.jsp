<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
	
	<a href = "/insertarempleado">Insertar</a>
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