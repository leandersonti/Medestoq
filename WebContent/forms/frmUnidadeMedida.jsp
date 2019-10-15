<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<div class="container">

	<div class="card">
		<div class="card-header text-white bg-dark">Cadastrar Unidade de Medida:</div>
		<div class="card-body">

			<form action="#" method="post" name="form1" id="form1" class="needs-validation_" novalidate>
				<s:if test='undmedida.id != null'>
					<input type="hidden" id="id" name="undmedida.id" value="${undmedida.id}">
				</s:if>
				
				<div class="form-row">
					<label for="sigla">*Sigla:</label> 
					<input type="text" class="form-control" id="sigla" name="und.sigla"	placeholder="Informe uma Sigla" value="${und.sigla}" required>
					<div class="invalid-feedback">Por favor, informe uma sigla.</div>
				</div>
				<br />

				<div class="form-row">
					<label for="descricao">*Descrição:</label> 
					<input type="text" class="form-control" id="descricao" name="und.descricao"	placeholder="Informe uma descrição" value="${und.descricao}" required>
					<div class="invalid-feedback">Por favor, informe uma descricao.</div>
				</div>
				<br>
				
				
				<button class="btn btn-success" id="btnSave" type="button">Enviar</button>
			</form>
		</div>
	</div>

</div>
<jsp:include page="/javascripts.jsp" />

<script type="text/javascript">
$(document).ready(function() {
 
	 $("#btnSave").click(function() {
		var URL = ""; 
		if ( $('#id').length ) { URL = "atualizar"; }
		else{ URL = "adicionar";  }	
		if (verificaDados()){
			 swal({
		         title: "Confirma ?",
		         text: "Confirma " + URL + "?",
		         icon: 'warning',
		         buttons: [true, "Salvar"]
		         }).then((result) => {
					if (result) {
						var frm = $("#form1").serialize();						
						$.getJSON({
							url: URL,
							data: frm
					    }).done(function( data ) {					    	
					    	if(data.ret==1)
					    		swal(URL, data.mensagem, "success");
					    	else 
					    		swal(URL, data.mensagem, "error");
						}).fail(function() {
							swal("Adicionar", "Ocorreu um erro ao incluir", "error");
						});
				      } 
			   }); // -- FIM SWAL --
		   }else{
			   swal("Dados", "Verifique os campos obrigatórios ", "error");
		   }
	 	}); // -- FIM btnSave --
	 
});

 function verificaDados(){
    if ($("#form1")[0].checkValidity()===false){
    	$("#form1")[0].classList.add('was-validated');
    	return false;
    }else 
	   return true;
 }
</script>
<jsp:include page="/mainfooter.inc.jsp" />