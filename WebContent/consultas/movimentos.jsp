<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />


<div class="container">
     
<div class="card">

  <div class="card-header">Movimentos</div>
  <div class="card-body">
  
    <table id="tbmovimento" class="table table-sm table-hover">
	<thead>
		<tr>
			<th width="25%">Dt. Movimento</th>
			<th width="15%">Tipo</th>
			<th width="18%">Descrição</th>
			
			<th width="15%"><a href="frmCad" class="btn btn-sm btn-primary" role="button">Novo</a>
		    </th> 
		</tr>
	</thead>
	
			 <!-- Modal -->
		<div class="modal fade" id="situacaomovi" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Situação</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		            <div id="situacao"> </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
   
	
	<tbody>
	<s:iterator value="lstMovimento">
		<tr id="tr${id}">
		    <td><s:property value="%{getText('format.date',{dtMovimento})}"/></td>
			<td>
				<s:if test="isRecebimento == 1">
					Entrada
				</s:if>
				<s:else>
					Saida
				</s:else>
			</td>
			<td><s:property value="motivo"/></td>		
			<td>  		    
			
				   <a href="#" id="#situacao" class="btn btn-sm btn-secondary" data-toggle="modal" data-itemid="${id}" data-target="#situacaomovi">
				   <i class="fa fa-search" aria-hidden="true"></i>
					
				   
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
<script>
$(document).ready(function() {
	if($("#tbmovimento").length){
		   $('#tbmovimento').dataTable( {
		        "order": [[ 0, "des" ],[ 1, "des" ]]
		   });
    }
	
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
					  url: "remover?mov.id="+id
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
});

// ------- MODAL PARA CONSULTAR COMANDA ---------------------
$('#situacaomovi').on('show.bs.modal', function (event) {
	  var href = $(event.relatedTarget)
	  var id = href.data('itemid') 
	  var vUrl = "getBeanLimpo?mov.id="+id;
	  $.ajax({
		    url: vUrl,
		    dataType: 'html',
		    success: function(data) {
	           $('#situacao').html(data);
		    }
		});
	});
	

</script>

<jsp:include page = "/mainfooter.inc.jsp" />
