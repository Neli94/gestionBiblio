<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado</title>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h1>Listado</h1>


<table>
  <thead>
    <tr>
      <th>Libro</th>
      <th>Editorial</th>
      <th>Nº de páginas</th>
      <th>Editar</th>
      <th>Borrar</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${listado_ejemplares}" var="ejemplar">
  <tr>
  <td>${ejemplar.libro.titulo }</td>
  <td>${ejemplar.editorial }</td>
  <td>${ejemplar.npaginas }</td>
  <td><a href="ejemplares/${ejemplar.id }" class="btn btn-success">Editar</a></td>
  <td><a href="ejemplares/${ejemplar.id }" class="btn btn-danger">Borrar</a></td>
 </tr>
  </c:forEach>
  
  </tbody>
</table>
</body>
</html>