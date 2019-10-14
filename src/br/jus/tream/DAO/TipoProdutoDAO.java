package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.TipoProduto;

public interface TipoProdutoDAO {
	
	public List<TipoProduto> listar() throws Exception;
		
	public TipoProduto getBean(int id) throws Exception;
	
	public int adicionar (TipoProduto usuario) throws Exception;
	
	public int atualizar (TipoProduto usuario) throws Exception;
	
	public int remover (TipoProduto usuario) throws Exception;
	
	
}  