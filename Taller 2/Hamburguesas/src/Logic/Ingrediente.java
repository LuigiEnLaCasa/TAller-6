package Logic;

public class Ingrediente {
	
	//*** Atributos de clase ingrediente ***//
	
	
	private String nombre;
	private int costoAdicional;

	
	///***Métodos de la clase ingrediente***//
	
	public Ingrediente(String nombre, int costoAdicional) {
		this.nombre= nombre;
		this.costoAdicional = costoAdicional;
		
	};
	
	
	public  int getCostoAdicional() {
		
		return this.costoAdicional;};
	
	
	public String getNombre() {return this.nombre;}; 
	
}
