import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class SecuenciaMaximaTests {

	private SecuenciaMaxima secuenciaMaxima;
	
	@Before
	public void setup() {
		secuenciaMaxima = new SecuenciaMaxima();
	}
	
	@Test
	public void pruebaEjemplo() {
		String pathIn = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\ejemplo.in";
		String pathOut = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\ejemplo.out";
		
		secuenciaMaxima.calcular(pathIn, pathOut);
		
		FileReaderSM fr = new FileReaderSM(pathOut);
		
		Assert.assertEquals(fr.obtenerCantidadTotalValoresValidos(), 5);
		Assert.assertEquals(fr.obtenerCantidadTotalSecuenciasLongitudMaxima(), 2);
	}
	
	@Test
	public void ningunValorValido() {
		String pathIn = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\ninguno.in";
		String pathOut = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\ninguno.out";
		
		secuenciaMaxima.calcular(pathIn, pathOut);
		
		FileReaderSM fr = new FileReaderSM(pathOut);
		
		Assert.assertEquals(fr.obtenerCantidadTotalValoresValidos(), 0);
		Assert.assertEquals(fr.obtenerCantidadTotalSecuenciasLongitudMaxima(), 0);
	}
	

	@Test
	public void todosValoresValidos() {
		String pathIn = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\todos.in";
		String pathOut = "C:\\Projects\\OIA-SecuenciasMaximas\\files\\todos.out";
		
		secuenciaMaxima.calcular(pathIn, pathOut);
		
		FileReaderSM fr = new FileReaderSM(pathOut);
		
		Assert.assertEquals(fr.obtenerCantidadTotalValoresValidos(), 4);
		Assert.assertEquals(fr.obtenerCantidadTotalSecuenciasLongitudMaxima(), 1);
	}
}
