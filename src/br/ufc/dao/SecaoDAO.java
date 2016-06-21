package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.ISecaoDAO;
import br.ufc.model.Secao;

@Repository
public class SecaoDAO implements ISecaoDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirSecao(Secao secao){
		manager.persist(secao);
	}
	
	public void alterarSecao(Secao secao){
		manager.merge(secao);
	}
	
	public List<Secao> getLista(){
		return manager.createQuery("select s from SECAO as s",Secao.class).getResultList();
	}
		
	public Secao recuperarSecao(Long id){
		return manager.find(Secao.class, id);
	}
	
	public void apagarSecao(Long id){
		Secao ref = this.recuperarSecao(id);
		if(ref!=null)
			manager.remove(ref);
	}
}
