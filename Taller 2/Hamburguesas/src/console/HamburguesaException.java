package console;

abstract class HamburguesaException {

	
	public void diagnostico(String message) {
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("POR FAVOR DISCULPANOS HUBO UN ERROR: " + message);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
}
