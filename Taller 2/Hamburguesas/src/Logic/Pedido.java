package Logic;


import java.util.Random;
import java.util.ArrayList;

public class Pedido {
	
	
	//***  Atributos Pedido   ***///
	
	
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente; 
	public ArrayList<Object> productosPedido = new ArrayList<>();
	
	
	//*** Métodos Pedido ***//
	
	
	
	public Pedido(String nombreCliente, String direccionCliente) {
		
		Random randomInt = new Random(); 
		
		int random = randomInt.nextInt(101);
		this.idPedido = random;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		
		
	};
	//Getters de la clase pedido
	public int getIdPedido() {return this.idPedido;};
	public String getNombreCliente() {return this.nombreCliente;};
	public String getDireccionCliente() {return this.direccionCliente;};
	public ArrayList<Object> getProductosEnPedido(){return this.productosPedido;}
	
	
	
	public int getPrecioNetoPedido() {
		
		//Arraylist con los productos que se han escogido del pedido
		ArrayList<Object> productos = this.productosPedido;
		
		int precioProductos = 0;
		
		for (Object o : productos) {
			
			
			int precioProducto=0;
			
			if(o instanceof ProductoMenu) 	
			{precioProducto = ((ProductoMenu) o).getPrecio();}
			
			else if (o instanceof Ingrediente) 
			{precioProducto = ((Ingrediente) o).getCostoAdicional();}
			
			else if (o instanceof Combo) {precioProducto = ((ProductoMenu) o).getPrecio();}
			
			
			precioProductos= precioProductos + precioProducto;
		
			
			
		}
		
		return precioProductos;
		
	};
	
	
	
	
	
	private int getPrecioTotalPedido() {return 0;};
	
	private Double getPrecioIVAPedido(Double valor) {
		
		Double iva = valor*0.19;
		
		return iva;
		
		
	};
	
	
	
	public StringBuilder guardarFactura() {
		
		
		StringBuilder factura = generarTextoFactura();
		
		return factura;
	};
	
	
	private StringBuilder generarTextoFactura() {
		
		
	
		ArrayList<Object> productos = this.productosPedido;
		
		
		StringBuilder factura = new StringBuilder();
		
		String cabeza= """
				=======================================\n
				|              FACTURA                |\n
				=======================================\n

				""";
		
		
		
		
		
		String id = "| IdPedido : "+ this.idPedido +"\n";
		String nom = "| Nombre Cliente : "+ this.nombreCliente +"\n" ;
		String dir ="| Direccion Cliente : "+ this.direccionCliente+"\n" ;
		
		
		factura.append(cabeza);
		factura.append(id);
		factura.append(nom);
		factura.append(dir);
		
		double precioNeto = 0; 
		
		for (Object o : productos) {
			
			
			int preci0 = 0;
			String n0mbre = "";
			
			if(o instanceof ProductoMenu) {preci0 = ((ProductoMenu) o).getPrecio(); n0mbre= ((ProductoMenu) o).getNombre();}
			else if (o instanceof Ingrediente) {preci0 = ((Ingrediente) o).getCostoAdicional(); n0mbre= ((Ingrediente) o).getNombre();}
			else if (o instanceof Combo) {preci0 = ((ProductoMenu) o).getPrecio(); n0mbre= ((ProductoMenu) o).getNombre();;}
			
			String linea =   "|  -- "+   n0mbre   +"           "+   String.valueOf(preci0) +  "       |\n";
			
			precioNeto= precioNeto + preci0;
			factura.append(linea);
			
			
		}
		
		
		factura.append("=============================\n");
		
		Double iva = getPrecioIVAPedido(precioNeto);
		
		Double precioTotal = iva+precioNeto;
		
		
		String neto = "Valor neto de la compra: "+ String.valueOf(precioNeto)+"\n";
		factura.append(neto);
		
		String iva_string = "Valor del iva de su compra:   " + String.valueOf(iva)+"\n";
		factura.append(iva_string);
		
		String suma = "Valor total de su compra es de: " + String.valueOf(precioTotal)+"\n";
		
		factura.append(suma);
		
		
		
		
		return factura;
		
		};
	
	
	public void agregarProducto(Object nuevoItem) {
		
		
		ArrayList<Object> productos = this.productosPedido;
		
		productos.add(nuevoItem);
		
		this.productosPedido = productos;
		
	};
	
	
	
	
	

}


