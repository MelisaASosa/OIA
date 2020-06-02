import java.util.List;

public class Moviles {

	private static List<Integer> colgantes;
	
	public static void getMayorCantidadMoviles(String pathIn, String pathOut) {
		colgantes = FileUtils.readFile(pathIn);
		
		int cantidad = 0;
		int sumaTotal = 0;
		
		for(int i = 0; i < colgantes.size(); i++) {
			for(int j = i+1; j < colgantes.size(); j++) {
				if(colgantes.get(i).equals(colgantes.get(j))) {
					cantidad++;
					sumaTotal += colgantes.get(i) * 2;
				}
			}
		}
		
		FileUtils.writeResponse(pathOut, sumaTotal, cantidad);
	}
}
