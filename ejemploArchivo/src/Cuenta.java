
public class Cuenta {
	
	 private int cuenta;
	 private String nombre;
	 private String apellido;
   	 private double saldo;
   	 
	 public Cuenta(){
	       this.cuenta =0;
	       this.nombre = "";
	       this.apellido = "";
	       this.saldo = 0.0;
	   }
	 
	 public Cuenta(int cta, String nombre, String apellido, double saldo){
	    
	     this.cuenta = cta;
	     this.nombre = nombre;
	     this.apellido = apellido;
	     this.saldo = saldo;
	   }

	 public int getCuenta() {
	       return cuenta;
	   }

	 public void setCuenta(int cuenta) {
	       this.cuenta = cuenta;
	    }

	 public String getNombre() {
	       return nombre;
	   }

	 public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	 public String getApellido() {
	        return apellido;
	    }

	 public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	 public double getSaldo() {
	        return saldo;
	    }

	 public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }
}
