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
	public void ganadoraCorrecta() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Ganadora_correcta.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Ganadora_correcta.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(3, resultados[0]);
		Assert.assertEquals(2, resultados[1]);
		Assert.assertEquals(74, resultados[2]);
	}

	@Test
	public void ningunaVendedoraLlegaALasVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_ventas_inferiores.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_ventas_inferiores.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals("No hay ganadoras", resultados[0]);
	}

	@Test
	public void unaVendedoraNoLlegaALasVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_no_supera_ventas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_no_supera_ventas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(2, resultados[0]);
		Assert.assertEquals(3, resultados[1]);
		Assert.assertEquals(94, resultados[2]);
	}
	
	@Test
	public void lecturaUltimaLinea() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Lectura_ultima_linea.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Lectura_ultima_linea.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(3, resultados[0]);
		Assert.assertEquals(2, resultados[1]);
		Assert.assertEquals(74, resultados[2]);
	}
	
	@Test
	public void evaluaVentasConsecutivas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Evaluacion_ventas_consecutivas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Evaluacion_ventas_consecutivas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(2, resultados[0]);
		Assert.assertEquals(2, resultados[1]);
		Assert.assertEquals(56, resultados[2]);
	}

	@Test
	public void vendedorasEmpatadas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_empatadas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_empatadas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals("No se puede desempatar", resultados[0]);
	}

	@Test
	public void vendedoraDesempatadaCantidadDeVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_cant_ventas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_cant_ventas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(3, resultados[0]);
		Assert.assertEquals(4, resultados[1]);
		Assert.assertEquals(46, resultados[2]);
	}

	@Test
	public void vendedoraDesempatadaPorImporte() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_por_importe.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_por_importe.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		int[] resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals(2, resultados[0]);
		Assert.assertEquals(4, resultados[1]);
		Assert.assertEquals(50, resultados[2]);
	}
}
