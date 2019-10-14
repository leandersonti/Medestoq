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
 *              movimento.  uma classe auxiliar que no possui manipulao
 *              direta do usurio.
 */
@Entity
@Table(name = "tb_itemmovimento")
public class ItemMovimento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_ITEMMOVIMENTO_SEQ", sequenceName = "TB_ITEMMOVIMENTO_SEQ")
	@GeneratedValue(generator = "TB_ITEMMOVIMENTO_SEQ", strategy = GenerationType.AUTO)
	@Column(name = "idItemMovimento", unique = true, nullable = false)
	private Long idItemMovimento;
	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkProduto", referencedColumnName = "idProduto", nullable = true)
	private Produto fkProduto;
	@ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fkMovimento")
	private Movimento fkMovimento;
	@Column(name = "qtdItem")
	private Integer qtdItem;
	public Long getIdItemMovimento() {
		return idItemMovimento;
	}
	public void setIdItemMovimento(Long idItemMovimento) {
		this.idItemMovimento = idItemMovimento;
	}
	public Produto getFkProduto() {
		return fkProduto;
	}
	public void setFkProduto(Produto fkProduto) {
		this.fkProduto = fkProduto;
	}
	public Movimento getFkMovimento() {
		return fkMovimento;
	}
	public void setFkMovimento(Movimento fkMovimento) {
		this.fkMovimento = fkMovimento;
	}
	public Integer getQtdItem() {
		return qtdItem;
	}
	public void setQtdItem(Integer qtdItem) {
		this.qtdItem = qtdItem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}