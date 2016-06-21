package br.ufc.dao.interfaces;

import java.util.List;

import br.ufc.model.PapelUsuario;


public interface IPapelUsuario {
	
	public void inserirPapelUsuario(PapelUsuario pu);
	
	public void alterarPapelUsuario(PapelUsuario pu);
	
	public void apagarPapelUsuario(Long id);
	
	public List<PapelUsuario> getLista();
	
	public PapelUsuario recuperarPapelUsuario(Long id);
}
