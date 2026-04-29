package Veterinaria_elementos;


public class AuthController {
	

		private AuthView vista;
		
		public AuthController() {
		
			vista = new AuthView();
		}
		
		public void login() {
			vista.loginView();
		}
		
		public void Inicio() {
			vista.InicioView();}
		
		
		
			
	}

