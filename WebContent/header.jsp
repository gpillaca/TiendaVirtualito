<%@page import="java.util.ArrayList"%>
<%@page import="beans.ClienteBean"%>
<%
	HttpSession sesion = request.getSession();
	ClienteBean usuario = (ClienteBean) sesion.getAttribute("usuario");
	ArrayList<String> carrito = (ArrayList<String>) sesion.getAttribute("productos");
%>
<nav class="navbar sticky-top navbar-toggleable-sm navbar-inverse bg-inverse">
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<a class="navbar-brand" href="#">
		    GP
		</a>
		 <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav mr-auto">
		      	<a class="nav-item nav-link active" href="<%=getServletContext().getContextPath()%>/Producto">Productos</a>
		      	<a class="nav-item nav-link" href="<%=getServletContext().getContextPath()%>/Carrito">Carrito
		      	<%if (sesion.getAttribute("productos") != null){ %>
						(<%= carrito.size() %>)
				<%} %>
		      	</a>
		      	<a class="nav-item nav-link" href="<%=getServletContext().getContextPath()%>/Pedidos">Pedidos</a>
	    	</div>
	    	
	    	<div>
	    		
	    		
	    		<a class="nav-item nav-link" href="<%=getServletContext().getContextPath()%>/Login">
	    		<% if(sesion.getAttribute("usuario") == null){%>
	    			Iniciar Sesi&oacute;n
				<% } else { %>
					<%= usuario.getNombre() + " " + usuario.getApellido() %> | Cerrar Sesi&oacute;n
				<%} %>
	    		</a>
	    	</div>
	    </div>
</nav>