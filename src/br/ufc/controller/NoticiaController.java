package br.ufc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.criptofy.Criptografia;
import br.ufc.dao.interfaces.INoticiaDAO;
import br.ufc.dao.interfaces.ISecaoDAO;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.util.JornalFileUtil;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	@Qualifier(value="noticiaDAO")
	private INoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private ISecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="criptografia")
	private Criptografia crip;
	
	@Autowired
	private ServletContext servletContext;
	
	
	private Date data;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(){
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia n, BindingResult br, 
								 @RequestParam(value="imagemz", required=false) MultipartFile imagem, HttpSession session){
		if(br.hasFieldErrors("titulo") || br.hasFieldErrors("texto"))
			return "noticia/inserir_noticia_formulario";
		
		data = new Date();
		String image = data.toString();
		
		String path = servletContext.getRealPath("/")+"resources/images/"+image+".png";
		JornalFileUtil.salvarImagem(path, imagem);
		
		n.setImagem(image);
		n.setData(data);
		n.setSecao(sDAO.recuperarSecao(n.getSecaoId()));
		n.setUsuario(uDAO.recuperarUsuario(n.getUsuarioId()));
		n.setAtivo(true);	
		this.nDAO.inserirNoticia(n);
		
		List<Noticia> noticias = this.nDAO.getListaOrderByDate();
		session.setAttribute("noticias", noticias);
		
		return "home";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id, HttpSession session){
		
		Noticia n = this.nDAO.recuperarNoticia(id);
		n.setAtivo(false);
		
		List<Noticia> noticias = this.nDAO.getListaOrderByDate();
		session.setAttribute("noticias", noticias);
		
		return "home";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model, Long secID, HttpSession session){
		Secao secao = sDAO.recuperarSecao(secID);
		List<Noticia> noticias = this.nDAO.getLista(secID);
		
		session.setAttribute("secao", secao);
		model.addAttribute("noticias", noticias);
		
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/listarNoticiaPelaData")
	public String listarNoticiaPelaData(Model model){
		List<Noticia> noticias = nDAO.getListaOrderByDate();
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id,Model model){

		Noticia noticia = this.nDAO.recuperarNoticia(id);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia n, HttpSession session) {
		Noticia ref = nDAO.recuperarNoticia(n.getId());
		n.setImagem(ref.getImagem());
		n.setSecao(sDAO.recuperarSecao(n.getSecaoId()));
		n.setUsuario(uDAO.recuperarUsuario(n.getUsuarioId()));
		n.setData(nDAO.recuperarNoticia(n.getId()).getData());
		n.setAtivo(true);
		
		this.nDAO.alterarNoticia(n);

		List<Noticia> noticias = this.nDAO.getListaOrderByDate();
		session.setAttribute("noticias", noticias);
		
		return "home";
	}
	
}
