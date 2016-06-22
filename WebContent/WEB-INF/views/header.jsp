<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Home</title>

    <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body >
		
			<div align="right">
				<form action="home" method="post">
					
						<img style="margin-left: 100px;" align="left" src="resources/images/logo.gif" />
					
					<!-- <a class="btn" href="home">Home</a> -->
					 
					<input type="hidden" name="usuarioID" value="${usuario_logado.id }"/>
					<input type="hidden" name="papelID" value="${papelusuario.papelId }"/>
					<input type="submit" class="btn btn-primary"  value="home"/>
					
					<c:if test="${usuario_logado.id == null }">
						<a class="btn btn-primary" href="#" data-toggle="modal" data-target="#login-modal" >Logar</a>
						<a class="btn btn-primary" href="inserirUsuarioFormulario"> Cadastrar-se</a>
					</c:if>
					<c:if test="${usuario_logado.id != null }">
						<a class="btn btn-primary" href="#" data-toggle="modal" data-target="#login-modal" >Relogar</a>
						
						<ul class="nav navbar-nav navbar-right">
		         			<li class="dropdown" style="min-width:200px"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> ${usuario_logado.nome}<span class="caret"></span></a>
		          				<ul class="dropdown-menu" role="menu" style="min-width: 200px">
		            				<c:if test="${papelusuario.papelId == 1 }">
		            					
		            					<li><a href="inserirUsuarioFormulario">Usuarios</a></li>
		            					<li><a href="inserirSecaoFormulario">Seções</a></li>
		            				</c:if>
		            				<c:if test="${papelusuario.papelId == 2 }">
		            					<li><a href="#">Selecione a seção para inseriir uma nova noticia</a>
		            				</c:if>
		            				<c:if test="${papelusuario.papelId == 3 }">
		            					<li><a href="inserirClassificadoFormulario">Classificados</a></li>
		            					
		            				</c:if>
		           						<li class="divider"></li>
		           						<li><a href="logout">Sair</a></li>
		          				</ul>
		          			</li>
		        		</ul>
	        		</c:if>
				</form> 
		
				<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			    	  <div class="modal-dialog">
							<div class="login-modal" >
								<jsp:include page="login/realizar_login_formulario.jsp"></jsp:include>
							</div>
				      </div>
				</div>
			</div>
		
</body>
</html>