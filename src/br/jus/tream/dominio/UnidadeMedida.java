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
	@SequenceGenerator(name = "TB_UNIDADEMEDIDA_SEQ", sequenceName = "TB_UNIDADEMEDIDA_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_UNIDADEMEDIDA_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idUnidadeMedida", unique = true, nullable = false)
	private Integer id;

	@Column(name = "txUnidadeMedida", unique = true)
	private String descricao;

	@Column(name = "txSigla")
	private String sigla;	
	
	public UnidadeMedida() {		
	}
	
	public UnidadeMedida(Integer id, String descricao, String sigla) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		UnidadeMedida other = (UnidadeMedida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}