package br.ufc.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="NOTICIA")
public class Noticia {
	
	@Id
	@Column(name="NOTICIA_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{noticia.titulo.vazio}")
	@Size(min=5, message="{noticia.titulo.min}")
	@Column(name="NOTICIA_TITULO")
	private String titulo;
	
	@NotNull(message="{noticia.texto.vazio}")
	@Size(min=5, message="{noticia.texto.min}")
	@Column(name="NOTICIA_TEXTO")
	@Lob
	private String texto;
	
	@Column(name="NOTICIA_SUBTITULO")
	private String subtitulo;
	
	@Column(name="NOTICIA_DATA")
	private Date data;

	@Column(name="SECAO_ID", insertable=false, updatable=false, nullable=false)
	private Long secaoId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="SECAO_ID" , referencedColumnName = "SECAO_ID")
	private Secao secao;
	
	
	@Column(name="USUARIO_ID", insertable=false, updatable=false, nullable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@OneToMany(mappedBy="noticia"	,targetEntity=Comentario.class, fetch=FetchType.EAGER)
	private List<Comentario> comentarios;
	
	@Column(name="NOTICIA_IMAGEM")
	private String imagem;
	
	@Column(name="NOTICIA_ATIVO")
	private boolean ativo;
	
	// Get's and Set's
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(Long secaoId) {
		this.secaoId = secaoId;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
