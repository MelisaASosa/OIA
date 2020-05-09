import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class VendedorasPremiadasTests {
	
	private VendedorasPremiadas vendedorasPremiadas;
	
	@Before
	public void setup() {
		vendedorasPremiadas = new VendedorasPremiadas();
	}
	
	@Test
	public void pruebaEjemplo() {
		String pathIn = "";
		String pathOut = "";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(3, resultados[0]);
		Assert.assertEquals(2, resultados[1]);
		Assert.assertEquals(74, resultados[2]);
	}

}
