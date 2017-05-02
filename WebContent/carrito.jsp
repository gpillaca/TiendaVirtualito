<%@page import="beans.ProductoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>

<%@include file="header.jsp" %>
<%
	//HttpSession sesion = request.getSession();
	ArrayList<ProductoBean> productos = (ArrayList<ProductoBean>) request.getAttribute("productos");
%>
<div class="container" style="margin-top:20px">
	<div class="row">
		<div class="col-md-3">
			<%@include file="menu.jsp" %>
		</div>
		<div class="col-md-9">
		
			<div>
				<input type="submit" class="btn btn-default" value="Comprar">
				<br>
				<br>
				<table class="table table-hover" width="100%">
					<tr>
						<th>Producto</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Acciones</th>
					</tr>
					
					<% for (int i = 0; i<productos.size(); i++){ %>
					<tr>
						<td><%= productos.get(i).getNombre() %></td>
						<td><%= productos.get(i).getDescripcion() %></td>
						<td><%= productos.get(i).getPrecio() %></td>
						<td> <a href="<%=getServletContext().getContextPath() %>/ProductoEliminar?pos=<%=i%>">Eliminar</a> 
							<a href="<%=getServletContext().getContextPath() %>/Editar?pos=<%=i%>"> Editar</a></td>
						
					</tr>
					<%} %>
				</table>
			</div>
		
		</div>
	</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

<script>
	
</script>

</html>