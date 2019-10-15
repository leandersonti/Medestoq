package br.jus.tream.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.jus.tream.dominio.ItemMovimento;
import br.jus.tream.dominio.Movimento;
import br.jus.tream.dominio.Produto;

public class MovimentoDAOImpl implements MovimentoDAO {
	private DAO<Movimento> dao = new DAO<Movimento>(Movimento.class);
	static MovimentoDAOImpl db;

	public static MovimentoDAO getInstance() {
		if (db == null) {
			db = new MovimentoDAOImpl();
		}
		return db;
	}

	@Override
	public List<Movimento> listar() throws Exception {
		List<Movimento> lista = null;
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Movimento getBean(int id) throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		Movimento movimento = new Movimento();
		try {			
			movimento = dao.getBean(id); 		
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return movimento;
	}
	

	@Override
	public int adicionar(Movimento movimento) throws Exception {
		int ret = 0;
		try {
			dao.adicionar(movimento);
			ret = 1;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int atualizar(Movimento movimento) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(movimento);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int adicionarItem(List<ItemMovimento> itens) throws Exception {
		int ret = 0;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {			
			
			em.getTransaction().begin();
			
			for(ItemMovimento item : itens) {				
				em.merge(item);
			}
			
			em.getTransaction().commit();
			em.close();
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(Movimento movimento) throws Exception {
		int ret = 0;
		try {
			dao.remover(movimento);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		MovimentoDAO dao = MovimentoDAOImpl.getInstance();
		Movimento movimento = new Movimento();			
		Produto produto = new Produto();		
		
		/*
		 * List<ItemMovimento> itens = new ArrayList<ItemMovimento>();
		 * 
		 * 
		 * movimento.setDtMovimento(new Date(15)); movimento.setIsRecebimento(true);
		 * movimento.setMotivo("teste sistema");
		 * 
		 * 
		 * movimento = dao.getBean(7); //itens = movimento.getItens();
		 * 
		 * ItemMovimento item1 = new ItemMovimento(); 
		 * item1.setMovimento(movimento);
		 * produto = ProdutoDAOImpl.getInstance().getBean(240);
		 * item1.setProduto(produto); item1.setQtdItem(10);
		 * 
		 * ItemMovimento item2 = new ItemMovimento(); 
		 * item2.setMovimento(movimento);
		 * produto = ProdutoDAOImpl.getInstance().getBean(234);
		 * item2.setProduto(produto); item2.setQtdItem(20);
		 * 
		 * itens.add(item1); itens.add(item2);
		 * 
		 * //movimento.setItens(itens); int ret = dao.adicionarItem(itens);
		 * System.out.println("==="+ret);
		 */
				
		movimento = dao.getBean(7);
		int ret = dao.remover(movimento);
		
		System.out.println("==="+ret);
		
		/*
		 * for (Movimento s : dao.listar()) { System.out.println("===" +
		 * s.getDescricao()); }
		 */

		System.out.println("Done!!");

	}

}
