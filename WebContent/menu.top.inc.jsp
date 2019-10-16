<!-- MENU TOP -->
<%@page import="br.jus.tream.dominio.BeanLogin"%>
       
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <!--  <a class="navbar-brand" href="#">AnaJÉ</a> -->
      <a class="navbar-brand" href="#">
         <img class="topmnu" src="${pageContext.request.contextPath}/images/brasao2.gif" alt="AnaJé" width="60" height="60"> 
        </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/">MedEstoq<span class="sr-only">(current)</span></a>
          </li>
          
          <li class="nav-item ${produtos}">
             <a class="nav-link" href="${pageContext.request.contextPath}/produto/listar" id="navbarDropdownMenuLink" aria-haspopup="true" aria-expanded="false">Produtos</a>
          </li>
          
          <li class="nav-item ${movimento}">
             <a class="nav-link" href="${pageContext.request.contextPath}/movimento/frmCad" id="navbarDropdownMenuLink" aria-haspopup="true" aria-expanded="false">Movimento</a>	              	                          		             		                               	              	            
          </li>
    
            <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tabelas</a>
	            <div class="dropdown-menu" aria-labelledby="dropdown01">
	              <a class="dropdown-item" href="${pageContext.request.contextPath}/tipoproduto/listar">Tipos de produtos</a>
	              <a class="dropdown-item" href="${pageContext.request.contextPath}/undmedida/listar">Und de Medidas</a>
	              <a class="dropdown-item" href="${pageContext.request.contextPath}/movimento/listar">Movimentos</a>
	              <a class="dropdown-item" href="${pageContext.request.contextPath}/grupoproduto/listar">Grupos</a>	              
	            </div>
	          </li>        
              
        </ul>
        <ul class="nav navbar-nav navbar-right">
             
             <li class="nav-item dropdown">
                <%
			     BeanLogin s = (BeanLogin)session.getAttribute("login");
				  try{
				      if (!s.getNome().equals("")){
			    %>
	             <a class="nav-link dropdown-toggle" href="http://example.com" id="sessionmnu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                <i class="fa fa-user-circle-o" aria-hidden="true"></i> <%=s.getTitulo() + "-" + s.getFirstName()%>
	             </a>
	            <div class="dropdown-menu" aria-labelledby="sessionmnu">
	              <a class="dropdown-item" href="${pageContext.request.contextPath}/login/logout"><i class="fa fa-power-off" aria-hidden="true"></i> Sair</a>
	            </div>
	            
	            <%
				   }
			     }catch (Exception e){
			    	 %>
			    	 <a class="nav-link dropdown-toggle" href="http://example.com" id="sessionmnu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	               				Sessão não iniciada
			             </a>
			            <div class="dropdown-menu" aria-labelledby="sessionmnu">
			              <a class="dropdown-item" href="${pageContext.request.contextPath}/login/frmLogin">Login</a>
			            </div> 
			    <%	 
			     }
				%>
	          </li>
		
				 
			</ul>
				
        <!--  
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form> -->
      </div>
    </nav>
    