package CuentasRedSocial;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Bienvenido, este programa le permite gestionar su cuenta en una red social.");
		Menus menus = new Menus();
		menus.menuPrincipal();
	}
}
