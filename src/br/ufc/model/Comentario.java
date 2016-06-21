package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="COMENTARIO")
public class Comentario {
	
	@Id
	@Column(name="COMENTARIO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{comentario.texto.vazio}")
	@Size(min=5, message="{comentario.texto.min}")
	@Column(name="COMENTARIO_TEXTO")
	private String texto;
	
	@Column(name="USUARIO_ID", insertable=false, updatable=false, nullable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="NOTICIA_ID", insertable=false, updatable=false, nullable=false)
	private Long noticiaId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="NOTICIA_ID", referencedColumnName="NOTICIA_ID")
	private Noticia noticia;
	
	
	//Get's e Set's

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
	
}
