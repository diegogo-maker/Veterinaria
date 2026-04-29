package Veterinaria_elementos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AuthView {

public void loginView() {
		
		JFrame ventana = new JFrame();
		//configuracion de ventana
		ventana.setSize(1000,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setTitle("Veterinaria");
		ventana.setLocation(0,0);
		ventana.setResizable(true);
		ventana.setLayout(null);
				
		//this.Login();
		//this.Salir();		
		//this.Inicio();
		//this.Costos();


		// panel izquierdo = fondo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBounds(0, 0, 500, 600);
        panelIzquierdo.setLayout(new BorderLayout());

        JLabel fondo = new JLabel();

        ImageIcon imgFondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo_login.png"));
        Image imgEscalada = imgFondo.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(imgEscalada));

        panelIzquierdo.add(fondo, BorderLayout.CENTER);
        ventana.add(panelIzquierdo);

        // panel derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBounds(500, 0, 500, 600);
        panelDerecho.setBackground(new Color(235, 235, 235));
        panelDerecho.setLayout(null);
        ventana.add(panelDerecho);

        JLabel logo = new JLabel();
        logo.setBounds(170, 20, 200, 150);

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
        Image imgLogo = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imgLogo));

        panelDerecho.add(logo);

        JLabel frase = new JLabel("“Porque ellos también merecen lo mejor”");
        frase.setFont(new Font("Adamina", Font.PLAIN, 16));
        frase.setBounds(100, 170, 400, 30);
        panelDerecho.add(frase);

        JLabel user = new JLabel("Usuario:");
        user.setFont(new Font("Inter", Font.BOLD, 16));
        user.setBounds(50, 210, 200, 25);
        panelDerecho.add(user);

        JTextField campoUser = new JTextField();
        campoUser.setBounds(50, 240, 400, 40);
        campoUser.setFont(new Font("Inter", Font.PLAIN, 16));
        campoUser.setBackground(Color.decode("#B7BDE3"));
        panelDerecho.add(campoUser);

        JLabel pass = new JLabel("Contraseña:");
        pass.setFont(new Font("Inter", Font.BOLD, 16));
        pass.setBounds(50, 290, 200, 25);
        panelDerecho.add(pass);

        JPasswordField campoPass = new JPasswordField();
        campoPass.setBounds(50, 320, 400, 40);
        campoPass.setFont(new Font("Inter", Font.PLAIN, 16));
        campoPass.setBackground(Color.decode("#B7BDE3"));
        panelDerecho.add(campoPass);

        JLabel recordar = new JLabel("Recordarme:");
        recordar.setFont(new Font("Inter", Font.PLAIN, 16));
        recordar.setBounds(50, 370, 150, 25);
        panelDerecho.add(recordar);

        JCheckBox check = new JCheckBox();
        check.setBounds(170, 375, 20, 20);
        check.setBackground(Color.decode("#B7BDE3"));
        panelDerecho.add(check);

        JButton salir = new JButton("Salir");
        salir.setFont(new Font("Adamina", Font.PLAIN, 20));
        salir.setBounds(50, 430, 150, 50);
        salir.setBackground(Color.decode("#565654"));
        salir.setForeground(Color.WHITE);
        salir.setFocusPainted(false);
        panelDerecho.add(salir);

        JButton acceder = new JButton("Acceder");
        acceder.setFont(new Font("Adamina", Font.PLAIN, 20));
        acceder.setBounds(250, 430, 200, 50);
        acceder.setBackground(Color.decode("#014F97"));
        acceder.setForeground(Color.WHITE);     
        acceder.setFocusPainted(false);
        panelDerecho.add(acceder);
        
        acceder.addActionListener(e->{
        	ventana.dispose();
        	InicioView();
        });


        ventana.setVisible(true);
	}
public void InicioView() {

	
	JFrame ventana = new JFrame();
	//configuracion de ventana
	ventana.setSize(1000,600);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setLocationRelativeTo(null);
	ventana.setMinimumSize(new Dimension(200,200));
	ventana.setTitle("Veterinaria");
	ventana.setLocation(0,0);
	ventana.setResizable(true);
	ventana.setLayout(null);
			

    JPanel fondo = new JPanel();
    fondo.setBounds(0, 0, 1000, 600);
    fondo.setBackground(Color.decode("#F2F2F2"));
    fondo.setLayout(null);
    ventana.add(fondo);

    JLabel titulo = new JLabel("Sistema de gestión veterinaria");
    titulo.setFont(new Font("Adamina", Font.BOLD, 32));
    titulo.setBounds(45, 30, 800, 40);
    fondo.add(titulo);

    JLabel subtitulo = new JLabel("Ingresa y gestiona la información de tus pacientes de forma rápida y sencilla.");
    subtitulo.setFont(new Font("Adamina", Font.PLAIN, 20));
    subtitulo.setBounds(45, 75, 900, 30);
    fondo.add(subtitulo);

    JPanel panel = new JPanel();
    panel.setBounds(45, 120, 900, 420);
    panel.setBackground(Color.decode("#7F9BB3"));
    panel.setLayout(null);
    panel.setBorder(new LineBorder(Color.BLACK, 2, true));
    fondo.add(panel);

    JButton cerrar = new JButton("Cerrar sesión");
    cerrar.setBounds(15, 360, 170, 50);
    cerrar.setFont(new Font("Adamina", Font.BOLD, 20));
    cerrar.setBackground(Color.decode("#014F97"));
    cerrar.setForeground(Color.WHITE);
    cerrar.setFocusPainted(false);
    cerrar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFFF"), 3, true));
    panel.add(cerrar);

    JLabel rol = new JLabel("Veterinario");
    rol.setOpaque(true);
    rol.setFont(new Font("Adamina", Font.BOLD, 20));
    rol.setBackground(Color.decode("#FFFFFF"));
    rol.setBounds(15, 10, 165, 40);
    rol.setBorder(new LineBorder(Color.BLACK, 1, true));
    panel.add(rol);

    JLabel nombre = new JLabel("Jesus Andres Salcido Hernandez");
    nombre.setOpaque(true);
    nombre.setFont(new Font("Adamina", Font.BOLD, 20));
    nombre.setBackground(Color.decode("#FFFFFF"));
    nombre.setBounds(190, 10, 400, 40);
    nombre.setBorder(new LineBorder(Color.BLACK, 1, true));
    panel.add(nombre);

    JLabel logo = new JLabel();
    logo.setBounds(785, 10, 100, 100);

    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
    Image imgLogo = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    logo.setIcon(new ImageIcon(imgLogo));

    panel.add(logo);

    JLabel img1 = new JLabel();
    img1.setBounds(15, 120, 240, 150);

    ImageIcon i1 = new ImageIcon(getClass().getResource("/Imagenes/Citas_Inicio_paneles.jpg"));
    Image imgEscalada1 = i1.getImage().getScaledInstance(240, 150, Image.SCALE_SMOOTH);
    img1.setIcon(new ImageIcon(imgEscalada1));

    panel.add(img1);

    JLabel img2 = new JLabel();
    img2.setBounds(330, 120, 240, 150);

    ImageIcon i2 = new ImageIcon(getClass().getResource("/Imagenes/Dueños_Inicio_paneles.png"));
    Image imgEscalada2 = i2.getImage().getScaledInstance(240, 150, Image.SCALE_SMOOTH);
    img2.setIcon(new ImageIcon(imgEscalada2));

    panel.add(img2);

    JLabel img3 = new JLabel();
    img3.setBounds(645, 120, 240, 150);

    ImageIcon i3 = new ImageIcon(getClass().getResource("/Imagenes/Costos.jpg"));
    Image imgEscalada3 = i3.getImage().getScaledInstance(240, 150, Image.SCALE_SMOOTH);
    img3.setIcon(new ImageIcon(imgEscalada3));

    panel.add(img3);
    
    JButton citas = new JButton("Citas de pacientes");
    citas.setBounds(15, 280, 240, 55);
    citas.setBackground(Color.decode("#072548"));
    citas.setForeground(Color.WHITE);
    citas.setFont(new Font("Adamina", Font.BOLD, 20));
    citas.setBorder(new LineBorder(Color.white, 1, true));
    citas.setFocusPainted(false);
    panel.add(citas);

    JButton clientes = new JButton("Clientes del recinto");
    clientes.setBounds(330, 280, 240, 55);
    clientes.setFont(new Font("Adamina", Font.BOLD, 20));
    clientes.setBackground(Color.decode("#072548"));
    clientes.setForeground(Color.WHITE);
    clientes.setBorder(new LineBorder(Color.white, 1, true));
    clientes.setFocusPainted(false);
    panel.add(clientes);

    JButton costos = new JButton("Costos de consultas");
    costos.setBounds(645, 280, 240, 55);
    costos.setFont(new Font("Adamina", Font.BOLD, 20));
    costos.setBackground(Color.decode("#072548"));
    costos.setForeground(Color.WHITE);
    costos.setBorder(new LineBorder(Color.white, 1, true));
    costos.setFocusPainted(false);
    panel.add(costos);
    
    ventana.setVisible(true);
}
	
}

	

