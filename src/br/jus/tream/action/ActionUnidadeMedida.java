package br.jus.tream.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.DAO.UnidadeMedidaDAO;
import br.jus.tream.DAO.UnidadeMedidaDAOImpl;
import br.jus.tream.dominio.BeanResult;
import br.jus.tream.dominio.UnidadeMedida;

@SuppressWarnings("serial")
@Namespace("/undmedida")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ActionUnidadeMedida extends ActionSupport{
	private List<UnidadeMedida> lstUnidadeMedida;
	private UnidadeMedida und;
	private BeanResult result;
	private final static UnidadeMedidaDAO dao = UnidadeMedidaDAOImpl.getInstance();
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/unidades-medidas.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	   //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listar() {
		try {
			this.lstUnidadeMedida = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "lstUnidadeMedida" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarJson() {
		try {
			this.lstUnidadeMedida = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCad", results = { @Result(name = "success", location = "/forms/frmUnidadeMedida.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmCadEleicao() {	
		return "success";
	}
	
	@Action(value = "frmEditar", results = { @Result(name = "success", location = "/forms/frmUnidadeMedida.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doFrmEditar() {
		try {
			this.und = dao.getBean(this.und.getId());
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
				beanResult.setRet(dao.adicionar(und));
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
			beanResult.setRet(dao.atualizar(this.und));
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
				beanResult.setRet(dao.remover(this.und));
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
	
	public List<UnidadeMedida> getLstUnidadeMedida() {
		return lstUnidadeMedida;
	}

	public void setLstUnidadeMedida(List<UnidadeMedida> lstUnidadeMedida) {
		this.lstUnidadeMedida = lstUnidadeMedida;
	}

	public UnidadeMedida getUnd() {
		return und;
	}

	public void setUnd(UnidadeMedida und) {
		this.und = und;
	}

	public BeanResult getResult() {
		return result;
	}
	public void setResult(BeanResult result) {
		this.result = result;
	}
}
