package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO {
	
	public void inserirComentario(Comentario comentario);
	
	public void alterarComentario(Comentario comentario);
	
	public void apagarComentario(Long id);
	
	public List<Comentario> getLista();
	
	public Comentario recuperarComentario(Long id);
}
