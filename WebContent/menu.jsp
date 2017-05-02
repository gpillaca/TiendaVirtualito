<%@page import="beans.CategoriaBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<CategoriaBean> categorias = (ArrayList<CategoriaBean>) request.getAttribute("categorias"); %>
<div class="row">
	<div class="col-md-12">
		<label>CATEGORIA</label>
		<ul>
			<li><a href="<%=getServletContext().getContextPath()%>/Producto">Todos</a></li>
			<%for(CategoriaBean categoria: categorias){ %>
			<li><a href="<%=getServletContext().getContextPath()%>/CategoriaBuscar?id=<%=categoria.getId()%>"><%=categoria.getNombre() %></a></li>
			<%} %>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<form action="<%=getServletContext().getContextPath() %>/ProductoBuscar" method="POST">
		<div class="form-group">
			<label>Buscar</label> 
			<input type="text" name="nombre" id="nombre" class="form-control">
			
		</div>
		<input type="submit" class="btn btn-primary" value="buscar" />
		</form>
	</div>
</div>