<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<div class="container">

	<div class="card">
		<div class="card-header text-white bg-dark">Cadastrar Tipo Produto:</div>
		<div class="card-body">

			<form action="#" method="post" name="frmMovimento" id="" class="needs-validation_" novalidate>
				<s:if test='mov.id != null'>
					<input type="hidden" id="" name="" value="${mov.id}">
				</s:if>
	
				<label for="descricao">*Tipo Movimento:</label>				  			
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
					  <label class="form-check-label" for="exampleRadios1">
					    Entrada
					  </label>  
					</div>    
					<div class="form-check">
					  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
					  <label class="form-check-label" for="exampleRadios2">
					    Saida
					  </label>
					</div>  
				 
				<div class="form-row">
					<label for="descricao">*Descricao:</label> 
					<input type="text" class="form-control" name="mov.motivo" placeholder="Informe uma descrição" required>
					<div class="invalid-feedback">Por favor, informe uma descricao.</div>
				</div>
					<br>
										
				  <div class="form-row">
			    <div class="table-responsive">
			    <table class="table table-sm">
					  <thead>
					    <tr>
					      <th scope="col">Produto</th>
					      <th scope="col">Qtd</th>					      
					      <th scope="col">-</th>
					    </tr>
					    
					  </thead>
					  <tbody>
					    <tr id="rowid0">
					      <td> 
					        <select class="form-control" name="itens[0].produto.id" id="produto0">
					          <option value="1" selected>1</option>
				          </select>
				          </td>					      				          
					      <td><input name="itens[0].qtdItem" id="qtd0" type="text" size="5" value="1" class="form-control"></td>					     
					      <td></td>
					    </tr>
	    				
					  </tbody>
					</table>
			     </div>  
			    
			  </div>
			  				  
			   <button id="add-row" type="button" class="btn btn-sm btn-info">Add Item</button> 
			   <button id="btnSave" type="button" class="btn btn-sm btn-success">Salvar</button>
			   				
			</form>
		</div>
	</div>

</div>

<jsp:include page="/javascripts.jsp" />
<script>

$(document).ready(function() {

	var line = 0;
	
	CarregaProduto(0); 

	$("#add-row").click(function(){
		 line++;
	    var markup ='<tr>'+
				      '<td>'+ 
				        '<select class="form-control" name="itens['+line+'].produto.id" id="produto'+line+'">'+
				                '<option value="1">1</option>'+
			            '</select>'+
			          '</td>'+					      
			          '<td><input name="itens['+line+'].qtdItem" size="5" id="qtd'+line+'" type="text" value="1" class="form-control"></td>'+			      
				      '<td><button class="btn btn-sm btn-danger" onclick="removeRow(this)" type="button"><i class="fa fa-trash-o" aria-hidden="true"></i></button></td>'+
				    '</tr>';
	     $("table tbody").append(markup);
	     CarregaProduto(line);
	});
	
	// CLICK DO BOTÃO SAVE	
	$("#btnSave").click(function() {
		var URL = ""; 
		if ( $('#id').length ) { URL = "atualizar"; }		
		//if (verificaDados()){
			 swal({
		         title: "Confirma ?",
		         text: "Confirma " + URL + "?",
		         icon: 'warning',
		         buttons: [true, "Salvar"]
		         }).then((result) => {
					if (result) {
						console.log(frm);
						var frm = $("#frmMovimento").serialize();
						$.getJSON({
							url: URL,
							data: frm
					    }).done(function( data ) {
					    	//if(data.ret==1)
					    		swal(URL, data.mensagem, data.type);
					    	//else 
					    		//swal(URL, data.mensagem, "error");
						}).fail(function() {
							 swal("Adicionar", "Ocorreu um erro ao incluir", "error");
						});
				      } 
			   }); // -- FIM SWAL --
		  // }else{ swal("Dados", "Verifique os campos obrigatórios!", "error");  }
	 	}); 

});

function CarregaProduto(id){
	  var select = $('#produto'+id);	       
	      select.find('option').remove();	      
			      $.getJSON('../produto/listarCbx',function(jsonResponse) {			    	  
			    	  $('<option>').val(-1).text("Informe o produto").appendTo(select);			    	  
			              $.each(jsonResponse, function(key, value) {
			                $('<option>').val(value.id).text(value.descricao).appendTo(select);
	       			      });
		          });
	  }	

removeRow = function(handler) { 
    var tr = $(handler).closest('tr');
    tr.fadeOut(400, function(){ 
      tr.remove(); 
    }); 
    return false;
  };


/* function verificaDados(){
    if ($("#frmMovimento")[0].checkValidity()===false){
    	$("#frmMovimento")[0].classList.add('was-validated');
    	return false;
    }else 
	   return true;
 } */


</script>
	
<jsp:include page="/mainfooter.inc.jsp" />