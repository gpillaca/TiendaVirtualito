package beans;

public class ProductoBean {
	
	private int id;
	private String nombre;
	private double precio;
	private String descripcion;
	private int categoria_id;
	private String categoria;
	private String url;
	
	
	
	public ProductoBean() {
	}
	
	
	
	public ProductoBean(int id, String nombre, double precio, String descripcion, int categoria_id, String categoria,
			String url) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria_id = categoria_id;
		this.categoria = categoria;
		this.url = url;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
