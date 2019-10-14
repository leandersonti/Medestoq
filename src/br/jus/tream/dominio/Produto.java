package br.jus.tream.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Ederson
 * 
 * @Description Classe principal do sistema, um produto e suas informaes,
 *              gerencivel pelo usurio.
 *
 */
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable, Comparable<Produto> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_PRODUTO_SEQ", sequenceName = "TB_PRODUTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_PRODUTO_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idProduto", unique = true, nullable = false)
	private Integer idProduto;

	@Column(name = "txProduto")
	private String txProduto;

	@Column(name = "qtdEstoque")
	private Integer qtdEstoque;

	@Column(name = "qtdMinima")
	private Integer qtdMinima;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtValidade")
	private Date dtValidade;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkUnidadeMedida", referencedColumnName = "idUnidadeMedida", nullable = true)
	private UnidadeMedida fkUnidadeMedida;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkGrupoProduto", referencedColumnName = "idGrupoProduto", nullable = true)
	private GrupoProduto fkGrupoProduto;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkTipoProduto", referencedColumnName = "idTipoProduto", nullable = true)
	private TipoProduto fkTipoProduto;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getTxProduto() {
		return txProduto;
	}

	public void setTxProduto(String txProduto) {
		this.txProduto = txProduto;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Integer qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public UnidadeMedida getFkUnidadeMedida() {
		return fkUnidadeMedida;
	}

	public void setFkUnidadeMedida(UnidadeMedida fkUnidadeMedida) {
		this.fkUnidadeMedida = fkUnidadeMedida;
	}

	public GrupoProduto getFkGrupoProduto() {
		return fkGrupoProduto;
	}

	public void setFkGrupoProduto(GrupoProduto fkGrupoProduto) {
		this.fkGrupoProduto = fkGrupoProduto;
	}

	public TipoProduto getFkTipoProduto() {
		return fkTipoProduto;
	}

	public void setFkTipoProduto(TipoProduto fkTipoProduto) {
		this.fkTipoProduto = fkTipoProduto;
	}

	/**
	 * Mtodo implicitamente utilizado ao solicitar o Collections.sort. Aqui a
	 * informao chave para ordenao a data de validade do produto. Classes que
	 * precisam compor uma tela de listagem e j iniciar com uma ordenao especfica
	 * precisam implementar a interface Comparable.
	 */
	@Override
	public int compareTo(Produto prod) {
		if (this.dtValidade.after(prod.dtValidade)) {
			return 1;
		}
		if (this.dtValidade.before(prod.dtValidade)) {
			return -1;
		}
		return 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
