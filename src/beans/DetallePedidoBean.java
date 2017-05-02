package beans;

public class DetallePedidoBean {
	private int pedido_id;
	private int producto_id;
	private double precio;
	private int cantidad;
	
	
	public DetallePedidoBean() {
	}
	public DetallePedidoBean(int pedido_id, int producto_id, double precio, int cantidad) {
		this.pedido_id = pedido_id;
		this.producto_id = producto_id;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}	
