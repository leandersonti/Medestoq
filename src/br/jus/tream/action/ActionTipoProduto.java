package br.jus.tream.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.DAO.TipoProdutoDAO;
import br.jus.tream.DAO.TipoProdutoDAOImpl;
import br.jus.tream.dominio.BeanResult;
import br.jus.tream.dominio.TipoProduto;

@SuppressWarnings("serial")
@Namespace("/tipoproduto")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ActionTipoProduto extends ActionSupport{
	private List<TipoProduto> lstTipoProduto;
	private TipoProduto tipoproduto;
	private BeanResult result;
	private final static TipoProdutoDAO dao = TipoProdutoDAOImpl.getInstance();
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/eleicao.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	   //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listar() {
		try {
			this.lstTipoProduto = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "lstTipoProduto" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarJson() {
		try {
			this.lstTipoProduto = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCad", results = { @Result(name = "success", location = "/forms/frmTipoProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmCadEleicao() {	
		return "success";
	}
	
	@Action(value = "frmEditar", results = { @Result(name = "success", location = "/forms/frmTipoProduto.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doFrmEditar() {
		try {
			this.tipoproduto = dao.getBean(this.tipoproduto.getId());
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
				beanResult.setRet(dao.adicionar(tipoproduto));
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
			beanResult.setRet(dao.atualizar(this.tipoproduto));
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
	   //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doRemover() {
		BeanResult beanResult = new BeanResult();
		beanResult.setRet(0);
		try {
				beanResult.setRet(dao.remover(this.tipoproduto));
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
	
	public List<TipoProduto> getLstTipoProduto() {
		return lstTipoProduto;
	}

	public void setLstTipoProduto(List<TipoProduto> lstTipoProduto) {
		this.lstTipoProduto = lstTipoProduto;
	}

	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public BeanResult getResult() {
		return result;
	}
	public void setResult(BeanResult result) {
		this.result = result;
	}
}
