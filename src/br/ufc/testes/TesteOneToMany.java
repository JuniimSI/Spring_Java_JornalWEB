package br.ufc.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.model.*;

public class TesteOneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("jornal");
		EntityManager manager = factory.createEntityManager();
		
		/*
		Secao c = new Secao();
		c.setDescricao("Descricao da seção 1");
		c.setTitulo("Titulo da seção 1");
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		
		Secao c = manager.find(Secao.class, 1L);
		Noticia n = new Noticia();
		n.setData("11/05/2016");
		n.setSubtitulo("Subtitulo da Noticia");
		n.setTitulo("Titulo da Noticia");
		n.setTexto("Texto da Noticia");
		n.setSecao(c);
		
		manager.getTransaction().begin();
		manager.persist(n);
		manager.getTransaction().commit();
			
		Secao c = manager.find(Secao.class, 1L);
		List<Noticia> noticias = c.getNoticias();
		
		for(Noticia n: noticias){
			System.out.println(n.getTitulo() + " - " + n.getTexto());
		}
		
		Usuario u = new Usuario();
		u.setEmail("Email do Usuario");
		u.setLogin("Login do Usuario");
		u.setSenha("Senha do Usuario");
		u.setNome("Nome do Usuario");
				
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();
		
		Usuario u = manager.find(Usuario.class, 1L);
		Comentario c = new Comentario();
		c.setTexto("Texto do Comentario");
		c.setUsuario(u);
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		
		
		Usuario p = manager.find(Usuario.class, 1L);
		List<Papel> p2 = p.getPapeis();
		for(Papel q: p2)
			System.out.println(q.getNome());
		}
		
		Usuario u = manager.find(Usuario.class, 1L);
		
		Secao sc = manager.find(Secao.class, 2L);
		System.out.println(sc.getTitulo());
	
		
		Noticia c = new Noticia();
		c.setData("11//11/11");
		c.setSubtitulo("subtitulo da noticia3");
		c.setTexto("texto da noticia3");
		c.setTitulo("titulo da nticia3");
		c.setSecao(sc);
		c.setUsuario(u);
		
		List<Noticia>noticias = new ArrayList<Noticia>();
		noticias.add(c);
		u.setNoticias(noticias);
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();*/
		
		
		Usuario u = manager.find(Usuario.class, 1L);
		List<Noticia> n = u.getNoticias();
		
		System.out.println(u.getNoticias().size());
		
		for(Noticia c:n){
			System.out.println(c.getTitulo());
		}
		
		manager.close();
		factory.close();
	}

}
