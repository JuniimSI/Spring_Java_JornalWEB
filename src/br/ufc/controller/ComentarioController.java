package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.interfaces.IComentarioDAO;
import br.ufc.dao.interfaces.INoticiaDAO;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

@Transactional
@Controller
public class ComentarioController {

	@Autowired
	@Qualifier(value="comentarioDAO")
	private IComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private INoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(HttpSession session, Long notId){
		Noticia n = nDAO.recuperarNoticia(notId);
		session.setAttribute("noticia", n);
		return "comentario/inserir_comentario_formulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(@Valid Comentario c, BindingResult br, HttpSession session){

		if(br.hasFieldErrors("texto"))
			return "comentario/inserir_comentario_formulario";
		
		c.setNoticia(nDAO.recuperarNoticia(c.getNoticiaId()));
		c.setUsuario(uDAO.recuperarUsuario(c.getUsuarioId()));
		session.setAttribute("noticias", nDAO.getListaOrderByDate());
		this.cDAO.inserirComentario(c);
		
		List<Noticia> noticias = this.nDAO.getListaOrderByDate();
		session.setAttribute("noticias", noticias);
		
		return "home";
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id){
		this.cDAO.apagarComentario(id);
		return "home";
	}
	
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model){
		List<Comentario> comentarios = this.cDAO.getLista();
		model.addAttribute("comentarios", comentarios);
		return "comentario/listar_comentario";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		Comentario comentario = this.cDAO.recuperarComentario(id);
		model.addAttribute("comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario c){
		this.cDAO.alterarComentario(c);
		return "redirect:listarComentario";
	}
}
