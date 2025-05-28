package CuentasRedSocial;

import java.util.Scanner;

public class ControlExcepciones {
	// Excepciones
	protected class TelefonoInvalido extends Exception {
        public TelefonoInvalido(String mensaje) {
            super(mensaje);
        }
    }
	
	protected class EdadInvalida extends Exception {
        public EdadInvalida(String mensaje) {
            super(mensaje);
        }
    }
	// Métodos
	 protected int pedirTelefonoValido(Scanner teclado) {
	        int telefono;
	        
	        while (true) {
	            try {
	                System.out.print("Introduzca su número de teléfono: ");
	                telefono = teclado.nextInt();
	                teclado.nextLine();
	                String telefonoLongitud = String.valueOf(telefono);
	                if (telefonoLongitud.length() != 10) {
	                    throw new TelefonoInvalido("El número de teléfono debe tener 10 dígitos.");
	                }
	                return telefono;
	            } catch (TelefonoInvalido e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	 
	 protected int pedirEdadValida(Scanner teclado) {
	        int edad;
	        
	        while (true) {
	            try {
	                System.out.print("Introduzca su edad: ");
	                edad = teclado.nextInt();
	                teclado.nextLine();
	                if (edad < 16) {
	                    throw new EdadInvalida("La edad mínima para registrarse es de 16 años.");
	                }
	                return edad;
	            } catch (EdadInvalida e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
}
