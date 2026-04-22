package Veterinaria_elementos;

import javax.swing.*;
import java.awt.*;

public class Ventana_inicio extends JFrame {
	
	public Ventana_inicio() {
		
		//configuracion de ventana
		this.setSize(1400,1024);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(200,200));
		this.setTitle("Veterinaria");
		this.setLocation(0,0);
		this.setResizable(true);
		this.setLayout(null);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
		Image img = icono.getImage();
		Image imgEscalada = img.getScaledInstance(64,64,Image.SCALE_SMOOTH);
		this.setIconImage(imgEscalada);
		
		this.setVisible(true);
	}
	
}
