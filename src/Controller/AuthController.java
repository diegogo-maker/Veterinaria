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
	
	public void showHistorialCostos() {
		vista.HistorialCostos();
	}
	
	public void showCrearCita() {
	    vista.CrearCita();
	}

	public void showEdicionCita() {
	    vista.EdicionCita();
	}

	public void showCambiosCita() {
	    vista.CambiosCita();
	}

	public void showEliminarCita() {
	    vista.EliminarCita();
	}
	
	public void showPanelDueno() {
		vista.PanelDuenos();
	}
	
	public void showCrearDueno() {
		vista.CrearDueno();
	}
	
	public void showCrearPaciente() {
		vista.CrearPaciente();
	}
	
	public void showEliminarRegistroDueno() {
		vista.EliminarRegistroDueno();
	}
	
	public void showEliminadoExitoso() {
		vista.EliminadoExitoso();
	}
	
	public void showRegistroExitoso() {
		vista.RegistroExitoso();
	}
	
	public void showDetallesDueno() {
		vista.DetallesDueno();
	}
	
	public void showDetallesPaciente() {
		vista.DetallesPaciente();
	}
}
