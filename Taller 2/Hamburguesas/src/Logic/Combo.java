package Logic;

public class Combo {
	
	//*** Atributos Combo ***//
	
	private double descuento;
	private String nombreCombo; 
	private String papas;
	private String bebida;
	private int precioCombo;
	
	
	//*** Métodos Combo ***//
	
	public Combo( String nombreCombo, String papas, String bebida ,double descuento) {
		
		this.nombreCombo= nombreCombo;
		this.papas = papas;
		this.bebida= bebida;
		this.descuento = descuento;
		
	}
	
	
	
	public void agregarItemACombo(Producto itemCombo) {}
		
	public String generarTextoFactura() {return "";}
	
	public String getNombre() {return  this.nombreCombo;}

	public String getPapas() {return this.papas;}
	
	public String getBebida() {return this.bebida;}
	
	public Double getDescuento() {return this.descuento;}
	
	public Double calculatePrecioCombo() {return 0.0;}
	
	public int getPrecio() {return this.precioCombo;}

	
	
}