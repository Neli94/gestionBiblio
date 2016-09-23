<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="es_ES" />
<c:set var="selectedLanguage" value="${usuario.idioma }" />
<c:choose>
	<c:when test="${!empty selectedLanguage }">
		<c:set var="language" value="${selectedLanguage.locale}" />
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>



<!DOCTYPE html>
<html lang="${language}">
<head>

<title>Gestion de Cursos</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- BOOTSTRAP BASE STYLES -->
<link href="<c:url value="resources/css/bootstrap.min.css" />" rel="stylesheet">

<!-- BOOTSTRAP THEME STYLES -->
<link href="<c:url value="resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link rel="stylesheet" href=<c:url value="resources/css/bootstrap-theme.min.css" /> />
<!-- FONT AWESOME -->
<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
<!-- MY THEME STYLES -->
<link rel="stylesheet" href="resources/css/styles.css" />
<!-- JQUERY -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BOOTSTRAP JS LIBS -->
<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
<!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>

<body class="container-fluid">
	<header class="row">
		<h1 class="col-xs-6">Gestion de Libros de la Biblioteca Teca</h1>
	</header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">			
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">LIBROS <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="libros">Ver Libros </a></li>
							<li><a
								href="libros/save">Crear
									Libro </a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">EJEMPLARES<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="ejemplares">Ver Ejemplares </a></li>
							<li><a
								href="ejemplares/save">Crear
									Ejemplar </a></li>
						</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button">USUARIOS <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="usuarios">Ver Usuarios </a></li>
							<li><a
								href="usuarios/save">Crear
									Usuario </a></li>
						</ul></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">ADMIN <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="">Ver Usuarios Conectados </a></li>

						</ul></li>


				</ul>

				<ul class="nav navbar-nav navbar-right">
					<p class="navbar-text">
						Identificado como <strong></strong>
					</p>
					<a href="" class="btn btn-danger navbar-btn">LogouT
					</a>
				</ul>
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		
	</nav>
	<container-fluid>