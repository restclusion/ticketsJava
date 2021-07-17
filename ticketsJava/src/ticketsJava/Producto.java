package ticketsJava;

public class Producto {

	private int cantidad;
	private String nombre;
	private boolean llevaImpuesto;
	private boolean esImportado;
	private double precio;
	
	public Producto(int cantidad, String nombre, boolean llevaImpuesto, boolean esImportado, double precio) {
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.llevaImpuesto = llevaImpuesto;
		this.esImportado = esImportado;
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public boolean getImpuesto() {
		return llevaImpuesto;
	}
	
	public boolean getImportado() {
		return esImportado;
	}
	
	public double calcularImpuestos() {
		double impuestosTotal = 0.0;
		if(llevaImpuesto) {
			impuestosTotal += precio * 0.10;
		}
		if(esImportado) {
			impuestosTotal += precio * 0.05;
		}
		return cantidad * impuestosTotal;
	}
	
	public String toString() {
		String prod = this.cantidad + " " + this.nombre + " " + this.precio;
		return prod;
	}
	
}
