import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CrearArchivoSecuencial {

	private ObjectOutputStream salida;
	
	public void AbrirArchivo(String ruta){
		try {
			salida=new ObjectOutputStream(new FileOutputStream(ruta));
		} catch (FileNotFoundException e) {
			System.err.println("No se encontro el archivo");
		} catch (IOException e) {
			System.err.println("Error con el flujo de salida");
		}
	}
	
	public void AgregarRegistro(){
		RegistroCuentaSeriarizable registro;
		int numeroCuenta=0;//numero de cuenta del objeto
		String nombre;
		String apellido;
		double saldo;
		
		Scanner entrada=new Scanner(System.in);
		System.out.printf("%s\n%s\n%s\n%s\n\n","Para terminar de introducir los datos, escriba el indicador de archivo", 
				"Cuando se le pida que introduzca los datos.","En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima enter",
				"En Windows escriba <ctrl> z y oprima enter");
		
		System.out.printf("%s\n%s", "Escriba el  numero de cuenta (> 0), nombre, apellido, y saldo","?");
		
		while(entrada.hasNext()){
			numeroCuenta=entrada.nextInt();
			nombre=entrada.next();
			apellido=entrada.next();
			saldo=entrada.nextDouble();
			
			if(numeroCuenta>0){
				
				try {
					registro=new RegistroCuentaSeriarizable(numeroCuenta,nombre,apellido,saldo);
					salida.writeObject(registro);
				} catch (IOException e) {
					
				}catch(NoSuchElementException e){
					System.err.println("Entrada no valida");
					entrada.nextLine();
				}
				
			}
			System.out.printf("%s\n%s", "Escriba el numero de cuenta (> 0), nombre, apellido y saldo","?");
		}
	}
	
	public void CerrarArchivo(){
		if(salida!=null){
			try{
				salida.close();
			}catch(IOException e){
				System.err.println("Error al cerrar al¿rchivo");
				System.exit(1);
			}
		}
	}
	
}
