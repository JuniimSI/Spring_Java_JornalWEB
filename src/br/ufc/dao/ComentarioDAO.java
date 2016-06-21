package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.IComentarioDAO;
import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO implements IComentarioDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirComentario(Comentario comentario){
		manager.persist(comentario);
	}
	
	public void alterarComentario(Comentario comentario){
		manager.merge(comentario);	
	}
		
	public List<Comentario> getLista(){
		return manager.createQuery("select c from COMENTARIO as c",Comentario.class).getResultList();
	}
	
	public Comentario recuperarComentario(Long id){
		return manager.find(Comentario.class, id);
	}
	
	public void apagarComentario(Long id){
		Comentario ref = this.recuperarComentario(id);
		if(ref!=null) 
			manager.remove(ref);
	}
}
