<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">

    <!--[if lt IE 9]>	
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body >
	 <div  class="container-fluid">
		<header id="index">
			<h1 class="pisca">Bem Vindo ao Info Jornal WEB</h1>
			<a class="btn btn-primary" href="realizarLoginFormulario" data-toggle="modal" data-target="#login-modal" >Login</a>
			<a class="btn btn-primary" href="inserirUsuarioFormulario"> Cadastrar-se</a>
			<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			    	  <div class="modal-dialog">
							<div class="login-modal" >
								<jsp:include page="WEB-INF/views/login/realizar_login_formulario.jsp"></jsp:include>
							</div>
				      </div>
				</div>
		</header>
		<div class="row">
			<div role="main">
				<div class="carousel slide" id="carousel-468008">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-468008" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-468008">
					</li>
					<li data-slide-to="2" data-target="#carousel-468008" >
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img width="700" height="700" alt="Noticias para todos os gostos" src="resources/images/tec.jpg" />
						<div class="carousel-caption">
							<h4>
								Tecnologia
							</h4>
							<p>
								Tudo sobre as novidades tecnológicas.
							</p>
						</div>
					</div>
					<div class="item">
						<img width="700" height="700" alt="Carousel Bootstrap Second" src="resources/images/class.jpg" />
						<div class="carousel-caption">
							<h4>
								Classificados
							</h4>
							<p>
								Que tal publicar algo que não te interessa mais? Algo que está ocupando espaço?
								Ou você está precisando de grana e não quer sair de casa?
								Veja nossos classificados.
							</p>
						</div>
					</div>
					<div class="item active">
						<img width="700" height="700" alt="Carousel Bootstrap Third" src="resources/images/dna.jpg" />
						<div class="carousel-caption">
							<h4>
								Tudo aqui no jornal Web
							</h4>
							<p>
								Noticias sobre ciências biológicas atualizadas.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-468008" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-468008" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
				<div  >
					<br/>
					<a class="btn btn-primary" href="home">Seguir para o Site</a> <br/> <br/>
					
				</div>	
			</div>
		</div>
	</div> 
	
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>