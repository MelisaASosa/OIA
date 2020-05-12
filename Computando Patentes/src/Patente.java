import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patente {
	
	protected String numero;

	public Patente(String numero) {
		this.numero = numero;
	}

	protected String siguiente(Patente patenteVieja, int k) {
		String resultado = patenteVieja.numero;
		
		for(int i = 0; i < k; i++) {
			resultado = aumentarPatente(resultado);
		}
		
		return resultado;
	}

	private String aumentarPatente(String numero) {
		char[] numeroArray = numero.toCharArray();
		int i = numero.length() - 1;
		boolean aumentarSiguiente = true;
		
		while(aumentarSiguiente && i > 0) {
			aumentarSiguiente = (Character.getNumericValue(numeroArray[i]) == 9 || numeroArray[i] == 'Z') ? true : false;

			numeroArray[i] = getSiguiente(String.valueOf(numeroArray[i])).charAt(0);

			i--;
		}
		
		return new String(numeroArray);
	}

	private String getSiguiente(String caracter) {
		List<String> abecedario = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
		
		int indexAbecedario = abecedario.indexOf(caracter);
		
		if(indexAbecedario != -1) {
			if(indexAbecedario == (abecedario.size() - 1)) {
				return abecedario.get(0);
			}
			return abecedario.get(indexAbecedario + 1);
		}
		
		List<Integer> numeros = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		
		int indexNumeros = numeros.indexOf(new Integer(caracter));
		
		if(indexNumeros != -1) {
			if(indexNumeros == (numeros.size() - 1)) {
				return numeros.get(0).toString();
			}
			return numeros.get(indexNumeros + 1).toString();
		}
		
		return null;
	}
}
