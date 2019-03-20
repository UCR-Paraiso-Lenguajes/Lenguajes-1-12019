<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

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