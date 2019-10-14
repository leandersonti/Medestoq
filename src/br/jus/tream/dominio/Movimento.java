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
public class Movimento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "TB_MOVIMENTO_SEQ", sequenceName = "TB_MOVIMENTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_MOVIMENTO_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idMovimento", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "isRecebimento")
	@NotNull
	private Boolean isRecebimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtMovimento")
	private Date dtMovimento;
	
	@Column(name = "txMotivo")
	private String motivo;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fkMovimento", fetch = FetchType.EAGER, orphanRemoval = true)
	List<ItemMovimento> itens;
	
	public Movimento() {
	
	}	
	
	public Movimento(Integer id, Boolean isRecebimento, Date dtMovimento, String motivo, List<ItemMovimento> itens) {
		super();
		this.id = id;
		this.isRecebimento = isRecebimento;
		this.dtMovimento = dtMovimento;
		this.motivo = motivo;
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsRecebimento() {
		return isRecebimento;
	}

	public void setIsRecebimento(Boolean isRecebimento) {
		this.isRecebimento = isRecebimento;
	}

	public Date getDtMovimento() {
		return dtMovimento;
	}

	public void setDtMovimento(Date dtMovimento) {
		this.dtMovimento = dtMovimento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public List<ItemMovimento> getItens() {
		return itens;
	}

	public void setItens(List<ItemMovimento> itens) {
		this.itens = itens;
	}
		
	
}