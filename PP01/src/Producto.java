
public class Producto {

	private String producto;
	private int compra;
	private int venta;
	private int cantidad;
	private int ingreso;
	private int caducidad;
	private Bodega bodega;
	
	public Producto(String producto, int compra, int venta, int cantidad, int ingreso, int caducidad, Bodega bodega) {
		
		this.producto = producto;
		this.compra = compra;
		this.venta = venta;
		this.cantidad = cantidad;
		this.ingreso = ingreso;
		this.caducidad = caducidad;
		this.bodega = bodega;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public int getCompra() {
		return compra;
	}
	
	public int getVenta() {
		return venta;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public int getIngreso() {
		return ingreso;
	}
	
	public int getCaducidad() {
		return caducidad;
	}
	
	public Bodega getBodega() {
		return bodega;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}

