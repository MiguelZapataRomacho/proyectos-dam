package CuentasRedSocial;

import java.util.Scanner;

public class Menus {

	Scanner teclado=new Scanner(System.in);
	GestionCuentasyPublicaciones gestion=new GestionCuentasyPublicaciones();
	GestionFicheros gestionFicheros=new GestionFicheros();
	
	// Métodos del menú principal
	protected void imprimirMenu() {
		System.out.println("1.- Crear una cuenta.");
		System.out.println("2.- Mostrar datos de una cuenta.");
		System.out.println("3.- Actualizar perfil.");
		System.out.println("4.- Publicación.");
		System.out.println("5.- Ver publicaciones.");
		System.out.println("6.- Salir.");
		
	}

	protected void menuPrincipal () {
		int opcion;
		
		do {
			imprimirMenu ();
			System.out.print("Por favor, escoja qué desea hacer: ");
			opcion=teclado.nextInt();
			teclado.nextLine();	
			opcionesMenu (opcion);
		} while (opcion!=6);
	}
	
	protected void opcionesMenu (int opcion) {
		switch (opcion) {
		case 1:
			gestion.crearCuenta();
			break;
		case 2:
			gestion.mostrarCuenta();
			break;
		case 3:
			gestion.modificarCuenta();
			break;
		case 4:
			gestion.publicarMensaje();
			break;
		case 5:
			gestionFicheros.mostrarPublicaciones();
			break;
		case 6: 
			System.out.println("¡Hasta pronto!");
			break;
		default:
			System.out.println("Por favor, introduzca un número del 1 al 6.");
		}
	}
	// Método tipo cuenta premium
	protected String seleccionarTipoSuscripcion () {
		int opcion;
		String tipoSuscripcion = ""; // Inicializo vacía porque si no java no consideraba la variable inicializada en el bucle.
		
		do {
	        System.out.println("Seleccione un tipo de suscripción:");
	        System.out.println("1.- Silver.");
	        System.out.println("2.- Gold.");
	        System.out.println("3.- Platinum.");
	        System.out.print("Opción: ");
	        opcion = teclado.nextInt();
	        teclado.nextLine();

	        switch (opcion) {
	            case 1 -> tipoSuscripcion = "Silver";
	            case 2 -> tipoSuscripcion = "Gold";
	            case 3 -> tipoSuscripcion = "Platinum";
	            default -> System.out.println("Por favor, introduzca un número del 1 al 3.");
	        }
	    } while (!(opcion == 1 || opcion == 2 || opcion == 3));

	    return tipoSuscripcion;
	}
	
	
	
	
}
