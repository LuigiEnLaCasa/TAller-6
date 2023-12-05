
package View;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import console.Restaurante;
import console.SobreCosto;
import Logic.ProductoMenu;
import Logic.Ingrediente;
import Logic.Combo;
import Logic.Pedido;
import Logic.Producto;


public class Aplicacion {

	
	public void mostrarMenu() {
		
		//menú de opciones que va a ver el usuario en consola
		
		System.out.println("=========================================");
		System.out.println("\nOpciones para su orden :)\n");
		System.out.println("1. Mostrar Menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar info de pedido dado su id");
		System.out.println("0. Cerrar aplicación\n");
		
		
		
		
	};
	
	
	
	public void mostrarMenuIngredienteMenu() {
		
		System.out.println("\nQue parte del menu desea ver:)");
		System.out.println("---------------------------------");
		System.out.println("\nRecuerde ver todo pa ver de que se le antoja (en serio)");
		System.out.println("1. Productos ");
		System.out.println("2. Ingredientes");
		System.out.println("3. Combos");
		//System.out.println("0. Regresar");
		
	};
	
	
	
	public int preguntarOpcion() {
		
		mostrarMenu();
		
		System.out.print("Escoge alguna de las opciones: ");
		
		Scanner scanner = new Scanner(System.in);
		
		int opcionSeleccionada= scanner.nextInt();
		
		scanner.close();
		
		return opcionSeleccionada;
		
	};
	
/*
	public HashMap<Integer,Object> mapOrganizerX(HashMap<Integer, Object>  todoMap){
		
		HashMap<Integer,Object> organized_map = new HashMap<>();
			
	
		List<Integer> sortedKeys = new ArrayList<>(todoMap.keySet());
	    Collections.sort(sortedKeys);
	
	    // Iterate through the sorted keys and access the corresponding values
	    for (Integer key : sortedKeys) {
	        Object value = todoMap.get(key);
	        organized_map.put(key, value);
	        
	    }
        
	
	return organized_map;
		
	}

*/
	
	
	
	public void ejecutarOpcion() {
		
		
		HashMap<Integer,Object> todoMap = new HashMap<>();
		Restaurante restaurante = new Restaurante();
		
		boolean continuar = true; 
		
		while(continuar) {
			
			try {
				
				//se solicita periódicamente que el usuario vaya escogiendo opciones
				mostrarMenu();
				System.out.print("Escoge alguna de las opciones: ");
				
				Scanner scanner = new Scanner(System.in);
				
				int opcionSeleccionada= scanner.nextInt();
				
				
				///////////////////// aquí se instancia el tipo restaurante
				
				
				
				ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
				ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
				
				ArrayList<Combo> combos =restaurante.getCombo();
				
				

				
				
				
				
				 //Aquí se llama a las funciones de la clase restaurante para ejecutar lo que haya que ejecutar. 
			
				if (opcionSeleccionada == 1) {
					
					System.out.println("\n================= SUPER MENÚ =================");
					
					mostrarMenuIngredienteMenu();
					
					
					Scanner scanner2 = new Scanner(System.in);
					
					int opcionSeleccionada2 = scanner.nextInt();
					
					if(opcionSeleccionada2 ==1) {
						
						//Imprime la información del menu
						
						System.out.println("==========================");
						System.out.println("PRODUCTOS");
						int i = 0;
						for (ProductoMenu p : menu) {
							i++;
							
							todoMap.put(i, p);
							System.out.println(i+". "+ p.getNombre()+ ": "+ p.getPrecio()+" COP");
							};
							//Eliminar todo esto de aquí
							
							
						
					}
					
					else if (opcionSeleccionada2==2) {
						
						
						System.out.println("==========================");
						System.out.println("INGREDIENTES");
						
						
						int c=22;
						for (Ingrediente ing : ingredientes) {
							c++;
							
							todoMap.put(c, ing);
							
							System.out.println(c+". "+ ing.getNombre()+ ": "+ ing.getCostoAdicional()+" COP");
							};
							//Eliminar todo esto de aquí
							
							
							
					}
					else if (opcionSeleccionada2==3) {
						
						System.out.println("==========================");
						System.out.println("COMBOS");
		
						;
						int a = 37;
						for(Combo c: combos) {
							
							a++;
							todoMap.put(a, c);
							System.out.println(a+". " +  c.getNombre() + "+ "+ c.getBebida()+"+ "+c.getPapas()+"+ "+c.getDescuento() +"% Discount");
							
						}
						
						//Eliminar todo esto de aquí
						
						
					}
					
					else if(opcionSeleccionada2==512) {
						
						System.out.println("");
						scanner2.close();
						
					
					}
					
					//XXXXXXXXXXX
					
					
					
				}
				
				else if (opcionSeleccionada== 2) {
					
					System.out.println("\nINICIANDO NUEVO PEDIDO...");
					
					
					Scanner scannerPedido = new Scanner(System.in);
					System.out.println("Nombre del cliente: ");
					
					String nombreCliente = scannerPedido.nextLine();
					
					System.out.println("Su direccion: ");
							
					String direccionCliente = scannerPedido.nextLine() ;
					
					
					restaurante.iniciarPedido(nombreCliente, direccionCliente);
				
					
					Pedido p = restaurante.getPedidoEnCurso();
					
					System.out.println("Su pedido es el # " + p.getIdPedido());
					
					;}
				
				
				
				
				
				
				
				
				else if (opcionSeleccionada== 3 ) {
					
					System.out.println("Que producto desea añadir a su pedido: \n>");
					Scanner scannerAnadir = new Scanner(System.in);
					int opcion = scanner.nextInt();
					
					
					Object productoAnadir = todoMap.get(opcion);
					
					
					
					Pedido p = restaurante.getPedidoEnCurso();
					int precioTemporal = p.getPrecioNetoPedido();
					
					try {
					
						
						
						//  
						
					p.agregarProducto(productoAnadir);
					
					System.out.println("Hasta ahora su pedido trae:\n");
					
					for(Object o : restaurante.getPedidoEnCurso().productosPedido ) {
						
					    if ( ((ProductoMenu) o).getPrecio()+precioTemporal>=150000) {
					    	
					    	throw new SobreCosto("NO se puede añadir el producto, pues su pedido se pasa del limite 150k iría " + precioTemporal);
					    }
						else if(o instanceof ProductoMenu) {System.out.println("Producto " + ((ProductoMenu) o).getNombre());}
						else if (o instanceof Ingrediente) {System.out.println("Ingrediente: "+ ((Ingrediente) o).getNombre());}
						else if (o instanceof Combo) {System.out.println("Combo: " +((Combo) o).getNombre());}
						
						
							;}
					
					
					
					
					System.out.println("\nSu pedido tiene un costo de "+ String.valueOf(precioTemporal)+ " (límite de 150.000)");
						
					}catch( SobreCosto e) {
						
						System.out.println(e.getMessage());
					}
					
					
					
				
				
				
				
				}
				
				
				
				
	
				
				
				else if (opcionSeleccionada== 4) {
					
					System.out.println("escogiste 4");
					
					Pedido pedido = restaurante.getPedidoEnCurso();
					
					StringBuilder factura= pedido.guardarFactura();
					
					System.out.println(factura);
				
				}
				
				
				
				
				
				
				
				else if (opcionSeleccionada== 5) {System.out.println("escogiste 5");
				
				
				}
					
				
				else if (opcionSeleccionada==0) {
					System.out.println("\nGracias por pedir en Hamburguesas.Zip ");  
					continuar= false; 
					
					//AQUÍ SE CIERRA EL SCANNER DEL MENU PRINCIPAL
					
					scanner.close();}
				
				else {System.out.println("Escoge una opción válida, intenta de nuevo");}
				
				
				
			}
			
			catch(NumberFormatException e){ System.out.println("Debe seleccionar una de las opciones, por favor intente de nuevo");}
			
		}
		
		
		
		
		
		
		
		
	};
	
	
}
