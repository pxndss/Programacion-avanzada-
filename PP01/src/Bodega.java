
public class Bodega {

	private String bodega;
	private Supermercado supermercado;
	
	public Bodega(String bodega, Supermercado supermercado) {
		this.bodega = bodega;
		this.supermercado = supermercado;
	}
	
	public String getBodega() {
		return bodega;
	}
	
	public Supermercado getSuper() {
		return supermercado;
	}
	
}
