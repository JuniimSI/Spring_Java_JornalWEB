package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	
	public void inserirClassificado(Classificado classificado);
	
	public void alterarClassificado(Classificado classificado);
	
	public void apagarClassificado(Long id);
	
	public List<Classificado> getLista();
	
	
	public Classificado recuperarClassificado(Long id);
}
