<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12 col-sm-6">
	 <h1>Libro</h1>
		<form:form method="POST" action="save" commandName="ejemplar">
			<c:if test="${!empty ejemplar }">
				<form:label path="id">
					<spring:message text="Id:" />
				</form:label>
				<form:input path="id" readonly="true" size="10" disabled="true"
					cssClass="form-control" />
				<form:hidden path="id" />
			</c:if>
			<div class="form-group">
				<form:label path="editorial">
					<spring:message text="Editorial:" />
				</form:label>
				<form:input path="editorial" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="editorial" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="npaginas">
					<spring:message text="Nº de páginas:" />
				</form:label>
				<form:input path="npaginas" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="npaginas" cssClass="text-danger"></form:errors>
			</div>
			 <div class="form-group">
 			 <form:select path="idLibro">
   				<form:option value="-1">Selecciona el libro</form:option>
   					<form:options items="${libros}" itemLabel="titulo" itemValue="id" />
			</form:select>
 			</div>
			<div class="form-group">
				<a href="<c:url value='ejemplares'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${ejemplar.id > 0}">
					<c:set var="msgBoton" value="EDITAR" />
				</c:if>
				<button type="submit" class="btn btn-success">
					<spring:message text="${msgBoton}" />
				</button>
				</div>
			<c:forEach items="${libros}" var="libro">
				${libro.titulo }
			</c:forEach>
		</form:form>

	</div>
</div>