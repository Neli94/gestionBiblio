<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h1>Listado</h1>
<table>
  <thead>
    <tr>
   
      <th>Nombre</th>
      <th>Apellidos</th>
      <th>Editar</th>
      <th>Borrar</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${listado_usuarios}" var="usuario">
  <tr>
  <td>${usuario.nombre}</td>
  <td>${usuario.apellidos}</td>
  
  <td><a href="usuarios/${usuario.id }" class="btn btn-success">Editar</a></td>
  <td><a href="usuarios/${usuario.id }" class="btn btn-danger">Borrar</a></td>
 </tr>
  </c:forEach>
  
  </tbody>
</table>
</body>
</html>html>