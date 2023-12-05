package console;

//**Estos imports ayudarán en la carga de datos
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

///*** Estos imports traen las funciones de los demas paquetes o clases. 
import Logic.Pedido;
import Logic.Producto;
import Logic.Ingrediente;
import Logic.ProductoMenu;
import Logic.Combo;




public class Restaurante {

	
	//*** Esta clase solo tiene métodos
	
	
	public Pedido pedidoEnCurso;
	
	
	
	
	
	///METODOS
	public Restaurante(){};
	
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
		Pedido pedido = new Pedido(nombreCliente,direccionCliente);
		
		this.pedidoEnCurso = pedido;
	
	};
	
	
	public void cerrarYGuardarPedido(){};
	
	
	public Pedido getPedidoEnCurso() {return this.pedidoEnCurso;};
	
	public ArrayList<ProductoMenu> getMenuBase() {
		
		
		ArrayList<ProductoMenu> arrayMenuBase = cargarMenu("/Users/luchopinilla/Downloads/ANDES/TERCER/DPOO/Taller 2/data/menu.txt");
		
		
		return arrayMenuBase;};
		
	public ArrayList<Ingrediente> getIngredientes(){
		
		ArrayList<Ingrediente> arrayIngredientes = cargarIngredientes("/Users/luchopinilla/Downloads/ANDES/TERCER/DPOO/Taller 2/data/ingredientes.txt");
		
		
				
		return arrayIngredientes;
		};
		
	public ArrayList<Combo> getCombo(){
		
		ArrayList<Combo> arrayCombo = cargarCombos("/Users/luchopinilla/Downloads/ANDES/TERCER/DPOO/Taller 2/data/combos.txt");
		
		return arrayCombo;}
		
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		};
	
		
		
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                  TALLER   6           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	private static ArrayList<Ingrediente> cargarIngredientes(String archivoIngredientes) {
		
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(archivoIngredientes))){
					
					String line;
					while ((line = reader.readLine()) != null) {
						
						String[] partes = line.split(";");
						if (partes.length == 2) {
							String nombre = partes[0].trim();
							int costoAdicional = Integer.parseInt(partes[1].trim());
							
							
							
							Ingrediente  ingrediente= new Ingrediente(nombre,costoAdicional);
							ingredientes.add(ingrediente);
							
						};
					};
		
					
				}catch(IOException e) {System.err.println("IOException Error");System.out.println("Error al cargar ingredientes");};
				
				
				
				HashSet<String> ingredienteSet = new HashSet<>();
				
				for (Ingrediente i :ingredientes) {
					
					String nombre = i.getNombre();
					
					if(ingredienteSet.contains(nombre)) {
						
						IngredienteRepetidoException ire = new IngredienteRepetidoException();
						ire.ingredienteRepetido();
					}else {ingredienteSet.add(nombre);}
					
				}
				
				
				
				return ingredientes;
		
		
	};
	
	

	private static ArrayList<ProductoMenu> cargarMenu(String archivoMenu)  {
		
		//Crear un mapa de la info que vamos a usar jiij
		
		ArrayList<ProductoMenu> menu = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(archivoMenu))){
			
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] partes = line.split(";");
				if (partes.length == 2) {
					String nombre = partes[0].trim();
					int precio = Integer.parseInt(partes[1].trim());
					
					
					
					ProductoMenu  producto= new ProductoMenu(nombre,precio);
					menu.add(producto);
					
				};
			};
			
		}catch(IOException e) {System.err.println("IOException Error");System.out.println("Error al cargar Menú");};
		
		
		HashSet<String> productoSet = new HashSet<>();
		
		for (ProductoMenu p : menu) {
			
			String nombre = p.getNombre();
			
			if(productoSet.contains(nombre)) {
				
				ProductoRepetidoException ire = new ProductoRepetidoException();
				ire.productoRepetido();
			}else {productoSet.add(nombre);}
			
		}
		
		
		
		return menu;
	};
	
	
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX                  TALLER   6           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	private static ArrayList<Combo> cargarCombos(String archivoCombos) {;
	
	
		ArrayList<Combo> combos = new ArrayList<>();
		
		
		//Crear un mapa de la info que vamos a usar jiij
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(archivoCombos))){
			
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] partes = line.split(";");
				
					String nombreCombo = partes[0].trim();
					
					Double descuento = Double.parseDouble(partes[1].replaceAll("%", ""));
					
					String papas = partes[2].trim();
					
					String bebida = partes[3].trim();
				
				Combo combo= new Combo(nombreCombo,papas,bebida,descuento);
				combos.add(combo);
					
					
			
			};
			
		}catch(IOException e) {System.err.println("IOException Error"); System.out.println("Error al cargar combos");};
		
		
		return combos;
		
	}
	


	
	
	
	
	
	
	
}

