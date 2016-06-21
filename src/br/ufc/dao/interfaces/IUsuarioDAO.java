package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO {
	
	public void inserirUsuario(Usuario Usuario);
	
	public void alterarUsuario(Usuario Usuario);
	
	public void apagarUsuario(Long id);
	
	public List<Usuario> getLista();
	
	public Usuario recuperarUsuario(Long id);
	
	public Usuario recuperarUsuario(String login);
	
	public boolean permissao(Long usuId, Long papId);
}
