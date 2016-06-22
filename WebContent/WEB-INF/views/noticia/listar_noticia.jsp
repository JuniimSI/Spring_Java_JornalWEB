<%@page import="org.apache.taglibs.standard.tag.common.xml.IfTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>Lista de noticias</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 
    <title>Home</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>

	
</head>
<body>
	<div class="container-fluid">
		<header id="index" class="row">
	         <jsp:include page="../header.jsp"></jsp:include>  
	    </header>
		<div class="row">
			
	    	<aside id="index"  role="complementary" class="col-md-1">
	    		<jsp:include page="../left.jsp"></jsp:include>	    		
	    	</aside>
	    	
			 <div role="main" class="col-md-8">
			 	<c:if test="${papelusuario.papelId==1 || papelusuario.papelId==2}">
					<a class="btn btn-primary" href="inserirNoticiaFormulario">Inserir Nova Noticia</a>
				</c:if>	
			 				
				<c:forEach var="n" items="${noticias}"> 
					<c:if test="${n.ativo == true }">
						<div class="panel panel-primary">
							<div align="center"  class="panel-body">
								
															
								<img align="left" width="300" height="200" alt="${n.titulo}" src="<c:url value="/resources/images/${n.imagem}.png" />" />
								<div align="left">
									<h2 style="color: black;">${n.secao.titulo}</h2>
									<h2 style="color: black;">${n.titulo}</h2>
									<h3 style="color: black;">${n.subtitulo }</h3>
									${n.data }  -- 
									${n.usuario.nome} <br/><br/>
								</div>	
								<div align="right">
									<c:if test="${papelusuario.papelId  == 1 || (papelusuario.papelId  == 2 && n.usuario.id == usuario_logado.id)}"> 
										<a class="btn btn-danger" href="apagarNoticia?id=${n.id}">Apagar</a> 
									</c:if>
									<c:if test="${papelusuario.papelId  == 1}">
										<a class="btn" href="alterarNoticiaFormulario?id=${n.id}">Editar</a> 
									</c:if>
								</div>
								
								</div> <!-- body panel -->
								<div class="panel-footer">
									<div id="textoNot" >
										${n.texto }
									</div>
									
										<script type="text/javascript">
												$("#comentarios").css("display", "none");
												$("#esconderComentarios").css("display", "none");
										</script>
										<script type="text/javascript">
											$(document).ready(function(){
												
												$("#exibeComentarios").click(function(){
													$("#comentarios").css("display", "block"); 
													$("#esconderComentarios").css("display", "block");
												});
												$("#esconderComentarios").click(function(){
													$("#comentarios").css("display", "none"); 
									   				$("#esconderComentarios").css("display", "none");
									  			});
											}); 
									</script>
									<button id="exibeComentarios"> Comentarios </button>
								
									
									<div align="left" id="comentarios" class="list-group">
										<c:forEach var="c" items="${n.comentarios}">	
											<p style="color: black;" class="panel-footer" align="left" class="list-group-item-text">${c.usuario.nome }: --> ${c.texto }</p>
										</c:forEach>
										<c:if test="${papelusuario.papelId == 3}">
											<form action="inserirComentario" method="post">
												<input placeholder="comentario" type="text" name="texto" /> 
												<input type="hidden" name="noticiaId" value="${n.id}"/>  
												<input type="hidden" name="usuarioId" value="${usuario_logado.id}" />
												<input class="btn btn-default" type="submit" value="Comentar"/>
											</form>
										</c:if>
									</div>
							    </div>
						</div>
					</c:if>
				</c:forEach>
				
					
			</div>

			<aside class="slider" role="complementary" class="col-md-3	">
					<jsp:include page="../right.jsp"></jsp:include>
	       	</aside>
		</div>
		<footer class="row" id="index">
		      <jsp:include page="../footer.jsp"></jsp:include>
		</footer>
		
	</div>
	
		
	
</body>
</html>