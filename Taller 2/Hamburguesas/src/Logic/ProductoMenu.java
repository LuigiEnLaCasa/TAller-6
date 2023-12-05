package Logic;

public class ProductoMenu implements Producto {
	
	
	//*** Atributos Clase menú ***//
	
	private String nombre ;
	private int precioBase;
	
	
	//*** Métodos Calse producto menú ***//
	
	
	public ProductoMenu(String nombre, int precioBase) {
		
		this.nombre = nombre;
		this.precioBase = precioBase;
		
	}


	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return this.precioBase;
	}


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}


	
	///XXXXXXXXXXXXXXXXXXXX TALLER 6 XXXXXXXXXXXXXXXXXXX 
	//REVISAR LA CALSE PRODUCTO MENU TEST
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	};

	
	
}
