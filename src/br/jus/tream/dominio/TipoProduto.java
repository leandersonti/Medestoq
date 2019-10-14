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
 * @Description Classe mamtm todos os registros de tipos de produtos, gerencivel
 *              pelo usurio.
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
	@SequenceGenerator(name = "TB_TIPOPRODUTO_SEQ", sequenceName = "TB_TIPOPRODUTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_TIPOPRODUTO_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idTipoProduto", unique = true, nullable = false)
	private Integer id;

	@Column(name = "txTipoProduto")
	private String descricao;
	
	public TipoProduto() {		
	}

	public TipoProduto(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
		TipoProduto other = (TipoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}