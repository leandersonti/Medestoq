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
	@SequenceGenerator(name = "TB_GRUPOPRODUTO_SEQ", sequenceName = "TB_GRUPOPRODUTO_SEQ", allocationSize=1)
	@GeneratedValue(generator = "TB_GRUPOPRODUTO_SEQ", strategy = GenerationType.AUTO)
	
	@Column(name = "idGrupoProduto", unique = true, nullable = false)
	private Integer id;

	@Column(name = "txGrupoProduto")
	private String descricao;

	public GrupoProduto() {
		
	}
	
	public GrupoProduto(Integer id, String descricao) {
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

	

	
}