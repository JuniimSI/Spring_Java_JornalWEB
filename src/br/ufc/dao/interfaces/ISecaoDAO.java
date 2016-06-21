package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {
	
	public void inserirSecao(Secao Secao);
	
	public void alterarSecao(Secao Secao);
	
	public void apagarSecao(Long id);
	
	public List<Secao> getLista();
	
	public Secao recuperarSecao(Long id);
}
