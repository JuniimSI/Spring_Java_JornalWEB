package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Papel;

public interface IPapelDAO {
	
	public void inserirPapel(Papel Papel);
	
	public void alterarPapel(Papel Papel);
	
	public void apagarPapel(Long id);
	
	public List<Papel> getLista();
	
	public Papel recuperarPapel(Long id);
}
