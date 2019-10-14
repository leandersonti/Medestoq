package br.jus.tream.dominio;

import java.io.Serializable;
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

/**
 * 
 * 
 * @author Ederson
 * 
 * @Description Classe que cria um item para cada produto anexado a cada
 *              movimento. uma classe auxiliar que no possui manipulao direta do
 *              usurio.
 */
@Entity
@Table(name = "tb_itemmovimento")
public class ItemMovimento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_ITEMMOVIMENTO_SEQ", sequenceName = "TB_ITEMMOVIMENTO_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "TB_ITEMMOVIMENTO_SEQ", strategy = GenerationType.AUTO)

	@Column(name = "idItemMovimento", unique = true, nullable = false)
	private Integer id;

	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkProduto", referencedColumnName = "idProduto", nullable = true)
	private Produto produto;

	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkMovimento")
	private Movimento movimento;

	@Column(name = "qtdItem")
	private Integer qtdItem;

	public ItemMovimento() {
	}

	public ItemMovimento(Integer id, Produto produto, Movimento movimento, Integer qtdItem) {
		super();
		this.id = id;
		this.produto = produto;
		this.movimento = movimento;
		this.qtdItem = qtdItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public Integer getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Integer qtdItem) {
		this.qtdItem = qtdItem;
	}

}