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

import br.ufc.dao.interfaces.ISecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private ISecaoDAO sDAO;
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secao/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(@Valid Secao c, BindingResult br, HttpSession session){
		
		if(br.hasFieldErrors("titulo"))
			return "secao/inserir_secao_formulario";
		this.sDAO.inserirSecao(c); 
		List<Secao> secoes = this.sDAO.getLista();
		session.setAttribute("secoes", secoes);
		return "redirect:inserirSecaoFormulario";
	}
	
	@RequestMapping("/apagarSecao")
	public String apagarSecao(Long id){
		this.sDAO.apagarSecao(id);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/listarSecao")
	public String listarSecao(Model model){
		List<Secao> secoes = this.sDAO.getLista();
		model.addAttribute("secoes", secoes);
		return "secao/listar_secao";
	}
	
	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long id, Model model){
		Secao secao = this.sDAO.recuperarSecao(id);
		model.addAttribute("secao", secao);
		return "secao/alterar_secao_formulario";
	}
	
	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao s, HttpSession session){
		this.sDAO.alterarSecao(s);
		List<Secao> secoes = this.sDAO.getLista();
		session.setAttribute("secoes", secoes);
		return "redirect:listarSecao";
	}
}
