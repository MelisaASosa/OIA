import java.util.ArrayList;
import java.util.List;

public class VendedorasPremiadas {
	
	public void calcular(String pathIn, String pathOut) {
		List<Integer> entrada = FileUtils.fileToArrayInt(pathIn);
		
		int cantidadVendedoras = entrada.get(0);
		int cantidadVentasConsecutivas = entrada.get(entrada.size() - 1);
		
		List<Integer> importesMaximos = new ArrayList<>();
		boolean empatadas = true;
		boolean huboDesempate = false;
		
		while(empatadas) {
			int proximoIndice = 1;
			int cantidadVendedorasNoLlegan = 0;
			
			for(int i = 0; i < cantidadVendedoras; i++) {
				//El primer registro de cada vendedora va a tener la cantidad de ventas
				int cantidadVentas = entrada.get(proximoIndice);
				int sumaImporte = 0;
				if(cantidadVentas >= cantidadVentasConsecutivas) {
					
					List<Integer> importesVendedora = entrada.subList(proximoIndice + 1, 1 + proximoIndice + entrada.get(proximoIndice));

					sumaImporte = calcularSumaImporteMaximo(importesVendedora, cantidadVentasConsecutivas);
				} else {
					cantidadVendedorasNoLlegan++;
					
					if(cantidadVendedorasNoLlegan == cantidadVendedoras && huboDesempate) {
						String resultado = "No se puede desempatar";
						FileUtils.saveErrorToFile(resultado, pathOut);
						return;
					}
				}
				
				importesMaximos.add(sumaImporte);
				proximoIndice += cantidadVentas+1;
			}

			empatadas = vendedorasEmpatadas(importesMaximos);
			if(empatadas) {
				importesMaximos.clear();
				huboDesempate = true;
			}
			cantidadVentasConsecutivas++;
		}
		
		int importeMaximo = obtenerMaximo(importesMaximos);
		if(importesMaximos.size() > 0 && importeMaximo != 0) {
			int[] resultados = {importesMaximos.indexOf(importeMaximo) + 1, cantidadVentasConsecutivas - 1, importeMaximo};
			
			FileUtils.saveResultToFile(resultados, pathOut);
		} else {
			String resultado = "No hay ganadoras";
			FileUtils.saveErrorToFile(resultado, pathOut);
		}
	}
	
	private int calcularSumaImporteMaximo(List<Integer> importesVendedora, int n) {
		int cont = 0;
		int sum = 0;
		int maximo = 0;
		
		for(int i = 0; i < importesVendedora.size(); i++) {
			for(int j = i; j < i + n; j++) {
				if(j < importesVendedora.size() ) {
					sum += importesVendedora.get(j);
					cont++;
				}
			}
			

			if(sum > maximo && cont == n) {
				maximo = sum;
			}
			sum = 0;
			cont = 0;
		}
		
		return maximo;
	}

	private int obtenerMaximo(List<Integer> importesMaximos) {
		int max = 0;
		
		for(int i : importesMaximos) {
			if(i > max)
				max = i;
		}
		
		return max;
	}

	/**
	 * Esta funcion se fija si del array de importes maximos de todas las vendedoras, hay valores empatados
	 * @param importesMaximos
	 * @return
	 */
	private boolean vendedorasEmpatadas(List<Integer> importesMaximos) {
		if(importesMaximos.size() == 0) {
			return false;
		}
		
		boolean empatadas = false;
		int importe = importesMaximos.get(0);
		
		for(int i = 1; i < importesMaximos.size(); i++) {
			empatadas = empatadas || ((importe == importesMaximos.get(i)) && importe != 0);
			importe = importesMaximos.get(i);
		}
		
		return empatadas;
	}	

}
