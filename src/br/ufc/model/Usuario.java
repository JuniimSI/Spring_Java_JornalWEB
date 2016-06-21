package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="USUARIO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{usuario.nome.vazio}")
	@Size(min=5, message="{usuario.nome.min}")
	@Column(name="USUARIO_NOME")
	private String nome;
	
	@Column(name="USUARIO_EMAIL")
	@NotNull
	private String email;
	
	@Column(name="USUARIO_LOGIN")
	private String login;
	
	@Column(name="USUARIO_SENHA")
	private String senha;
	
	@OneToMany(mappedBy="usuario", targetEntity=Comentario.class, fetch=FetchType.EAGER)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="usuario", targetEntity=Classificado.class, fetch=FetchType.EAGER)
	private List<Classificado> classificados;

	//Olhar esse LAZY
	@OneToMany(mappedBy="usuario", targetEntity=Noticia.class, fetch=FetchType.EAGER)
	private List<Noticia> noticias; 
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PAPEL_USUARIO",
			joinColumns=@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID"),
			inverseJoinColumns=@JoinColumn(name="PAPEL_ID", referencedColumnName="PAPEL_ID"))
	private List<Papel> papeis;
	
	
	@Column(name="USUARIO_IMAGEM")
	private String imagem;
	
	
	//Get's e Set's
	
	
	
	public Long getId() {
		return id;
	}

	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	
	
	
	
}
