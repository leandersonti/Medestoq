<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
 
 <form action="" method="post" name="form1" id="frm">     
			   <div class="form-row">
			    <table class="table table-sm table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Produto</th>
					      <th scope="col" class="text-left">Validade</th>
					      <th scope="col" class="text-left">Grupo</th>
					      <th scope="col" class="text-left">Qtestoq</th>
					    </tr>
					  </thead>
					<tbody>
			    
			  </div>
			  <s:iterator value="mov.itens">
				<tr id="tr${id}">
				    <td><s:property value="produto.descricao"/></td>
					<td><s:property value="produto.dtValidade"/></td>
					<td><s:property value="produto.grupo.descricao"/></td>
					<td><s:property value="produto.qtdEstoque"/></td>
							
				</tr>
			</s:iterator>
			
			</div>
		</tbody>
		</table>
    </form>  
    
