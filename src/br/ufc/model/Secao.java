package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="SECAO")
public class Secao {
	
	@Id
	@Column(name="SECAO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="SECAO_DESCRICAO")
	private String descricao;

	@NotNull(message="{secao.titulo.vazio}")
	@Size(min=4, message="{secao.titulo.min}")
	@Column(name="SECAO_TITULO")
	private String titulo;
	
	@OneToMany(mappedBy="secao"	,targetEntity=Noticia.class, fetch=FetchType.EAGER)
	private List<Noticia> noticias;
	
	//Get's e Set's

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	
	
}
