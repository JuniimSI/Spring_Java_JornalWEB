package br.ufc.controller;

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
import br.ufc.dao.PapelUsuarioDAO;
import br.ufc.dao.interfaces.IPapelUsuario;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.PapelUsuario;
import br.ufc.model.Usuario;
import br.ufc.util.JornalFileUtil;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="criptografia")
	private Criptografia crip;
	
	@Autowired
	@Qualifier(value="papelUsuarioDAO")
	private IPapelUsuario puDAO;
	
	@Autowired
	@Qualifier(value="papelUsuarioDAO")
	private IPapelUsuario puDAO2;

	@Autowired
	private ServletContext servletContext;
		
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(HttpSession session){

		List<Usuario> usuarios = this.uDAO.getLista();
		session.setAttribute("usuarios", usuarios);
		
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(HttpSession session, @Valid Usuario u, BindingResult br, PapelUsuario pu, @RequestParam(value="imagem", required=false) MultipartFile imagem){
		if(br.hasFieldErrors("nome"))
			return "usuario/inserir_usuario_formulario";
		
		String image = u.getNome() + u.getLogin();
		String path = servletContext.getRealPath("/")+"resources/images/"+image+".png";
		u.setImagem(image);
		JornalFileUtil.salvarImagem(path, imagem);
		
		String senhaCrip = crip.criptografa(u.getSenha());
		u.setSenha(senhaCrip);
		
		this.uDAO.inserirUsuario(u);
		
		pu.setUsuarioId(u.getId());
		this.puDAO.inserirPapelUsuario(pu);

		List<Usuario> usuarios = this.uDAO.getLista();
		session.setAttribute("usuarios", usuarios);
		
		return "redirect:inserirUsuarioFormulario";
	}
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id, HttpSession session){
		this.uDAO.apagarUsuario(id);
		
		List<Usuario> usuarios = this.uDAO.getLista();
		session.setAttribute("usuarios", usuarios);
		
		return "redirect:inserirUsuarioFormulario";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = this.uDAO.getLista();
		model.addAttribute("usuarios", usuarios);
		return "usuario/listar_usuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		Usuario u = this.uDAO.recuperarUsuario(id);
		model.addAttribute("usuario", u);
		return "usuario/alterar_usuario_formulario";
	}
	
	/*@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario u, HttpSession session){
		Usuario a = uDAO.recuperarUsuario(u.getId());
		u.setImagem(a.getImagem());
		
		
		this.uDAO.alterarUsuario(u);
		

		List<Usuario> usuarios = this.uDAO.getLista();
		session.setAttribute("usuarios", usuarios);	
		return "home";
	}*/
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario u, HttpSession session, Long papelIdz){
		Usuario a = uDAO.recuperarUsuario(u.getId());
		u.setImagem(a.getImagem());
		u.setSenha(a.getSenha());
		
		this.uDAO.alterarUsuario(u);
		
		PapelUsuario pu = new PapelUsuario();
		
		pu.setPapelId(papelIdz);
		pu.setUsuarioId(u.getId());
		System.out.println(papelIdz + " " + u.getId());
		this.puDAO2.alterarPapelUsuario(pu);

		List<Usuario> usuarios = this.uDAO.getLista();
		session.setAttribute("usuarios", usuarios);	
		return "home";
	}
	
}
