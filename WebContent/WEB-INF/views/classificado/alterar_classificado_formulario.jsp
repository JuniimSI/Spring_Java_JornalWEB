<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Altera Classificado</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>

</head>
<body>
	
	
	<c:if test="${papelusuario.papelId  != 1}">
			<script type="text/javascript">
				alert("Somente Editor pode Editar");
				location.href="home";
			</script>
	</c:if>
	<div class="container-fluid">
	 	<header class="row">
	        <jsp:include page="../header.jsp"></jsp:include>
	    </header>
		<div align="center" class="row">
			<div role="main" class="col-md-8">
			
				
				<h2 style="color: black;">Adicionando novo classificado</h2>
					<form role="form" action="inserirClassificado" method="post">
						<div class="form-group">
							<label style="color: black;">Titulo:</label>
							<input type="text" name="titulo" placeholder="Titulo" value="${classificado.titulo }" class="form-control input-md"/> 
						</div>
						<div class="form-group">
							<label style="color: black;">Texto:</label>
							<input type="text" name="texto" placeholder="Texto" value="${classificado.texto }" class="form-control input-md"/> 
							<form:errors path="classificado.texto" /> 
						</div>
							
						<div class="form-group">	
							<label style="color: black;">Telefone:</label>
							<input id="inputTelefone"  type="text" value="${classificado.telefone }" name="telefone" placeholder="(99)9999-9999	" class="form-control input-md" /> 
																		  
							<script type="text/javascript">
				        		jQuery(function($){
				       				$("#inputTelefone").mask("(99)9999-9999");
								});
				        	</script>
						</div>
						<div class="form-group">	
							<label style="color: black;">Preco:</label>
							<input type="text" name="preco" value="${classificado.preco }" placeholder="Preço" class="form-control input-md" />
						</div>
				
						<input type="hidden" name="melhorOferta" value="0"/> <br />		
						<input type="hidden" name="usuarioId" value="${usuario_logado.id}"/>
						
						<input type="reset" value="Limpar"/>
						<input type="submit" value="Enviar Cadastro"/>
					</form>
				</div>
				<aside class="slider" role="complementary" class="col-md-3	">
						<jsp:include page="../right.jsp"></jsp:include>
	       	</aside>
			</div>
		</div>
</body>
</html>