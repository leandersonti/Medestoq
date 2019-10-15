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
import javax.persistence.ManyToOne;
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
public class Produto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_PRODUTO_SEQ", sequenceName = "TB_PRODUTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_PRODUTO_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idProduto", unique = true, nullable = false)
	private Integer id;

	@Column(name = "txProduto")
	private String descricao;

	@Column(name = "qtdEstoque")
	private Integer qtdEstoque;

	@Column(name = "qtdMinima")
	private Integer qtdMinima;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtValidade")
	private Date dtValidade;

	@ManyToOne()
	@JoinColumn(name = "fkUnidadeMedida")
	private UnidadeMedida unidadeMedida;

	@ManyToOne()
	@JoinColumn(name = "fkGrupoProduto")
	private GrupoProduto grupoProduto;

	@ManyToOne()
	@JoinColumn(name = "fkTipoProduto")
	private TipoProduto tipoProduto;	
	
	public Produto() {	
	}
	
	public Produto(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Produto(Integer id, String descricao, Integer qtdEstoque, Integer qtdMinima, Date dtValidade,
			UnidadeMedida unidadeMedida, GrupoProduto grupoProduto, TipoProduto tipoProduto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.qtdMinima = qtdMinima;
		this.dtValidade = dtValidade;
		this.unidadeMedida = unidadeMedida;
		this.grupoProduto = grupoProduto;
		this.tipoProduto = tipoProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
