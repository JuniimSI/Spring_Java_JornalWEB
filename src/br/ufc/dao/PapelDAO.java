package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.IPapelDAO;
import br.ufc.model.Papel;

@Repository
public class PapelDAO implements IPapelDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirPapel(Papel papel){
		manager.persist(papel);
	}
	
	public void alterarPapel(Papel papel){
		manager.merge(papel);
	}
		
	public List<Papel> getLista(){
		return manager.createQuery("select p from PAPEL as p",Papel.class).getResultList();
	}
	
	public Papel recuperarPapel(Long id){
		return manager.find(Papel.class, id);
	}

	public void apagarPapel(Long id) {
		Papel ref = this.recuperarPapel(id);
		if(ref!=null)
			manager.remove(ref);
	}
}
