import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)3, resultados.get(0));
		Assert.assertEquals((Integer)2, resultados.get(1));
		Assert.assertEquals((Integer)74, resultados.get(2));
	}

	@Test
	public void ningunaVendedoraLlegaALasVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_ventas_inferiores.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_ventas_inferiores.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		String resultado = FileUtils.readErrorFile(pathOut);
		
		Assert.assertEquals("No hay ganadoras", resultado);
	}

	@Test
	public void unaVendedoraNoLlegaALasVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_no_supera_ventas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_no_supera_ventas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)2, resultados.get(0));
		Assert.assertEquals((Integer)3, resultados.get(1));
		Assert.assertEquals((Integer)92, resultados.get(2));
	}
	
	@Test
	public void lecturaUltimaLinea() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Lectura_ultima_linea.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Lectura_ultima_linea.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)3, resultados.get(0));
		Assert.assertEquals((Integer)2, resultados.get(1));
		Assert.assertEquals((Integer)74, resultados.get(2));
	}
	
	@Test
	public void evaluaVentasConsecutivas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Evaluacion_ventas_consecutivas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Evaluacion_ventas_consecutivas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)2, resultados.get(0));
		Assert.assertEquals((Integer)2, resultados.get(1));
		Assert.assertEquals((Integer)56, resultados.get(2));
	}

	@Test
	public void vendedorasEmpatadas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_empatadas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedoras_empatadas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		String resultado = FileUtils.readErrorFile(pathOut);
		
		Assert.assertEquals("No se puede desempatar", resultado);
	}

	@Test
	public void vendedoraDesempatadaCantidadDeVentas() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_cant_ventas.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_cant_ventas.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)3, resultados.get(0));
		Assert.assertEquals((Integer)4, resultados.get(1));
		Assert.assertEquals((Integer)46, resultados.get(2));
	}

	@Test
	public void vendedoraDesempatadaPorImporte() {
		String pathIn = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_por_importe.in";
		String pathOut = "C:\\Projects\\OIA\\Vendedoras Premiadas\\files\\Vendedora_desempatada_por_importe.out";
		
		vendedorasPremiadas.calcular(pathIn, pathOut);
		
		List<Integer> resultados = FileUtils.fileToArrayInt(pathOut);
		
		Assert.assertEquals((Integer)2, resultados.get(0));
		Assert.assertEquals((Integer)4, resultados.get(1));
		Assert.assertEquals((Integer)50, resultados.get(2));
	}
	
}
