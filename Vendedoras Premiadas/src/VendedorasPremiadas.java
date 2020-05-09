import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VendedorasPremiadas {
	
	public void calcular(String pathIn, String pathOut) {
		List<Integer> entrada = FileUtils.fileToArrayInt(pathIn);
		
		int cantidadVendedoras = entrada.get(0);
		int cantidadVentasConsecutivas = entrada.get(entrada.size() - 1);
		
		List<Integer> importesMaximos = new ArrayList<>();
		boolean empatadas = true;
		
		while(empatadas) {
			importesMaximos.clear();
			int proximoIndice = 1;
			
			for(int i = 0; i < cantidadVendedoras; i++) {
				//El primer registro de cada vendedora va a tener la cantidad de ventas
				int cantidadVentas = entrada.get(proximoIndice);
				if(cantidadVentas >= cantidadVentasConsecutivas) {
					int sumaImporte = 0;
					for(int k = proximoIndice+1; k < cantidadVentasConsecutivas + proximoIndice+1; k++) {
						sumaImporte += entrada.get(k);
					}
						
					importesMaximos.add(sumaImporte);
				} else {
					if(importesMaximos.size() > 0) {
						String resultado = "No se puede desempatar";
						FileUtils.saveErrorToFile(resultado, pathOut);
						return;
					}
				}
				
				proximoIndice += cantidadVentas+1;
			}

			empatadas = vendedorasEmpatadas(importesMaximos);
			cantidadVentasConsecutivas++;
		}
		
		if(importesMaximos.size() > 0) {
			int importeMaximo = obtenerMaximo(importesMaximos);
			int[] resultados = {importesMaximos.indexOf(importeMaximo) + 1, cantidadVentasConsecutivas - 1, importeMaximo};
			
			FileUtils.saveResultToFile(resultados, pathOut);
		} else {
			String resultado = "No hay ganadoras";
			FileUtils.saveErrorToFile(resultado, pathOut);
		}
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
		boolean empatadas = false;
		int importe = 0;
		
		for(int i = 0; i < importesMaximos.size(); i++) {
			empatadas &= ((importe == importesMaximos.get(i)) && importe != 0);
			importe = importesMaximos.get(i);
		}
		
		return empatadas;
	}	
	
	/**
	 * Esta funcion solo tiene los importes de una vendedora y calcula los maximos consecutivos entre esos
	 * @param cantidad de ventas consecutivas a evaluar
	 * @param todos los importes de la vendedora
	 * @return
	 */
	/*private int calcularMaximoImporteParaVendedoraNVentas(int n, List<Integer> importesVendedora) {
		int sumaImporte = 0;
		for(int j = 0; j < importesVendedora.size(); j++) {
			int sumaParcial = 0;
			for(int k = j; k < n; k++) {
				sumaParcial += importesVendedora.get(k);
			}
			
			if(sumaParcial > sumaImporte) {
				sumaImporte = sumaParcial;
			}
		}
		
		return sumaImporte;
	}*/

}
