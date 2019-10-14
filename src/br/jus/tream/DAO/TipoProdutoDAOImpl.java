package br.jus.tream.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.jus.tream.dominio.TipoProduto;

public class TipoProdutoDAOImpl implements TipoProdutoDAO {
	private DAO<TipoProduto> dao = new DAO<TipoProduto>(TipoProduto.class);

	static TipoProdutoDAO db;

	public static TipoProdutoDAO getInstance() {
		if (db == null) {
			db = new TipoProdutoDAOImpl();
		}
		return db;
	}

	@Override
	public List<TipoProduto> listar() throws Exception {
		List<TipoProduto> lista = null;
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public TipoProduto getBean(int id) throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		TipoProduto TipoProduto = new TipoProduto();
		try {			
			dao.getBean(id);
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return TipoProduto;
	}

	@Override
	public int adicionar(TipoProduto tipoProduto) throws Exception {
		int ret = 0;
		try {
			dao.adicionar(tipoProduto);
			ret = 1;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int atualizar(TipoProduto tipoProduto) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(tipoProduto);
			ret = 1;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(TipoProduto tipoProduto) throws Exception {
		int ret = 0;
		try {
			dao.remover(tipoProduto);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		TipoProdutoDAO dao = TipoProdutoDAOImpl.getInstance();
		//TipoProduto tipoProduto = new TipoProduto();			
		
		//tipoProduto.setDescricao("teste sistema");
		//int ret = dao.adicionar(tipoProduto);
		//System.out.println("==="+ret);
					
		
		 for (TipoProduto s : dao.listar()) { System.out.println("===" +
		 s.getDescricao()); }
		

		System.out.println("Done!!");

	}

}
