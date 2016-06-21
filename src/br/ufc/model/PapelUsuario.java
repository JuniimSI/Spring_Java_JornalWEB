package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="PAPEL_USUARIO")
public class PapelUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAPEL_USUARIO_ID", nullable=false)
	private Long id;
	
	@Column(name="USUARIO_ID", nullable=false)
	private Long usuarioId;
	
	@Column(name="PAPEL_ID", nullable=false)
	private Long papelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getPapelId() {
		return papelId;
	}

	public void setPapelId(Long papelId) {
		this.papelId = papelId;
	}
	
	
}
