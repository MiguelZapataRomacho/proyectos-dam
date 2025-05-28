package CuentasRedSocial;

import java.util.Scanner;

public class GestionCuentasyPublicaciones {

		Scanner teclado = new Scanner(System.in);
		GestionFicheros gestionFicheros=new GestionFicheros();
		
		// Métodos cuentas
		protected void crearCuenta () {
			 int tipoCuenta;
			    CuentaUsuario cuenta;
			    ControlExcepciones control = new ControlExcepciones();
			    // Selección tipo de cuenta
			    System.out.print("Si desea una cuenta básica introduzca 1, si desea una cuenta premium introduzca 2: ");
			    do {
			        tipoCuenta = teclado.nextInt();
			        teclado.nextLine();
			        if (tipoCuenta != 1 && tipoCuenta != 2) {
			            System.out.println("Por favor, introduzca una de las opciones válidas (1 o 2).");
			        }
			    } while (tipoCuenta != 1 && tipoCuenta != 2);
			    // Pedir datos por teclado
			    System.out.print("Introduzca su nombre de usuario: ");
			    String nombre = teclado.nextLine();

			    int edad = control.pedirEdadValida(teclado); // Método que pide datos y control de excepciones

			    System.out.print("Introduzca su email: ");
			    String email = teclado.nextLine();

			    int telefono = control.pedirTelefonoValido(teclado); // Método que pide datos y control de excepciones

			    if (tipoCuenta == 1) {
			        cuenta = new CuentaBasica(nombre, email, telefono, edad, 2);
			    } else { // Si es cuenta premium es necesario seleccionar el tipo, lo he implementado en un menú
			        Menus menu = new Menus();
			        String tipoSuscripcion = menu.seleccionarTipoSuscripcion();
			        cuenta = new CuentaPremium(nombre, email, telefono, edad, tipoSuscripcion);
			    }

			    gestionFicheros.guardarCuenta(cuenta);
			    System.out.println("Cuenta creada con éxito.");
			}
		
		protected void mostrarCuenta() {
			System.out.print("Introduce el nombre de usuario: ");
			String nombreUsuario = teclado.nextLine();
			CuentaUsuario cuenta = gestionFicheros.buscarCuenta(nombreUsuario);
	        if (cuenta != null) {
	            cuenta.mostrarInformacion();
	        } else {
	            System.out.println("Cuenta no encontrada.");
	        }
	    }
		
		protected void modificarCuenta() { // Este método solo comprueba si la cuenta es básica o premium y llama al método correspondiente
			    System.out.print("Introduce el nombre de usuario: ");
			    String nombreUsuario = teclado.nextLine();
			    CuentaUsuario cuenta = gestionFicheros.buscarCuenta(nombreUsuario);

			    if (cuenta instanceof CuentaBasica basica) {
			        basica.actualizarPerfil();
			        gestionFicheros.actualizarCuenta(basica);
			    } else if (cuenta instanceof CuentaPremium premium) {
			        premium.actualizarPerfil(); 
			        gestionFicheros.actualizarCuenta(premium);
			    } else {
			        System.out.println("Cuenta no encontrada.\n");
			    }
			}
		
		// Métodos publicaciones
		protected void publicarMensaje() { // Este método solo comprueba si la cuenta es básica o premium y llama al método correspondiente en cuentaBasica/Premium
			System.out.print("Introduce el nombre de usuario: ");
		    String nombreUsuario = teclado.nextLine();
		    CuentaUsuario cuenta = gestionFicheros.buscarCuenta(nombreUsuario);

		    if (cuenta instanceof CuentaBasica basica) {
		        basica.publicarMensaje();
		    } else if (cuenta instanceof CuentaPremium premium) {
		        premium.publicarMensaje();
		    } else {
		        System.out.println("Cuenta no encontrada.\n");
		    }
		}
}
