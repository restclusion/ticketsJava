package ticketsJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Ticket {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("caso3.txt");
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);

			String linea;
			Producto prod;
			Carrito carrito = new Carrito();

			while ((linea = br.readLine()) != null)   {
				
				prod = carrito.transformarProducto(linea);
				prod.calcularImpuestos();
				// Carrito completo
				carrito.addItem(prod);
				
			}
			// Muestra carrito		
			carrito.showCarrito();
			
			fis.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}	

	}
}
