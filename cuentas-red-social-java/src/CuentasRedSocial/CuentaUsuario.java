package CuentasRedSocial;

abstract class CuentaUsuario {
	// Atributos
	private String nombreUsuario;
	private String email;
	private int telefono;
	private int edad;
	
	// Constructores
	protected CuentaUsuario() {
	
	}

	protected CuentaUsuario(String nombreUsuario, String email, int telefono, int edad) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
	}
	
	// Getters y setters
	protected String getNombreUsuario() {
		return nombreUsuario;
	}

	protected void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected int getTelefono() {
		return telefono;
	}

	protected void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}
	
	// Método abstracto
	protected abstract void mostrarInformacion ();

	
	
	

}
