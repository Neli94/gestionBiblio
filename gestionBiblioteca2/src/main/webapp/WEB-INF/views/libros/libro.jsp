<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12 col-sm-6">
	 <h1>Libro</h1>
		<form:form method="POST" action="save" commandName="libro">
			<c:if test="${!empty libro }">
				<form:label path="id">
					<spring:message text="Id:" />
				</form:label>
				<form:input path="id" readonly="true" size="10" disabled="true"
					cssClass="form-control" />
				<form:hidden path="id" />
			</c:if>
			<div class="form-group">
				<form:label path="isbn">
					<spring:message text="Isbn:" />
				</form:label>
				<form:input path="isbn" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="isbn" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="titulo">
					<spring:message text="Titulo:" />
				</form:label>
				<form:input path="titulo" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="titulo" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="autor">
					<spring:message text="Autor:" />
				</form:label>
				<form:input path="autor" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="autor" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<a href="<c:url value='/libros'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${libro.id > 0}">
					<c:set var="msgBoton" value="EDITAR" />
				</c:if>
				<button type="submit" class="btn btn-success">
					<spring:message text="${msgBoton}" />
				</button>
			</div>
		</form:form>

	</div>
</div>
</body>
</html>