<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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