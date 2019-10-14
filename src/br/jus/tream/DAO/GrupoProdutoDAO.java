package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.GrupoProduto;

public interface GrupoProdutoDAO {
	
	public List<GrupoProduto> listar() throws Exception;
		
	public GrupoProduto getBean(int id) throws Exception;
	
	public int adicionar (GrupoProduto grupoProduto) throws Exception;
	
	public int atualizar (GrupoProduto grupoProduto) throws Exception;
	
	public int remover (GrupoProduto grupoProduto) throws Exception;
	
} 