import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
	
	public static List<Integer> readFile(String path) {
		List<Integer> colgantes = new ArrayList<>();
		
		try {
			Scanner inScanner = new Scanner(new FileReader(path));

			int cantidad = inScanner.nextInt();
			while(inScanner.hasNext()) {
				colgantes.add(inScanner.nextInt());
			}
			
			inScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return colgantes;
	}
	
	public static void writeResponse(String path, int pesoTotal, int cantidadVarillas) {
		try {
			BufferedWriter outBuffer = new BufferedWriter(new FileWriter(path));

			outBuffer.write(String.valueOf(pesoTotal + " " + cantidadVarillas));

			outBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
