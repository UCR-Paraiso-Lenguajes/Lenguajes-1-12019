<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
	<a href="/insertarempleado">Insertar Empleado</a>
		<table>
				<tr>
					<th>Id</th>
					<th>Nombre</th>  
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