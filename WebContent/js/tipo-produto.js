$(document).ready(function() {
	if($("#tbeleicao").length){
		   $('#tbeleicao').dataTable( {
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
					  url: "remover?tipoProduto.id="+id
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