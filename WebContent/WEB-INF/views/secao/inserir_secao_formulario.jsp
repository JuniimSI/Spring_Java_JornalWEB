<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Inserir Secao</title>
</head>
<body>
	<c:if test="${papelusuario.papelId  != 1 }">
			<script type="text/javascript">
				alert("Somente Editor  pode Inserir Seção, Logue como tal@");
				location.href="realizarLoginFormulario";
			</script>
	</c:if>
	

	<div class="container-fluid">
	 	<header id="index" class="row">
	        <jsp:include page="../header.jsp"></jsp:include>
	    </header>
		<div align="center" class="row">
			<div role="main" class="col-md-8">				
				<h2 style="color: white;">Adicionando nova seção</h2>
				<form role="form" action="inserirSecao" method="post">
					<div class="form-group">
						<label style="color: white;">Titulo:</label>
						<input type="text" name="titulo" placeholder="Titulo" class="form-control input-md"/>
							<form:errors path="secao.titulo" />
					</div>
					<div class="form-group">
						<label style="color: white;">Descrição:</label>
						<input type="text" name="descricao"  placeholder="Descrição" class="form-control input-md" />
					</div>
					
					<input type="reset" value="Limpar" />
					<input type="submit" value="Enviar Cadastro" />
			
				</form>
			</div>
			<aside class="slider" role="complementary" class="col-md-3	">
				<div>
					<jsp:include page="listar_secao.jsp"></jsp:include>
				</div>
	       	</aside>
	    </div>
	    <footer class="row" id="index">
		     <jsp:include page="../footer.jsp"></jsp:include>
		</footer>
	    
	 </div>
	
</body>
</html>