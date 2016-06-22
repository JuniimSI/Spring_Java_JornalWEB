package br.ufc.testes;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.criptofy.Criptografia;
import br.ufc.dao.PapelUsuarioDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.PapelUsuario;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

public class testeGeral {
	

	public static void main(String[] args) {
		
		

		//UsuarioDAO uDAO = new UsuarioDAO();
		//SecaoDAO sDAO = new SecaoDAO();
/*		Usuario u = new Usuario();
		u.setEmail("email.com");
		u.setLogin("logins");
		u.setSenha("juno4848");
		u.setNome("Junior");
		//u.setId(12L);
		
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();*/

		//Usuario s = uDAO.recuperarUsuario(5L);
		
	/*	UsuarioDAO uDAO = new UsuarioDAO();
		Usuario u = new Usuario();
		u.setNome("Administrador");
		u.setLogin("admin");
		u.setSenha("admin");
		u.setEmail("admin@mail.br");
	*/
		Criptografia c = new Criptografia();
		System.out.println(c.criptografa("admin"));

		String n = "kkkkkkasdkkkkkkk";
		System.out.println(n.contains("asd"));
		
		PapelUsuario pu = new PapelUsuario();
		pu.setPapelId(1L);
		pu.setUsuarioId(2L);
		PapelUsuarioDAO puDAO = new PapelUsuarioDAO();
		puDAO.inserirPapelUsuario(pu);
		

		
		
	}
}
