<%@page import="beans.ProductoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">

<% ArrayList<ProductoBean> productos = (ArrayList<ProductoBean>) request.getAttribute("productos"); %>

</head>
<body>

	<%@include file="header.jsp" %>
	
	<div class="container" style="margin-top: 20px">
		<div class="row">
			<!-- Menu -->
			<div class="col-md-3">
				<%@include  file="menu.jsp" %>
			</div>
			
			<!-- contenedor -->
			<div class="col-md-9">
				
				<div class="row">
						<%if (productos.size()==0){ %>
							<label>No se encontraron productos</label>
						<%} %>
						<% for(int i = 0; i < productos.size(); i++){ %>
							<div class="col-md-4" style="margin-bottom: 10px;">
							<div class="card">
							  <img class="card-img-top" style="height: 180px; width: 100%; display: block;" src="<%= getServletContext().getContextPath() %>/img/<%=productos.get(i).getUrl() %>" data-holder-rendered="true">
							  <div class="card-block">
							    <h4 class="card-title"><%=productos.get(i).getNombre() %></h4>
							    <p class="card-text">
							    	<%=productos.get(i).getDescripcion() %><br>
							    	S/.<%=productos.get(i).getPrecio() %>
							    </p>
							    <a href="<%=getServletContext().getContextPath() %>/ProductoAgregarCarrito?id=<%=productos.get(i).getId() %>" class="btn btn-primary">Comprar</a>
							  </div>
							</div>
							</div>
						<%} %>
						
					
					
					
				</div>
				
				
			</div>
		
		</div>
	</div>

</body>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</html>