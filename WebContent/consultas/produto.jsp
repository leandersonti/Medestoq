<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />


<div class="container">
     
<div class="card">
  <div class="card-header">Produtos</div>
  <div class="card-body">
  
    <table id="tbeleicao" class="table table-sm table-hover">
	<thead>
		<tr>
			<th width="8%">Id</th>
			<th width="28%">Descrição</th> 

			<th width="15%"><a href="frmCad" class="btn btn-sm btn-primary" role="button">Novo</a>
		    </th>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="lstProduto">
		<tr id="tr${id}"> 
		    <td><s:property value="id"/></td>
			<td><s:property value="descricao"/></td>
		
			
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
<script type="text/javascript">


$( "[id*='excluir']" ).click(function(event) {
    var data = $(event.delegateTarget).data();
	var id = data.recordId; 
	var descricao = data.recordDescricao;
	swal({
		  title: 'Excluir?',
		  text: "Deseja excluir esse registro? (" + descricao + ")",
		  icon: 'warning',
		  buttons: [true, "Sim excluir!"]
		}).then((result) => {
		  if (result) {
		       $.getJSON({
				  url: "remover?produto.id="+id
			   }).done(function( data ) {
			    	  if (data.ret==1){
			    		  $('#tr'+id).fadeOut(); 
			    		  swal("Remover", data.mensagem, data.type);
			    	  }
			    	  else
			    		  swal("Remover", "Ocorreu um erro ao remover", data.type);
				}).fail(function() {
					swal("Remover", "Ocorreu um erro ao remover", "error");
				});
		   }
		})
  });
</script>
<jsp:include page = "/mainfooter.inc.jsp" />