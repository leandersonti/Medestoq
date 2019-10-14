package br.jus.tream.dominio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
/**
 *
 * @author Ederson
 *
 * @Description Classe mantém todos os registros de movimentos do sistema,
 *              podendo ser somente criado, listado ou excluído pelo usuário.
 * 
 */
@Entity
@Table(name = "tb_movimento")
public class Movimento implements Serializable, Comparable<Movimento> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_MOVIMENTO_SEQ", sequenceName = "TB_MOVIMENTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_MOVIMENTO_SEQ", strategy = GenerationType.AUTO)
	@Column(name = "idMovimento", unique = true, nullable = false)
	private Long idMovimento;
	
	@Column(name = "isRecebimento")
	@NotNull
	private Boolean isRecebimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtMovimento")
	private Date dtMovimento;
	
	@Column(name = "txMotivo")
	private String txMotivo;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fkMovimento", fetch = FetchType.EAGER, orphanRemoval = true)
	List<ItemMovimento> itens;
		
	public Long getIdMovimento() {
		return idMovimento;
	}
	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}
	public Boolean getIsRecebimento() {
		return isRecebimento;
	}
	public void setIsRecebimento(Boolean isRecebimento) {
		this.isRecebimento = isRecebimento;
	}
	public Date getDtMovimento() {
		return this.dtMovimento;
	}
	public void setDtMovimento(Date dtMovimento) {
		this.dtMovimento = dtMovimento;
	}
	public String getTxMotivo() {
		return txMotivo;
	}
	public void setTxMotivo(String txMotivo) {
		this.txMotivo = txMotivo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<ItemMovimento> getItens() {
		return itens;
	}
	public void setItens(List<ItemMovimento> itens) {
		this.itens = itens;
	}
	/**
	 * Método implicitamente utilizado ao solicitar o Collections.sort. Aqui a
	 * informação chave para ordenação é a data de criação do movimento. Classes
	 * que precisam compor uma tela de listagem e já iniciar com uma ordenação
	 * específica precisam implementar a interface Comparable.
	 */
	@Override
	public int compareTo(Movimento mov) {
		if (this.dtMovimento.after(mov.dtMovimento)) {
			return -1;
		}
		if (this.dtMovimento.before(mov.dtMovimento)) {
			return 1;
		}
		return 0;
	}
}