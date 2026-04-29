package Controller;

import Views.AuthView;

public class AuthController {
	
	private AuthView vista;
	
	public AuthController() {
		vista = new AuthView();
	}
	
	public void showLogin() {
		vista.Login();
	}
	
	public void showSalir() {
		vista.Salir();
	}
	
	public void showInicio() {
		vista.Inicio();
	}
	
	public void showCostos() {
		vista.Costos();
	}
	
	public void showRegistroCitas() {
		vista.RegistroCitas();
	}
}
