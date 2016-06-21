package br.ufc.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.criptofy.Criptografia;
import br.ufc.dao.interfaces.IClassificadoDAO;
import br.ufc.dao.interfaces.INoticiaDAO;
import br.ufc.dao.interfaces.ISecaoDAO;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.*;

@Controller
public class LoginController{
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private ISecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private IClassificadoDAO cDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private INoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="criptografia")
	private Criptografia crip;

	@RequestMapping("/realizarLoginFormulario")
	public String realizarLoginFormulario(){
		return "login/realizar_login_formulario";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Long usuarioID, Long papelID){
		Usuario u = new Usuario();
		PapelUsuario pu = new PapelUsuario();
		if(usuarioID == null || papelID == null){
			 u = new Usuario();
			pu = new PapelUsuario();
		}else{
			u = this.uDAO.recuperarUsuario(usuarioID);
			pu = new PapelUsuario();
			pu.setPapelId(papelID);
			pu.setUsuarioId(usuarioID);
		}
		
		List<Secao> secoes = this.sDAO.getLista();
		List<Classificado> classificados = this.cDAO.getLista();
		List<Noticia> noticias = this.nDAO.getListaOrderByDate();

		session.setAttribute("usuario_logado", u);
		session.setAttribute("papelusuario", pu);
		session.setAttribute("secoes", secoes);
		session.setAttribute("classificados", classificados);
		session.setAttribute("noticias", noticias);
		session.setAttribute("data", new Date());
		return "home";
	}
	
	@RequestMapping("/realizarLogin")
	public String realizarLogin(@Valid Usuario usuario, BindingResult br, HttpSession session,  Long papId, PapelUsuario pu){
		Usuario u = uDAO.recuperarUsuario(usuario.getLogin());
		if(u!=null){
			if(uDAO.permissao(u.getId(), papId)!=false){
				if(u.getSenha().equals(crip.criptografa(usuario.getSenha()))){
					
					pu.setPapelId(papId); 
					pu.setUsuarioId(u.getId());
					
					List<Secao> secoes = this.sDAO.getLista();
					List<Classificado> classificados = this.cDAO.getLista();
					List<Noticia> noticias = this.nDAO.getListaOrderByDate();

					session.setAttribute("usuario_logado", u);
					session.setAttribute("papelusuario", pu);
					session.setAttribute("secoes", secoes);
					session.setAttribute("classificados", classificados);
					session.setAttribute("noticias", noticias);
					session.setAttribute("data", new Date());
					
					return "home";
				}
			}
		}
		return "redirect:realizarLoginFormulario";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:realizarLoginFormulario";
	}
}