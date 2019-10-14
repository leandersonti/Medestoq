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
 * @Description Classe mamtm todos os registros de tipos de produtos,
 *              gerencivel pelo usurio.
 * 
 */
@Entity
@Table(name = "TB_TIPOPRODUTO")
public class TipoProduto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_TIPOPRODUTO_SEQ", sequenceName = "TB_TIPOPRODUTO_SEQ")
	@GeneratedValue(generator = "TB_TIPOPRODUTO_SEQ", strategy = GenerationType.AUTO)
	@Column(name = "idTipoProduto", unique = true, nullable = false)
	private Long idTipoProduto;
	@Column(name = "txTipoProduto")

	private String txTipoProduto;
	public Long getIdTipoProduto() {
		return idTipoProduto;
	}
	public void setIdTipoProduto(Long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}
	public String getTxTipoProduto() {
		return txTipoProduto;
	}
	public void setTxTipoProduto(String txTipoProduto) {
		this.txTipoProduto = txTipoProduto;
	}
}