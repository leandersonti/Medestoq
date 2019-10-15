package br.jus.tream.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.DAO.MovimentoDAO;
import br.jus.tream.DAO.MovimentoDAOImpl;
import br.jus.tream.dominio.BeanResult;
import br.jus.tream.dominio.ItemMovimento;
import br.jus.tream.dominio.Movimento;

@SuppressWarnings("serial")
@Namespace("/movimento")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ActionMovimento extends ActionSupport{
	private List<Movimento> lstMovimento;	
	private Movimento mov;
	private BeanResult result;
	private List<ItemMovimento> itens = new ArrayList<ItemMovimento>();
	private final static MovimentoDAO dao = MovimentoDAOImpl.getInstance();
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/movimentos.jsp"),
			@Result(name = "error", location = "/result.jsp")}
	   //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listar() {
		try {
			this.lstMovimento = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "lstMovimento" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String listarJson() {
		try {
			this.lstMovimento = dao.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCad", results = { @Result(name = "success", location = "/forms/frmMovimento.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmCadMovimento() {	
		return "success";
	}
	
	@Action(value = "frmEditar", results = { @Result(name = "success", location = "/forms/frmMovimento.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}
	 //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doFrmEditar() {
		try {
			this.mov = dao.getBean(this.mov.getId());
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
				beanResult.setRet(dao.adicionar(mov));
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
	
	@Action(value = "adicionarItens", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp")}
	  //, interceptorRefs = @InterceptorRef("authStack")
	)
	public String doAdicionarItens() {
		BeanResult beanResult = new BeanResult();
		try {
				beanResult.setRet(dao.adicionarItem(itens));
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
			beanResult.setRet(dao.atualizar(this.mov));
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
				mov = dao.getBean(this.mov.getId());
				
				if(mov != null) {
					beanResult.setRet(dao.remover(this.mov));
					beanResult.setMensagem(getText("remover.sucesso"));
					beanResult.setType("success");
				}else {
					beanResult.setMensagem(getText("remover.error"));
					beanResult.setType("error");
				}				
				
		 } catch (Exception e) {			
			 addActionError(getText("remover.error") + " Error: " + e.getMessage());
			 e.printStackTrace();
			// r.setMensagem(getText("remover.error") + " Error: " + e.getMessage());
			return "error";
		}
		this.result = beanResult;
	  return "success";
	}
	
	public List<Movimento> getLstMovimento() {
		return lstMovimento;
	}

	public void setLstMovimento(List<Movimento> lstMovimento) {
		this.lstMovimento = lstMovimento;
	}

	public Movimento getMov() {
		return mov;
	}

	public void setMov(Movimento mov) {
		this.mov = mov;
	}

	public BeanResult getResult() {
		return result;
	}
	public void setResult(BeanResult result) {
		this.result = result;
	}

	public List<ItemMovimento> getItens() {
		return itens;
	}

	public void setItens(List<ItemMovimento> itens) {
		this.itens = itens;
	}

	
}
