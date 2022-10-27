
public class Venta {

	private Supermercado supermercado;
	private Producto producto;
	private int cantidadVendida;
	private int totalVenta;
	
	public Venta(Supermercado supermercado, Producto producto, int cantidadVendida, int totalVenta) {
	
		this.supermercado = supermercado;
		this.producto = producto;
		this.cantidadVendida = cantidadVendida;
		this.totalVenta = totalVenta;
		
	}
	
	public Supermercado getSupermercado() {
		return supermercado;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public int getCantidadVendida() {
		return cantidadVendida;
	}
	
	public int getTotalVenta() {
		return totalVenta;
	}
	
	
}
