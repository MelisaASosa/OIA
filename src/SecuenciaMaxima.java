
public class SecuenciaMaxima {

	
	/**
	 * Calcula los resultados de secuencia maxima y devuelve el path del archivo generado
	 * @param path in
	 * @return path out
	 */
	public void calcular(String pathIn, String pathOut) {
		FileReaderSM fr = new FileReaderSM(pathIn);
		int[] valores = fr.fileToArray();
		
		int cantidadValoresValidos = 0;
		int longitud = 0;
		int longitudMaxima = 0;
		int cantidadSecuenciasLongMaxima = 0;
		
		for(int i = 0; i < valores.length; i++) {
			if(esValorValido(valores[i])) {
				cantidadValoresValidos++;
				longitud++;
			} else {
				if(longitud > longitudMaxima) {
					longitudMaxima = longitud;
				}
				longitud = 0;
			}
		}
		
		//La ultima longitud fue la maxima.
		if(longitud > longitudMaxima) {
			longitudMaxima = longitud;
		}
		
		//Si es 0 es porque todos los valores fueron invalidos. No necesito calcular la cantidad.
		if(longitudMaxima > 0) {
			int cont = 0;
			
			for(int i = 0; i < valores.length; i++) {
				if(esValorValido(valores[i])) {
					cont++;
				} else {
					cont = 0;
				}

				if(cont == longitudMaxima) {
					cantidadSecuenciasLongMaxima++;
					cont = 0;
				}
			}
		}
		
		int [] resultados = {cantidadValoresValidos, cantidadSecuenciasLongMaxima};
		FileWriterSM.grabarResultados(pathOut, resultados);
	}
	
	private boolean esValorValido(int numero) {
		return !MathUtils.esMultiploDe(numero, 2) && !MathUtils.esMultiploDe(numero, 3) && !MathUtils.esMultiploDe(numero, 5);
	}
}
