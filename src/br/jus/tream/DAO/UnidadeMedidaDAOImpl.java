package br.jus.tream.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tream.dominio.TipoProduto;
import br.jus.tream.dominio.UnidadeMedida;

public class UnidadeMedidaDAOImpl implements UnidadeMedidaDAO {
	private DAO<UnidadeMedida> dao = new DAO<UnidadeMedida>(UnidadeMedida.class);

	static UnidadeMedidaDAO db;

	public static UnidadeMedidaDAO getInstance() {
		if (db == null) {
			db = new UnidadeMedidaDAOImpl();
		}
		return db;
	}

	@Override
	public List<UnidadeMedida> listar() throws Exception {
		List<UnidadeMedida> lista = null;
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public UnidadeMedida getBean(int id) throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		UnidadeMedida unidadeMedida = new UnidadeMedida();
		try {			
			unidadeMedida = dao.getBean(id); 		
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return unidadeMedida;
	}
	

	@Override
	public int adicionar(UnidadeMedida unidadeMedida) throws Exception {
		int ret = 0;
		try {
			dao.adicionar(unidadeMedida);
			ret = 1;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int atualizar(UnidadeMedida unidadeMedida) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(unidadeMedida);
			ret = 1;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(UnidadeMedida unidadeMedida) throws Exception {
		int ret = 0;
		try {
			dao.remover(unidadeMedida);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		UnidadeMedidaDAO dao = UnidadeMedidaDAOImpl.getInstance();
		UnidadeMedida unidadeMedida = new UnidadeMedida();			
		
		//tipoProduto.setDescricao("teste sistema");
		//int ret = dao.adicionar(tipoProduto);
		//System.out.println("==="+ret);
		
		unidadeMedida = dao.getBean(1);
		
		System.out.println("==="+unidadeMedida.getDescricao());
		
		/*
		 * for (TipoProduto s : dao.listar()) { System.out.println("===" +
		 * s.getDescricao()); }
		 */

		System.out.println("Done!!");

	}

}
