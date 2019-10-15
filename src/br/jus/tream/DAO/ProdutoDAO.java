package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.Produto;

public interface ProdutoDAO {
	
	public List<Produto> listar() throws Exception;
	
	public List<Produto> listarCbx() throws Exception;
	
	public List<Produto> listar(String vdesc) throws Exception;
	
	public Produto getBean(int id) throws Exception;
	
	public int adicionar (Produto produto) throws Exception;
	
	public int atualizar (Produto produto) throws Exception;
	
	public int remover (Produto produto) throws Exception;
	
} 