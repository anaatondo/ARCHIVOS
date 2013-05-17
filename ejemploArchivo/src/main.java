
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArchivosTexto aplicacion=new ArchivosTexto("datos.txt");
		aplicacion.leerArchivo();
		aplicacion.escribirArchivo();
		
		CrearArchivo ca=new CrearArchivo();
		ca.abrirArchivo("Cuenta.txt");
		ca.agregarRegistro();
		ca.cerrarArchivo();
		
	/*	CrearArchivoSecuencial aplicacion=new CrearArchivoSecuencial();
		aplicacion.AbrirArchivo("Clientes.txt");
		aplicacion.AgregarRegistro();
		aplicacion.CerrarArchivo();*/
		
		/*LeerArchivoSecuencial aplicacion=new LeerArchivoSecuencial();
		aplicacion.abrirArchivo("Clientes.txt");
		aplicacion.leerRegistro();
		aplicacion.cerrarArchivo();*/
		
	}

}
