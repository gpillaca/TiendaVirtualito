package beans;

public class PedidoBean {
	private int id;
	private int cliente_id;
	private String fecha;
	private double montototal;
	private double igv;
	private double subtotal;
	
	
	
	public PedidoBean() {
	}
	public PedidoBean(int id, int cliente_id, String fecha, double montototal, double igv, double subtotal) {
		this.id = id;
		this.cliente_id = cliente_id;
		this.fecha = fecha;
		this.montototal = montototal;
		this.igv = igv;
		this.subtotal = subtotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getMontototal() {
		return montototal;
	}
	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}
