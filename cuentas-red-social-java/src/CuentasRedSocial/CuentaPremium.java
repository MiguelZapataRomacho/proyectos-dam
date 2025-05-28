package CuentasRedSocial;

import java.util.Scanner;

public class CuentaPremium extends CuentaUsuario implements OperacionesCuenta {
	// Atributos
	private String tipoSuscripcion;

	
	
	// Constructores 
	protected CuentaPremium() {
		super();
	}
	
	protected CuentaPremium(String nombreUsuario, String email, int telefono, int edad, String tipoSuscripcion) {
		super(nombreUsuario, email, telefono, edad);
		this.tipoSuscripcion = tipoSuscripcion;
	}

	// Getters y setters
	
	protected String getTipoSuscripcion() {
		return tipoSuscripcion;
	}

	protected void setTipoSuscripcion(String tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}
	
	// Métodos
	@Override
	public void actualizarPerfil() {
	    Scanner teclado = new Scanner(System.in);
	    Menus menus = new Menus();
	    ControlExcepciones control = new ControlExcepciones();

	    System.out.print("Nuevo email: ");
	    String nuevoEmail = teclado.nextLine();

	    int nuevoTelefono = control.pedirTelefonoValido(teclado);

	    String nuevaSuscripcion = menus.seleccionarTipoSuscripcion();

	    setEmail(nuevoEmail);
	    setTelefono(nuevoTelefono);
	    setTipoSuscripcion(nuevaSuscripcion);

	    System.out.println("Perfil actualizado correctamente (Cuenta Premium).\n");
	}

	@Override
	public void publicarMensaje() {
		 Scanner teclado = new Scanner(System.in);
		    GestionFicheros gestionFicheros = new GestionFicheros();

		    System.out.print("Escribe tu mensaje: ");
		    String mensaje = teclado.nextLine();
		    gestionFicheros.guardarPublicacion(getNombreUsuario(), mensaje);
		    System.out.println("Publicación realizada. Tienes un número ilimitado de publicaciones.\n");
		}

	@Override
	protected void mostrarInformacion() {
		System.out.println("CuentaPremium [Tipo de Suscripcion=" + tipoSuscripcion + ", Nombre de Usuario=" + getNombreUsuario()
		+ ", Email=" + getEmail() + ", Teléfono=" + getTelefono() + ", Edad=" + getEdad() + "]");
		
	}


	
}
