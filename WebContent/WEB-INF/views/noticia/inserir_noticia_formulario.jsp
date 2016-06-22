<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<title>Inserir Noticia</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
	<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>

</head>
<body>
	
	<c:if test="${papelusuario.papelId  != 2 && papelusuario.papelId  != 1}">
			<script type="text/javascript">
				alert("Somente Jornalista pode inserir uma noticia, Logue como tal");
				location.href="realizarLoginFormulario";
			</script>
	</c:if>

	<div class="container-fluid">
	 	<header id="index" class="row">
	        <jsp:include page="../header.jsp"></jsp:include>
	    </header>
		<div align="center" class="row">
			<div role="main" class="col-md-10">
				<h2 style="color: white;">Adicionando nova noticia</h2>
				<form role="form" action="inserirNoticia" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<input type="hidden" name="secaoId" value="${secao.id}"/> 
						<input type="hidden" name="usuarioId" value="${usuario_logado.id }">
						<label style="color: white;">Titulo:</label>
						<input type="text" name="titulo" placeholder="Titulo" class="form-control input-md" />   
							<form:errors path="noticia.titulo" />  
					</div>
					<div class="form-group">
						<label style="color: white;">Subtitulo:</label>
						<input type="text" name="subtitulo" placeholder="Subtitulo" class="form-control input-md"/>
					</div>
					<div class="form-group">
						<label style="color: white;">Texto:</label>					 
					 	<textarea id="textoNoticia" rows="40" cols="130" name="texto" class="form-control input-md"></textarea>
					 	<script type="text/javascript">
					 		window.onload=function(){
					 			CKEDITOR.replace("textoNoticia");
					 		};
					 	</script>
					 	
					</div>
					<div class="form-group">
						<label style="color: white;">Selecionar imagem:</label>					 					
						<input type="file" name="imagemz" />
					</div>
					<input type="reset" value="Limpar"/>
					<input type="submit" value="Enviar Cadastro"/>
				</form>
			</div>
			<aside class="slider" role="complementary" class="col-md-1	">
					<div>
						<jsp:include page="../secao/listar_secao.jsp"></jsp:include>
					</div>
	       	</aside>
	    </div>
	    <footer class="row" id="index">
		    <jsp:include page="../footer.jsp"></jsp:include>
		</footer>
	    
	</div>
</body>
</html>