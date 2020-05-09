import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterSM {

	public static void grabarResultados(String pathOut, int[] resultados) {
		try {
			BufferedWriter outBuffer = new BufferedWriter(new FileWriter(pathOut));
						
			for(int i = 0; i < resultados.length; i++) {
				outBuffer.write(String.valueOf(resultados[i]));
				outBuffer.newLine();
			}
			
			outBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
