<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-xs-12 col-sm-6">
	 <h1>usuario</h1>
		<form:form method="POST" action="save" commandName="usuario">
			<c:if test="${!empty usuario }">
				<form:label path="id">
					<spring:message text="Id:" />
				</form:label>
				<form:input path="id" readonly="true" size="10" disabled="true"
					cssClass="form-control" />
				<form:hidden path="id" />
			</c:if>
			
			<div class="form-group">
				<form:label path="nombre">
					<spring:message text="nombre:" />
				</form:label>
				<form:input path="nombre" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="nombre" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="apellidos">
					<spring:message text="apellidos:" />
				</form:label>
				<form:input path="apellidos" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="apellidos" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="password">
					<spring:message text="password:" />
				</form:label>
				<form:input path="password" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="password" cssClass="text-danger"></form:errors>
			</div>
			
			<div class="form-group">
				<form:label path="email">
					<spring:message text="email:" />
				</form:label>
				<form:input path="email" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="email" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<a href="<c:url value='/usuarios'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${usuario.id > 0}">
					<c:set var="msgBoton" value="EDITAR" />
				</c:if>
				<button type="submit" class="btn btn-success">
					<spring:message text="${msgBoton}" />
				</button>
			</div>
		</form:form>

	</div>
</div>

<!--<c:if test="${usuario.id > 0}">
					
		<c:if test="${usuario.ejemplar.id== 0}">
		No se alquilado ejemplares al usuario	
			<c:forEach items="${ejemplares_noalquilados }" var="ejemplar">
			
			<form method="post" action="${usuario.id }/alquilar/${ ejemplar.id}">
			${ejemplar.libro.titulo }--${ejemplar.editorial }
				<button type="submit">Alquilar</button>
			</form>	
		</c:forEach>
		</c:if>			
	</c:if>
	
<c:if test="${usuario.ejemplar.id > 0}">

El usuario tiene alquilado el libro <strong>${usuario.ejemplar.libro.titulo }</strong> de la editorial  <strong>${usuario.ejemplar.editorial}</strong>
<form method="post" action="${usuario.id }/devolver">
<input type="hidden" name="id" value="${usuario.id }">
<button>Devolver</button>
</form>
</c:if>-->

</html>