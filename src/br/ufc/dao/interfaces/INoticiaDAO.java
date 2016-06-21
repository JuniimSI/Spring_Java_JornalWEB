package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Noticia;

public interface INoticiaDAO {
	
	public void inserirNoticia(Noticia Noticia);
	
	public void alterarNoticia(Noticia Noticia);
	
	public void apagarNoticia(Long id);
	
	public List<Noticia> getLista(Long secID);
	
	public List<Noticia> getListaOrderByDate();
	
	public Noticia recuperarNoticia(Long id);
}
