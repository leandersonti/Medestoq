package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.TipoProduto;
import br.jus.tream.dominio.UnidadeMedida;

public interface UnidadeMedidaDAO {
	
	public List<UnidadeMedida> listar() throws Exception;
		
	public UnidadeMedida getBean(int id) throws Exception;
	
	public int adicionar (UnidadeMedida unidadeMedida) throws Exception;
	
	public int atualizar (UnidadeMedida unidadeMedida) throws Exception;
	
	public int remover (UnidadeMedida unidadeMedida) throws Exception;
	
	
}  