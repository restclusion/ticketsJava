package ticketsJava;

import java.text.NumberFormat;
import java.util.*;

public class Carrito {

	private List<Producto> carrito;
	private static final String[] noImpuestos = {"libro", "bombon", "chocolate", "pastilla"};
	
	public Carrito() {
		carrito = new ArrayList<Producto>();
	}
	
	
	public void addItem(Producto prod) {
		//carrito.add(parseLine(lineaFich));		
		this.carrito.add(prod);	
	}
	
	
	public void showCarrito() {
		ListIterator<Producto> iterator = carrito.listIterator();
		while(iterator.hasNext()) {
			Producto item1 = iterator.next();
			System.out.println(item1);
		}
	}
	
	public void transformarProducto(String linea) {
		
		Producto elProducto;
		
		int cantidad;
		String nombre = "";
		double precio = 0.0;
		boolean llevaImpuesto = true;
		boolean esImportado;
		
		boolean breakb = false;
		
		String[] elem = linea.split(" ");
		
		cantidad = Integer.parseInt(elem[0]);
		
		System.out.println(cantidad);
		
		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		
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
		
		System.out.println(nombre);
		System.out.println(precio + "\n");
		System.out.println("ES IMPORTADO: " + esImportado);
		System.out.println("LLEVA IMPUESTO: " + llevaImpuesto + "\n");

		//return elProducto;
	}
	
}
