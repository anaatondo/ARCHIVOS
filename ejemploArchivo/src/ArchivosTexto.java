import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArchivosTexto {
	
	private String rutaArchivo;
	private File archivo;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ArchivosTexto(String ruta){
		this.rutaArchivo=ruta;
	}
	
	public void leerArchivo(){
		
		try {
			archivo=new File(this.rutaArchivo);
			fr=new FileReader(archivo);//
			br=new BufferedReader(fr);//camino por el cual se enviara la informacion
			String linea;
			while((linea=br.readLine())!=null){
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.err.println("No existe el archivo: "+this.rutaArchivo);
			
		} catch (IOException e) {
			System.err.println("Error en el flujo de lectura del bifferet");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					
					System.err.println("Error al cerrar el archivo");
				}
			}
		}
	}
	
	public void escribirArchivo(){
		try {
			fw=new FileWriter(this.rutaArchivo);
			pw=new PrintWriter(fw);
			for(int i=0; i<10; i++){
				pw.println("Linea: "+i);
			}
		} catch (IOException e) {
			System.err.println("Error de archivo");
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el archivo");
				}
			}
		}
	}

}
