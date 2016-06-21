package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="PAPEL")
public class Papel {

	@Id
	@Column(name="PAPEL_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull(message="{papel.nome.vazio}")
	@Size(min=5, message="{papel.nome.min}")
	@Column(name="PAPEL_NOME")
	private String nome;

	@ManyToMany(mappedBy="papeis", fetch=FetchType.EAGER)
	private List<Usuario> usuarios;
	
	//Get's e Set's
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
