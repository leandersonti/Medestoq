<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page = "/mainhead.inc.jsp" />


<div class="container">
     
<div class="card">
  <div class="card-header">Consultar</div>
   <form class="form-row" action="consultar">
    
  		<div class="col-md-4">
      <input class="form-control mr-sm-2" name="produto.descricao" type="search" placeholder="Pesquisar" aria-label="Search">
      </div>
      <button href="consultar" type="submit" class="btn btn-primary">Consultar</button>
    
</form>
  
 
 
  <div class="card-body">
  
    <table id="tbproduto" class="table table-sm table-hover">
	<thead>
		<tr>
			<th width="8%">Id</th>
			<th width="28%">Descrição</th> 
			<th width="28%">Dte valid</th>
			<th width="28%">QTD</th>
			<th width="28%">Min</th> 
			<th width="28%">Status</th>
			<th width="15%"><a href="frmCad" class="btn btn-sm btn-primary" role="button">Novo</a>
		    </th>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="lstProduto">
		<tr id="tr${id}" class="table-${estilo}"> 
		   <td><s:property value="id"/></td>
			<td><s:property value="descricao"/></td>
			<td><s:property value="%{getText('format.date',{dtValidade})}"/></td>
			
			<td><s:property value="qtdEstoque"/></td>
			<td><s:property value="qtdMinima"/></td>
			
			<td><s:property value="status"/></td>
			<td>  		    
				    <a href="frmEditar?produto.id=${id}" id="idedit" class="btn btn-sm btn-warning" role="button">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
				    </a>
					
					<a href="#" id="excluir${id}" class="btn btn-sm btn-danger" role="button" data-record-id="${id}" 					    
					     data-record-descricao="${descricao}">
					  		<i class="fa fa-trash-o" aria-hidden="true"></i>
				    </a>
			</td>
		</tr>
		</s:iterator>
	 </tbody>	
	</table>
	
    
	  </div>
	</div>
</div>

   

<jsp:include page = "/javascripts.jsp" />
<script src="${pageContext.request.contextPath}/js/produto.js" charset="utf-8"></script>
<script>

function CarregaTipo(){	
	var x = "${produto.tipo.id}";
	  var select = $('#tipo');		  

	  
	      select.find('option').remove();	      
			      $.getJSON('../tipoproduto/listarJson',function(jsonResponse) {			    	  
			    	  $('<option>').val(-1).text("Informe o tipo").appendTo(select);			    	  
			              $.each(jsonResponse, function(key, value) {
			            	  if(value.id==x){
			            		  $('<option selected>').val(value.id).text(value.descricao).appendTo(select);
			            	  }else{
			            		  $('<option>').val(value.id).text(value.descricao).appendTo(select);  
			            		}
			                
	       			      });
		          }).done(function() {
		        	  $(".chosen-select").chosen({no_results_text: "Oops, não tem produto!"}); 
		          });			      
	  }	
   
function CarregaGrupo(){	
	
	  	var x = '${produto.grupo.id}';
	  		var select = $('#grupo');
	  		
	      select.find('option').remove();	      
			      $.getJSON('../grupoproduto/listarJson',function(jsonResponse) {			    	  
			    	  $('<option>').val(-1).text("Informe o grupo").appendTo(select);			    	  
			              $.each(jsonResponse, function(key, value) {
			            	  if (value.id==x){
			                	$('<option selected>').val(value.id).text(value.descricao).appendTo(select);  
			            	  }else {
			            		  $('<option>').val(value.id).text(value.descricao).appendTo(select);
			            	  }
	       			      });
		          }).done(function() {
		        	  $(".chosen-select").chosen({no_results_text: "Oops, não tem produto!"}); 
		          });			      
	  }	

</script>
<jsp:include page = "/mainfooter.inc.jsp" />