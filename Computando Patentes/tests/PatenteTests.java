import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PatenteTests {
	
	@Test
	public void patenteSiguienteFormatoViejo() {
		Patente patenteVieja = new Patente("ABC151");
		
		String siguiente = patenteVieja.siguiente(patenteVieja, 1);
		
		Assert.assertEquals("ABC152", siguiente);
	}
	
	@Test
	public void patenteSiguienteFormatoViejoCasoLimite() {
		Patente patenteVieja = new Patente("PAT199");
		
		String siguiente = patenteVieja.siguiente(patenteVieja, 1);
		
		Assert.assertEquals("PAT200", siguiente);
	}
	

	@Test
	public void patenteSiguienteFormatoViejoCasoLimiteLetras() {
		Patente patenteVieja = new Patente("QWY999");
		
		String siguiente = patenteVieja.siguiente(patenteVieja, 1);
		
		Assert.assertEquals("QWZ000", siguiente);
	}
	
	
	@Test
	public void patenteSiguienteFormatoNuevo() {
		Patente patenteNueva = new Patente("TE200AW");
		
		String siguiente = patenteNueva.siguiente(patenteNueva, 1);
		
		Assert.assertEquals("TE200AX", siguiente);
	}
	
	@Test
	public void patenteSiguienteFormatoNuevoCasoLimite() {
		Patente patenteNueva = new Patente("PW582YZ");
		
		String siguiente = patenteNueva.siguiente(patenteNueva, 1);
		
		Assert.assertEquals("PW582ZA", siguiente);
	}
	

	@Test
	public void patenteSiguienteFormatoNuevoCasoLimiteNumeros() {
		Patente patenteNueva = new Patente("RT199ZZ");
		
		String siguiente = patenteNueva.siguiente(patenteNueva, 1);
		
		Assert.assertEquals("RT200AA", siguiente);
	}
	
	@Test
	public void tresPatentesMasFormatoViejo() {
		Patente patenteVieja = new Patente("TRY456");
		
		String siguiente = patenteVieja.siguiente(patenteVieja, 3);
		
		Assert.assertEquals("TRY459", siguiente);
	}

	@Test
	public void tresPatentesMasFormatoNuevo() {
		Patente patenteNueva = new Patente("AA513TB");
		
		String siguiente = patenteNueva.siguiente(patenteNueva, 3);
		
		Assert.assertEquals("AA513TE", siguiente);
	}
	
}
