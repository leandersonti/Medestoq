<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<div class="container">

	<div class="card">
		<div class="card-header text-white bg-dark">Cadastrar Tipo Produto:</div>
		<div class="card-body">

			<form action="#" method="post" name="frmUnidadeMedida" id="" class="needs-validation_" novalidate>
				<s:if test='eleicao.id != null'>
					<input type="hidden" id="" name="" value="${eleicao.id}">
				</s:if>
	
				<div class="form-row">
					<label for="descricao">*Descrição:</label> 
					<input type="text" class="form-control" id="" name=""	placeholder="Informe uma descrição" value="" required>
					<div class="invalid-feedback">Por favor, informe uma descricao.</div>
				</div>
				<br>
				
				<button class="btn btn-success" id="btnSave" type="button">Enviar</button>
			</form>
		</div>
	</div>

</div>

<jsp:include page="/javascripts.jsp" />
<script src="${pageContext.request.contextPath}/js/eleicao.js" charset="utf-8"></script>
	
<jsp:include page="/mainfooter.inc.jsp" />