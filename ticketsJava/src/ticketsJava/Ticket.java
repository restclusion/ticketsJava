package ticketsJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ticket {
	private String caso;
	public static void main(String[] args) throws Exception {
		
		System.out.println("-------------- Sistema de tickets --------------\n");
		System.out.println("-------------- ENTRADAS --------------\n");
		System.out.println("Casos del Enunciado + 1 personal: entrada1, entrada2, entrada3, entrada4 \n");
		System.out.println("Casos de ERROR (formatos incorrectos): entrada5, entrada6 \n");
		System.out.println("Elije NUMERO de entrada: {1, 2, 3, 4, 5, 6}\n");
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		
		try {
			FileInputStream fis = new FileInputStream("entrada" + s + ".txt");
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);

			String linea;
			Producto prod;
			Carrito carrito = new Carrito();
			System.out.println("-----------------");

			while ((linea = br.readLine()) != null)   {		
				prod = carrito.transformarProducto(linea);

				// Anadir producto al carrito
				carrito.addItem(prod);	
			}
			carrito.showCarrito();			
			fis.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
}