package JUnitTester;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logic.Pedido;

class PedidoTest {

	@BeforeEach
	public void setUp() throws Exception {
		
		Pedido p = new Pedido("Pepe", "Direccion: pruebas");
	}
	
	
	@Test
	void testGetIdPedido() {
		
	}

	@Test
	void testGetNombreCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDireccionCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProductosEnPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPrecioNetoPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testGuardarFactura() {
		fail("Not yet implemented");
	}

	@Test
	void testAgregarProducto() {
		fail("Not yet implemented");
	}

}
