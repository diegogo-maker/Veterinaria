package Veterinaria_elementos;

import javax.swing.JFrame;

import Controller.AuthController;

import java.awt.Color;
import java.awt.Dimension;


public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ventana_inicio miVentana = new Ventana_inicio();
		
		AuthController ac = new AuthController();		
		ac.showLogin();
	}

}
