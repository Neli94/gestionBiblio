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
      <th>ISBN</th>
      <th>Título</th>
      <th>Autor</th>
      <th>Editar</th>
      <th>Borrar</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${listado_libros }" var="libro">
  <tr>
  <td>${libro.isbn }</td>
  <td>${libro.titulo }</td>
  <td>${libro.autor }</td>
  <td><a href="libros/${libro.id }" class="btn btn-success">Editar</a></td>
  <td><a href="libros/${libro.id }" class="btn btn-danger">Borrar</a></td>
 </tr>
  </c:forEach>
  
  </tbody>
</table>
</body>
</html>