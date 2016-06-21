package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.IClassificadoDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;

@Repository
public class ClassificadoDAO implements IClassificadoDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirClassificado(Classificado classificado){
		manager.persist(classificado);
	}
	
	public void alterarClassificado(Classificado classificado){
		manager.merge(classificado);
	}
	
	public List<Classificado> getLista(){
		return manager.createQuery("select c from CLASSIFICADO as c",Classificado.class).getResultList();		
	}
		
	public Classificado recuperarClassificado(Long id){
		return manager.find(Classificado.class, id);
	}
	
	public void apagarClassificado(Long id){
		Classificado ref = this.recuperarClassificado(id);
		if(ref!=null)
			manager.remove(ref);
	}
}
