package CuentasRedSocial;

import java.util.Scanner;

public class CuentaBasica extends CuentaUsuario implements OperacionesCuenta {
	// Atributos
	private int publicacionesRestantes;

	// Constructores
	protected CuentaBasica() {
		super();
	}

	protected CuentaBasica(String nombreUsuario, String email, int telefono, int edad, int publicacionesRestantes) {
		super(nombreUsuario, email, telefono, edad);
		this.publicacionesRestantes = publicacionesRestantes;
	}

	// Getters y setters
	protected int getPublicacionesRestantes() {
		return publicacionesRestantes;
	}

	protected void setPublicacionesRestantes(int publicacionesRestantes) {
		this.publicacionesRestantes = publicacionesRestantes;
	}

	// Métodos
	@Override
	public void actualizarPerfil() {
	    Scanner teclado = new Scanner(System.in);
	    ControlExcepciones control = new ControlExcepciones();

	    System.out.print("Nuevo email: ");
	    String nuevoEmail = teclado.nextLine();

	    int nuevoTelefono = control.pedirTelefonoValido(teclado); // He integrado pedir la información en el método que controla excepciones

	    setEmail(nuevoEmail);
	    setTelefono(nuevoTelefono);
	    System.out.println("Perfil actualizado correctamente (Cuenta Básica).\n");
	}

	@Override
	public void publicarMensaje() {
		 Scanner teclado = new Scanner(System.in);
		    GestionFicheros gestionFicheros = new GestionFicheros();

		    if (publicacionesRestantes > 0) { //Cuentas básicas tienen un número limitado de publicaciones.
		        System.out.print("Escribe tu mensaje: ");
		        String mensaje = teclado.nextLine();
		        gestionFicheros.guardarPublicacion(getNombreUsuario(), mensaje);
		        publicacionesRestantes--;
		        gestionFicheros.actualizarCuenta(this);
		        System.out.println("Publicación realizada. Te quedan " + publicacionesRestantes + " publicaciones.\n");
		    } else {
		        System.out.println("No te quedan publicaciones disponibles. Puedes mejorar tu cuenta a Premium.\n");
		    }
		}

	@Override
	protected void mostrarInformacion() {
		System.out.println("Cuenta Básica [Publicaciones restantes=" + publicacionesRestantes + ", Nombre de Usuario=" + getNombreUsuario()
		+ ", Email=" + getEmail() + ", Teléfono=" + getTelefono() + ", Edad=" + getEdad() + "]");
		
	}
}
