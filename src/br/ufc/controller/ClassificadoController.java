package br.ufc.controller;

import java.util.Date;
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

import br.ufc.dao.interfaces.IClassificadoDAO;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private IClassificadoDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	private Date data;

	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirCLassificado(@Valid Classificado c, BindingResult br, HttpSession session){
		
		if(br.hasFieldErrors("texto"))
			return "classificado/inserir_classificado_formulario";

		Usuario u = uDAO.recuperarUsuario(c.getUsuarioId());
		c.setUsuario(u);
		
		data = new Date();
		c.setDataOferta(data);
		this.cDAO.inserirClassificado(c);
		List<Classificado> classificados = this.cDAO.getLista();
		session.setAttribute("classificados", classificados);
		return "home";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
		
		List<Classificado> classificados = this.cDAO.getLista();
		model.addAttribute("classificados", classificados);
		
		return "classificado/listar_classificado";
	}
	
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id, HttpSession session){
			this.cDAO.apagarClassificado(id);
			List<Classificado> classificados = this.cDAO.getLista();
			session.setAttribute("classificados", classificados);
		return "home";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long id, Model model){
		Classificado classificado = this.cDAO.recuperarClassificado(id);
		model.addAttribute("classificado", classificado);
		return "classificado/alterar_classificado_formulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado c, HttpSession session){
		c.setUsuario(uDAO.recuperarUsuario(c.getUsuarioId()));
		c.setDataOferta(new Date());
		this.cDAO.alterarClassificado(c);
		List<Classificado> classificados = this.cDAO.getLista();
		session.setAttribute("classificados", classificados);
		return "home";
	}
	
	
	@RequestMapping("/inserirOfertaFormulario")
	public String inserirOfertaFormulario(Long id, Model model){
		Classificado c = cDAO.recuperarClassificado(id);
		model.addAttribute("classificado",c);
		
		
		return "classificado/inserir_oferta_formulario";
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Classificado c, HttpSession session){
		Classificado ac = cDAO.recuperarClassificado(c.getId());
		if(ac.getMelhorOferta() < c.getMelhorOferta() && c.getMelhorOferta() > ac.getPreco()){
			c.setUsuario(uDAO.recuperarUsuario(c.getUsuarioId()));
			
			data = new Date();
			c.setDataOferta(data);
			this.cDAO.alterarClassificado(c);
			List<Classificado> classificados = this.cDAO.getLista();
			session.setAttribute("classificados", classificados);
		}
		return "home";
	}

	
	
}
