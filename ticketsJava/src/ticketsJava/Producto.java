package ticketsJava;

import java.text.DecimalFormat;

public class Producto {

	private int cantidad;
	private String nombre;
	private boolean llevaImpuesto;
	private boolean esImportado;
	private double precio;
	private static DecimalFormat decimal = new DecimalFormat("#.##");

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

	private double redondearImp(double imp){
		return Math.ceil((imp * 20.0)) / 20.0;
	}

	/**
	 * @param 
	 * @return double
	 * 
	 * Devuelve los impuestos totales de un producto
	 */	

	public double calcularImpuestos() {
		double impuestosTotal = 0.0;
		if(llevaImpuesto) {
			impuestosTotal += precio * 0.10;
		}
		if(esImportado) {
			impuestosTotal += precio * 0.05;
		}
		return cantidad * redondearImp(impuestosTotal);
	}

	public String precioIndiv() {
		return decimal.format(calcularImpuestos() + this.precio);
	}

	public String toString() {
		String prod = this.cantidad + " " + this.nombre + ": " + precioIndiv() + " €";
		return prod;
	}
}
