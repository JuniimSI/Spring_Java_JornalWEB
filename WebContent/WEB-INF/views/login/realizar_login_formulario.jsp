<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
	
	<title>Realizar Login</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/estilos.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maskedinput.min.js"></script>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
</head>
<body style="background-image: url(../images/fundo.png)">
	

    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">Login to Jornal Web</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-12">
                      <div class="well">
                          <form id="loginForm" method="POST" action="realizarLogin" novalidate="novalidate">
                              <div class="form-group">
                                  <label for="login" class="control-label">Username</label>
                                  <input type="text" class="form-control" id="login" name="login" value="" required="" title="Please enter you username" placeholder="Login">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="senha" class="control-label">Password</label>
                                  <input type="password" class="form-control" placeholder="Senha" id="senha" name="senha" value="" required="" title="Please enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <select name="papId" class="select" >
					                    <option value="1">Editor</option>
					                    <option value="2">Jornalista</option>
					                    <option value="3">Leitor</option>               
					      	  </select>	
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username og password</div>
                              
                              <button type="submit" class="btn btn-primary btn-block">Login</button>
                             
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div> 
	
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
</body>
</html>