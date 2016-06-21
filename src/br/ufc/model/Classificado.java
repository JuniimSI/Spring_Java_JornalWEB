package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="CLASSIFICADO")
public class Classificado {

	@Id
	@Column(name="CLASSIFICADO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="CLASSIFICADO_TITULO")
	private String titulo;
	
	@NotNull(message="{classificado.texto.vazio}")
	@Size(min=5, message="{classificado.texto.min}")
	@Column(name="CLASSIFICADO_TEXTO")
	private String texto;
	
	@Column(name="CLASSIFICADO_TELEFONE")
	private String telefone;
	
	@Column(name="CLASSIFICADO_PRECO")
	private double preco;
	
	@Column(name="CLASSIFICADO_MELHOR_OFERTA")
	private double melhorOferta;
	
	@Column(name="CLASSIFICADO_DATA_OFERTA")
	private Date dataOferta;
	
	@Column(name="USUARIO_ID", insertable=false, updatable=false, nullable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="COMPRADOR")
	private String comprador;
	
	//Get's e Set's
	
	

	public double getMelhorOferta() {
		return melhorOferta;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public void setMelhorOferta(double melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	
}
