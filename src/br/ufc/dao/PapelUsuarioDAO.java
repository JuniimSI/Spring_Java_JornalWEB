package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.IPapelUsuario;
import br.ufc.model.PapelUsuario;

@Repository
public class PapelUsuarioDAO implements IPapelUsuario{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserirPapelUsuario(PapelUsuario pu) {
		manager.persist(pu);
	}

	@Override
	public void alterarPapelUsuario(PapelUsuario pu) {
		manager.merge(pu);
	}

	@Override
	public void apagarPapelUsuario(Long id) {
		PapelUsuario pu = this.recuperarPapelUsuario(id);
		if(pu!=null)
			manager.remove(pu);
	}

	@Override
	public List<PapelUsuario> getLista() {
		return manager.createQuery("select p from PAPEL_USUARIO as p",PapelUsuario.class).getResultList();
	}

	@Override
	public PapelUsuario recuperarPapelUsuario(Long id) {
		return manager.find(PapelUsuario.class, id);
	}

}
