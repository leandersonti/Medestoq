package br.jus.tream.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.DAO.GrupoProdutoDAO;
import br.jus.tream.DAO.GrupoProdutoDAOImpl;
import br.jus.tream.dominio.BeanResult;
import br.jus.tream.dominio.GrupoProduto;

@SuppressWarnings("serial")
@Namespace("/grupoproduto")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ActionGrupoProduto extends ActionSupport{
	private List<GrupoProduto> lstGrupoProduto;
	private GrupoProduto grupoProduto;
	private BeanResult result;
	private final static GrupoProdutoDAO dao = GrupoProdutoDAOImpl.getInstance();
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/grupos.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listar() {
		try {
			this.lstGrupoProduto = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "lstGrupoProduto" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarJson() {
		try {
			this.lstGrupoProduto = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCad", results = { @Result(name = "success", location = "/forms/frmGrupoProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
	//,		interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmCadEleicao() {	
		return "success";
	}
	
	@Action(value = "frmEditar", results = { @Result(name = "success", location = "/forms/frmGrupoProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doFrmEditar() {
		try {
			this.grupoProduto = dao.getBean(this.grupoProduto.getId());
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
	public String Adicionar() {
		BeanResult beanResult = new BeanResult();
		try {							
				beanResult.setRet(dao.adicionar(grupoProduto));				
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
			    e.printStackTrace();
			  //result.setMensagem(getText("inserir.error") + " Error: " + e.getMessage());
			return "error";
		}
		this.result = beanResult;
		return "success";
	}
	
	@Action(value = "atualizar", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, 
	  interceptorRefs = @InterceptorRef("authStack")
	)
	public String doAtualizar() {
		BeanResult beanResult = new BeanResult();
		try {
			beanResult.setRet(dao.atualizar(this.grupoProduto));
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
			@Result(name = "error", location = "/pages/resultAjax.jsp")}, 
			interceptorRefs = @InterceptorRef("authStack")
	)
	public String doRemover() {
		BeanResult beanResult = new BeanResult();
		beanResult.setRet(0);
		try {
				beanResult.setRet(dao.remover(this.grupoProduto));
				beanResult.setMensagem(getText("remover.sucesso"));
				beanResult.setType("success");
		 } catch (Exception e) {
			addActionError(getText("remover.error") + " Error: " + e.getMessage());
			// r.setMensagem(getText("remover.error") + " Error: " + e.getMessage());
			return "error";
		}
		this.result = beanResult;
	  return "success";
	}

	public List<GrupoProduto> getLstGrupoProduto() {
		return lstGrupoProduto;
	}

	public void setLstGrupoProduto(List<GrupoProduto> lstGrupoProduto) {
		this.lstGrupoProduto = lstGrupoProduto;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}
	
	
}
	
	