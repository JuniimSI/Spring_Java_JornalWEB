<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<title>Inserir Usuario</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	<c:if test="${papelusuario.papelId == 2 }">
		<script type="text/javascript">
				alert("Somente Editor e leitor podem Inserir um novo usuario, Logue como tal@");
				location.href="realizarLoginFormulario";
		</script>
	</c:if>
	
	<c:if test="${papelusuario.papelId== 3 || papelusuario.papelId == null}">
		<div class="container-fluid">
		 	<header id="index" class="row">
		        <jsp:include page="../header.jsp"></jsp:include>
		    </header>
			<div align="center" class="row">
				<div role="main" class="col-md-8">
					
					<h2 style="color: white;">Adicionando novo usuario</h2>
					<form role="form" action="inserirUsuario" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label style="color: white;">Nome:</label>
							 <input type="text" name="nome" placeholder="Nome" class="form-control input-md" />
							 <form:errors path="usuario.nome" />   
							 
						</div>   
						<div class="form-group">
							<label style="color: white;">Login:</label>
							<input type="text" name="login" placeholder="Seu login" class="form-control input-md"/> 
						</div>
						<div class="form-group">
							<label style="color: white;">Senha:</label>
							<input type="text" name="senha" placeholder="Sua senha" class="form-control input-md"/>
						</div>
						<div class="form-group" >
							<label style="color: white;">Email:</label>
							<input type="text" name="email" placeholder="client@servidor.dom" class="form-control input-md"/>
						</div>
						<div class="form-group">
							<label style="color: black;">Escolha uma opção:</label>
										<select id="papID" name="papelId" class="select" >
					                    <option id="leitor" value="3">Leitor</option>               
					      	</select>	
					    </div>
				      	
				      	<div id="imagem" class="form-group">
				      		<label style="color: black;">Selecione:</label>
				      		<div align="center">
				      			<input  type="file" name="imagem" /> <br/>
				      		</div>
					      	<script type="text/javascript">
					      		$("#imagem").css("display", "none");
						      	$(document).ready(function(){
						      		$("#jornalista").click(function(){
						   				$("#imagem").css("display", "block"); 
						   			});
						      		$("#leitor").click(function(){
						   				$("#imagem").css("display", "none"); 
						   			});
						      		$("#editor").click(function(){
						   				$("#imagem").css("display", "none"); 
						   			});
								}); 
						    </script>
				      	</div>	
						
						<input type="reset" value="Limpar"/>
						<input type="submit" value="Cadastrar"/>
						
					</form>
				</div>
				<aside class="slider" role="complementary" class="col-md-3	">
						<div>
							<jsp:include page="listar_usuario.jsp"></jsp:include>
						</div>
		       	</aside>
				
			</div>
			<footer class="row" id="index">
		      <jsp:include page="../footer.jsp"></jsp:include>
		    </footer>
		</div>
	</c:if>
	
	<c:if test="${papelusuario.papelId  == 1}">
		<div class="container-fluid">
		 	<header id="index" class="row">
		        <jsp:include page="../header.jsp"></jsp:include>
		    </header>
			<div align="center" class="row">
				<div role="main" class="col-md-8">
					
					<h2 style="color: white;">Adicionando novo usuario</h2>
					<form role="form" action="inserirUsuario" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label style="color: white;">Nome:</label>
							 <input type="text" name="nome" placeholder="Nome" class="form-control input-md" />
							 <form:errors path="usuario.nome" />   
							 
						</div>   
						<div class="form-group">
							<label style="color: white;">Login:</label>
							<input type="text" name="login" placeholder="Seu login" class="form-control input-md"/> 
						</div>
						<div class="form-group">
							<label style="color: white;">Senha:</label>
							<input type="password" name="senha" placeholder="Sua senha" class="form-control input-md"/>
						</div>
						<div class="form-group" >
							<label style="color: white;">Email:</label>
							<input type="text" name="email" placeholder="client@servidor.dom" class="form-control input-md"/>
						</div>
						<div class="form-group">
							<label style="color: black;">Escolha uma opção:</label>
										<select id="papID" name="papelId" class="select" >
					                    <option id="editor" value="1">Editor</option>
					                    <option id="jornalista" value="2">Jornalista</option>
					                    <option id="leitor" value="3">Leitor</option>               
					      	</select>	
					    </div>
				      	
				      	<div id="imagem" class="form-group">
				      		<label style="color: black;">Selecione:</label>
				      		<div align="center">
				      			<input  type="file" name="imagem" /> <br/>
				      		</div>
					      	<script type="text/javascript">
					      		$("#imagem").css("display", "none");
						      	$(document).ready(function(){
						      		$("#jornalista").click(function(){
						   				$("#imagem").css("display", "block"); 
						   			});
						      		$("#leitor").click(function(){
						   				$("#imagem").css("display", "none"); 
						   			});
						      		$("#editor").click(function(){
						   				$("#imagem").css("display", "none"); 
						   			});
								}); 
						    </script>
				      	</div>	
						
						<input type="reset" value="Limpar"/>
						<input type="submit" value="Cadastrar"/>
						
					</form>
				</div>
				<aside class="slider" role="complementary" class="col-md-3	">
						<div>
							<jsp:include page="listar_usuario.jsp"></jsp:include>
						</div>
		       	</aside>
				
			</div>
			<footer class="row" id="index">
		      <jsp:include page="../footer.jsp"></jsp:include>
		    </footer>
			
		</div>	
	</c:if>	
</body>
</html>