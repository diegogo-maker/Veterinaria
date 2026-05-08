package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;



public class AuthView {
	
	public void Login() {

		//configuracion de ventana
		JFrame ventana = new JFrame();
		ventana.setSize(1000,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setTitle("Veterinaria");
		ventana.setLocation(0,0);
		ventana.setResizable(true);
		ventana.setLayout(null);
		
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
        panelDerecho.setBackground(Color.decode("#FFFFFF"));
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
        salir.setBackground(Color.decode("#D81F10"));
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
        
        acceder.addActionListener(e -> {
            ventana.dispose(); 
            Inicio();
        });
        
		ventana.setVisible(true);
	}
	
	public void Salir() {

		//configuracion de ventana
		JFrame ventana = new JFrame();
		ventana.setSize(1000,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setTitle("Salir");
		ventana.setLocation(0,0);
		ventana.setResizable(true);
		ventana.setLayout(null);
		
		JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setBackground(Color.decode("#FFFFFF"));
        fondo.setLayout(null);
        ventana.add(fondo);

        JLabel logo = new JLabel();
        logo.setBounds(425, 30, 170, 150);

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
        Image img = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(img));

        fondo.add(logo);

        JLabel texto = new JLabel("¿Deseas cerrar la sesión?");
        texto.setFont(new Font("Adamina", Font.PLAIN, 60));
        texto.setBounds(155, 190, 700, 120);
        fondo.add(texto);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(200, 380, 250, 70);
        cancelar.setBackground(Color.decode("#14518C"));
        cancelar.setForeground(Color.WHITE);
        cancelar.setFont(new Font("Inter", Font.BOLD, 26));
        cancelar.setFocusPainted(false);
        fondo.add(cancelar);
        
        cancelar.addActionListener(e -> {
            ventana.dispose(); 
            Inicio();
        });

        JButton confirmar = new JButton("Sí, estoy seguro");
        confirmar.setBounds(550, 380,250,70);
        confirmar.setBackground(Color.decode("#D81F10"));
        confirmar.setForeground(Color.WHITE);
        confirmar.setFont(new Font("Inter", Font.BOLD, 26));
        confirmar.setFocusPainted(false);
        fondo.add(confirmar);
        
        confirmar.addActionListener(e -> {
            ventana.dispose(); 
            Login();
        });
        
        ventana.setVisible(true);
	}
	
	public void Inicio() {
			
		//configuracion de ventana
		JFrame ventana = new JFrame();
		ventana.setSize(1000,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setTitle("Inicio");
		ventana.setLocation(0,0);
		ventana.setResizable(true);
		ventana.setLayout(null);
		
		JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setBackground(Color.decode("#FFFFFF"));
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
        panel.setBackground(Color.decode("#8CACCB"));
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.BLACK, 2, true));
        fondo.add(panel);

        JButton cerrar = new JButton("Cerrar sesión");
        cerrar.setBounds(15, 360, 170, 50);
        cerrar.setFont(new Font("Adamina", Font.BOLD, 20));
        cerrar.setBackground(Color.decode("#D81F10"));
        cerrar.setForeground(Color.WHITE);
        cerrar.setFocusPainted(false);
        cerrar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 3, true));
        panel.add(cerrar);
        
        cerrar.addActionListener(e -> {
            ventana.dispose();
            Salir();
        });

        JLabel rol = new JLabel("Veterinario");
        rol.setOpaque(true);
        rol.setFont(new Font("Adamina", Font.BOLD, 20));
        rol.setBackground(Color.decode("#FFFFFF"));
        rol.setBounds(15, 10, 165, 40);
        rol.setHorizontalAlignment(JLabel.CENTER);
        rol.setBorder(new LineBorder(Color.BLACK, 1, true));
        panel.add(rol);

        JLabel nombre = new JLabel("Jesus Andres Salcido Hernandez");
        nombre.setOpaque(true);
        nombre.setFont(new Font("Adamina", Font.BOLD, 20));
        nombre.setBackground(Color.decode("#FFFFFF"));
        nombre.setBounds(190, 10, 695, 40);
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setBorder(new LineBorder(Color.BLACK, 1, true));
        panel.add(nombre);

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
        
        citas.addActionListener(e -> {
            ventana.dispose();
            RegistroCitas();
        });

        JButton clientes = new JButton("Clientes del recinto");
        clientes.setBounds(330, 280, 240, 55);
        clientes.setFont(new Font("Adamina", Font.BOLD, 20));
        clientes.setBackground(Color.decode("#072548"));
        clientes.setForeground(Color.WHITE);
        clientes.setBorder(new LineBorder(Color.white, 1, true));
        clientes.setFocusPainted(false);
        panel.add(clientes);
        
        clientes.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

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
            Costos();
        });
        
        ventana.setVisible(true);
	}
	
	public void Costos() {

		//configuracion de ventana
		JFrame ventana = new JFrame();
		ventana.setSize(1000,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setTitle("Costos de consultas");
		ventana.setLocation(0,0);
		ventana.setResizable(true);
		ventana.setLayout(null);
		
		JPanel fondo = new JPanel();
	    fondo.setBounds(0, 0, 1000, 600);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setLayout(null);
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Costo de consultas y medicamentos");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 32));
	    titulo.setBounds(50, 30, 900, 40);
	    fondo.add(titulo);
	    
	    JPanel panel1 = new JPanel();
	    panel1.setBounds(50, 90, 400, 380);
	    panel1.setBackground(Color.decode("#8CACCB"));
	    panel1.setLayout(null);
	    panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
	    fondo.add(panel1);

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
	    fondo.add(panel2);

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
	    regresar.setBackground(Color.decode("#D81F10"));
	    regresar.setForeground(Color.WHITE);
	    regresar.setFocusPainted(false);
	    regresar.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
	    fondo.add(regresar);
	    
	    regresar.addActionListener(e -> {
	        ventana.dispose();
	        Inicio();
	    });

	    ventana.repaint();
	    
	    ventana.setVisible(true);
	}
	
	public void RegistroCitas() {

	    JFrame ventana = new JFrame("Registro de citas");
	    ventana.setSize(1000, 600);
	    ventana.setLocationRelativeTo(null);
	    ventana.setTitle("Registro de citas");
	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0, 0, 1000, 600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Registro de citas");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 34));
	    titulo.setBounds(50, 20, 400, 40);
	    fondo.add(titulo);

	    JPanel contenedor = new JPanel();
	    contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.Y_AXIS));
	    contenedor.setBackground(Color.decode("#FFFFFF"));

	    JScrollPane scroll = new JScrollPane(contenedor);
	    scroll.setBounds(50, 80, 900, 400);
	    scroll.setBorder(null);
	    fondo.add(scroll);
    

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#8CACCB"));

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        panel.setPreferredSize(new Dimension(850, 120));

        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.BLACK, 2, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));

	    Image img = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(img);
	
	    JButton foto = new JButton(iconoEscalado);
	    foto.setBounds(20, 20, 80, 80);
	    foto.setBackground(Color.LIGHT_GRAY);
	    foto.setFocusPainted(false);
	    foto.setBorder(null);	
	    panel.add(foto);
	    
	    foto.addActionListener(e -> {
	        ventana.dispose();
	        DetallesPaciente();
	    });

        JLabel nombre = new JLabel("Nombre");
        nombre.setFont(new Font("Adamina", Font.BOLD, 28));
        nombre.setBounds(120, 10, 300, 40);
        panel.add(nombre);

        JLabel desc = new JLabel("Tipo / raza");
        desc.setFont(new Font("Adamina", Font.PLAIN, 18));
        desc.setBounds(120, 50, 300, 30);
        panel.add(desc);

        JLabel cita = new JLabel("Próxima cita: --/--/----");
        cita.setFont(new Font("Adamina", Font.PLAIN, 18));
        cita.setBounds(450, 20, 300, 30);
        panel.add(cita);

        JButton historial = new JButton("Historial");
        historial.setBounds(450, 60, 130, 35);
        historial.setBackground(Color.decode("#14518C"));
        historial.setForeground(Color.white);
        historial.setFont(new Font("Inter", Font.BOLD, 20));
        
        historial.addActionListener(e -> {
	        ventana.dispose();
	        HistorialCostos();
	    });


        JButton crear = new JButton("Crear");
        crear.setBounds(590, 60, 100, 35);
        crear.setBackground(Color.decode("#14518C"));
        crear.setForeground(Color.white);
        crear.setFont(new Font("Inter", Font.BOLD, 20));
        
        crear.addActionListener(e -> {
	        ventana.dispose();
	        CrearCita();
	    });

        JButton editar = new JButton("Editar");
        editar.setBounds(700, 60, 100, 35);
        editar.setBackground(Color.decode("#14518C"));
        editar.setForeground(Color.white);
        editar.setFont(new Font("Inter", Font.BOLD, 20));
        
        editar.addActionListener(e -> {
	        ventana.dispose();
	        EdicionCita();
	    });

        panel.add(historial);
        panel.add(crear);
        panel.add(editar);

        contenedor.add(panel);
	    

	    JButton regresar = new JButton("Regresar");
	    regresar.setBounds(50, 490, 180, 60);
	    regresar.setFont(new Font("Inter", Font.BOLD, 20));
	    regresar.setBackground(Color.decode("#D81F10"));
	    regresar.setForeground(Color.white);
	    regresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    regresar.setFocusPainted(false);
	    fondo.add(regresar);

	    regresar.addActionListener(e -> {
	        ventana.dispose();
	        Inicio();
	    });

	    ventana.setVisible(true);
	}
	
	public void HistorialCostos() {

		JFrame ventana = new JFrame("Costos");
	    ventana.setSize(1000, 600);
	    ventana.setTitle("Historial de costos");
	    ventana.setLocationRelativeTo(null);
	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0, 0, 1000, 600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Costo final de consultas y medicamentos");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 28));
	    titulo.setBounds(50, 20, 800, 40);
	    fondo.add(titulo);

	    JLabel paciente = new JLabel("Paciente:");
	    paciente.setFont(new Font("Adamina", Font.PLAIN, 20));
	    paciente.setBounds(50, 80, 120, 30);
	    fondo.add(paciente);

	    JTextField txtPaciente = new JTextField("Nombre");
	    txtPaciente.setBounds(160, 80, 250, 35);
	    txtPaciente.setEditable(false);
	    txtPaciente.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(txtPaciente);

	    JLabel dueno = new JLabel("Dueño:");
	    dueno.setFont(new Font("Adamina", Font.PLAIN, 20));
	    dueno.setBounds(500, 80, 100, 30);
	    fondo.add(dueno);

	    JTextField txtDueno = new JTextField("Nombre");
	    txtDueno.setBounds(600, 80, 250, 35);
	    txtDueno.setEditable(false);
	    txtDueno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(txtDueno);

	    String[] col1 = {"Consultas anteriores", "Estado", "Costo"};
	    String[][] data1 = {{"--", "--", "--"}};

	    JTable tabla1 = new JTable(data1, col1);
	    tabla1.setRowHeight(40);
	    tabla1.setFont(new Font("Adamina", Font.PLAIN, 18));
	    tabla1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

	    JScrollPane sp1 = new JScrollPane(tabla1);
	    sp1.setBounds(50, 140, 850, 80);
	    sp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(sp1);

	    String[] col2 = {"#", "Concepto", "Estado", "Costo"};
	    String[][] data2 = {
	        {"1", "Concepto", "Estado", "$0"},
	        {"2", "Concepto", "Estado", "$0"}
	    };

	    JTable tabla2 = new JTable(data2, col2);
	    tabla2.setRowHeight(40);
	    tabla2.setFont(new Font("Adamina", Font.PLAIN, 18));
	    tabla2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

	    JScrollPane sp2 = new JScrollPane(tabla2);
	    sp2.setBounds(50, 250, 850, 120);
	    sp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(sp2);

	    JButton regresar = new JButton("Regresar");
	    regresar.setBounds(50, 440, 200, 60);
	    regresar.setBackground(Color.decode("#D81F10"));
	    regresar.setForeground(Color.WHITE);
	    regresar.setFont(new Font("Inter", Font.BOLD, 20));
	    regresar.setFocusPainted(false);
	    regresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(regresar);
	    
	    regresar.addActionListener(e -> {
	        ventana.dispose();
	        RegistroCitas();
	    });

	    JLabel actualizacion = new JLabel("Última actualización:");
	    actualizacion.setFont(new Font("Adamina", Font.PLAIN, 18));
	    actualizacion.setBounds(370, 440, 240, 20);
	    fondo.add(actualizacion);

	    JTextField fecha = new JTextField("--/--/----");
	    fecha.setBounds(370, 460, 240, 40);
	    fecha.setEditable(false);
	    fecha.setHorizontalAlignment(JTextField.CENTER);
	    fecha.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(fecha);

	    JButton descargar = new JButton("Descargar ticket");
	    descargar.setBounds(700, 440, 200, 60);
	    descargar.setBackground(Color.decode("#14508C"));
	    descargar.setForeground(Color.WHITE);
	    descargar.setFont(new Font("Inter", Font.BOLD, 18));
	    descargar.setFocusPainted(false);
	    descargar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    fondo.add(descargar);
	    
	    ventana.setVisible(true);
	}
	
	public void CrearCita() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Crear cita del paciente");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Creacion de citas");
	    titulo.setFont(new Font("Adamina",Font.BOLD,36));
	    titulo.setBounds(40,20,400,40);
	    fondo.add(titulo);

	    JPanel panelFormulario = new JPanel();
	    panelFormulario.setBounds(40,80,900,320);
	    panelFormulario.setLayout(null);
	    panelFormulario.setBackground(Color.decode("#8CACCB"));
	    panelFormulario.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelFormulario);

	    JLabel nombre = new JLabel("Nombre:");
	    nombre.setBounds(20,20,120,30);
	    panelFormulario.add(nombre);

	    JTextField txtNombre = new JTextField();
	    txtNombre.setBounds(120,20,220,30);
	    txtNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtNombre);

	    JLabel especie = new JLabel("Especie:");
	    especie.setBounds(20,60,120,30);
	    panelFormulario.add(especie);

	    JTextField txtEspecie = new JTextField();
	    txtEspecie.setBounds(120,60,220,30);
	    txtEspecie.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtEspecie);

	    JLabel raza = new JLabel("Raza:");
	    raza.setBounds(20,100,120,30);
	    panelFormulario.add(raza);

	    JTextField txtRaza = new JTextField();
	    txtRaza.setBounds(120,100,220,30);
	    txtRaza.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtRaza);

	    JLabel edad = new JLabel("Edad:");
	    edad.setBounds(20,140,120,30);
	    panelFormulario.add(edad);

	    JTextField txtEdad = new JTextField();
	    txtEdad.setBounds(120,140,220,30);
	    txtEdad.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtEdad);

	    JLabel historial = new JLabel("Historial:");
	    historial.setBounds(20,180,120,30);
	    panelFormulario.add(historial);

	    JTextField txtHistorial = new JTextField();
	    txtHistorial.setBounds(120,180,220,30);
	    txtHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtHistorial);

	    JLabel asunto = new JLabel("Asunto:");
	    asunto.setBounds(20,220,120,30);
	    panelFormulario.add(asunto);

	    JTextField txtAsunto = new JTextField();
	    txtAsunto.setBounds(120,220,220,30);
	    txtAsunto.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtAsunto);

	    JLabel dueno = new JLabel("Dueño:");
	    dueno.setBounds(400,20,120,30);
	    panelFormulario.add(dueno);

	    JTextField txtDueno = new JTextField();
	    txtDueno.setBounds(500,20,220,30);
	    txtDueno.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtDueno);

	    JLabel apellidos = new JLabel("Apellidos:");
	    apellidos.setBounds(400,60,120,30);
	    panelFormulario.add(apellidos);

	    JTextField txtApellidos = new JTextField();
	    txtApellidos.setBounds(500,60,220,30);
	    txtApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtApellidos);

	    JLabel telefono = new JLabel("Telefono:");
	    telefono.setBounds(400,100,120,30);
	    panelFormulario.add(telefono);

	    JTextField txtTelefono = new JTextField();
	    txtTelefono.setBounds(500,100,220,30);
	    txtTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtTelefono);

	    JLabel correo = new JLabel("Correo:");
	    correo.setBounds(400,140,120,30);
	    panelFormulario.add(correo);

	    JTextField txtCorreo = new JTextField();
	    txtCorreo.setBounds(500,140,220,30);
	    txtCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtCorreo);

	    JLabel ultima = new JLabel("Ult. Cita:");
	    ultima.setBounds(400,180,120,30);
	    panelFormulario.add(ultima);

	    JTextField txtUltima = new JTextField();
	    txtUltima.setBounds(500,180,220,30);
	    txtUltima.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtUltima);

	    JLabel proxima = new JLabel("Prox. Cita:");
	    proxima.setBounds(400,220,120,30);
	    panelFormulario.add(proxima);

	    JTextField txtProxima = new JTextField();
	    txtProxima.setBounds(500,220,220,30);
	    txtProxima.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtProxima);

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,440,220,70);
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    botonRegresar.setFont(new Font("Inter",Font.BOLD,22));
	    fondo.add(botonRegresar);

	    JButton botonGuardar = new JButton("Guardar");
	    botonGuardar.setBounds(720,440,220,70);
	    botonGuardar.setBackground(Color.decode("#0B2545"));
	    botonGuardar.setForeground(Color.WHITE);
	    botonGuardar.setFont(new Font("Inter",Font.BOLD,22));
	    fondo.add(botonGuardar);

	    botonRegresar.addActionListener(e->{
	    	ventana.dispose();
	    	RegistroCitas();
	    });
	    
	    botonGuardar.addActionListener(e->{
	    	ventana.dispose();
	    	CambiosCita();
	    });

	    ventana.setVisible(true);
	}
	
	public void EdicionCita() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Edicion de citas");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Edicion de citas");
	    titulo.setFont(new Font("Adamina",Font.BOLD,28));
	    titulo.setBounds(40,20,400,40);
	    fondo.add(titulo);

	    JPanel panelFormulario = new JPanel();
	    panelFormulario.setBounds(40,80,900,320);
	    panelFormulario.setLayout(null);
	    panelFormulario.setBackground(Color.decode("#8CACCB"));
	    panelFormulario.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelFormulario);

	    JLabel nombre = new JLabel("Nombre:");
	    nombre.setBounds(20,20,120,30);
	    panelFormulario.add(nombre);

	    JTextField txtNombre = new JTextField();
	    txtNombre.setBounds(120,20,220,30);
	    txtNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtNombre);

	    JLabel especie = new JLabel("Especie:");
	    especie.setBounds(20,60,120,30);
	    panelFormulario.add(especie);

	    JTextField txtEspecie = new JTextField();
	    txtEspecie.setBounds(120,60,220,30);
	    txtEspecie.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtEspecie);

	    JLabel raza = new JLabel("Raza:");
	    raza.setBounds(20,100,120,30);
	    panelFormulario.add(raza);

	    JTextField txtRaza = new JTextField();
	    txtRaza.setBounds(120,100,220,30);
	    txtRaza.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtRaza);

	    JLabel edad = new JLabel("Edad:");
	    edad.setBounds(20,140,120,30);
	    panelFormulario.add(edad);

	    JTextField txtEdad = new JTextField();
	    txtEdad.setBounds(120,140,220,30);
	    txtEdad.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtEdad);

	    JLabel historial = new JLabel("Historial:");
	    historial.setBounds(20,180,120,30);
	    panelFormulario.add(historial);

	    JTextField txtHistorial = new JTextField();
	    txtHistorial.setBounds(120,180,220,30);
	    txtHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtHistorial);

	    JLabel asunto = new JLabel("Asunto:");
	    asunto.setBounds(20,220,120,30);
	    panelFormulario.add(asunto);

	    JTextField txtAsunto = new JTextField();
	    txtAsunto.setBounds(120,220,220,30);
	    txtAsunto.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtAsunto);

	    JLabel dueno = new JLabel("Dueño:");
	    dueno.setBounds(400,20,120,30);
	    panelFormulario.add(dueno);

	    JTextField txtDueno = new JTextField();
	    txtDueno.setBounds(500,20,220,30);
	    txtDueno.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtDueno);

	    JLabel apellidos = new JLabel("Apellidos:");
	    apellidos.setBounds(400,60,120,30);
	    panelFormulario.add(apellidos);

	    JTextField txtApellidos = new JTextField();
	    txtApellidos.setBounds(500,60,220,30);
	    txtApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtApellidos);

	    JLabel telefono = new JLabel("Telefono:");
	    telefono.setBounds(400,100,120,30);
	    panelFormulario.add(telefono);

	    JTextField txtTelefono = new JTextField();
	    txtTelefono.setBounds(500,100,220,30);
	    txtTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtTelefono);

	    JLabel correo = new JLabel("Correo:");
	    correo.setBounds(400,140,120,30);
	    panelFormulario.add(correo);

	    JTextField txtCorreo = new JTextField();
	    txtCorreo.setBounds(500,140,220,30);
	    txtCorreo.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtCorreo);

	    JLabel ultima = new JLabel("Ult. Cita:");
	    ultima.setBounds(400,180,120,30);
	    panelFormulario.add(ultima);

	    JTextField txtUltima = new JTextField();
	    txtUltima.setBounds(500,180,220,30);
	    txtUltima.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtUltima);

	    JLabel proxima = new JLabel("Prox. Cita:");
	    proxima.setBounds(400,220,120,30);
	    panelFormulario.add(proxima);

	    JTextField txtProxima = new JTextField();
	    txtProxima.setBounds(500,220,220,30);
	    txtProxima.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    panelFormulario.add(txtProxima);

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,440,220,70);
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    botonRegresar.setFont(new Font("Inter",Font.BOLD,22));
	    fondo.add(botonRegresar);

	    JButton botonEliminar = new JButton("Eliminar cita");
	    botonEliminar.setBounds(390,440,220,70);
	    botonEliminar.setBackground(Color.decode("#14508C"));
	    botonEliminar.setForeground(Color.WHITE);
	    botonEliminar.setFont(new Font("Inter",Font.BOLD,22));
	    fondo.add(botonEliminar);

	    JButton botonGuardar = new JButton("Guardar");
	    botonGuardar.setBounds(720,440,220,70);
	    botonGuardar.setBackground(Color.decode("#0B2545"));
	    botonGuardar.setForeground(Color.WHITE);
	    botonGuardar.setFont(new Font("Inter",Font.BOLD,22));
	    fondo.add(botonGuardar);

	    botonRegresar.addActionListener(e->{
	    	ventana.dispose();
	    	RegistroCitas();
	    });
	    
	    botonGuardar.addActionListener(e->{
	    	ventana.dispose();
	    	CambiosCita();
	    });
	    
	    botonEliminar.addActionListener(e->{
	    	ventana.dispose();
	    	EliminarCita();
	    });

	    ventana.setVisible(true);
	}
	
	public void CambiosCita() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Cambios cita");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);
	    
	    JLabel logo = new JLabel();
	    logo.setBounds(425,40,160,160);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
	    Image imagen = icono.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(imagen));
	    fondo.add(logo);

	    JLabel mensaje = new JLabel("Se han guardado los nuevos cambios.");
	    mensaje.setFont(new Font("Adamina",Font.BOLD,36));
	    mensaje.setBounds(100,200,800,120);
	    mensaje.setHorizontalAlignment(JLabel.CENTER);
	    fondo.add(mensaje);

	    JButton botonAceptar = new JButton("Aceptar");
	    botonAceptar.setBounds(390,350,220,90);
	    botonAceptar.setFont(new Font("Inter",Font.BOLD,28));
	    botonAceptar.setBackground(Color.decode("#14508C"));
	    botonAceptar.setForeground(Color.WHITE);
	    fondo.add(botonAceptar);

	    botonAceptar.addActionListener(e->{
	    	ventana.dispose();
	    	Inicio();
	    });

	    ventana.setVisible(true);
	}
	
	public void EliminarCita() {

		JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Eliminar cita");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);
	    
	    JLabel logo = new JLabel();
	    logo.setBounds(425,40,160,160);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
	    Image imagen = icono.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(imagen));
	    fondo.add(logo);
	    
	    JLabel mensaje = new JLabel("¿Estás seguro de que deseas eliminar la cita?");
	    mensaje.setFont(new Font("Adamina",Font.BOLD,36));
	    mensaje.setBounds(100,200,800,120);
	    mensaje.setHorizontalAlignment(JLabel.CENTER);
	    fondo.add(mensaje);

	    JButton botonCancelar = new JButton("Cancelar");
	    botonCancelar.setBounds(250,360,220,70);
	    botonCancelar.setBackground(Color.decode("#14508C"));
	    botonCancelar.setForeground(Color.WHITE);
	    botonCancelar.setFont(new Font("Inter",Font.BOLD,22));
	    botonCancelar.setFocusPainted(false);
	    botonCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    fondo.add(botonCancelar);

	    JButton botonConfirmar = new JButton("Si, estoy seguro");
	    botonConfirmar.setBounds(530,360,250,70);
	    botonConfirmar.setBackground(Color.decode("#D81F10"));
	    botonConfirmar.setForeground(Color.WHITE);
	    botonConfirmar.setFont(new Font("Inter",Font.BOLD,22));
	    botonConfirmar.setFocusPainted(false);
	    botonConfirmar.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    fondo.add(botonConfirmar);

	    botonCancelar.addActionListener(e->{
	    	ventana.dispose();
	    	EdicionCita();
	    });
	    
	    botonConfirmar.addActionListener(e->{
	    	ventana.dispose();
	    	RegistroCitas();
	    });

	    ventana.setVisible(true);
	}
	
	public void PanelDuenos() {

		JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Panel de dueños");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);

	    JLabel titulo = new JLabel("Registro de dueños");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 28));
	    titulo.setBounds(40,20,400,40);
	    fondo.add(titulo);

	    JPanel panelRegistro = new JPanel();
	    panelRegistro.setBounds(40,80,900,200);
	    panelRegistro.setLayout(null);
	    panelRegistro.setBackground(Color.decode("#8CACCB"));
	    panelRegistro.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelRegistro);
	    
	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Doctor_Registro.jpg"));

	    Image img = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(img);
	    
	    JLabel botonFotoDueno = new JLabel(iconoEscalado);
	    botonFotoDueno.setBounds(20,40,120,120);
	    panelRegistro.add(botonFotoDueno);    

	    JLabel labelNombreDueno = new JLabel("Nombre del dueño");
	    labelNombreDueno.setFont(new Font("Adamina", Font.BOLD, 28));
	    labelNombreDueno.setBounds(160,40,400,40);
	    panelRegistro.add(labelNombreDueno);

	    JLabel labelMascotaTexto = new JLabel("Mascota:");
	    labelMascotaTexto.setBounds(160,90,100,25);
	    panelRegistro.add(labelMascotaTexto);

	    JLabel labelNombreMascota = new JLabel("Nombre mascota");
	    labelNombreMascota.setBounds(240,90,200,25);
	    panelRegistro.add(labelNombreMascota);
	    
	    ImageIcon icono2 = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));

	    Image img2 = icono2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado2 = new ImageIcon(img2);

	    JLabel botonFotoMascota = new JLabel(iconoEscalado2);
	    botonFotoMascota.setBounds(500,40,120,120);
	    panelRegistro.add(botonFotoMascota);

	    JButton botonDetalles = new JButton("Detalles");
	    botonDetalles.setBounds(650,40,120,40);
	    botonDetalles.setFont(new Font("Inter", Font.BOLD, 20));
	    botonDetalles.setBackground(Color.decode("#14518C"));
	    botonDetalles.setForeground(Color.WHITE);
	    panelRegistro.add(botonDetalles);

	    JButton botonEditar = new JButton("Editar");
	    botonEditar.setBounds(650,90,120,40);
	    botonEditar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonEditar.setBackground(Color.decode("#14518C"));
	    botonEditar.setForeground(Color.WHITE);
	    panelRegistro.add(botonEditar);

	    JButton botonEliminar = new JButton("Eliminar");
	    botonEliminar.setBounds(650,140,120,40);
	    botonEliminar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonEliminar.setBackground(Color.decode("#14518C"));
	    botonEliminar.setForeground(Color.WHITE);
	    panelRegistro.add(botonEliminar);

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,500,150,50);
	    botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    fondo.add(botonRegresar);

	    JButton botonCrearNuevo = new JButton("Crear nuevo");
	    botonCrearNuevo.setBounds(780,500,160,50);
	    botonCrearNuevo.setFont(new Font("Inter", Font.BOLD, 20));
	    botonCrearNuevo.setBackground(Color.decode("#072548"));
	    botonCrearNuevo.setForeground(Color.WHITE);
	    fondo.add(botonCrearNuevo);

	    botonRegresar.addActionListener(e -> {
	        ventana.dispose();
	        Inicio();
	    });

	    botonCrearNuevo.addActionListener(e -> {
	        ventana.dispose();
	        CrearDueno();
	    });

	    botonDetalles.addActionListener(e -> {
	        ventana.dispose();
	        DetallesDueno();
	    });

	    botonEditar.addActionListener(e -> {
	        ventana.dispose();
	        CrearDueno();
	    });

	    botonEliminar.addActionListener(e -> {
	        ventana.dispose();
	        EliminarRegistroDueno();
	    });

	    ventana.setVisible(true);
	    
	}
	
	public void CrearDueno() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Crear perfil del dueño");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);
	    
	    JLabel titulo = new JLabel("Crear dueño");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 28));
	    titulo.setBounds(40,20,400,40);
	    fondo.add(titulo);

	    JPanel panelDatos = new JPanel();
	    panelDatos.setBounds(40,80,500,350);
	    panelDatos.setLayout(null);
	    panelDatos.setBackground(Color.decode("#8CACCB"));
	    panelDatos.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelDatos);

	    JLabel tituloDatos = new JLabel("Datos del nuevo paciente");
	    tituloDatos.setBounds(10,10,300,20);
	    tituloDatos.setFont(new Font("Adamina", Font.BOLD, 20));
	    panelDatos.add(tituloDatos);

	    JLabel labelNombre = new JLabel("Nombre:");
	    labelNombre.setBounds(20,40,100,25);
	    labelNombre.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelNombre);

	    JTextField campoNombre = new JTextField();
	    campoNombre.setBounds(120,40,330,25);
	    panelDatos.add(campoNombre);

	    JLabel labelApellidos = new JLabel("Apellidos:");
	    labelApellidos.setBounds(20,70,100,25);
	    labelApellidos.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelApellidos);

	    JTextField campoApellidos = new JTextField();
	    campoApellidos.setBounds(120,70,330,25);
	    panelDatos.add(campoApellidos);

	    JLabel labelTelefono = new JLabel("Teléfono:");
	    labelTelefono.setBounds(20,100,100,25);
	    labelTelefono.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelTelefono);

	    JTextField campoTelefono = new JTextField();
	    campoTelefono.setBounds(120,100,330,25);
	    panelDatos.add(campoTelefono);

	    JLabel labelCorreo = new JLabel("Correo:");
	    labelCorreo.setBounds(20,130,100,25);
	    labelCorreo.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelCorreo);

	    JTextField campoCorreo = new JTextField();
	    campoCorreo.setBounds(120,130,330,25);
	    panelDatos.add(campoCorreo);

	    JLabel labelMascota = new JLabel("Mascota:");
	    labelMascota.setBounds(20,160,100,25);
	    labelMascota.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelMascota);

	    JTextField campoMascota = new JTextField();
	    campoMascota.setBounds(120,160,330,25);
	    panelDatos.add(campoMascota);

	    JLabel labelColonia = new JLabel("Colonia:");
	    labelColonia.setBounds(20,190,100,25);
	    labelColonia.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelColonia);

	    JTextField campoColonia = new JTextField();
	    campoColonia.setBounds(120,190,330,25);
	    panelDatos.add(campoColonia);

	    JLabel labelDireccion = new JLabel("Dirección:");
	    labelDireccion.setBounds(20,220,100,25);
	    labelDireccion.setFont(new Font("Adamina", Font.BOLD, 14));
	    panelDatos.add(labelDireccion);

	    JTextArea campoDireccion = new JTextArea();
	    campoDireccion.setBounds(120, 220, 330, 80);
	    campoDireccion.setLineWrap(true);
	    campoDireccion.setWrapStyleWord(true);

	    panelDatos.add(campoDireccion);

	    JPanel panelFoto = new JPanel();
	    panelFoto.setBounds(560,80,350,350);
	    panelFoto.setLayout(null);
	    panelFoto.setBackground(Color.decode("#8CACCB"));
	    panelFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelFoto);

	    JLabel tituloFoto = new JLabel("Fotografía del dueño");
	    tituloFoto.setBounds(20,10,200,20);
	    tituloFoto.setFont(new Font("Adamina", Font.BOLD, 20));
	    panelFoto.add(tituloFoto);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Doctor_Registro.jpg"));

	    Image img = icono.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(img);
	    
	    JLabel Imagen = new JLabel(iconoEscalado);
	    Imagen.setBounds(80,40,180,180);
	    panelFoto.add(Imagen);

	    JButton botonCargarImagen = new JButton("Cargar imagen");
	    botonCargarImagen.setBounds(80,250,180,50);
	    botonCargarImagen.setFont(new Font("Adamina", Font.BOLD, 16));
	    botonCargarImagen.setBackground(Color.decode("#0B2545"));
	    botonCargarImagen.setForeground(Color.WHITE);
	    panelFoto.add(botonCargarImagen);

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,470,150,50);
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    fondo.add(botonRegresar);

	    JButton botonBorrar = new JButton("Borrar todo");
	    botonBorrar.setBounds(210,470,150,50);
	    botonBorrar.setBackground(Color.decode("#6F6F6D"));
	    botonBorrar.setForeground(Color.WHITE);
	    fondo.add(botonBorrar);

	    JButton botonGuardar = new JButton("Guardar");
	    botonGuardar.setBounds(760,470,150,50);
	    botonGuardar.setBackground(Color.decode("#014F97"));
	    botonGuardar.setForeground(Color.WHITE);
	    fondo.add(botonGuardar);

	    botonRegresar.addActionListener(e -> {
	        ventana.dispose();
	        PanelDuenos();
	    });

	    botonBorrar.addActionListener(e -> {
	        campoNombre.setText("");
	        campoApellidos.setText("");
	        campoTelefono.setText("");
	        campoCorreo.setText("");
	        campoMascota.setText("");
	        campoColonia.setText("");
	        campoDireccion.setText("");
	    });

	    botonGuardar.addActionListener(e -> {
	        ventana.dispose();
	        CrearPaciente();
	    });

	    ventana.setVisible(true);
	}
	
	public void CrearPaciente() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Crear registro de pacientes");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);
	    
	    JLabel titulo = new JLabel("Crear paciente");
	    titulo.setFont(new Font("Adamina", Font.BOLD, 28));
	    titulo.setBounds(40,20,400,40);
	    fondo.add(titulo);

	    JPanel panelDatos = new JPanel();
	    panelDatos.setBounds(40, 80, 500, 350);
	    panelDatos.setLayout(null);
	    panelDatos.setBackground(Color.decode("#8CACCB"));
	    panelDatos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
	    fondo.add(panelDatos);

	    JLabel tituloDatos = new JLabel("Datos del nuevo paciente");
	    tituloDatos.setFont(new Font("Adamina", Font.BOLD, 18));
	    tituloDatos.setBounds(20, 10, 300, 25);
	    panelDatos.add(tituloDatos);

	    JLabel labelNombre = new JLabel("Nombre:");
	    labelNombre.setBounds(20, 50, 100, 25);
	    panelDatos.add(labelNombre);

	    JTextField campoNombre = new JTextField();
	    campoNombre.setBounds(130, 50, 270, 25);
	    panelDatos.add(campoNombre);

	    JLabel labelEspecie = new JLabel("Especie:");
	    labelEspecie.setBounds(20, 85, 100, 25);
	    panelDatos.add(labelEspecie);

	    JTextField campoEspecie = new JTextField();
	    campoEspecie.setBounds(130, 85, 270, 25);
	    panelDatos.add(campoEspecie);

	    JLabel labelRaza = new JLabel("Raza:");
	    labelRaza.setBounds(20, 120, 100, 25);
	    panelDatos.add(labelRaza);

	    JTextField campoRaza = new JTextField();
	    campoRaza.setBounds(130, 120, 270, 25);
	    panelDatos.add(campoRaza);

	    JLabel labelEdad = new JLabel("Edad:");
	    labelEdad.setBounds(20, 155, 100, 25);
	    panelDatos.add(labelEdad);

	    JTextField campoEdad = new JTextField();
	    campoEdad.setBounds(130, 155, 270, 25);
	    panelDatos.add(campoEdad);

	    JLabel labelSexo = new JLabel("Sexo:");
	    labelSexo.setBounds(20, 190, 100, 25);
	    panelDatos.add(labelSexo);

	    JTextField campoSexo = new JTextField();
	    campoSexo.setBounds(130, 190, 270, 25);
	    panelDatos.add(campoSexo);

	    JLabel labelDiagnostico = new JLabel("Diagnóstico:");
	    labelDiagnostico.setBounds(20, 225, 100, 25);
	    panelDatos.add(labelDiagnostico);

	    JTextArea campoDiagnostico = new JTextArea();
	    campoDiagnostico.setLineWrap(true);
	    campoDiagnostico.setWrapStyleWord(true);

	    JScrollPane scrollDiagnostico = new JScrollPane(campoDiagnostico);
	    scrollDiagnostico.setBounds(130, 225, 270, 60);
	    panelDatos.add(scrollDiagnostico);

	    JLabel labelDueno = new JLabel("Dueño:");
	    labelDueno.setBounds(20, 295, 100, 25);
	    panelDatos.add(labelDueno);

	    JTextField campoDueno = new JTextField();
	    campoDueno.setBounds(130, 295, 270, 25);
	    panelDatos.add(campoDueno);

	    JPanel panelAdministrativo = new JPanel();
	    panelAdministrativo.setBounds(560,80,350,170);
	    panelAdministrativo.setLayout(null);
	    panelAdministrativo.setBackground(Color.decode("#8CACCB"));
	    panelAdministrativo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelAdministrativo);

	    JLabel tituloAdministrativo = new JLabel("Datos administrativos");
	    tituloAdministrativo.setFont(new Font("Adamina", Font.BOLD, 18));
	    tituloAdministrativo.setBounds(20, 10, 250, 25);
	    panelAdministrativo.add(tituloAdministrativo);

	    JLabel labelFecha = new JLabel("Fecha de ingreso:");
	    labelFecha.setFont(new Font("Adamina", Font.PLAIN, 14));
	    labelFecha.setBounds(20, 45, 150, 20);
	    panelAdministrativo.add(labelFecha);

	    JTextField campoFecha = new JTextField();
	    campoFecha.setBounds(20, 65, 150, 25);
	    panelAdministrativo.add(campoFecha);

	    JLabel labelDoctor = new JLabel("Doctor a cargo:");
	    labelDoctor.setFont(new Font("Adamina", Font.PLAIN, 14));
	    labelDoctor.setBounds(20, 95, 150, 20);
	    panelAdministrativo.add(labelDoctor);

	    JTextField campoDoctor = new JTextField();
	    campoDoctor.setBounds(20, 115, 150, 25);
	    panelAdministrativo.add(campoDoctor);
	    
	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));

	    Image img = icono.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(img);
	    
	    JLabel Imagen = new JLabel(iconoEscalado);
	    Imagen.setBounds(220,5,110,110);
	    panelAdministrativo.add(Imagen);
	    
	    JButton botonCargarImagen = new JButton("img mascota");
	    botonCargarImagen.setBounds(220,120,110,30);
	    botonCargarImagen.setBackground(Color.decode("#14518C"));
	    botonCargarImagen.setForeground(Color.decode("#FFFFFF"));
	    panelAdministrativo.add(botonCargarImagen);

	    JPanel panelHistorial = new JPanel();
	    panelHistorial.setBounds(560,270,350,160);
	    panelHistorial.setLayout(null);
	    panelHistorial.setBackground(Color.decode("#8CACCB"));
	    panelHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panelHistorial);

	    JLabel tituloHistorial = new JLabel("Historial clinico y observaciones");
	    tituloHistorial.setFont(new Font("Adamina", Font.BOLD, 18));
	    tituloHistorial.setBounds(10, 5, 300, 25);
	    panelHistorial.add(tituloHistorial);

	    JTextArea areaHistorial = new JTextArea();
	    areaHistorial.setBounds(10, 35, 330, 110);
	    areaHistorial.setLineWrap(true);
	    areaHistorial.setWrapStyleWord(true);
	    panelHistorial.add(areaHistorial);

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,470,150,50);
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    fondo.add(botonRegresar);

	    JButton botonBorrar = new JButton("Borrar todo");
	    botonBorrar.setBounds(210,470,150,50);
	    botonBorrar.setBackground(Color.decode("#6B6B6B"));
	    botonBorrar.setForeground(Color.WHITE);
	    fondo.add(botonBorrar);

	    JButton botonGuardar = new JButton("Guardar");
	    botonGuardar.setBounds(760,470,150,50);
	    botonGuardar.setBackground(Color.decode("#0B2545"));
	    botonGuardar.setForeground(Color.WHITE);
	    fondo.add(botonGuardar);

	    botonRegresar.addActionListener(e -> {
	        ventana.dispose();
	        CrearDueno();
	    });

	    botonBorrar.addActionListener(e -> {
	        campoNombre.setText("");
	        campoEspecie.setText("");
	        campoRaza.setText("");
	        campoEdad.setText("");
	        campoSexo.setText("");
	        campoDiagnostico.setText("");
	        campoDueno.setText("");
	        campoFecha.setText("");
	        campoDoctor.setText("");
	        areaHistorial.setText("");
	    });

	    botonGuardar.addActionListener(e -> {
	        ventana.dispose();
	        RegistroExitoso();
	    });

	    ventana.setVisible(true);
	}
	
	public void EliminarRegistroDueno() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Eliminar registro del dueño");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);	    

	    JLabel logo = new JLabel();
	    logo.setBounds(425,40,160,160);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
	    Image imagen = icono.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(imagen));
	    fondo.add(logo);

	    JLabel texto = new JLabel("¿Deseas eliminar el registro?");
	    texto.setBounds(200, 210, 600, 60);
	    texto.setFont(new Font("Adamina", Font.BOLD, 32));
	    texto.setHorizontalAlignment(JLabel.CENTER);
	    fondo.add(texto);

	    JButton cancelar = new JButton("Cancelar");
	    cancelar.setBounds(290, 330, 180, 60);
	    cancelar.setBackground(Color.decode("#14518C"));
	    cancelar.setForeground(Color.WHITE);
	    cancelar.setFocusPainted(false);
	    fondo.add(cancelar);

	    JButton confirmar = new JButton("Sí, estoy seguro");
	    confirmar.setBounds(530, 330, 220, 60);
	    confirmar.setBackground(Color.decode("#D81F10"));
	    confirmar.setForeground(Color.WHITE);
	    confirmar.setFocusPainted(false);
	    fondo.add(confirmar);

	    cancelar.addActionListener(e->{
	    	ventana.dispose();
	    	PanelDuenos();
	    });
	    
	    confirmar.addActionListener(e->{
	    	ventana.dispose();
	    	EliminadoExitoso();
	    });

	    ventana.setVisible(true);
	}
	
	public void EliminadoExitoso() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Eliminado exitoso");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);
	    
	    JLabel logo = new JLabel();
	    logo.setBounds(425,40,160,160);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
	    Image imagen = icono.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(imagen));
	    fondo.add(logo);

	    JLabel texto = new JLabel("Se eliminó el registro correctamente.");
	    texto.setBounds(100,200,800,80);
	    texto.setFont(new Font("Adamina",Font.BOLD,34));
	    texto.setHorizontalAlignment(JLabel.CENTER);
	    fondo.add(texto);

	    JButton aceptar = new JButton("Aceptar");
	    aceptar.setBounds(400,350,200,70);
	    aceptar.setBackground(Color.decode("#14508C"));
	    aceptar.setForeground(Color.WHITE);
	    fondo.add(aceptar);

	    aceptar.addActionListener(e->{
	    	ventana.dispose();
	    	PanelDuenos();
	    });

	    ventana.setVisible(true);
	}
	
	public void RegistroExitoso() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Registro exitoso");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    fondo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	    ventana.add(fondo);
	    
	    JLabel logo = new JLabel();
	    logo.setBounds(425,40,160,160);

	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
	    Image imagen = icono.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(imagen));
	    fondo.add(logo);

	    JLabel texto = new JLabel("Se agregó el nuevo registro exitosamente.");
	    texto.setBounds(100,220,800,80);
	    texto.setFont(new Font("Adamina",Font.BOLD,34));
	    texto.setHorizontalAlignment(JLabel.CENTER);
	    fondo.add(texto);

	    JButton aceptar = new JButton("Aceptar");
	    aceptar.setBounds(405,350,200,70);
	    aceptar.setFont(new Font("Adamina",Font.BOLD,34));
	    aceptar.setBackground(Color.decode("#14508C"));
	    aceptar.setForeground(Color.WHITE);
	    fondo.add(aceptar);

	    aceptar.addActionListener(e->{
	    	ventana.dispose();
	    	PanelDuenos();
	    });

	    ventana.setVisible(true);
	}
	
	public void DetallesDueno() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Detalles del dueño");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);

	    JLabel ultima = new JLabel("Ultima modificacion: 7 de Marzo del 2026");
	    ultima.setBounds(350,10,400,20);
	    fondo.add(ultima);

	    JPanel panel = new JPanel();
	    panel.setBounds(40,40,900,380);
	    panel.setLayout(null);
	    panel.setBackground(Color.decode("#8CACCB"));
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panel);

	    ImageIcon iconoDueno = new ImageIcon(getClass().getResource("/Imagenes/Doctor_Registro.jpg"));
	    Image imgDueno = iconoDueno.getImage().getScaledInstance(110,110,Image.SCALE_SMOOTH);
	    
	    JLabel fotoDueno = new JLabel(new ImageIcon(imgDueno));
	    fotoDueno.setBounds(20,70,110,110);
	    panel.add(fotoDueno);

	    ImageIcon iconoMascota = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));
	    Image imgMascota = iconoMascota.getImage().getScaledInstance(110,110,Image.SCALE_SMOOTH);
	   
	    JButton fotoMascota = new JButton(new ImageIcon(imgMascota));
	    fotoMascota.setBounds(20,215,110,110);
	    panel.add(fotoMascota);

	    fotoMascota.addActionListener(e -> {
	        ventana.dispose();
	        DetallesPaciente();
	    });

	    Font tituloFont = new Font("Adamina", Font.BOLD, 26);
	    Font labelFont = new Font("Adamina", Font.BOLD, 14);
	    Font valorFont = new Font("Adamina", Font.PLAIN, 14);

	    JLabel titulo = new JLabel("Información completa del cliente");
	    titulo.setFont(tituloFont);
	    titulo.setBounds(170,20,600,30);
	    panel.add(titulo);

	    String[][] datos = {
	        {"Nombre",""},
	        {"Apellidos",""},
	        {"Dirección",""},
	        {"Colonia",""},
	        {"Teléfono",""},
	        {"Correo",""},
	        {"Mascota",""},
	        {"Estado",""}
	    };

	    int y = 70;

	    for(String[] fila : datos){

	        JPanel filaPanel = new JPanel();
	        filaPanel.setLayout(null);
	        filaPanel.setBounds(170,y,650,30);
	        filaPanel.setBackground(Color.WHITE);
	        filaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	        panel.add(filaPanel);

	        JLabel etiqueta = new JLabel(fila[0] + ":");
	        etiqueta.setFont(labelFont);
	        etiqueta.setBounds(10,3,150,25);
	        filaPanel.add(etiqueta);

	        JLabel valor = new JLabel(fila[1]);
	        valor.setFont(valorFont);
	        valor.setBounds(160,3,450,25);
	        filaPanel.add(valor);

	        y += 32;
	    }

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,450,150,50);
	    botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    fondo.add(botonRegresar);

	    JButton botonAgregarMascota = new JButton("Añadir mascota");
	    botonAgregarMascota.setBounds(390,450,200,50);
	    botonAgregarMascota.setFont(new Font("Inter", Font.BOLD, 20));
	    botonAgregarMascota.setBackground(Color.decode("#14508C"));
	    botonAgregarMascota.setForeground(Color.WHITE);
	    fondo.add(botonAgregarMascota);

	    JButton botonPagos = new JButton("Pagos");
	    botonPagos.setBounds(740,450,200,50);
	    botonPagos.setFont(new Font("Inter", Font.BOLD, 20));
	    botonPagos.setBackground(Color.decode("#0B2545"));
	    botonPagos.setForeground(Color.WHITE);
	    fondo.add(botonPagos);

	    botonRegresar.addActionListener(e -> {
	        ventana.dispose();
	        PanelDuenos();
	    });

	    botonAgregarMascota.addActionListener(e -> {
	        ventana.dispose();
	        CrearPaciente();
	    });

	    botonPagos.addActionListener(e -> {
	        ventana.dispose();
	        HistorialCostos();
	    });

	    ventana.setVisible(true);
	}
	
	public void DetallesPaciente() {

	    JFrame ventana = new JFrame();
	    ventana.setSize(1000,600);
	    ventana.setTitle("Detalles del paciente");
	    ventana.setLocationRelativeTo(null);
	    ventana.setLayout(null);

	    JPanel fondo = new JPanel();
	    fondo.setBounds(0,0,1000,600);
	    fondo.setLayout(null);
	    fondo.setBackground(Color.decode("#FFFFFF"));
	    ventana.add(fondo);

	    JLabel ultima = new JLabel("Ultima modificacion: 7 de Marzo del 2026");
	    ultima.setBounds(350,10,400,20);
	    fondo.add(ultima);

	    JPanel panel = new JPanel();
	    panel.setBounds(40,40,900,380);
	    panel.setLayout(null);
	    panel.setBackground(Color.decode("#8CACCB"));
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
	    fondo.add(panel);

	    ImageIcon iconoMascota = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));
	    Image imgMascota = iconoMascota.getImage().getScaledInstance(110,110,Image.SCALE_SMOOTH);
	    
	    JLabel fotoMascota = new JLabel(new ImageIcon(imgMascota));
	    fotoMascota.setBounds(20,70,110,110);
	    panel.add(fotoMascota);

	    ImageIcon iconoDueno = new ImageIcon(getClass().getResource("/Imagenes/Doctor_Registro.jpg"));
	    Image imgDueno = iconoDueno.getImage().getScaledInstance(110,110,Image.SCALE_SMOOTH);
	    
	    JButton fotoDueno = new JButton(new ImageIcon(imgDueno));
	    fotoDueno.setBounds(20,215,110,110);
	    panel.add(fotoDueno);

	    fotoDueno.addActionListener(e -> {
	        ventana.dispose();
	        DetallesDueno();
	    });

	    Font tituloFont = new Font("Adamina", Font.BOLD, 26);
	    Font labelFont = new Font("Adamina", Font.BOLD, 14);
	    Font valorFont = new Font("Adamina", Font.PLAIN, 14);

	    JLabel titulo = new JLabel("Información completa del paciente");
	    titulo.setFont(tituloFont);
	    titulo.setBounds(180,20,600,30);
	    panel.add(titulo);

	    String[][] datos = {
	        {"Nombre",""},
	        {"Especie",""},
	        {"Raza",""},
	        {"Edad",""},
	        {"Sexo",""},
	        {"Diagnóstico",""},
	        {"Dueño",""},
	        {"Estado",""}
	    };

	    int y = 70;

	    for(String[] fila : datos){

	        JPanel filaPanel = new JPanel();
	        filaPanel.setLayout(null);
	        filaPanel.setBounds(180,y,650,30);
	        filaPanel.setBackground(Color.WHITE);
	        filaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	        panel.add(filaPanel);

	        JLabel etiqueta = new JLabel(fila[0] + ":");
	        etiqueta.setFont(labelFont);
	        etiqueta.setBounds(10,3,150,25);
	        filaPanel.add(etiqueta);

	        JLabel valor = new JLabel(fila[1]);
	        valor.setFont(valorFont);
	        valor.setBounds(160,3,450,25);
	        filaPanel.add(valor);

	        y += 32;
	    }

	    JButton botonRegresar = new JButton("Regresar");
	    botonRegresar.setBounds(40,450,150,50);
	    botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonRegresar.setBackground(Color.decode("#D81F10"));
	    botonRegresar.setForeground(Color.WHITE);
	    fondo.add(botonRegresar);

	    JButton botonCarnet = new JButton("Carnet");
	    botonCarnet.setBounds(250,450,150,50);
	    botonCarnet.setFont(new Font("Inter", Font.BOLD, 20));
	    botonCarnet.setBackground(Color.decode("#14508C"));
	    botonCarnet.setForeground(Color.WHITE);
	    fondo.add(botonCarnet);

	    JButton botonDescargar = new JButton("Descargar ficha");
	    botonDescargar.setBounds(465,450,200,50);
	    botonDescargar.setFont(new Font("Inter", Font.BOLD, 20));
	    botonDescargar.setBackground(Color.decode("#14508C"));
	    botonDescargar.setForeground(Color.WHITE);
	    fondo.add(botonDescargar);

	    JButton botonHistorial = new JButton("Historial");
	    botonHistorial.setBounds(740,450,200,50);
	    botonHistorial.setFont(new Font("Inter", Font.BOLD, 20));
	    botonHistorial.setBackground(Color.decode("#0B2545"));
	    botonHistorial.setForeground(Color.WHITE);
	    fondo.add(botonHistorial);

	    botonRegresar.addActionListener(e -> {
	        ventana.dispose();
	        PanelDuenos();
	    });

	    botonHistorial.addActionListener(e -> {
	        ventana.dispose();
	        HistorialCostos();
	    });

	    ventana.setVisible(true);
	}
}
