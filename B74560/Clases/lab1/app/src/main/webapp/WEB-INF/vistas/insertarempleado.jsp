<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<form  method="post" action="/insertarempleado">
		Nombre:<br>
		<input type="text" name="nombre" value="">
		<br>
		Apellidos:<br>
		<input type="text" name="apellidos" value="">
		<br>
		Departamentos:<br>
		<select name="departamento">
			<c:forEach items="${departamentos}" var="deparmento">
			 <option value="${deparmento.getCod()}">${deparmento.getNombre()}</option>
			</c:forEach>
		</select>
		<br><br>
		<input type="submit" value="Agregar">
	</form> 
	</body>
</html>