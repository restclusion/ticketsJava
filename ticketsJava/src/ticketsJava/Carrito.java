package ticketsJava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Carrito {

	private static DecimalFormat decimal = new DecimalFormat("#.##");

	private Producto elProducto;
	private List<Producto> carrito;
	private static final String[] noImpuestos = {"libro", "bombon", "chocolate", "pastilla"};

	private double costeTotal = 0.0;
	private double impuestosTotal = 0.0;

	public Carrito() {
		carrito = new ArrayList<Producto>();
	}

	public void addItem(Producto prod) {
		carrito.add(prod);	
	}

	public List<Producto> getCarrito(){
		return new ArrayList<Producto> (carrito);
	}

	/**
	 * @param 
	 * @return double
	 * 
	 * Devuelve los impuestos totales (incluidos los importados)
	 */	

	public double getImpuestosTotal() {
		for(int i = 0; i < carrito.size(); i++) {
			impuestosTotal += carrito.get(i).calcularImpuestos();
		}
		return impuestosTotal;
	}

	/**
	 * @param 
	 * @return double
	 * 
	 * Devuelve el precio total del carrito de la compra
	 */	

	public double getPrecioTotal() {
		for(int i = 0; i < carrito.size(); i++) {
			costeTotal += carrito.get(i).getPrecio();
		}		
		costeTotal += impuestosTotal;
		decimal.setRoundingMode(RoundingMode.UP);

		return new BigDecimal(costeTotal).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * @param 
	 * @return 
	 * 
	 * Muestra el carrito con formato
	 */	
	public void showCarrito() {
		ListIterator<Producto> iterator = carrito.listIterator();
		while(iterator.hasNext()) {
			Producto item = iterator.next();
			System.out.println(item);
		}
		System.out.println("Impuestos sobre las ventas: " + getImpuestosTotal());
		System.out.println("Total: " + getPrecioTotal());
	}


	/**
	 * @param linea
	 * @return Producto
	 * 
	 * Devuelve Producto en base al String pasado (linea del archivo)
	 */	
	public Producto transformarProducto(String linea) {		
		int cantidad;
		String nombre = "";
		double precio = 0.0;
		boolean llevaImpuesto = true;
		boolean esImportado;	
		boolean breakb = false;

		String[] elem = linea.split(" ");	
		cantidad = Integer.parseInt(elem[0]);

		for (int i = 1; i<elem.length && !breakb; i++) {
			if(elem[i].equals("a")) {
				i = i + 1;
				String temp = elem[i].replaceAll(",",".");
				precio = Double.parseDouble(temp);
				breakb = true;
			}
			else {
				nombre += elem[i] + " ";	
			}
		}		
		for(String item : noImpuestos) {
			if(nombre.indexOf(item) >= 0) {
				llevaImpuesto = false;
			}
		}	
		esImportado = linea.indexOf("importado") >= 0;
		return elProducto = new Producto(cantidad, nombre, llevaImpuesto, esImportado, precio);
	}
}
