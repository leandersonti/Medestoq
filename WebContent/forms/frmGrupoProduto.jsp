<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<div class="container">

	<div class="card">
		<div class="card-header text-white bg-dark">Grupo de Produtos</div>
		<div class="card-body">

			<form action="#" method="post" name="frmGrupo" id="frmGrupo" class="needs-validation_" novalidate>
				<s:if test='grupoProduto.id != null'>
					<input type="hidden" id="id" name="grupoProduto.id" value="${grupoProduto.id}">
				</s:if>
				<div class="form-row">
					<label for="descricao">*Descrição:</label> 
					<input type="text" class="form-control" id="descricao" name="grupoProduto.descricao" placeholder="Informe uma descrição" value="${grupoProduto.descricao}" required>
					<div class="invalid-feedback">Por favor, informe uma descricao.</div>
				</div>
				
				<button class="btn btn-success" id="btnSave" type="button">Enviar</button>
			</form>
		</div>
	</div>

</div>
<jsp:include page="/javascripts.jsp" />
<script type="text/javascript" >

//CLICK DO BOTÃO SAVE	
$("#btnSave").click(function() {
	var URL = "adicionar"; 
	if ( $('#id').length ) { URL = "atualizar"; }

	if (verificaDados()){
		 swal({
	         title: "Confirma ?",
	         text: "Confirma " + URL + "?",
	         icon: 'warning',
	         buttons: [true, "Salvar"]
	         }).then((result) => {
				if (result) {
					var frm = $("#frmGrupo").serialize();
					console.log(frm);
					$.getJSON({
						url: URL,
						data: frm
				    }).done(function( data ) {
				    	//if(data.ret==1)
				    		swal(URL, data.mensagem, data.type).then((result) => {
				    			
				    			$(':input','#frmGrupo')
				    			  .not(':button, :submit, :reset, :hidden')
				    			  .val('')
				    			  .removeAttr('checked')
				    			  .removeAttr('selected');
				    		});
				    	//else 
				    		//swal(URL, data.mensagem, "error");
					}).fail(function() {
						 swal("Adicionar", "Ocorreu um erro ao incluir", "error");
					});
			      } 
		   }); // -- FIM SWAL --
	   }else{ swal("Dados", "Verifique os campos obrigatórios!", "error");  }
 	}); 

function verificaDados(){
    if ($("#frmGrupo")[0].checkValidity()===false){
    	$("#frmGrupo")[0].classList.add('was-validated');
    	return false;
    }else 
	   return true;
 }
 
</script>


<jsp:include page="/mainfooter.inc.jsp" />