package Veterinaria_elementos;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

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
		

		JLabel etiquetaTitulo = new JLabel("Veterinaria", SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Serif", Font.BOLD, 28));
		etiquetaTitulo.setBounds(850, 120, 350, 40);
		this.add(etiquetaTitulo);

		// ====== FRASE ======
		JLabel etiquetaFrase = new JLabel("“Porque ellos también merecen lo mejor”", SwingConstants.CENTER);
		etiquetaFrase.setFont(new Font("Serif", Font.PLAIN, 16));
		etiquetaFrase.setBounds(800, 170, 450, 30);
		this.add(etiquetaFrase);

		// ====== USUARIO ======
		JLabel etiquetaUsuario = new JLabel("Usuario:");
		etiquetaUsuario.setFont(new Font("Serif", Font.PLAIN, 16));
		etiquetaUsuario.setBounds(850, 230, 100, 25);
		this.add(etiquetaUsuario);

		JTextField campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Serif", Font.PLAIN, 15));
		campoUsuario.setBounds(850, 260, 350, 40);
		campoUsuario.setBackground(new Color(180, 185, 210));
		campoUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
		this.add(campoUsuario);

		// ====== CONTRASEÑA ======
		JLabel etiquetaContrasena = new JLabel("Contraseña:");
		etiquetaContrasena.setFont(new Font("Serif", Font.PLAIN, 16));
		etiquetaContrasena.setBounds(850, 320, 120, 25);
		this.add(etiquetaContrasena);

		JPasswordField campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Serif", Font.PLAIN, 15));
		campoContrasena.setBounds(850, 350, 350, 40);
		campoContrasena.setBackground(new Color(180, 185, 210));
		campoContrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
		this.add(campoContrasena);

		// ====== RECORDARME ======
		JLabel etiquetaRecordar = new JLabel("Recordarme:");
		etiquetaRecordar.setFont(new Font("Serif", Font.PLAIN, 16));
		etiquetaRecordar.setBounds(850, 410, 120, 25);
		this.add(etiquetaRecordar);

		JCheckBox checkRecordar = new JCheckBox();
		checkRecordar.setBounds(970, 410, 20, 20);
		checkRecordar.setBackground(Color.WHITE);
		this.add(checkRecordar);

		// ====== BOTONES ======
		JButton botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("Serif", Font.PLAIN, 16));
		botonSalir.setBounds(850, 470, 150, 50);
		botonSalir.setBackground(new Color(100, 100, 100));
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setBorder(null);
		botonSalir.setFocusPainted(false);
		this.add(botonSalir);

		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.setFont(new Font("Serif", Font.PLAIN, 16));
		botonAcceder.setBounds(1050, 470, 150, 50);
		botonAcceder.setBackground(new Color(20, 80, 140));
		botonAcceder.setForeground(Color.WHITE);
		botonAcceder.setBorder(BorderFactory.createEmptyBorder());
		botonAcceder.setFocusPainted(false);
		this.add(botonAcceder);



		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
		Image img = icono.getImage();
		Image imgEscalada = img.getScaledInstance(64,64,Image.SCALE_SMOOTH);
		this.setIconImage(imgEscalada);
		
		this.setVisible(true);
	}
	
}
