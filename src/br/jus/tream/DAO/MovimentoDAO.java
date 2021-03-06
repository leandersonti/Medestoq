package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.ItemMovimento;
import br.jus.tream.dominio.Movimento;

public interface MovimentoDAO {
	
	public List<Movimento> listar() throws Exception;
		
	public Movimento getBean(int id) throws Exception;	
	
	public int adicionar (Movimento movimento) throws Exception;	
	
	public int atualizarEstoque(Movimento movimento) throws Exception;
	
	public int retornaEstoque(Movimento movimento) throws Exception;
	
	public int atualizar (Movimento movimento) throws Exception;
	
	public int adicionarItem (Movimento movimento) throws Exception;
	
	public int remover (Movimento movimento) throws Exception;
	
	
}  