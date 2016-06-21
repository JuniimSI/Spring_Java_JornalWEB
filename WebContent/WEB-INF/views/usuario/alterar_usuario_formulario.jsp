<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterando Usuario</title>
</head>
<body>

	
	
	<div class="container-fluid">
	 	<header class="row">
	        <jsp:include page="../header.jsp"></jsp:include>
	    </header>
		<div align="center" class="row">
			<div role="main" class="col-md-8">
				
				<h2 style="color: black;">Alterando usuario</h2>
				<form role="form" action="alterarUsuario" method="post" enctype="multipart/form-data">
					<div class="form-group">
					<input type="hidden" name="id" value="${usuario.id }"/>
					<input type="hidden" name="senha" value="${usuario.senha }"/>
					
			
						<label style="color: black;">Nome:</label>
						 <input type="text" value="${usuario.nome }" name="nome" placeholder="Nome" class="form-control input-md" />
						 <form:errors path="usuario.nome" />   
						 
					</div>   
					<div class="form-group">
						<label style="color: black;">Login:</label>
						<input type="text" value="${usuario.login }" name="login" placeholder="Seu login" class="form-control input-md"/> 
					</div>
					
					<div class="form-group" >
						<label style="color: black;">Email:</label>
						<input type="text" value="${usuario.email }" name="email" placeholder="client@servidor.dom" class="form-control input-md"/>
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
	</div>	
	

</body>
</html>