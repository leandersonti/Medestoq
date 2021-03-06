<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />


<div class="container">
     
<div class="card ">
  <div class="card-header text-white bg-dark" >Unidade de Medida</div>
  <div class="card-body">
  
    <table id="tbeleicao" class="table table-sm table-hover">
	<thead>
		<tr>
			<th width="3%">Sigla</th>
			<th width="15%">Descrição</th>

			<th width="2%"><a href="frmCad" class="btn btn-sm btn-primary" role="button">Novo</a>
		    </th>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="lstUnidadeMedida">
		<tr id="tr${id}">
		    <td><s:property value="sigla"/></td>
			<td><s:property value="descricao"/></td>
		
			<td>  		    
				    <a href="frmEditar?und.id=${id}" id="idedit" class="btn btn-sm btn-warning" role="button">
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


<script type="text/javascript">

$(document).ready(function() {
	if($("#tbeleicao").length){
		   $('#tbeleicao').dataTable( {
		        "order": [[ 0, "des" ],[ 1, "des" ]]
		   });
    }
	
});	

// CLICK DO BOTÃO EXCLUIR
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
				  url: "remover?und.id="+id
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