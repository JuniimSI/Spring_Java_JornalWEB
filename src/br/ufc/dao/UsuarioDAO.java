package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.dao.interfaces.IUsuarioDAO;
import br.ufc.model.PapelUsuario;
import br.ufc.model.Usuario;;

@Repository
public class UsuarioDAO implements IUsuarioDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirUsuario(Usuario usuario){
		manager.persist(usuario);
	}
		
	public void alterarUsuario(Usuario usuario){
		manager.merge(usuario);
	}
		
	public List<Usuario> getLista(){
		return manager.createQuery("select u from USUARIO as u",Usuario.class).getResultList();
	}
		
	public Usuario recuperarUsuario(Long id){
		return manager.find(Usuario.class, id);
	}
	
	public Usuario recuperarUsuario(String login){
		String hql = "select U from USUARIO as U where U.login = :param_login";
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("param_login", login).getResultList();
		if(usuarios.size() != 0)
			return usuarios.get(0);
		return null;		
	}
	
	public boolean permissao(Long usuId, Long papId){
		String hql = "select u from PAPEL_USUARIO as u where u.usuarioId=:param_usu_id and u.papelId=:param_pap_id";
		Query query = manager.createQuery(hql);
		List<PapelUsuario> li = query.setParameter("param_usu_id", usuId).setParameter("param_pap_id", papId).getResultList();
		if(li.size() != 0)
			return true;
		return false;
	}
	
	public void apagarUsuario(Long id){
		Usuario ref = this.recuperarUsuario(id);
		if(ref!=null)
			manager.remove(ref);
	}
}
