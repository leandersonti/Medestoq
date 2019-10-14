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
 * 
 * @author Ederson
 * @author Vinicius
 * 
 * @Description Classe que gerencia os grupos os quais um dado produto pertence,
 *              gerenciveis pelo usurio.
 */
@Entity
@Table(name = "TB_GRUPOPRODUTO")
public class GrupoProduto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_GRUPOPRODUTO_SEQ", sequenceName = "TB_GRUPOPRODUTO_SEQ")
	@GeneratedValue(generator = "TB_GRUPOPRODUTO_SEQ", strategy = GenerationType.AUTO)
	@Column(name = "idGrupoProduto", unique = true, nullable = false)
	private Long idGrupoProduto;
	@Column(name = "txGrupoProduto")

	private String txGrupoProduto;
	public Long getIdGrupoProduto() {
		return idGrupoProduto;
	}
	public void setIdGrupoProduto(Long idGrupoProduto) {
		this.idGrupoProduto = idGrupoProduto;
	}
	public String getTxGrupoProduto() {
		return txGrupoProduto;
	}
	public void setTxGrupoProduto(String txGrupoProduto) {
		this.txGrupoProduto = txGrupoProduto;
	}
}