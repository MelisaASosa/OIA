import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

	public static List<Integer> fileToArrayInt(String path) {
		List<Integer> valores = new ArrayList<>();
		
		try {
			Scanner inScanner = new Scanner(new FileReader(path));
			
			while(inScanner.hasNext()) {
				valores.add(inScanner.nextInt());
			}
						
			
			inScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return valores;
	}

	public static String readErrorFile(String path) {
		String error = "";
		
		try {
			Scanner inScanner = new Scanner(new FileReader(path));
		
			error = inScanner.nextLine();
			
			inScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return error;
	}
	
	public static void saveResultToFile(int[] resultados, String pathOut) {
		try {
			BufferedWriter outBuffer = new BufferedWriter(new FileWriter(pathOut));

			outBuffer.write(String.valueOf(resultados[0]));
			outBuffer.newLine();
			outBuffer.write(String.valueOf(resultados[1]) + " " + String.valueOf(resultados[2]));

			outBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveErrorToFile(String resultado, String pathOut) {
		try {
			BufferedWriter outBuffer = new BufferedWriter(new FileWriter(pathOut));

			outBuffer.write(resultado);

			outBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	}

}
