package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorGeral extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
			String URI = request.getRequestURI();
			if(URI.contains("listar") || URI.endsWith("LoginFormulario") || URI.endsWith("home") || URI.endsWith("Login")|| URI.endsWith("/") || URI.endsWith("home"))
				return true;		
			
			if(request.getSession().getAttribute("usuario_logado") != null)
				return true;
		/*	if(request.getSession().getAttribute("papelusuario") != null){
				if(request.getSession().getAttribute("papelusuario.papelId") == "1"){
					if(URI.contains("inserirClassificado") || URI.contains("inserirOferta") || URI.contains("inserirNoticia")){
						response.sendRedirect("realizarLoginFormulario");
						return false;
					}
					return true;
				}
				if(request.getSession().getAttribute("papelusuario.papelId") == "2"){
					if(URI.contains("inserirNoticia") || URI.contains("inserirOferta")){
						response.sendRedirect("realizarLoginFormulario");
						return false;
					}
				}
			}*/
			
			response.sendRedirect("realizarLoginFormulario");
			return false;
		}
	
}
