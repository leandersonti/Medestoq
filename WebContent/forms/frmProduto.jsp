<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<div class="container">

	<div class="card">
		<div class="card-header text-white bg-dark">Produtos</div>
		<div class="card-body">

			<form action="#" method="post" name="frmProduto" id="frmProduto" class="needs-validation_" novalidate>
				<s:if test='produto.id != null'>
					<input type="hidden" id="id" name="produto.id" value="${produto.id}">
				</s:if>
				<div class="form-row">
					<label for="descricao">*Descri��o:</label> 
					<input type="text" class="form-control" id="descricao" name="produto.descricao" placeholder="Informe uma descri��o" value="${produto.descricao}" required>
					<div class="invalid-feedback">Por favor, informe uma descricao.</div>
				</div>
				
					<div class="form-row">
						<div class="col-md-4 mb-4">
							<label for="qtdestoque">Quantidade Estoque</label> 
							<input type="number" class="form-control" id="qtdestoque" name="produto.qtdEstoque" placeholder="Informe quantidade do estoque" <s:if test='produto.id != null'>disabled</s:if> value="${produto.qtdEstoque}">
						</div>	
					
					
					<div class="col-md-4 mb-4">
						<label for="qtdminima">Quantidade M�nima:</label> 
						<input type="number" class="form-control" id="qtdminima" name="produto.qtdMinima"	placeholder="Informe a quantidade m�nima" value="${produto.qtdMinima}">
					</div>	
					
					<div class="col-md-4 mb-4">
						<label for="dtValidade">*Data Validade:</label> 
						<input type="date" class="form-control" name="produto.dtValidade" id="dtValidade" value="<s:property value="%{getText('format.dtUSA',{produto.dtValidade})}"/>" required>
						<div class="invalid-feedback">Por favor, informe a data de in�cio.</div>
					</div>
						
				</div>	
				
				<div class="form-row">
						<div class="col-md-4 mb-4">
						<label for="unidadeMedida.id">Unidade Medida :</label> 								
							<s:select label="Tipo" headerKey="-1"
									headerValue="--Selecione--"
									list="lstunidadeMedida" listKey="id"
									listValue="descricao"
									name="produto.unidadeMedida.id"  id="unidadeMedida.id" theme="simple"
									cssClass="form-control" />  
						</div>
						
						<div class="col-md-4 mb-4">
						<label for="grupo.id">Grupo :</label> 								
							<s:select label="Tipo" headerKey="-1"
									headerValue="--Selecione--"
									list="lstgrupo" listKey="id"
									listValue="descricao"
									name="produto.grupo.id"  id="grupo.id" theme="simple"
									cssClass="form-control" />  
						</div>	
						
						<div class="col-md-4 mb-4">
						<label for="tipo.id">Tipo :</label> 								
							<s:select label="Tipo" headerKey="-1"
									headerValue="--Selecione--"
									list="lsttipo" listKey="id"
									listValue="descricao"
									name="produto.tipo.id"  id="tipo.id" theme="simple"
									cssClass="form-control" />  
						</div>		
				
				</div>
				
				<button class="btn btn-success" id="btnSave" type="button">Enviar</button>
			</form>
		</div>
	</div>

</div>
<jsp:include page="/javascripts.jsp" />
<script type="text/javascript" >

//CLICK DO BOT�O SAVE	
$("#btnSave").click(function() {
	console.log("Teste")
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
					var frm = $("#frmProduto").serialize();
					console.log(frm);
					$.getJSON({
						url: URL,
						data: frm
				    }).done(function( data ) {
				    	//if(data.ret==1)
				    		swal(URL, data.mensagem, data.type).then((result) => {
				    			
				    			$('#frmProduto').each (function(){
				    				  this.reset();
				    				});
				    			
				    		});
				    	//else 
				    		//swal(URL, data.mensagem, "error");
					}).fail(function() {
						 swal("Adicionar", "Ocorreu um erro ao incluir", "error");
					});
			      } 
		   }); // -- FIM SWAL --
	   }else{ swal("Dados", "Verifique os campos obrigat�rios!", "error");  }
 	}); 

function verificaDados(){
    if ($("#frmProduto")[0].checkValidity()===false){
    	$("#frmProduto")[0].classList.add('was-validated');
    	return false;
    }else 
	   return true;
 }
 
</script>


<jsp:include page="/mainfooter.inc.jsp" />