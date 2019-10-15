package br.jus.tream.DAO;

import java.util.List;

import br.jus.tream.dominio.GrupoProduto;


public class GrupoProdutoDAOImpl implements GrupoProdutoDAO {
	private DAO<GrupoProduto> dao = new DAO<GrupoProduto>(GrupoProduto.class);
	static GrupoProdutoDAOImpl db;
	
	public static GrupoProdutoDAO getInstance(){
		if (db == null){
			db = new GrupoProdutoDAOImpl();
		}
		return db;
	}

	@Override
	public GrupoProduto getBean(int id) throws Exception{
		GrupoProduto grupoProduto = new GrupoProduto();
		try {
			grupoProduto = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grupoProduto;
	}

	@Override
	public List<GrupoProduto> listar() throws Exception {
		List<GrupoProduto> lista = null;
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	@Override
	public int adicionar (GrupoProduto grupoProduto) throws Exception{
		int ret = 0;
		try {
			dao.adicionar(grupoProduto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover (GrupoProduto grupoProduto) throws Exception{
		int ret = 0;
		try {
			dao.remover(grupoProduto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int atualizar (GrupoProduto grupoProduto) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(grupoProduto);
			ret =1;
		} catch (Exception e) {
			System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}


	

    
	public static void main(String[] args) throws Exception{
		GrupoProdutoDAO dao = GrupoProdutoDAOImpl.getInstance();
		
		//Produto p0 = new Produto();
		//int ret = 0;
		//p0 = dao.getBean(10);
		//p0.setDescricao("Lasanha de Carne para 2 pessoas");
		//p0.setTitulo("Lasanha de carne com molho bolonhesa");
		//p0.setValor(new BigDecimal("37.00"));
		//p0.setPicture(FuncsUtils.getInstance().readBytes(fileUpload));
		
		//ret = dao.alterar(p0);
		//System.out.println("atualizado  = " + ret );
		
		GrupoProduto grupoProduto = new GrupoProduto();
		grupoProduto.setDescricao("teste sistema");
		int ret = dao.adicionar(grupoProduto);
		
		System.out.println("==="+ret);
		
		/*
		 * for (GrupoProduto p : dao.listar()) { System.out.println("produto " +
		 * p.getDescricao()); }
		 */ 
			
				
	}
}
