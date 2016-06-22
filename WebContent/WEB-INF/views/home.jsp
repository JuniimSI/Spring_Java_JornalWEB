<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
<body>
    <div class="container-fluid">
	    <header id="index" class="row">
	        <jsp:include page="header.jsp"></jsp:include>
	    </header>
	    <div class="row">
	    	<aside id="index" role="complementary" class="col-md-2">
	    		<jsp:include page="left.jsp"></jsp:include>	    		
	    	</aside>
	    	
	        <div  role="main" class="col-md-7">		
				<jsp:include page="noticia/listar_noticia_by_date.jsp"></jsp:include>
	        </div>
	        
	        <aside class="slider" role="complementary" class="col-md-3	">
					<jsp:include page="right.jsp"></jsp:include>
	        </aside>
	    </div>
	    
	    <footer class="row" id="index">
	      <jsp:include page="footer.jsp"></jsp:include>
	    </footer>
	</div>
	
	

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>