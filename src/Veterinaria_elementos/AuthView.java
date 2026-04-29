package Veterinaria_elementos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

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
       
        salir.addActionListener(e -> {
        	ventana.dispose();

        });

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

    ImageIcon icono1 = new ImageIcon(getClass().getResource("/Imagenes/Citas_Inicio_paneles.jpg"));
    Image img = icono1.getImage().getScaledInstance(240, 150, Image.SCALE_SMOOTH);

    JButton boton = new JButton(new ImageIcon(img));
    boton.setBounds(15, 120, 240, 150);
    boton.setBorderPainted(false);
    boton.setContentAreaFilled(false);
    boton.setFocusPainted(false);
    boton.setOpaque(false);
    
    ////// falta ventana citas ///////
    
    boton.addActionListener(e -> {
    	ventana.dispose();
    	//CitasView();
    });

    panel.add(boton);

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

    citas.addActionListener(e -> {
    	ventana.dispose();
    	//CitasView();
    });
    
    
    JButton clientes = new JButton("Clientes del recinto");
    clientes.setBounds(330, 280, 240, 55);
    clientes.setFont(new Font("Adamina", Font.BOLD, 20));
    clientes.setBackground(Color.decode("#072548"));
    clientes.setForeground(Color.WHITE);
    clientes.setBorder(new LineBorder(Color.white, 1, true));
    clientes.setFocusPainted(false);
    
    clientes.addActionListener(e -> {
    	ventana.dispose();
    	//ClientesView();
    });
    
    panel.add(clientes);
    
    JButton costos = new JButton("Costos de consultas");
    costos.setBounds(645, 280, 240, 55);
    costos.setFont(new Font("Adamina", Font.BOLD, 20));
    costos.setBackground(Color.decode("#072548"));
    costos.setForeground(Color.WHITE);
    costos.setBorder(new LineBorder(Color.white, 1, true));
    costos.setFocusPainted(false);
    panel.add(costos);

    costos.addActionListener(e -> {
    	ventana.dispose();
    	CostosView();
    });
    
    ventana.setVisible(true);

    JButton cerrar = new JButton("Cerrar sesión");
    cerrar.setBounds(15, 360, 170, 50);
    cerrar.setFont(new Font("Adamina", Font.BOLD, 20));
    cerrar.setBackground(Color.decode("#014F97"));
    cerrar.setForeground(Color.WHITE);
    cerrar.setFocusPainted(false);
    cerrar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFFF"), 3, true));
    
    cerrar.addActionListener(e->{
    	SalirView();
    });

    
    panel.add(cerrar);
}

public void SalirView() {
	
	JFrame ventana = new JFrame();
	ventana.setBounds(310,100, 400,400);
	ventana.setBackground(Color.decode("#F2F2F2"));
    ventana.setLayout(null);

    JLabel logo = new JLabel();
    logo.setBounds(425, 30, 170, 150);

    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
    Image img = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    logo.setIcon(new ImageIcon(img));

    ventana.add(logo);

    JLabel texto = new JLabel("¿Deseas cerrar la sesión?");
    texto.setFont(new Font("Adamina", Font.PLAIN, 60));
    texto.setBounds(155, 190, 700, 120);
    ventana.add(texto);

    JButton cancelar = new JButton("Cancelar");
    cancelar.setBounds(200, 380, 250, 70);
    cancelar.setBackground(Color.decode("#6B6B6B"));
    cancelar.setForeground(Color.WHITE);
    cancelar.setFont(new Font("Inter", Font.BOLD, 26));
    cancelar.setFocusPainted(false);
    ventana.add(cancelar);
    
    cancelar.addActionListener(e -> {
    	ventana.dispose();
    });

    JButton confirmar = new JButton("Sí, estoy seguro");
    confirmar.setBounds(550, 380,250,70);
    confirmar.setBackground(Color.decode("#14508C"));
    confirmar.setForeground(Color.WHITE);
    confirmar.setFont(new Font("Inter", Font.BOLD, 26));
    confirmar.setFocusPainted(false);
    ventana.add(confirmar);
    
    confirmar.addActionListener(e -> {
    	ventana.dispose();
    	InicioView();
    	ventana.dispose();
    	loginView();
    });
    
    ventana.setVisible(true);
}

public void CostosView() {
	
	JFrame ventana = new JFrame();
	ventana.setBounds(0, 0, 1000, 600);
	ventana.setBackground(Color.decode("#F2F2F2"));
	ventana.setLayout(null);

    JLabel titulo = new JLabel("Costo de consultas y medicamentos");
    titulo.setFont(new Font("Adamina", Font.BOLD, 32));
    titulo.setBounds(50, 30, 900, 40);
    ventana.add(titulo);
    
    JPanel panel1 = new JPanel();
    panel1.setBounds(50, 90, 400, 380);
    panel1.setBackground(Color.decode("#8CACCB"));
    panel1.setLayout(null);
    panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    ventana.add(panel1);

    JLabel label1 = new JLabel("Tipo de consultas:");
    label1.setFont(new Font("Adamina", Font.PLAIN, 22));
    label1.setBounds(10, 10, 300, 30);
    panel1.add(label1);

    String[] columnas1 = {"Consultas", "Costo"};
    String[][] datos1 = {
            {"Consulta rutinaria", "$700 MXN"},
            {"Consulta urgencias", "$2,000 MXN"},
            {"Consulta especializada", "$2,000 MXN"},
            {"Vacunación", "$1,500 MXN"},
            {"Desparasitación", "$600 MXN"},
            {"Consulta a domicilio", "$1,800 MXN"}
    };

    JTable tabla1 = new JTable(datos1, columnas1);
    tabla1.setFont(new Font("Adamina", Font.PLAIN, 16));
    tabla1.setRowHeight(30);

    JTableHeader header1 = tabla1.getTableHeader();
    header1.setFont(new Font("Adamina", Font.BOLD, 18));

    JScrollPane scroll1 = new JScrollPane(tabla1);
    scroll1.setBounds(10, 50, 380, 300);
    panel1.add(scroll1);

    JPanel panel2 = new JPanel();
    panel2.setBounds(500, 90, 400, 380);
    panel2.setBackground(Color.decode("#8CACCB"));
    panel2.setLayout(null);
    panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    ventana.add(panel2);

    JLabel label2 = new JLabel("Medicamentos:");
    label2.setFont(new Font("Adamina", Font.PLAIN, 22));
    label2.setBounds(10, 10, 300, 30);
    panel2.add(label2);

    String[] columnas2 = {"Medicamentos", "Costo"};
    String[][] datos2 = {
            {"Antibiótico clavoxivet (20 tabletas)", "$295 MXN"},
            {"Desparacitante Care Max", "$85 MXN"},
            {"Antiparasitarios", "$300 MXN"},
            {"Analgésicos", "$200 MXN"},
            {"Suplementos", "$400 MXN"},
            {"Vendaje", "$45 MXN"}
    };

    JTable tabla2 = new JTable(datos2, columnas2);
    tabla2.setFont(new Font("Adamina", Font.PLAIN, 16));
    tabla2.setRowHeight(30);

    JTableHeader header2 = tabla2.getTableHeader();
    header2.setFont(new Font("Adamina", Font.BOLD, 18));

    JScrollPane scroll2 = new JScrollPane(tabla2);
    scroll2.setBounds(10, 50, 380, 300);
    panel2.add(scroll2);

    JButton regresar = new JButton("Regresar");
    regresar.setBounds(50, 490, 180, 60);
    regresar.setFont(new Font("Inter", Font.BOLD, 24));
    regresar.setBackground(Color.decode("#6B6B6B"));
    regresar.setForeground(Color.WHITE);
    regresar.setFocusPainted(false);
    regresar.setBorder(BorderFactory.createLineBorder(Color.decode("#6B6B6B"), 2, true));
    
    regresar.addActionListener(e->{
    	ventana.dispose();
    	InicioView();
    });

    
    ventana.add(regresar);

    
    ventana.repaint();
    ventana.setVisible(true);
	
}
	public void CitasView() {
		/// Pantalla de citas pendiente. ///
	}
	
	public void ClientesView() {
		
		/// Pantalla de Clientes pendiente. ///
	}
}
	
	


	

