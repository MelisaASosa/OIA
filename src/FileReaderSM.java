import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class FileReaderSM {
	
	private String path;
	
	FileReaderSM(String path) {
		this.path = path;
	}
	
	public int obtenerCantidadTotalValoresValidos() {
		Scanner inScanner = null;
		
		try {
			inScanner = new Scanner(new FileReader(this.path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return inScanner.nextInt();
	}
	
	public int obtenerCantidadTotalSecuenciasLongitudMaxima() {
		Scanner inScanner = null;
		
		try {
			inScanner = new Scanner(new FileReader(this.path));
			inScanner.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return inScanner.nextInt();
	}

	public int[] fileToArray() {
		int[] valores = {};
		Locale.setDefault(Locale.ENGLISH);
		
		try {
			Scanner inScanner = new Scanner(new FileReader(this.path));
			
			int lineas = inScanner.nextInt();
			
			valores = new int[lineas];
			
			for(int i = 0; i < lineas; i++) {
				valores[i] = inScanner.nextInt();
			}
			
			inScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return valores;
	}
}
