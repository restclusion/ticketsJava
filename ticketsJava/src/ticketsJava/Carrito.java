package ticketsJava;

import java.util.*;

public class Carrito {

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
	
	public double getImpuestosTotal() {
		for(int i = 0; i < carrito.size(); i++) {
			impuestosTotal += carrito.get(i).calcularImpuestos();
		}
		return impuestosTotal;
	}

	public double getPrecioTotal() {
		for(int i = 0; i < carrito.size(); i++) {
			costeTotal += carrito.get(i).getPrecio();
		}
		return costeTotal + impuestosTotal;
	}
	
	
	public void showCarrito() {
		ListIterator<Producto> iterator = carrito.listIterator();
		while(iterator.hasNext()) {
			Producto item = iterator.next();
			System.out.println(item);
		}
	}
	
	public Producto transformarProducto(String linea) {
		
		int cantidad;
		String nombre = "";
		double precio = 0.0;
		boolean llevaImpuesto = true;
		boolean esImportado;
		
		boolean breakb = false;
		
		String[] elem = linea.split(" ");
		
		cantidad = Integer.parseInt(elem[0]);
		
		//System.out.println(cantidad);
		
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
		
		/**System.out.println(nombre);
		System.out.println(precio + "\n");
		System.out.println("ES IMPORTADO: " + esImportado);
		System.out.println("LLEVA IMPUESTO: " + llevaImpuesto + "\n");**/

		return elProducto = new Producto(cantidad, nombre, llevaImpuesto, esImportado, precio);
	}
	
}
