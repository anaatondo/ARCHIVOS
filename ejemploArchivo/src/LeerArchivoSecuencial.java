import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;


public class LeerArchivoSecuencial {
	
	private ObjectInputStream entrada;
	
	public void abrirArchivo(String ruta){
		try {
			entrada= new ObjectInputStream(new FileInputStream(ruta));
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		}
	}
	
	public void leerRegistro(){
		RegistroCuentaSeriarizable registro;
		
		System.out.printf("%-10s%-15%-15s%10s\n","Cuenta","Nombre","Apellido","saldo");
		while(true){
			try {
				registro=(RegistroCuentaSeriarizable)entrada.readObject();
				System.out.printf("%-10d%-15s%-15s%11.2f\n",registro.getCuenta(),registro.getNombre(),registro.getApellido(),registro.getSaldo());
			}catch(EOFException e){
				return;
			} catch (IOException e) {
				System.err.println("Error al leer el archivo");
			} catch (ClassNotFoundException e) {
				System.err.println("Archivo no encontrado");
			}
			
		}
	}
	
	public void cerrarArchivo(){
		if(entrada!=null){
			try {
				entrada.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el archivo");
			}
		}
	}

	
	
	

}
