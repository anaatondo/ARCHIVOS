import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CrearArchivo {
    
    private Formatter salida;
    public void abrirArchivo(String url){
        try {
            salida = new Formatter(url);
        } catch (FileNotFoundException ex) {
            System.err.println("Error al crear el archivo");
            System.exit(1);
        }
    }
    
    public void agregarRegistro(){
        Cuenta registro = new Cuenta();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el numero de cuenta > 0, nombre, apellido y saldo");
        while(entrada.hasNext()){
            try{
                registro.setCuenta(entrada.nextInt());
                registro.setNombre(entrada.next());
                registro.setApellido(entrada.next());
                registro.setSaldo(entrada.nextDouble());
                
                if(registro.getCuenta() > 0){
                    salida.format("%d %s %s %.2f\n", registro.getCuenta(), registro.getNombre(), registro.getApellido(), registro.getSaldo());
                }else{
                     System.out.println("Elnumero de cuenta debe ser mayor a 0");
                }
            }catch(FormatterClosedException ex){
                 System.err.println("Error al escribir en el archivo");
                 return;
            }catch(NoSuchElementException ex){
                 System.err.println("Entrada invalida");
                 entrada.nextLine();
            }
        
        }
    }
    
    public void cerrarArchivo(){
        if(salida!= null){
            salida.close();
        }
    }
    
}
