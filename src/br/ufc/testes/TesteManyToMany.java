package br.ufc.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.model.*;

public class TesteManyToMany {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("jornal");
		EntityManager manager = factory.createEntityManager();
		
	  /*Papel p = new Papel();
		p.setNome("Nome do Papel");
		
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit(); */
		
		
		Usuario p = manager.find(Usuario.class, 1L);
		List<Papel> papeis = new ArrayList<Papel>();
		
		papeis.add(manager.find(Papel.class, 2L));
		papeis.add(manager.find(Papel.class, 3L));
		papeis.add(manager.find(Papel.class, 1L));
		p.setPapeis(papeis);
		
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit(); 
		
		manager.close();
		factory.close();
	}

}
