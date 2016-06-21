package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.INoticiaDAO;
import br.ufc.model.Noticia;

@Repository
public class NoticiaDAO implements INoticiaDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirNoticia(Noticia noticia){
		manager.persist(noticia);
	}
	
	public void alterarNoticia(Noticia noticia){
		manager.merge(noticia);
	}
	
	public List<Noticia> getLista(Long secID){
		String hql = "select n from NOTICIA as n where n.secaoId = :param_sec_id ";
		Query query = manager.createQuery(hql);
		return query.setParameter("param_sec_id", secID).getResultList();
	}
	
	public List<Noticia> getListaOrderByDate(){
		String hql = "select n from NOTICIA as n order by n.data desc";
		List<Noticia> ntcs = manager.createQuery(hql).getResultList();
		return	ntcs;
		
	}
	
	public Noticia recuperarNoticia(Long id){
		return manager.find(Noticia.class, id);
	}
	
	public void apagarNoticia(Long id){
		Noticia ref = this.recuperarNoticia(id);
		if(ref!=null)
			manager.remove(ref);
	}
	
}
