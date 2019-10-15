package br.jus.tream.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tream.dominio.GrupoProduto;
import br.jus.tream.dominio.Produto;
import br.jus.tream.dominio.TipoProduto;
import br.jus.tream.dominio.UnidadeMedida;


public class ProdutoDAOImpl implements ProdutoDAO {
	private DAO<Produto> dao = new DAO<Produto>(Produto.class);
	static ProdutoDAOImpl db;
	
	public static ProdutoDAO getInstance(){
		if (db == null){
			db = new ProdutoDAOImpl();
		}
		return db;
	}

	@Override
	public Produto getBean(int id) throws Exception{
		Produto Produto = new Produto();
		try {
			Produto = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Produto;
	}

	@Override
	public List<Produto> listar(String vdesc) throws Exception{
		List<Produto> produtos = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {						
			 TypedQuery<Produto> query = em.createQuery("SELECT c FROM Produto c WHERE c.txProduto LIKE ?1", Produto.class);
			 produtos = query.setParameter(1, "%" + vdesc + "%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return produtos;
	}
	
	
	@Override
	public int adicionar (Produto produto) throws Exception{
		int ret = 0;
		try {
			dao.adicionar(produto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover (Produto produto) throws Exception{
		int ret = 0;
		try {
			dao.remover(produto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int atualizar (Produto produto) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(produto);
			ret =1;
		} catch (Exception e) {
			System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Produto> listar() throws Exception {
		List<Produto> lista = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			  // lista = dao.listarTodos();
			  TypedQuery<Produto> query = em.createQuery("SELECT c FROM Produto c ORDER BY c.descricao", 
					    Produto.class);
			  lista = query.getResultList();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
			}
		return lista;	
	}
	 
	@Override 
	public List<Produto> listarCbx() throws Exception { 
		List<Produto> lista = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			  // lista = dao.listarTodos();
			  TypedQuery<Produto> query = em.createQuery("SELECT NEW Produto(c.id, c.descricao) FROM Produto c ORDER BY c.descricao", 
					    Produto.class);
			  lista = query.getResultList();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
			}
		return lista;	
	}
	 
	public byte[] readBytes(File file) throws IOException {
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		try {
			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
			}
		} finally {
			try {
				if (ous != null)
					ous.close();
			} catch (IOException e) {
			}

			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
			}
		}
		return ous.toByteArray();
	}
	
    
	public static void main(String[] args) throws Exception{
		ProdutoDAO dao = ProdutoDAOImpl.getInstance();

		GrupoProduto grp = new GrupoProduto();
		grp = GrupoProdutoDAOImpl.getInstance().getBean(2);
		
		TipoProduto tipo = new TipoProduto();		
		tipo = TipoProdutoDAOImpl.getInstance().getBean(1);		
		
		UnidadeMedida und = new UnidadeMedida();
		und = UnidadeMedidaDAOImpl.getInstance().getBean(3);
		
		Produto p0 = new Produto();		
				
		p0.setGrupoProduto(grp); 
		p0.setUnidadeMedida(und); 
		p0.setTipoProduto(tipo);
		 
		//System.out.println("=="+p0.getGrupoProduto().getDescricao());
		
		p0.setQtdEstoque(20); 
		p0.setQtdMinima(25);
		p0.setDescricao("teste sistema3");
		p0.setDtValidade(new Date(System.currentTimeMillis()));		
		
		int ret = dao.adicionar(p0);
		
		System.out.println("Ret = " + ret);
		
		
		System.out.println("Done!!!");
				
	}
}
