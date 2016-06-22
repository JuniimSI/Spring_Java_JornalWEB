<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Inserir Classificado</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	 	<header id="index"  class="row">
	        <jsp:include page="../header.jsp"></jsp:include>
	    </header>
		<div align="center" class="row">
			<div role="main" class="col-md-8">
				
				<h2 style="color: white;">Adicionando novo classificado</h2>
					<form role="form" action="inserirClassificado" method="post">
						<div class="form-group">
							<label style="color: white;">Titulo:</label>
							<input type="text" name="titulo" placeholder="Titulo" class="form-control input-md"/> 
						</div>
						<div class="form-group">
							<label style="color: white;">Texto:</label>
							<input type="text" name="texto" placeholder="Texto" class="form-control input-md"/> 
							<form:errors path="classificado.texto" /> 
						</div>
							
						<div class="form-group">	
							<label style="color: white;">Telefone:</label>
							<input id="inputTelefone"  type="text" name="telefone" placeholder="(99)9999-9999	" class="form-control input-md" /> 
																		  
							<script type="text/javascript">
				        		jQuery(function($){
				       				$("#inputTelefone").mask("(99)9999-9999");
								});
				        	</script>
						</div>
						<div class="form-group">	
							<label style="color: white;">Preco:</label>
							<input type="text" name="preco" placeholder="Preço" class="form-control input-md" />
						</div>
				
						<input type="hidden" name="melhorOferta" value="0"/> <br />		
						<input type="hidden" name="usuarioId" value="${usuario_logado.id }"/>
						
						<input type="reset" value="Limpar"/>
						<input type="submit" value="Enviar Cadastro"/>
					</form>
				</div>
				<aside id="index" class="slider" role="complementary" class="col-md-3	">
						<jsp:include page="../right.jsp"></jsp:include>
	       	</aside>
			</div>
			<footer class="row" id="index">
		      <jsp:include page="../footer.jsp"></jsp:include>
		    </footer>
			
		</div>
	
</body>
</html>