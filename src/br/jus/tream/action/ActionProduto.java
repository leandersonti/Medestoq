package br.jus.tream.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.DAO.ProdutoDAO;
import br.jus.tream.DAO.ProdutoDAOImpl;
import br.jus.tream.dominio.BeanResult;
import br.jus.tream.dominio.Produto;

@SuppressWarnings("serial")
@Namespace("/produto")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ActionProduto extends ActionSupport{
	private List<Produto> lstProduto;
	private Produto produto;
	private BeanResult result;
	private final static ProdutoDAO dao = ProdutoDAOImpl.getInstance();
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/produto.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	//,interceptorRefs = @InterceptorRef("authStack")
	)
	public String listar() {
		try {
			if (produto != null ) {
			this.lstProduto = dao.listar(produto.getTipo().getId(), produto.getGrupo().getId());
					}
			
				
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "consultar", results = { @Result(name = "success", location = "/consultas/produto-consultar.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	//,interceptorRefs = @InterceptorRef("authStack")
	)
	public String consultar() {
		try {
			
			if (produto != null ) {
				this.lstProduto = dao.listar(produto.getDescricao());
					}
			
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJsonByTipoGrupo", results = { @Result(name = "success", type = "json", params = { "root", "lstProduto" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarByTipoGrupo() {
		try {
			this.lstProduto = dao.listar(produto.getTipo().getId(), produto.getGrupo().getId());
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "lstProduto" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarJson() {
		try {
			this.lstProduto = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "listarCbx", results = { @Result(name = "success", type = "json", params = { "root", "LstProduto" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarCdx() {
		try {
			this.lstProduto = dao.listarCbx();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCad", results = { @Result(name = "success", location = "/forms/frmProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmProduto() {	
		return "success";
	}
	
	@Action(value = "frmEditar", results = { @Result(name = "success", location = "/forms/frmProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doFrmEditar() {
		try {
			this.produto = dao.getBean(this.produto.getId());
		} catch (Exception e) {
			addActionError(getText("frmsetup.error") + " Error: " + e.getMessage());
			return "error";
		}
		return "success";
	}
	
	@Action(value = "adicionar", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp")}
	  //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doAdicionar() {
		BeanResult beanResult = new BeanResult();
		try {
				beanResult.setRet(dao.adicionar(produto));
				if (beanResult.getRet() == 1) {
					beanResult.setMensagem(getText("inserir.sucesso"));
					beanResult.setType("success");
				}
				else {
					beanResult.setMensagem(getText("inserir.error"));
					beanResult.setType("error");
				}
		} catch (Exception e) {
			    addActionError(getText("alterar.error") + " Error: " + e.getMessage());
			  //result.setMensagem(getText("inserir.error") + " Error: " + e.getMessage());
			return "error";
		}
		this.result = beanResult;
		return "success";
	}
	
	@Action(value = "atualizar", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	  //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doAtualizar() {
		BeanResult beanResult = new BeanResult();
		try {
			beanResult.setRet(dao.atualizar(this.produto));
				if (beanResult.getRet()==1) {
					beanResult.setMensagem(getText("alterar.sucesso"));
					beanResult.setType("success");
				}else {
					beanResult.setMensagem(getText("alterar.error")); 
					beanResult.setType("error");
				}
		} catch (Exception e) {
			addActionError(getText("alterar.error") + " Error: " + e.getMessage());
			return "error";
		}
		 this.result = beanResult;
		return "success";
	}
	
	@Action(value = "remover", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp")}
	   	//	, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doRemover() {
		BeanResult beanResult = new BeanResult();
		beanResult.setRet(0);
		try {	
				produto = dao.getBean(this.produto.getId());
				
				beanResult.setRet(dao.remover(this.produto));
				beanResult.setMensagem(getText("remover.sucesso"));
				beanResult.setType("success");
		 } catch (Exception e) {
			addActionError(getText("remover.error") + " Error: " + e.getMessage());
			//r.setMensagem(getText("remover.error") + " Error: " + e.getMessage());
			return "error";
		}
		this.result = beanResult;
	  return "success";
	}	 
	
	public List<Produto> getLstProduto() {
		return lstProduto;
	}

	public void setLstProduto(List<Produto> lstProduto) {
		this.lstProduto = lstProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}

}
