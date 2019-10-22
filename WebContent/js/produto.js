$(document).ready(function() {
	
	


	CarregaTipo();
	CarregaGrupo();
	
	if($("#tbproduto").length){
		   $('#tbproduto').dataTable( {
			   dom: 'Bfrtip',
			   buttons: [{
				      extend: 'excelHtml5',
				      exportOptions: {
		                    columns: [ 0, 1, 2, 3, 4, 5 ]
		              },
				      customize: function (xlsx) {
				        var sheet = xlsx.xl.worksheets['sheet1.xml'];
				        
				        $('row c[r^="F"]', sheet).each( function () {
		                    // Get the value
		                    if ( $('is t', this).text() == 'Estoque baixo' ) {
		                    	$(this).attr( 's', "22" );
		                    } else if ( $('is t', this).text() == 'Vencimento em breve' ) {
		                        $(this).attr( 's', '17' );
		                    } else if ( $('is t', this).text() == 'Vencido' ) {
		                        $(this).attr( 's', '10' );
		                    }
		                    
		                    
		                });
				        
				      }
				  }],
		        
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
	

	    var buttonCommon = {
	        exportOptions: {
	            format: {
	                body: function ( data, row, column, node ) {
	                    // Strip $ from salary column to make it numeric
	                    return column === 5 ?
	                        data.replace( /[$,]/g, '' ) :
	                        data;
	                }
	            }
	        }
	    };
	 
	    
	
	
	
	
	
	

