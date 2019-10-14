package br.jus.tream.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Ederson
 * 
 * @Description Classe mantm todos os registros de unidades de medidas dos
 *              produtos, gerencivel pelo usurio.
 * 
 */
@Entity
@Table(name = "TB_UnidadeMedida")
public class UnidadeMedida implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_UNIDADEMEDIDA_SEQ", sequenceName = "TB_UNIDADEMEDIDA_SEQ")
	@GeneratedValue(generator = "TB_UNIDADEMEDIDA_SEQ", strategy = GenerationType.AUTO)
	@Column(name = "idUnidadeMedida", unique = true, nullable = false)
	private Long idUnidadeMedida;

	@Column(name = "txUnidadeMedida", unique = true)
	private String txUnidadeMedida;

	@Column(name = "txSigla")
	private String txSigla;

	public Long getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getTxUnidadeMedida() {
		return txUnidadeMedida;
	}

	public void setTxUnidadeMedida(String txUnidadeMedida) {
		this.txUnidadeMedida = txUnidadeMedida;
	}

	public String getTxSigla() {
		return txSigla;
	}

	public void setTxSigla(String txSigla) {
		this.txSigla = txSigla;
	}
}