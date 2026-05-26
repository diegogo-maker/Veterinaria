package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import Controller.AuthController;
import Model.Dueno;
import Model.Paciente;

import Model.VeterinariaModel;


public class AuthView {

	 private AuthController controller = new AuthController();
     private String nombreUsuarioActual;

     public void Login() {
    	    JFrame ventana = new JFrame();
    	    ventana.setSize(1000, 600);
    	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    ventana.setLocationRelativeTo(null);
    	    ventana.setTitle("Veterinaria");
    	    ventana.setResizable(true);
    	    ventana.setLayout(null);

    	    JPanel panelIzquierdo = new JPanel();
    	    panelIzquierdo.setBounds(0, 0, 500, 600);
    	    panelIzquierdo.setLayout(new BorderLayout());

    	    JLabel fondo = new JLabel();
    	    ImageIcon imgFondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.png"));
    	    Image imgEscalada = imgFondo.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH);
    	    fondo.setIcon(new ImageIcon(imgEscalada));
    	    panelIzquierdo.add(fondo, BorderLayout.CENTER);
    	    ventana.add(panelIzquierdo);

    	    JPanel panelDerecho = new JPanel();
    	    panelDerecho.setBounds(500, 0, 500, 600);
    	    panelDerecho.setBackground(Color.WHITE);
    	    panelDerecho.setLayout(null);
    	    ventana.add(panelDerecho);

    	    JLabel logo = new JLabel();
    	    logo.setBounds(170, 20, 200, 150);
    	    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
    	    Image imgLogo = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    	    logo.setIcon(new ImageIcon(imgLogo));
    	    panelDerecho.add(logo);

    	    JLabel labelUser = new JLabel("Correo electrónico:");
    	    labelUser.setBounds(50, 200, 400, 30);
    	    labelUser.setFont(new Font("Adamina", Font.PLAIN, 16));
    	    panelDerecho.add(labelUser);

    	    JTextField campoUser = new JTextField();
    	    campoUser.setBounds(50, 235, 400, 40);
    	    campoUser.setFont(new Font("Adamina", Font.PLAIN, 14));
    	    panelDerecho.add(campoUser);

    	    JLabel labelPass = new JLabel("Contraseña:");
    	    labelPass.setBounds(50, 295, 400, 30);
    	    labelPass.setFont(new Font("Adamina", Font.PLAIN, 16));
    	    panelDerecho.add(labelPass);

    	    JPasswordField campoPass = new JPasswordField();
    	    campoPass.setBounds(50, 330, 400, 40);
    	    campoPass.setFont(new Font("Adamina", Font.PLAIN, 14));
    	    panelDerecho.add(campoPass);

    	    JButton salir = new JButton("Salir");
    	    salir.setBounds(50, 430, 150, 50);
    	    salir.setFont(new Font("Inter", Font.BOLD, 18));
    	    salir.setBackground(Color.decode("#D81F10"));
    	    salir.setForeground(Color.WHITE);
    	    salir.setFocusPainted(false);
    	    panelDerecho.add(salir);

    	    salir.addActionListener(e -> ventana.dispose());

    	    JButton acceder = new JButton("Acceder");
    	    acceder.setBounds(250, 430, 200, 50);
    	    acceder.setFont(new Font("Inter", Font.BOLD, 18));
    	    acceder.setBackground(Color.decode("#14518C"));
    	    acceder.setForeground(Color.WHITE);
    	    acceder.setFocusPainted(false);
    	    panelDerecho.add(acceder);

    	    acceder.addActionListener(e -> {
    	        String usuario = campoUser.getText().trim();
    	        String password = new String(campoPass.getPassword()).trim();
    	        
    	        if (usuario.isEmpty() || password.isEmpty()) {
    	            JOptionPane.showMessageDialog(null, "Por favor ingrese correo y contraseña");
    	            return;
    	        }
    	        
    	        System.out.println("Intentando login con: " + usuario);
    	        
    	        String nombre = controller.login(usuario, password);
    	        
    	        if (nombre != null) {
    	            System.out.println("Login exitoso: " + nombre);
    	            ventana.dispose();
    	            Inicio(nombre);
    	        } else {
    	            System.out.println("Login fallido para: " + usuario);
    	            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
    	        }
    	    });

    	    ventana.setVisible(true);
    	}

     public void Salir() {
         JPanel panel = new JPanel();
         panel.setLayout(null);
         panel.setBackground(Color.WHITE);
         panel.setPreferredSize(new Dimension(420, 180));

         ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
         Image img = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
         JLabel logo = new JLabel(new ImageIcon(img));
         logo.setBounds(185, 5, 50, 50);
         panel.add(logo);

         JLabel texto = new JLabel("¿Deseas cerrar la sesión?");
         texto.setBounds(40, 60, 340, 30);
         texto.setHorizontalAlignment(SwingConstants.CENTER);
         texto.setFont(new Font("Adamina", Font.PLAIN, 22));
         panel.add(texto);

         JButton confirmar = new JButton("Sí, salir");
         confirmar.setBounds(55, 110, 140, 40);
         confirmar.setBackground(Color.decode("#D81F10"));
         confirmar.setForeground(Color.WHITE);
         confirmar.setFont(new Font("Inter", Font.BOLD, 16));
         confirmar.setFocusPainted(false);
         confirmar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

         JButton cancelar = new JButton("Cancelar");
         cancelar.setBounds(225, 110, 140, 40);
         cancelar.setBackground(Color.decode("#14518C"));
         cancelar.setForeground(Color.WHITE);
         cancelar.setFont(new Font("Inter", Font.BOLD, 16));
         cancelar.setFocusPainted(false);
         cancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

         panel.add(confirmar);
         panel.add(cancelar);

         UIManager.put("OptionPane.background", Color.WHITE);
         UIManager.put("Panel.background", Color.WHITE);

         JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                 JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
         JDialog dialog = optionPane.createDialog("Salir");
         dialog.setIconImage(icono.getImage());

         confirmar.addActionListener(e -> {
             dialog.dispose();
             Login();
         });

         cancelar.addActionListener(e -> {
             dialog.dispose();
             Inicio(nombreUsuarioActual);
         });

         dialog.setLocationRelativeTo(null);
         dialog.setVisible(true);
     }
	
     public void Inicio(String nombre) {
         this.nombreUsuarioActual = nombre;

         JFrame ventana = new JFrame();
         ventana.setSize(1000, 600);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventana.setLocationRelativeTo(null);
         ventana.setMinimumSize(new Dimension(200, 200));
         ventana.setTitle("Inicio");
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

         JLabel nombreLabel = new JLabel(nombre);
         nombreLabel.setOpaque(true);
         nombreLabel.setFont(new Font("Adamina", Font.BOLD, 20));
         nombreLabel.setBackground(Color.decode("#FFFFFF"));
         nombreLabel.setBounds(190, 10, 695, 40);
         nombreLabel.setHorizontalAlignment(JLabel.CENTER);
         nombreLabel.setBorder(new LineBorder(Color.BLACK, 1, true));
         panel.add(nombreLabel);

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
         JFrame ventana = new JFrame();
         ventana.setSize(1000, 600);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventana.setLocationRelativeTo(null);
         ventana.setMinimumSize(new Dimension(200, 200));
         ventana.setTitle("Costos de consultas");
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
             Inicio(nombreUsuarioActual);
         });

         ventana.setVisible(true);
     }

     public void RegistroCitas() {
         JFrame ventana = new JFrame("Registro de citas");
         ventana.setSize(1000, 600);
         ventana.setLocationRelativeTo(null);
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
         contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
         contenedor.setBackground(Color.decode("#FFFFFF"));

         JScrollPane scroll = new JScrollPane(contenedor);
         scroll.setBounds(50, 80, 900, 380);
         scroll.setBorder(null);
         scroll.getVerticalScrollBar().setUnitIncrement(16);
         fondo.add(scroll);

         ArrayList<Paciente> listaPacientes = controller.listarPacientes();

         for (Paciente paciente : listaPacientes) {
             JPanel panel = new JPanel();
             panel.setLayout(null);
             panel.setBackground(Color.decode("#8CACCB"));
             panel.setPreferredSize(new Dimension(850, 120));
             panel.setMaximumSize(new Dimension(850, 120));
             panel.setMinimumSize(new Dimension(850, 120));
             panel.setBorder(BorderFactory.createCompoundBorder(
                     BorderFactory.createEmptyBorder(0, 0, 10, 0),
                     new LineBorder(Color.BLACK, 2, true)));

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
                 DetallesPaciente(paciente);
             });

             JLabel nombre = new JLabel(paciente.getNombre());
             nombre.setFont(new Font("Adamina", Font.BOLD, 28));
             nombre.setBounds(120, 10, 300, 40);
             panel.add(nombre);

             JLabel desc = new JLabel(paciente.getEspecie() + " / " + paciente.getRaza());
             desc.setFont(new Font("Adamina", Font.PLAIN, 18));
             desc.setBounds(120, 50, 300, 30);
             panel.add(desc);

             String fechaCita = paciente.getFecha() != null ? paciente.getFecha() : "No asignada";
             JLabel cita = new JLabel("Próxima cita: " + fechaCita);
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
                 Dueno dueno = controller.obtenerDuenoPorId(paciente.getIdDueno());
                 HistorialCostos(paciente, dueno);
             });
             panel.add(historial);

             JButton crear = new JButton("Crear");
             crear.setBounds(590, 60, 100, 35);
             crear.setBackground(Color.decode("#14518C"));
             crear.setForeground(Color.white);
             crear.setFont(new Font("Inter", Font.BOLD, 20));
             crear.addActionListener(e -> {
                 ventana.dispose();
                 CrearCita();
             });
             panel.add(crear);

             JButton editar = new JButton("Editar");
             editar.setBounds(700, 60, 100, 35);
             editar.setBackground(Color.decode("#14518C"));
             editar.setForeground(Color.white);
             editar.setFont(new Font("Inter", Font.BOLD, 20));
             editar.addActionListener(e -> {
                 ventana.dispose();
                 EdicionCita(paciente);
             });
             panel.add(editar);

             contenedor.add(panel);
         }

         contenedor.revalidate();
         contenedor.repaint();

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
             Inicio(nombreUsuarioActual);
         });

         ventana.setVisible(true);
     }

     public void DetallesPaciente(Paciente paciente) {
         JFrame ventana = new JFrame();
         ventana.setSize(1000, 600);
         ventana.setTitle("Detalles del paciente");
         ventana.setLocationRelativeTo(null);
         ventana.setLayout(null);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel fondo = new JPanel();
         fondo.setBounds(0, 0, 1000, 600);
         fondo.setLayout(null);
         fondo.setBackground(Color.decode("#FFFFFF"));
         ventana.add(fondo);

         JPanel panel = new JPanel();
         panel.setBounds(40, 40, 900, 380);
         panel.setLayout(null);
         panel.setBackground(Color.decode("#8CACCB"));
         panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
         fondo.add(panel);

         JLabel fotoMascota = new JLabel();
         fotoMascota.setBounds(20, 70, 110, 110);
         fotoMascota.setOpaque(true);
         fotoMascota.setBackground(Color.WHITE);
         fotoMascota.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

         if (paciente.getFoto() != null && !paciente.getFoto().equals("")) {
             ImageIcon iconoMascota = new ImageIcon(paciente.getFoto());
             Image imgMascota = iconoMascota.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
             fotoMascota.setIcon(new ImageIcon(imgMascota));
         } else {
             ImageIcon iconoMascota = new ImageIcon(getClass().getResource("/Imagenes/fotomascota.jpg"));
             Image imgMascota = iconoMascota.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
             fotoMascota.setIcon(new ImageIcon(imgMascota));
         }
         panel.add(fotoMascota);

         Font tituloFont = new Font("Adamina", Font.BOLD, 26);
         Font labelFont = new Font("Adamina", Font.BOLD, 14);
         Font valorFont = new Font("Adamina", Font.PLAIN, 14);

         JLabel titulo = new JLabel("Información completa del paciente");
         titulo.setFont(tituloFont);
         titulo.setBounds(180, 20, 600, 30);
         panel.add(titulo);

         String[][] datos = {
                 {"Nombre", paciente.getNombre()},
                 {"Especie", paciente.getEspecie()},
                 {"Raza", paciente.getRaza()},
                 {"Edad", paciente.getEdad()},
                 {"Sexo", paciente.getSexo()},
                 {"Diagnóstico", paciente.getDiagnostico()},
                 {"Fecha", paciente.getFecha()},
                 {"Doctor", paciente.getDoctor()}
         };

         int y = 70;
         for (String[] fila : datos) {
             JPanel filaPanel = new JPanel();
             filaPanel.setLayout(null);
             filaPanel.setBounds(180, y, 650, 30);
             filaPanel.setBackground(Color.WHITE);
             filaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
             panel.add(filaPanel);

             JLabel etiqueta = new JLabel(fila[0] + ":");
             etiqueta.setFont(labelFont);
             etiqueta.setBounds(10, 3, 150, 25);
             filaPanel.add(etiqueta);

             JLabel valor = new JLabel(fila[1]);
             valor.setFont(valorFont);
             valor.setBounds(160, 3, 450, 25);
             filaPanel.add(valor);

             y += 32;
         }

         JButton botonRegresar = new JButton("Regresar");
         botonRegresar.setBounds(40, 450, 180, 50);
         botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
         botonRegresar.setBackground(Color.decode("#D81F10"));
         botonRegresar.setForeground(Color.WHITE);
         fondo.add(botonRegresar);

         botonRegresar.addActionListener(e -> {
             ventana.dispose();
             PanelDuenos();
         });

         ventana.setVisible(true);
     }

     public void HistorialCostos(Paciente paciente, Dueno dueno) {
         JFrame ventana = new JFrame("Historial de costos");
         ventana.setSize(1000, 600);
         ventana.setLocationRelativeTo(null);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventana.setLayout(null);

         JPanel fondo = new JPanel();
         fondo.setBounds(0, 0, 1000, 600);
         fondo.setLayout(null);
         fondo.setBackground(Color.WHITE);
         ventana.add(fondo);

         JLabel titulo = new JLabel("Costo final de consultas y medicamentos");
         titulo.setBounds(50, 20, 900, 40);
         titulo.setFont(new Font("Adamina", Font.BOLD, 28));
         fondo.add(titulo);

         String urgencia = (paciente.getUrgencia() != null) ? paciente.getUrgencia() : "Baja";
         String medicamento = (paciente.getMedicamento() != null) ? paciente.getMedicamento() : "Ninguno";

         String costoConsulta = "$700";
         if (urgencia.equals("Alta")) costoConsulta = "$2000";
         else if (urgencia.equals("Media")) costoConsulta = "$1200";

         String costoMedicamento = "$0";
         if (medicamento.equals("Antibiótico clavoxivet")) costoMedicamento = "$295";
         else if (medicamento.equals("Antiparasitarios")) costoMedicamento = "$300";
         else if (medicamento.equals("Desparacitante Care Max")) costoMedicamento = "$85";

         int total = Integer.parseInt(costoConsulta.replace("$", "")) +
                     Integer.parseInt(costoMedicamento.replace("$", ""));

         String[][] data = {{
             paciente.getTipoCita() != null ? paciente.getTipoCita() : "No especificada",
             urgencia,
             medicamento,
             costoConsulta,
             costoMedicamento,
             "$" + total
         }};

         String[] cols = {"Consulta", "Urgencia", "Medicamento", "Costo consulta", "Costo medicamento", "Total"};

         JTable tabla = new JTable(data, cols);
         tabla.setRowHeight(40);
         JScrollPane sp = new JScrollPane(tabla);
         sp.setBounds(50, 140, 850, 200);
         fondo.add(sp);

         JLabel totalLabel = new JLabel("Costo total: $" + total);
         totalLabel.setBounds(600, 360, 300, 40);
         totalLabel.setFont(new Font("Adamina", Font.BOLD, 26));
         fondo.add(totalLabel);

         JButton regresar = new JButton("Regresar");
         regresar.setBounds(50, 450, 180, 50);
         regresar.setFont(new Font("Inter", Font.BOLD, 20));
         regresar.setBackground(Color.decode("#D81F10"));
         regresar.setForeground(Color.WHITE);
         regresar.addActionListener(e -> {
             ventana.dispose();
             RegistroCitas();
         });
         fondo.add(regresar);

         ventana.setVisible(true);
     }

     public void CrearCita() {
         JFrame ventana = new JFrame();
         ventana.setSize(1000, 600);
         ventana.setTitle("Crear cita");
         ventana.setLocationRelativeTo(null);
         ventana.setLayout(null);
         ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel fondo = new JPanel();
         fondo.setBounds(0, 0, 1000, 600);
         fondo.setLayout(null);
         fondo.setBackground(Color.WHITE);
         ventana.add(fondo);

         JLabel titulo = new JLabel("Crear nueva cita");
         titulo.setBounds(40, 20, 400, 40);
         titulo.setFont(new Font("Adamina", Font.BOLD, 32));
         fondo.add(titulo);

         JPanel panel = new JPanel();
         panel.setBounds(40, 80, 900, 400);
         panel.setLayout(null);
         panel.setBackground(Color.decode("#8CACCB"));
         panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
         fondo.add(panel);

         // Obtener el último dueño registrado
         Dueno dueno = controller.obtenerUltimoDueno();
         
         if (dueno == null) {
             JOptionPane.showMessageDialog(null, "Primero debe registrar un dueño");
             ventana.dispose();
             CrearDueno();
             return;
         }
         
         // Obtener la mascota del dueño
         Paciente paciente = controller.obtenerPacientePorDueno(dueno.getId());
         
         if (paciente == null) {
             JOptionPane.showMessageDialog(null, "Este dueño no tiene mascota registrada.\nPrimero registre una mascota.");
             ventana.dispose();
             CrearPaciente(dueno);
             return;
         }

         // Mostrar información del dueño
         JLabel labelDueno = new JLabel("Dueño:");
         labelDueno.setBounds(40, 40, 150, 30);
         labelDueno.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelDueno);

         JTextField campoDueno = new JTextField(dueno.getNombre() + " " + dueno.getApellidos());
         campoDueno.setBounds(180, 40, 250, 30);
         campoDueno.setEditable(false);
         campoDueno.setFont(new Font("Adamina", Font.PLAIN, 14));
         panel.add(campoDueno);

         // Mostrar información de la mascota
         JLabel labelMascota = new JLabel("Mascota:");
         labelMascota.setBounds(470, 40, 150, 30);
         labelMascota.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelMascota);

         JTextField campoMascota = new JTextField(paciente.getNombre());
         campoMascota.setBounds(620, 40, 220, 30);
         campoMascota.setEditable(false);
         campoMascota.setFont(new Font("Adamina", Font.PLAIN, 14));
         panel.add(campoMascota);

         // Fecha de la cita
         JLabel labelFecha = new JLabel("Fecha:");
         labelFecha.setBounds(40, 100, 150, 30);
         labelFecha.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelFecha);

         JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel());
         JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
         spinnerFecha.setEditor(dateEditor);
         spinnerFecha.setBounds(180, 100, 250, 30);
         panel.add(spinnerFecha);

         // Doctor
         JLabel labelDoctor = new JLabel("Doctor:");
         labelDoctor.setBounds(470, 100, 150, 30);
         labelDoctor.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelDoctor);

         JComboBox<String> comboDoctor = new JComboBox<>(controller.listarDoctores().toArray(new String[0]));
         comboDoctor.setBounds(620, 100, 220, 30);
         panel.add(comboDoctor);

         // Urgencia
         JLabel labelUrgencia = new JLabel("Urgencia:");
         labelUrgencia.setBounds(40, 160, 150, 30);
         labelUrgencia.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelUrgencia);

         JComboBox<String> comboUrgencia = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
         comboUrgencia.setBounds(180, 160, 250, 30);
         panel.add(comboUrgencia);

         // Tipo de cita
         JLabel labelTipo = new JLabel("Tipo:");
         labelTipo.setBounds(470, 160, 150, 30);
         labelTipo.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelTipo);

         JComboBox<String> comboTipo = new JComboBox<>(new String[]{
                 "Consulta rutinaria", "Consulta urgencias", "Consulta especializada",
                 "Vacunación", "Desparasitación", "Consulta a domicilio"
         });
         comboTipo.setBounds(620, 160, 220, 30);
         panel.add(comboTipo);

         // Medicamento
         JLabel labelMed = new JLabel("Medicamento:");
         labelMed.setBounds(40, 220, 150, 30);
         labelMed.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelMed);

         JComboBox<String> comboMed = new JComboBox<>(new String[]{
                 "Ninguno", "Antibiótico clavoxivet", "Antiparasitarios", "Desparacitante Care Max"
         });
         comboMed.setBounds(180, 220, 250, 30);
         panel.add(comboMed);

         // Costo (se calcula automáticamente)
         JLabel labelCosto = new JLabel("Costo:");
         labelCosto.setBounds(470, 220, 150, 30);
         labelCosto.setFont(new Font("Adamina", Font.BOLD, 16));
         panel.add(labelCosto);

         JTextField campoCosto = new JTextField();
         campoCosto.setBounds(620, 220, 220, 30);
         campoCosto.setEditable(false);
         campoCosto.setFont(new Font("Adamina", Font.BOLD, 14));
         campoCosto.setBackground(Color.WHITE);
         panel.add(campoCosto);

         // Actualizar costo cuando cambien los valores
         comboUrgencia.addActionListener(e -> actualizarCosto(comboTipo, comboUrgencia, comboMed, campoCosto));
         comboTipo.addActionListener(e -> actualizarCosto(comboTipo, comboUrgencia, comboMed, campoCosto));
         comboMed.addActionListener(e -> actualizarCosto(comboTipo, comboUrgencia, comboMed, campoCosto));
         actualizarCosto(comboTipo, comboUrgencia, comboMed, campoCosto);

         // Botón Guardar
         JButton guardar = new JButton("Guardar cita");
         guardar.setBounds(620, 300, 220, 50);
         guardar.setBackground(Color.decode("#14518C"));
         guardar.setForeground(Color.WHITE);
         guardar.setFont(new Font("Inter", Font.BOLD, 20));
         guardar.setFocusPainted(false);
         panel.add(guardar);

         // Variable final para usar en el listener
         final Paciente pacienteFinal = paciente;
         final Dueno duenoFinal = dueno;

         guardar.addActionListener(e -> {
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String fecha = sdf.format((Date) spinnerFecha.getValue());

             String tipo = comboTipo.getSelectedItem().toString();
             String urgencia = comboUrgencia.getSelectedItem().toString();
             String medicamento = comboMed.getSelectedItem().toString();
             
             // Calcular costo
             double costoConsulta = 0;
             if (tipo.equals("Consulta rutinaria")) costoConsulta = 700;
             else if (tipo.equals("Consulta urgencias")) costoConsulta = 2000;
             else if (tipo.equals("Consulta especializada")) costoConsulta = 2000;
             else if (tipo.equals("Vacunación")) costoConsulta = 1500;
             else if (tipo.equals("Desparasitación")) costoConsulta = 600;
             else if (tipo.equals("Consulta a domicilio")) costoConsulta = 1800;

             double costoMedicamento = 0;
             if (medicamento.equals("Antibiótico clavoxivet")) costoMedicamento = 295;
             else if (medicamento.equals("Antiparasitarios")) costoMedicamento = 300;
             else if (medicamento.equals("Desparacitante Care Max")) costoMedicamento = 85;

             double costo = costoConsulta + costoMedicamento;

             // Actualizar el paciente con los datos de la cita
             boolean exito = controller.actualizarPaciente(
                 pacienteFinal.getId(),
                 pacienteFinal.getNombre(),
                 pacienteFinal.getEspecie(),
                 pacienteFinal.getRaza(),
                 pacienteFinal.getEdad(),
                 pacienteFinal.getSexo(),
                 fecha,
                 comboDoctor.getSelectedItem().toString(),
                 pacienteFinal.getDiagnostico(),
                 pacienteFinal.getHistorial(),
                 pacienteFinal.getFoto(),
                 urgencia,
                 tipo
             );

             if (exito) {
                 JOptionPane.showMessageDialog(null, "Cita creada correctamente");
                 ventana.dispose();
                 RegistroCitas();
             } else {
                 JOptionPane.showMessageDialog(null, "Error al guardar la cita");
             }
         });

         // Botón Regresar
         JButton regresar = new JButton("Regresar");
         regresar.setBounds(40, 500, 180, 50);
         regresar.setBackground(Color.decode("#D81F10"));
         regresar.setForeground(Color.WHITE);
         regresar.setFont(new Font("Inter", Font.BOLD, 20));
         regresar.setFocusPainted(false);
         fondo.add(regresar);

         regresar.addActionListener(e -> {
             ventana.dispose();
             RegistroCitas();
         });

         ventana.setVisible(true);
     }

     private void actualizarCosto(JComboBox<String> comboTipo, JComboBox<String> comboUrgencia, 
                                   JComboBox<String> comboMed, JTextField campoCosto) {
         String tipo = comboTipo.getSelectedItem().toString();
         String medicamento = comboMed.getSelectedItem().toString();

         double costoConsulta = 0;
         if (tipo.equals("Consulta rutinaria")) costoConsulta = 700;
         else if (tipo.equals("Consulta urgencias")) costoConsulta = 2000;
         else if (tipo.equals("Consulta especializada")) costoConsulta = 2000;
         else if (tipo.equals("Vacunación")) costoConsulta = 1500;
         else if (tipo.equals("Desparasitación")) costoConsulta = 600;
         else if (tipo.equals("Consulta a domicilio")) costoConsulta = 1800;

         double costoMedicamento = 0;
         if (medicamento.equals("Antibiótico clavoxivet")) costoMedicamento = 295;
         else if (medicamento.equals("Antiparasitarios")) costoMedicamento = 300;
         else if (medicamento.equals("Desparacitante Care Max")) costoMedicamento = 85;

         double total = costoConsulta + costoMedicamento;
         campoCosto.setText("$" + total + " MXN");
     }

     public void EdicionCita(Paciente paciente) {
    	    JFrame ventana = new JFrame();
    	    ventana.setSize(1000, 600);
    	    ventana.setTitle("Edición de cita");
    	    ventana.setLocationRelativeTo(null);
    	    ventana.setLayout(null);
    	    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	    JPanel fondo = new JPanel();
    	    fondo.setBounds(0, 0, 1000, 600);
    	    fondo.setLayout(null);
    	    fondo.setBackground(Color.decode("#FFFFFF"));
    	    ventana.add(fondo);

    	    JLabel titulo = new JLabel("Edición de cita");
    	    titulo.setFont(new Font("Adamina", Font.BOLD, 34));
    	    titulo.setBounds(40, 20, 400, 40);
    	    fondo.add(titulo);

    	    JPanel panel = new JPanel();
    	    panel.setBounds(40, 80, 900, 400);
    	    panel.setLayout(null);
    	    panel.setBackground(Color.decode("#8CACCB"));
    	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    	    fondo.add(panel);

    	    Font labelFont = new Font("Adamina", Font.BOLD, 18);
    	    Font fieldFont = new Font("Adamina", Font.PLAIN, 18);

    	    int y = 40;
    	    int anchoLabel = 120;
    	    int anchoCampo = 250;
    	    int espacio = 30;

    	    JLabel lblNombre = new JLabel("Nombre:");
    	    lblNombre.setBounds(50, y, anchoLabel, 35);
    	    lblNombre.setFont(labelFont);
    	    panel.add(lblNombre);

    	    JTextField txtNombre = new JTextField(paciente.getNombre());
    	    txtNombre.setBounds(180, y, anchoCampo, 40);
    	    txtNombre.setFont(fieldFont);
    	    panel.add(txtNombre);

    	    JLabel lblEspecie = new JLabel("Especie:");
    	    lblEspecie.setBounds(500, y, anchoLabel, 35);
    	    lblEspecie.setFont(labelFont);
    	    panel.add(lblEspecie);

    	    JTextField txtEspecie = new JTextField(paciente.getEspecie());
    	    txtEspecie.setBounds(630, y, anchoCampo, 40);
    	    txtEspecie.setFont(fieldFont);
    	    panel.add(txtEspecie);

    	    y += 65;
    	    
    	    JLabel lblRaza = new JLabel("Raza:");
    	    lblRaza.setBounds(50, y, anchoLabel, 35);
    	    lblRaza.setFont(labelFont);
    	    panel.add(lblRaza);

    	    JTextField txtRaza = new JTextField(paciente.getRaza());
    	    txtRaza.setBounds(180, y, anchoCampo, 40);
    	    txtRaza.setFont(fieldFont);
    	    panel.add(txtRaza);
    	    
    	    JLabel lblFecha = new JLabel("Fecha:");
    	    lblFecha.setBounds(500, y, anchoLabel, 35);
    	    lblFecha.setFont(labelFont);
    	    panel.add(lblFecha);

    	    JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel());
    	    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
    	    spinnerFecha.setEditor(dateEditor);
    	    spinnerFecha.setBounds(630, y, anchoCampo, 40);
    	    spinnerFecha.setFont(fieldFont);
    	    
    	    if (paciente.getFecha() != null && !paciente.getFecha().isEmpty()) {
    	        try {
    	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	            Date fecha = sdf.parse(paciente.getFecha());
    	            spinnerFecha.setValue(fecha);
    	        } catch (Exception e) {
    	            // Si no se puede parsear, dejar fecha actual
    	        }
    	    }
    	    panel.add(spinnerFecha);

    	    y += 65;

    	    JLabel lblDoctor = new JLabel("Doctor:");
    	    lblDoctor.setBounds(50, y, anchoLabel, 35);
    	    lblDoctor.setFont(labelFont);
    	    panel.add(lblDoctor);

    	    JComboBox<String> comboDoctor = new JComboBox<>(controller.listarDoctores().toArray(new String[0]));
    	    comboDoctor.setSelectedItem(paciente.getDoctor());
    	    comboDoctor.setBounds(180, y, anchoCampo, 40);
    	    comboDoctor.setFont(fieldFont);
    	    panel.add(comboDoctor);

    	    JLabel lblUrgencia = new JLabel("Urgencia:");
    	    lblUrgencia.setBounds(500, y, anchoLabel, 35);
    	    lblUrgencia.setFont(labelFont);
    	    panel.add(lblUrgencia);

    	    JComboBox<String> comboUrgencia = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
    	    if (paciente.getUrgencia() != null) comboUrgencia.setSelectedItem(paciente.getUrgencia());
    	    comboUrgencia.setBounds(630, y, anchoCampo, 40);
    	    comboUrgencia.setFont(fieldFont);
    	    panel.add(comboUrgencia);

    	    y += 65;

    	    JLabel lblTipo = new JLabel("Tipo:");
    	    lblTipo.setBounds(50, y, anchoLabel, 35);
    	    lblTipo.setFont(labelFont);
    	    panel.add(lblTipo);

    	    JComboBox<String> comboTipo = new JComboBox<>(new String[]{
    	        "Consulta rutinaria", "Consulta urgencias", "Consulta especializada",
    	        "Vacunación", "Desparasitación", "Consulta a domicilio"
    	    });
    	    
    	    if (paciente.getTipoCita() != null) comboTipo.setSelectedItem(paciente.getTipoCita());
    	    comboTipo.setBounds(180, y, anchoCampo, 40);
    	    comboTipo.setFont(fieldFont);
    	    panel.add(comboTipo);

    	    JLabel lblMedicina = new JLabel("Medicina:");
    	    lblMedicina.setBounds(500, y, anchoLabel, 35);
    	    lblMedicina.setFont(labelFont);
    	    panel.add(lblMedicina);

    	    JComboBox<String> comboMedicina = new JComboBox<>(new String[]{
    	        "Ninguno", "Antibiótico clavoxivet", "Antiparasitarios", "Desparacitante Care Max"
    	    });
    	    if (paciente.getMedicamento() != null) comboMedicina.setSelectedItem(paciente.getMedicamento());
    	    comboMedicina.setBounds(630, y, anchoCampo, 40);
    	    comboMedicina.setFont(fieldFont);
    	    panel.add(comboMedicina);

    	    y += 65;

    	    JLabel lblCosto = new JLabel("Costo:");
    	    lblCosto.setBounds(50, y, anchoLabel, 35);
    	    lblCosto.setFont(labelFont);
    	    panel.add(lblCosto);

    	    JTextField txtCosto = new JTextField();
    	    txtCosto.setBounds(180, y, anchoCampo, 40);
    	    txtCosto.setEditable(false);
    	    txtCosto.setFont(new Font("Adamina", Font.BOLD, 18));
    	    txtCosto.setBackground(Color.WHITE);
    	    txtCosto.setHorizontalAlignment(JTextField.CENTER);
    	    panel.add(txtCosto);

    	    Runnable actualizarCosto = () -> {
    	        String tipo = comboTipo.getSelectedItem().toString();
    	        String medicina = comboMedicina.getSelectedItem().toString();

    	        double costoConsulta = 0;
    	        if (tipo.equals("Consulta rutinaria")) costoConsulta = 700;
    	        else if (tipo.equals("Consulta urgencias")) costoConsulta = 2000;
    	        else if (tipo.equals("Consulta especializada")) costoConsulta = 2000;
    	        else if (tipo.equals("Vacunación")) costoConsulta = 1500;
    	        else if (tipo.equals("Desparasitación")) costoConsulta = 600;
    	        else if (tipo.equals("Consulta a domicilio")) costoConsulta = 1800;

    	        double costoMedicina = 0;
    	        if (medicina.equals("Antibiótico clavoxivet")) costoMedicina = 295;
    	        else if (medicina.equals("Antiparasitarios")) costoMedicina = 300;
    	        else if (medicina.equals("Desparacitante Care Max")) costoMedicina = 85;

    	        double total = costoConsulta + costoMedicina;
    	        txtCosto.setText(String.format("$%.0f MXN", total));
    	    };

    	    comboTipo.addActionListener(e -> actualizarCosto.run());
    	    comboUrgencia.addActionListener(e -> actualizarCosto.run());
    	    comboMedicina.addActionListener(e -> actualizarCosto.run());
    	    actualizarCosto.run();

    	    JButton guardar = new JButton("Guardar");
    	    guardar.setBounds(690, 500, 200, 55);
    	    guardar.setBackground(Color.decode("#14518C"));
    	    guardar.setForeground(Color.WHITE);
    	    guardar.setFont(new Font("Inter", Font.BOLD, 22));
    	    guardar.setFocusPainted(false);
    	    fondo.add(guardar);

    	    JButton regresar = new JButton("Regresar");
    	    regresar.setBounds(40, 500, 200, 55);
    	    regresar.setBackground(Color.decode("#D81F10"));
    	    regresar.setForeground(Color.WHITE);
    	    regresar.setFont(new Font("Inter", Font.BOLD, 22));
    	    regresar.setFocusPainted(false);
    	    fondo.add(regresar);

    	    guardar.addActionListener(e -> {
    	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	        String fecha = sdf.format((Date) spinnerFecha.getValue());

    	        boolean exito = controller.actualizarPaciente(
    	            paciente.getId(),
    	            txtNombre.getText().trim(),
    	            txtEspecie.getText().trim(),
    	            txtRaza.getText().trim(),
    	            paciente.getEdad(),
    	            paciente.getSexo(),
    	            fecha,
    	            comboDoctor.getSelectedItem().toString(),
    	            paciente.getDiagnostico(),
    	            paciente.getHistorial(),
    	            paciente.getFoto(),
    	            comboUrgencia.getSelectedItem().toString(),
    	            comboTipo.getSelectedItem().toString()
    	        );

    	        if (exito) {
    	            JOptionPane.showMessageDialog(null, "Cita actualizada correctamente");
    	            ventana.dispose();
    	            RegistroCitas();
    	        } else {
    	            JOptionPane.showMessageDialog(null, "Error al actualizar la cita");
    	        }
    	    });

    	    regresar.addActionListener(e -> {
    	        ventana.dispose();
    	        RegistroCitas();
    	    });

    	    ventana.setVisible(true);
    	}
	
    public void PanelDuenos() {
        JFrame ventana = new JFrame("Registro de dueños");
        ventana.setSize(1000, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.WHITE);
        ventana.add(fondo);

        JLabel titulo = new JLabel("Registro de dueños");
        titulo.setBounds(40, 20, 400, 40);
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        fondo.add(titulo);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBackground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(contenedor);
        scroll.setBounds(40, 80, 900, 380);
        scroll.setBorder(null);
        fondo.add(scroll);

        ArrayList<Dueno> listaDuenos = controller.listarDuenos();

        for (Dueno dueno : listaDuenos) {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.decode("#8CACCB"));
            panel.setPreferredSize(new Dimension(850, 120));
            panel.setMaximumSize(new Dimension(850, 120));
            panel.setMinimumSize(new Dimension(850, 120));
            panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, 10, 0),
                    new LineBorder(Color.BLACK, 2, true)));

            if (dueno.getFoto() != null && !dueno.getFoto().isEmpty()) {
                ImageIcon icono = new ImageIcon(dueno.getFoto());
                Image img = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                JButton foto = new JButton(new ImageIcon(img));
                foto.setBounds(20, 20, 80, 80);
                foto.setBorder(null);
                foto.setFocusPainted(false);
                foto.addActionListener(e -> {
                    Paciente paciente = controller.obtenerPacientePorDueno(dueno.getId());
                    if (paciente != null) {
                        ventana.dispose();
                        DetallesPaciente(paciente);
                    } else {
                        JOptionPane.showMessageDialog(null, "Este dueño no tiene mascota registrada");
                    }
                });
                panel.add(foto);
            } else {
                JLabel foto = new JLabel("Sin foto");
                foto.setBounds(20, 20, 80, 80);
                foto.setHorizontalAlignment(SwingConstants.CENTER);
                foto.setVerticalAlignment(SwingConstants.CENTER);
                foto.setFont(new Font("Inter", Font.BOLD, 12));
                foto.setOpaque(true);
                foto.setBackground(Color.LIGHT_GRAY);
                foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                panel.add(foto);
            }

            JLabel nombre = new JLabel(dueno.getNombre() + " " + dueno.getApellidos());
            nombre.setBounds(120, 15, 350, 35);
            nombre.setFont(new Font("Adamina", Font.BOLD, 24));
            panel.add(nombre);

            JLabel mascota = new JLabel("Mascota: " + dueno.getMascota());
            mascota.setBounds(120, 55, 300, 30);
            mascota.setFont(new Font("Adamina", Font.PLAIN, 18));
            panel.add(mascota);

            JLabel telefono = new JLabel("Teléfono: " + dueno.getTelefono());
            telefono.setBounds(450, 20, 300, 30);
            telefono.setFont(new Font("Adamina", Font.PLAIN, 18));
            panel.add(telefono);

            JButton detalles = new JButton("Detalles");
            detalles.setBounds(450, 60, 120, 35);
            detalles.setBackground(Color.decode("#14518C"));
            detalles.setForeground(Color.WHITE);
            detalles.setFont(new Font("Inter", Font.BOLD, 18));
            panel.add(detalles);

            JButton editar = new JButton("Editar");
            editar.setBounds(590, 60, 100, 35);
            editar.setBackground(Color.decode("#14518C"));
            editar.setForeground(Color.WHITE);
            editar.setFont(new Font("Inter", Font.BOLD, 18));
            panel.add(editar);

            JButton eliminar = new JButton("Eliminar");
            eliminar.setBounds(710, 60, 120, 35);
            eliminar.setBackground(Color.decode("#D81F10"));
            eliminar.setForeground(Color.WHITE);
            eliminar.setFont(new Font("Inter", Font.BOLD, 18));
            panel.add(eliminar);

            detalles.addActionListener(e -> {
                ventana.dispose();
                DetallesDueno(dueno);
            });

            editar.addActionListener(e -> {
                ventana.dispose();
                CrearDueno(dueno);
            });

            eliminar.addActionListener(e -> {
                EliminarRegistroDueno(dueno.getId());
            });

            contenedor.add(panel);
        }

        JButton regresar = new JButton("Regresar");
        regresar.setBounds(40, 490, 180, 60);
        regresar.setBackground(Color.decode("#D81F10"));
        regresar.setForeground(Color.WHITE);
        regresar.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(regresar);

        regresar.addActionListener(e -> {
            ventana.dispose();
            Inicio(nombreUsuarioActual);
        });

        JButton crear = new JButton("Crear nuevo");
        crear.setBounds(730, 490, 210, 60);
        crear.setBackground(Color.decode("#14518C"));
        crear.setForeground(Color.WHITE);
        crear.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(crear);

        crear.addActionListener(e -> {
            ventana.dispose();
            CrearDueno();
        });

        ventana.setVisible(true);
    }

    public void CrearDueno() {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 600);
        ventana.setTitle("Crear dueño");
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#FFFFFF"));
        ventana.add(fondo);

        JLabel titulo = new JLabel("Registro de dueño");
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        titulo.setBounds(40, 20, 500, 40);
        fondo.add(titulo);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(40, 90, 900, 380);
        panelPrincipal.setBackground(Color.decode("#8CACCB"));
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        panelPrincipal.setLayout(new GridLayout(1, 2, 20, 20));
        fondo.add(panelPrincipal);

        JPanel panelCampos = new JPanel();
        panelCampos.setBackground(Color.decode("#8CACCB"));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelCampos.setLayout(new GridLayout(7, 2, 10, 15));

        Font fuente = new Font("Adamina", Font.BOLD, 18);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuente);
        panelCampos.add(lblNombre);
        JTextField campoNombre = new JTextField();
        panelCampos.add(campoNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(fuente);
        panelCampos.add(lblApellidos);
        JTextField campoApellidos = new JTextField();
        panelCampos.add(campoApellidos);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuente);
        panelCampos.add(lblTelefono);
        JTextField campoTelefono = new JTextField();
        panelCampos.add(campoTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(fuente);
        panelCampos.add(lblCorreo);
        JTextField campoCorreo = new JTextField();
        panelCampos.add(campoCorreo);

        JLabel lblMascota = new JLabel("Mascota:");
        lblMascota.setFont(fuente);
        panelCampos.add(lblMascota);
        JTextField campoMascota = new JTextField();
        panelCampos.add(campoMascota);

        JLabel lblColonia = new JLabel("Colonia:");
        lblColonia.setFont(fuente);
        panelCampos.add(lblColonia);
        JTextField campoColonia = new JTextField();
        panelCampos.add(campoColonia);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(fuente);
        panelCampos.add(lblDireccion);
        JTextField campoDireccion = new JTextField();
        panelCampos.add(campoDireccion);

        panelPrincipal.add(panelCampos);

        JPanel panelFoto = new JPanel();
        panelFoto.setBackground(Color.decode("#8CACCB"));
        panelFoto.setLayout(null);

        JLabel foto = new JLabel("SIN FOTO");
        foto.setBounds(90, 30, 220, 220);
        foto.setHorizontalAlignment(JLabel.CENTER);
        foto.setVerticalAlignment(JLabel.CENTER);
        foto.setOpaque(true);
        foto.setBackground(Color.WHITE);
        foto.setFont(new Font("Arial", Font.BOLD, 22));
        foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelFoto.add(foto);

        JButton agregarFoto = new JButton("Agregar foto");
        agregarFoto.setBounds(120, 270, 160, 40);
        agregarFoto.setBackground(Color.decode("#14508C"));
        agregarFoto.setForeground(Color.WHITE);
        agregarFoto.setFont(new Font("Inter", Font.BOLD, 16));
        agregarFoto.setFocusPainted(false);
        panelFoto.add(agregarFoto);

        panelPrincipal.add(panelFoto);

        final String[] rutaFoto = {""};

        agregarFoto.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                rutaFoto[0] = archivo.getAbsolutePath();
                ImageIcon icono = new ImageIcon(rutaFoto[0]);
                Image imagen = icono.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                foto.setText("");
                foto.setIcon(new ImageIcon(imagen));
            }
        });

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(40, 500, 180, 50);
        botonRegresar.setBackground(Color.decode("#D81F10"));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(botonRegresar);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(740, 500, 180, 50);
        botonGuardar.setBackground(Color.decode("#14508C"));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(botonGuardar);

        botonRegresar.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

        botonGuardar.addActionListener(e -> {
            boolean exito = controller.crearDueno(
                    campoNombre.getText(),
                    campoApellidos.getText(),
                    campoTelefono.getText(),
                    campoCorreo.getText(),
                    campoMascota.getText(),
                    campoColonia.getText(),
                    campoDireccion.getText(),
                    rutaFoto[0]
            );

            if (exito) {
                Dueno dueno = controller.obtenerUltimoDueno();
                ventana.dispose();
                CrearPaciente(dueno);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el dueño");
            }
        });

        ventana.setVisible(true);
    }

    public void CrearDueno(Dueno dueno) {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 600);
        ventana.setTitle("Editar dueño");
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#FFFFFF"));
        ventana.add(fondo);

        JLabel titulo = new JLabel("Editar dueño");
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        titulo.setBounds(40, 20, 500, 40);
        fondo.add(titulo);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(40, 90, 900, 380);
        panelPrincipal.setBackground(Color.decode("#8CACCB"));
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        panelPrincipal.setLayout(new GridLayout(1, 2, 20, 20));
        fondo.add(panelPrincipal);

        JPanel panelCampos = new JPanel();
        panelCampos.setBackground(Color.decode("#8CACCB"));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelCampos.setLayout(new GridLayout(7, 2, 10, 15));

        Font fuente = new Font("Adamina", Font.BOLD, 18);

        JTextField campoNombre = new JTextField(dueno.getNombre());
        JTextField campoApellidos = new JTextField(dueno.getApellidos());
        JTextField campoTelefono = new JTextField(dueno.getTelefono());
        JTextField campoCorreo = new JTextField(dueno.getCorreo());
        JTextField campoMascota = new JTextField(dueno.getMascota());
        JTextField campoColonia = new JTextField(dueno.getColonia());
        JTextField campoDireccion = new JTextField(dueno.getDireccion());

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuente);
        panelCampos.add(lblNombre);
        panelCampos.add(campoNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(fuente);
        panelCampos.add(lblApellidos);
        panelCampos.add(campoApellidos);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuente);
        panelCampos.add(lblTelefono);
        panelCampos.add(campoTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(fuente);
        panelCampos.add(lblCorreo);
        panelCampos.add(campoCorreo);

        JLabel lblMascota = new JLabel("Mascota:");
        lblMascota.setFont(fuente);
        panelCampos.add(lblMascota);
        panelCampos.add(campoMascota);

        JLabel lblColonia = new JLabel("Colonia:");
        lblColonia.setFont(fuente);
        panelCampos.add(lblColonia);
        panelCampos.add(campoColonia);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(fuente);
        panelCampos.add(lblDireccion);
        panelCampos.add(campoDireccion);

        panelPrincipal.add(panelCampos);

        JPanel panelFoto = new JPanel();
        panelFoto.setBackground(Color.decode("#8CACCB"));
        panelFoto.setLayout(null);

        JLabel foto = new JLabel();
        foto.setBounds(90, 30, 220, 220);
        foto.setHorizontalAlignment(JLabel.CENTER);
        foto.setVerticalAlignment(JLabel.CENTER);
        foto.setOpaque(true);
        foto.setBackground(Color.WHITE);
        foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelFoto.add(foto);

        final String[] rutaFoto = {dueno.getFoto()};

        if (rutaFoto[0] != null && !rutaFoto[0].isEmpty()) {
            ImageIcon icono = new ImageIcon(rutaFoto[0]);
            Image imagen = icono.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(imagen));
        } else {
            foto.setText("SIN FOTO");
            foto.setFont(new Font("Arial", Font.BOLD, 22));
        }

        JButton agregarFoto = new JButton("Agregar foto");
        agregarFoto.setBounds(120, 270, 160, 40);
        agregarFoto.setBackground(Color.decode("#14508C"));
        agregarFoto.setForeground(Color.WHITE);
        agregarFoto.setFont(new Font("Inter", Font.BOLD, 14));
        agregarFoto.setFocusPainted(false);
        panelFoto.add(agregarFoto);

        agregarFoto.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                rutaFoto[0] = archivo.getAbsolutePath();
                ImageIcon icono = new ImageIcon(rutaFoto[0]);
                Image imagen = icono.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                foto.setText("");
                foto.setIcon(new ImageIcon(imagen));
            }
        });

        panelPrincipal.add(panelFoto);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(760, 500, 180, 50);
        botonGuardar.setBackground(Color.decode("#072548"));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFont(new Font("Inter", Font.BOLD, 20));
        botonGuardar.setFocusPainted(false);
        fondo.add(botonGuardar);

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(40, 500, 180, 50);
        botonRegresar.setBackground(Color.decode("#D81F10"));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
        botonRegresar.setFocusPainted(false);
        fondo.add(botonRegresar);

        botonRegresar.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

        botonGuardar.addActionListener(e -> {
            boolean exito = controller.actualizarDueno(
                    dueno.getId(),
                    campoNombre.getText(),
                    campoApellidos.getText(),
                    campoTelefono.getText(),
                    campoCorreo.getText(),
                    campoMascota.getText(),
                    campoColonia.getText(),
                    campoDireccion.getText(),
                    rutaFoto[0]
            );

            if (exito) {
                Paciente paciente = controller.obtenerPacientePorDueno(dueno.getId());
                ventana.dispose();
                if (paciente != null) {
                    CrearPaciente(dueno, paciente);
                } else {
                    CrearPaciente(dueno);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el dueño");
            }
        });

        ventana.setVisible(true);
    }

    public void CrearPaciente(Dueno dueno) {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 600);
        ventana.setTitle("Crear paciente");
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#FFFFFF"));
        ventana.add(fondo);

        JLabel titulo = new JLabel("Registro de paciente");
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        titulo.setBounds(40, 20, 500, 40);
        fondo.add(titulo);

        JPanel panel = new JPanel();
        panel.setBounds(40, 90, 900, 420);
        panel.setBackground(Color.decode("#8CACCB"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        panel.setLayout(new GridLayout(1, 2, 20, 20));
        fondo.add(panel);

        JPanel panelCampos = new JPanel();
        panelCampos.setOpaque(false);
        panelCampos.setLayout(new GridLayout(11, 2, 10, 12));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        Font fuenteLabel = new Font("Adamina", Font.BOLD, 14);
        Font fuenteField = new Font("Adamina", Font.PLAIN, 14);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuenteLabel);
        panelCampos.add(lblNombre);
        JTextField campoNombre = new JTextField();
        campoNombre.setFont(fuenteField);
        panelCampos.add(campoNombre);

        JLabel lblEspecie = new JLabel("Especie:");
        lblEspecie.setFont(fuenteLabel);
        panelCampos.add(lblEspecie);
        JTextField campoEspecie = new JTextField();
        campoEspecie.setFont(fuenteField);
        panelCampos.add(campoEspecie);

        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setFont(fuenteLabel);
        panelCampos.add(lblRaza);
        JTextField campoRaza = new JTextField();
        campoRaza.setFont(fuenteField);
        panelCampos.add(campoRaza);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(fuenteLabel);
        panelCampos.add(lblEdad);
        JTextField campoEdad = new JTextField();
        campoEdad.setFont(fuenteField);
        panelCampos.add(campoEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(fuenteLabel);
        panelCampos.add(lblSexo);
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Macho", "Hembra"});
        comboSexo.setFont(fuenteField);
        panelCampos.add(comboSexo);

        JLabel lblFecha = new JLabel("Fecha (YYYY-MM-DD):");
        lblFecha.setFont(fuenteLabel);
        panelCampos.add(lblFecha);
        JTextField campoFecha = new JTextField();
        campoFecha.setFont(fuenteField);
        panelCampos.add(campoFecha);

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(fuenteLabel);
        panelCampos.add(lblDoctor);
        JComboBox<String> comboDoctor = new JComboBox<>(controller.listarDoctores().toArray(new String[0]));
        comboDoctor.setFont(fuenteField);
        panelCampos.add(comboDoctor);

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        lblDiagnostico.setFont(fuenteLabel);
        panelCampos.add(lblDiagnostico);
        JTextField campoDiagnostico = new JTextField();
        campoDiagnostico.setFont(fuenteField);
        panelCampos.add(campoDiagnostico);

        JLabel lblUrgencia = new JLabel("Urgencia:");
        lblUrgencia.setFont(fuenteLabel);
        panelCampos.add(lblUrgencia);
        JComboBox<String> comboUrgencia = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
        comboUrgencia.setFont(fuenteField);
        panelCampos.add(comboUrgencia);

        JLabel lblTipoCita = new JLabel("Tipo cita:");
        lblTipoCita.setFont(fuenteLabel);
        panelCampos.add(lblTipoCita);
        JComboBox<String> comboTipoCita = new JComboBox<>(new String[]{
            "Consulta rutinaria", "Consulta urgencias", "Consulta especializada",
            "Vacunación", "Desparasitación", "Consulta a domicilio"
        });
        comboTipoCita.setFont(fuenteField);
        panelCampos.add(comboTipoCita);

        JLabel lblMedicamento = new JLabel("Medicamento:");
        lblMedicamento.setFont(fuenteLabel);
        panelCampos.add(lblMedicamento);
        JComboBox<String> comboMedicamento = new JComboBox<>(new String[]{
            "Ninguno", "Antibiótico clavoxivet", "Antiparasitarios", "Desparacitante Care Max"
        });
        comboMedicamento.setFont(fuenteField);
        panelCampos.add(comboMedicamento);

        panel.add(panelCampos);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setOpaque(false);
        panelDerecho.setLayout(null);

        JLabel textoFoto = new JLabel("Fotografía");
        textoFoto.setFont(new Font("Adamina", Font.BOLD, 20));
        textoFoto.setBounds(120, 10, 200, 30);
        panelDerecho.add(textoFoto);

        JLabel foto = new JLabel();
        foto.setBounds(90, 45, 200, 180);
        foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        foto.setHorizontalAlignment(JLabel.CENTER);
        foto.setOpaque(true);
        foto.setBackground(Color.WHITE);
        foto.setText("SIN FOTO");
        foto.setFont(new Font("Arial", Font.BOLD, 16));
        foto.setHorizontalAlignment(JLabel.CENTER);
        panelDerecho.add(foto);

        final String[] rutaFoto = {""};

        JButton botonFoto = new JButton("Agregar foto");
        botonFoto.setBounds(110, 235, 160, 35);
        botonFoto.setBackground(Color.decode("#14508C"));
        botonFoto.setForeground(Color.WHITE);
        botonFoto.setFont(new Font("Inter", Font.BOLD, 14));
        botonFoto.setFocusPainted(false);
        panelDerecho.add(botonFoto);

        botonFoto.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                rutaFoto[0] = archivo.getAbsolutePath();
                ImageIcon icono = new ImageIcon(rutaFoto[0]);
                Image imagen = icono.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
                foto.setText("");
                foto.setIcon(new ImageIcon(imagen));
            }
        });

        JLabel lblHistorial = new JLabel("Historial:");
        lblHistorial.setFont(new Font("Adamina", Font.BOLD, 16));
        lblHistorial.setBounds(20, 290, 100, 25);
        panelDerecho.add(lblHistorial);

        JTextArea areaHistorial = new JTextArea();
        areaHistorial.setFont(new Font("Adamina", Font.PLAIN, 14));
        areaHistorial.setLineWrap(true);
        areaHistorial.setWrapStyleWord(true);
        JScrollPane scrollHistorial = new JScrollPane(areaHistorial);
        scrollHistorial.setBounds(20, 320, 280, 80);
        panelDerecho.add(scrollHistorial);

        panel.add(panelDerecho);

        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setFont(new Font("Adamina", Font.BOLD, 16));
        lblCosto.setBounds(580, 520, 80, 30);
        fondo.add(lblCosto);

        JTextField campoCosto = new JTextField();
        campoCosto.setBounds(650, 520, 150, 30);
        campoCosto.setEditable(false);
        campoCosto.setFont(new Font("Adamina", Font.BOLD, 14));
        campoCosto.setBackground(Color.WHITE);
        fondo.add(campoCosto);

        Runnable actualizarCosto = () -> {
            String tipo = comboTipoCita.getSelectedItem().toString();
            String medicamento = comboMedicamento.getSelectedItem().toString();

            double costoConsulta = 0;
            if (tipo.equals("Consulta rutinaria")) costoConsulta = 700;
            else if (tipo.equals("Consulta urgencias")) costoConsulta = 2000;
            else if (tipo.equals("Consulta especializada")) costoConsulta = 2000;
            else if (tipo.equals("Vacunación")) costoConsulta = 1500;
            else if (tipo.equals("Desparasitación")) costoConsulta = 600;
            else if (tipo.equals("Consulta a domicilio")) costoConsulta = 1800;

            double costoMedicamento = 0;
            if (medicamento.equals("Antibiótico clavoxivet")) costoMedicamento = 295;
            else if (medicamento.equals("Antiparasitarios")) costoMedicamento = 300;
            else if (medicamento.equals("Desparacitante Care Max")) costoMedicamento = 85;

            double total = costoConsulta + costoMedicamento;
            campoCosto.setText(String.format("$%.2f MXN", total));
        };

        comboTipoCita.addActionListener(e -> actualizarCosto.run());
        comboMedicamento.addActionListener(e -> actualizarCosto.run());
        comboUrgencia.addActionListener(e -> actualizarCosto.run());
        actualizarCosto.run();

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(760, 520, 180, 45);
        botonGuardar.setBackground(Color.decode("#072548"));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFont(new Font("Inter", Font.BOLD, 20));
        botonGuardar.setFocusPainted(false);
        fondo.add(botonGuardar);

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(40, 520, 180, 45);
        botonRegresar.setBackground(Color.decode("#D81F10"));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
        botonRegresar.setFocusPainted(false);
        fondo.add(botonRegresar);

        botonGuardar.addActionListener(e -> {

            if (campoNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
                return;
            }

            double costo;
            try {
                String costoStr = campoCosto.getText().replace("$", "").replace(" MXN", "").trim();
                costo = Double.parseDouble(costoStr);
            } catch (Exception ex) {
                costo = 0;
            }

            boolean exito = controller.crearPaciente(
                campoNombre.getText().trim(),
                campoEspecie.getText().trim(),
                campoRaza.getText().trim(),
                campoEdad.getText().trim(),
                comboSexo.getSelectedItem().toString(),
                campoFecha.getText().trim(),
                comboDoctor.getSelectedItem().toString(),
                campoDiagnostico.getText().trim(),
                areaHistorial.getText().trim(),
                rutaFoto[0],
                dueno.getId(),
                comboUrgencia.getSelectedItem().toString(),
                comboTipoCita.getSelectedItem().toString(),
                comboMedicamento.getSelectedItem().toString(),
                costo
            );

            if (exito) {
                ventana.dispose();
                RegistroExitoso();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el paciente");
            }
        });

        botonRegresar.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

        ventana.setVisible(true);
    }

    private JLabel crearLabel(String texto, Font fuente) {
        JLabel label = new JLabel(texto);
        label.setFont(fuente);
        return label;
    }

    public void CrearPaciente(Dueno dueno, Paciente paciente) {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 600);
        ventana.setTitle("Editar paciente");
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.decode("#FFFFFF"));
        ventana.add(fondo);

        JLabel titulo = new JLabel("Editar paciente");
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        titulo.setBounds(40, 20, 500, 40);
        fondo.add(titulo);

        JPanel panel = new JPanel();
        panel.setBounds(40, 90, 900, 420);
        panel.setBackground(Color.decode("#8CACCB"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        panel.setLayout(new GridLayout(1, 2, 20, 20));
        fondo.add(panel);

        JPanel panelCampos = new JPanel();
        panelCampos.setOpaque(false);
        panelCampos.setLayout(new GridLayout(11, 2, 10, 12));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        Font fuenteLabel = new Font("Adamina", Font.BOLD, 14);
        Font fuenteField = new Font("Adamina", Font.PLAIN, 14);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuenteLabel);
        panelCampos.add(lblNombre);
        JTextField campoNombre = new JTextField(paciente.getNombre());
        campoNombre.setFont(fuenteField);
        panelCampos.add(campoNombre);

        JLabel lblEspecie = new JLabel("Especie:");
        lblEspecie.setFont(fuenteLabel);
        panelCampos.add(lblEspecie);
        JTextField campoEspecie = new JTextField(paciente.getEspecie());
        campoEspecie.setFont(fuenteField);
        panelCampos.add(campoEspecie);

        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setFont(fuenteLabel);
        panelCampos.add(lblRaza);
        JTextField campoRaza = new JTextField(paciente.getRaza());
        campoRaza.setFont(fuenteField);
        panelCampos.add(campoRaza);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(fuenteLabel);
        panelCampos.add(lblEdad);
        JTextField campoEdad = new JTextField(paciente.getEdad());
        campoEdad.setFont(fuenteField);
        panelCampos.add(campoEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(fuenteLabel);
        panelCampos.add(lblSexo);
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Macho", "Hembra"});
        comboSexo.setSelectedItem(paciente.getSexo());
        comboSexo.setFont(fuenteField);
        panelCampos.add(comboSexo);

        JLabel lblFecha = new JLabel("Fecha (YYYY-MM-DD):");
        lblFecha.setFont(fuenteLabel);
        panelCampos.add(lblFecha);
        JTextField campoFecha = new JTextField(paciente.getFecha());
        campoFecha.setFont(fuenteField);
        panelCampos.add(campoFecha);
        
        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(fuenteLabel);
        panelCampos.add(lblDoctor);
        JComboBox<String> comboDoctor = new JComboBox<>(controller.listarDoctores().toArray(new String[0]));
        comboDoctor.setSelectedItem(paciente.getDoctor());
        comboDoctor.setFont(fuenteField);
        panelCampos.add(comboDoctor);

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        lblDiagnostico.setFont(fuenteLabel);
        panelCampos.add(lblDiagnostico);
        JTextField campoDiagnostico = new JTextField(paciente.getDiagnostico());
        campoDiagnostico.setFont(fuenteField);
        panelCampos.add(campoDiagnostico);

        JLabel lblUrgencia = new JLabel("Urgencia:");
        lblUrgencia.setFont(fuenteLabel);
        panelCampos.add(lblUrgencia);
        JComboBox<String> comboUrgencia = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
        if (paciente.getUrgencia() != null) comboUrgencia.setSelectedItem(paciente.getUrgencia());
        comboUrgencia.setFont(fuenteField);
        panelCampos.add(comboUrgencia);

        JLabel lblTipoCita = new JLabel("Tipo cita:");
        lblTipoCita.setFont(fuenteLabel);
        panelCampos.add(lblTipoCita);
        JComboBox<String> comboTipoCita = new JComboBox<>(new String[]{
            "Consulta rutinaria", "Consulta urgencias", "Consulta especializada",
            "Vacunación", "Desparasitación", "Consulta a domicilio"
        });
        if (paciente.getTipoCita() != null) comboTipoCita.setSelectedItem(paciente.getTipoCita());
        comboTipoCita.setFont(fuenteField);
        panelCampos.add(comboTipoCita);

        JLabel lblMedicamento = new JLabel("Medicamento:");
        lblMedicamento.setFont(fuenteLabel);
        panelCampos.add(lblMedicamento);
        JComboBox<String> comboMedicamento = new JComboBox<>(new String[]{
            "Ninguno", "Antibiótico clavoxivet", "Antiparasitarios", "Desparacitante Care Max"
        });
        if (paciente.getMedicamento() != null) comboMedicamento.setSelectedItem(paciente.getMedicamento());
        comboMedicamento.setFont(fuenteField);
        panelCampos.add(comboMedicamento);

        panel.add(panelCampos);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setOpaque(false);
        panelDerecho.setLayout(null);

        JLabel textoFoto = new JLabel("Fotografía");
        textoFoto.setFont(new Font("Adamina", Font.BOLD, 20));
        textoFoto.setBounds(120, 10, 200, 30);
        panelDerecho.add(textoFoto);

        JLabel foto = new JLabel();
        foto.setBounds(90, 45, 200, 180);
        foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        foto.setHorizontalAlignment(JLabel.CENTER);
        foto.setOpaque(true);
        foto.setBackground(Color.WHITE);
        panelDerecho.add(foto);

        final String[] rutaFoto = {paciente.getFoto()};

        if (rutaFoto[0] != null && !rutaFoto[0].equals("")) {
            ImageIcon icono = new ImageIcon(rutaFoto[0]);
            Image imagen = icono.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(imagen));
        } else {
            foto.setText("SIN FOTO");
            foto.setFont(new Font("Arial", Font.BOLD, 16));
            foto.setHorizontalAlignment(JLabel.CENTER);
        }

        JButton botonFoto = new JButton("Agregar foto");
        botonFoto.setBounds(110, 235, 160, 35);
        botonFoto.setBackground(Color.decode("#14508C"));
        botonFoto.setForeground(Color.WHITE);
        botonFoto.setFont(new Font("Inter", Font.BOLD, 14));
        botonFoto.setFocusPainted(false);
        panelDerecho.add(botonFoto);

        botonFoto.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                rutaFoto[0] = archivo.getAbsolutePath();
                ImageIcon icono = new ImageIcon(rutaFoto[0]);
                Image imagen = icono.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
                foto.setText("");
                foto.setIcon(new ImageIcon(imagen));
            }
        });

        JLabel lblHistorial = new JLabel("Historial:");
        lblHistorial.setFont(new Font("Adamina", Font.BOLD, 16));
        lblHistorial.setBounds(20, 290, 100, 25);
        panelDerecho.add(lblHistorial);

        JTextArea areaHistorial = new JTextArea(paciente.getHistorial());
        areaHistorial.setFont(new Font("Adamina", Font.PLAIN, 14));
        areaHistorial.setLineWrap(true);
        areaHistorial.setWrapStyleWord(true);
        JScrollPane scrollHistorial = new JScrollPane(areaHistorial);
        scrollHistorial.setBounds(20, 320, 280, 80);
        panelDerecho.add(scrollHistorial);

        panel.add(panelDerecho);

        JLabel lblCosto = new JLabel("Costo:");
        lblCosto.setFont(new Font("Adamina", Font.BOLD, 16));
        lblCosto.setBounds(580, 520, 80, 30);
        fondo.add(lblCosto);

        JTextField campoCosto = new JTextField();
        campoCosto.setBounds(650, 520, 150, 30);
        campoCosto.setEditable(false);
        campoCosto.setFont(new Font("Adamina", Font.BOLD, 14));
        campoCosto.setBackground(Color.WHITE);
        fondo.add(campoCosto);

        Runnable actualizarCosto = () -> {
            String tipo = comboTipoCita.getSelectedItem().toString();
            String medicamento = comboMedicamento.getSelectedItem().toString();

            double costoConsulta = 0;
            
            if (tipo.equals("Consulta rutinaria")) costoConsulta = 700;
            else if (tipo.equals("Consulta urgencias")) costoConsulta = 2000;
            else if (tipo.equals("Consulta especializada")) costoConsulta = 2000;
            else if (tipo.equals("Vacunación")) costoConsulta = 1500;
            else if (tipo.equals("Desparasitación")) costoConsulta = 600;
            else if (tipo.equals("Consulta a domicilio")) costoConsulta = 1800;

            double costoMedicamento = 0;
            
            if (medicamento.equals("Antibiótico clavoxivet")) costoMedicamento = 295;
            else if (medicamento.equals("Antiparasitarios")) costoMedicamento = 300;
            else if (medicamento.equals("Desparacitante Care Max")) costoMedicamento = 85;

            double total = costoConsulta + costoMedicamento;
            campoCosto.setText(String.format("$%.2f MXN", total));
        };

        comboTipoCita.addActionListener(e -> actualizarCosto.run());
        comboMedicamento.addActionListener(e -> actualizarCosto.run());
        comboUrgencia.addActionListener(e -> actualizarCosto.run());
        actualizarCosto.run();

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(760, 520, 180, 45);
        botonGuardar.setBackground(Color.decode("#072548"));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFont(new Font("Inter", Font.BOLD, 20));
        botonGuardar.setFocusPainted(false);
        fondo.add(botonGuardar);

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(40, 520, 180, 45);
        botonRegresar.setBackground(Color.decode("#D81F10"));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Inter", Font.BOLD, 20));
        botonRegresar.setFocusPainted(false);
        fondo.add(botonRegresar);

        botonGuardar.addActionListener(e -> {
            double costo;
            try {
                String costoStr = campoCosto.getText().replace("$", "").replace(" MXN", "").trim();
                costo = Double.parseDouble(costoStr);
            } catch (Exception ex) {
                costo = paciente.getCosto();
            }

            boolean exito = controller.actualizarPaciente(
                paciente.getId(),
                campoNombre.getText().trim(),
                campoEspecie.getText().trim(),
                campoRaza.getText().trim(),
                campoEdad.getText().trim(),
                comboSexo.getSelectedItem().toString(),
                campoFecha.getText().trim(),
                comboDoctor.getSelectedItem().toString(),
                campoDiagnostico.getText().trim(),
                areaHistorial.getText().trim(),
                rutaFoto[0],
                comboUrgencia.getSelectedItem().toString(),
                comboTipoCita.getSelectedItem().toString()
            );

            if (exito) {
                ventana.dispose();
                RegistroExitoso();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el paciente");
            }
        });

        botonRegresar.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

        ventana.setVisible(true);
    }
	
    public void EliminarRegistroDueno(int idDueno) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(470, 210));

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
        Image imagen = icono.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(imagen));
        logo.setBounds(207, 5, 55, 55);
        panel.add(logo);

        JLabel texto = new JLabel("¿Deseas eliminar este registro?");
        texto.setBounds(20, 65, 430, 35);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Adamina", Font.BOLD, 20));
        panel.add(texto);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(70, 125, 140, 45);
        cancelar.setBackground(Color.decode("#14508C"));
        cancelar.setForeground(Color.WHITE);
        cancelar.setFont(new Font("Inter", Font.BOLD, 18));
        cancelar.setFocusPainted(false);
        cancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panel.add(cancelar);

        JButton confirmar = new JButton("Sí, eliminar");
        confirmar.setBounds(250, 125, 150, 45);
        confirmar.setBackground(Color.decode("#D81F10"));
        confirmar.setForeground(Color.WHITE);
        confirmar.setFont(new Font("Inter", Font.BOLD, 18));
        confirmar.setFocusPainted(false);
        confirmar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panel.add(confirmar);

        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Eliminar registro");
        dialog.setIconImage(icono.getImage());

        cancelar.addActionListener(e -> {
            dialog.dispose();
            PanelDuenos();
        });

        confirmar.addActionListener(e -> {
            boolean exito = controller.eliminarDueno(idDueno);
            dialog.dispose();
            if (exito) {
                EliminadoExitoso();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                PanelDuenos();
            }
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void EliminadoExitoso() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(450, 190));

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
        Image imagen = icono.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(imagen));
        logo.setBounds(197, 5, 55, 55);
        panel.add(logo);

        JLabel texto = new JLabel("Se eliminó el registro correctamente.");
        texto.setBounds(25, 65, 400, 35);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Adamina", Font.BOLD, 20));
        panel.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(135, 120, 180, 45);
        aceptar.setBackground(Color.decode("#14508C"));
        aceptar.setForeground(Color.WHITE);
        aceptar.setFont(new Font("Inter", Font.BOLD, 18));
        aceptar.setFocusPainted(false);
        aceptar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panel.add(aceptar);

        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Eliminado exitoso");
        dialog.setIconImage(icono.getImage());

        aceptar.addActionListener(e -> {
            dialog.dispose();
            PanelDuenos();
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void RegistroExitoso() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(470, 190));

        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo_Inicio.jpeg"));
        Image imagen = icono.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(imagen));
        logo.setBounds(207, 5, 55, 55);
        panel.add(logo);

        JLabel texto = new JLabel("Se agregó el nuevo registro exitosamente.");
        texto.setBounds(20, 65, 430, 35);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Adamina", Font.BOLD, 18));
        panel.add(texto);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(145, 120, 180, 45);
        aceptar.setBackground(Color.decode("#14508C"));
        aceptar.setForeground(Color.WHITE);
        aceptar.setFont(new Font("Inter", Font.BOLD, 18));
        aceptar.setFocusPainted(false);
        aceptar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panel.add(aceptar);

        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog("Registro exitoso");
        dialog.setIconImage(icono.getImage());

        aceptar.addActionListener(e -> {
            dialog.dispose();
            PanelDuenos();
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void DetallesDueno(Dueno dueno) {
        JFrame ventana = new JFrame();
        ventana.setSize(1000, 600);
        ventana.setTitle("Detalles del dueño");
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, 1000, 600);
        fondo.setLayout(null);
        fondo.setBackground(Color.WHITE);
        ventana.add(fondo);

        JLabel titulo = new JLabel("Detalles del dueño");
        titulo.setBounds(40, 20, 400, 40);
        titulo.setFont(new Font("Adamina", Font.BOLD, 34));
        fondo.add(titulo);

        JPanel panel = new JPanel();
        panel.setBounds(40, 90, 900, 360);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#8CACCB"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        fondo.add(panel);

        JLabel foto = new JLabel();
        foto.setBounds(40, 40, 220, 220);
        foto.setOpaque(true);
        foto.setBackground(Color.WHITE);
        foto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        if (dueno.getFoto() != null && !dueno.getFoto().equals("")) {
            ImageIcon icono = new ImageIcon(dueno.getFoto());
            Image imagen = icono.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(imagen));
        } else {
            foto.setText("SIN FOTO");
            foto.setHorizontalAlignment(JLabel.CENTER);
            foto.setFont(new Font("Arial", Font.BOLD, 22));
        }
        panel.add(foto);

        String[][] datos = {
                {"Nombre", dueno.getNombre()},
                {"Apellidos", dueno.getApellidos()},
                {"Dirección", dueno.getDireccion()},
                {"Colonia", dueno.getColonia()},
                {"Teléfono", dueno.getTelefono()},
                {"Correo", dueno.getCorreo()},
                {"Mascota", dueno.getMascota()}
        };

        int y = 40;
        for (String[] fila : datos) {
            JPanel filaPanel = new JPanel();
            filaPanel.setLayout(null);
            filaPanel.setBounds(320, y, 520, 35);
            filaPanel.setBackground(Color.WHITE);
            filaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

            JLabel etiqueta = new JLabel(fila[0] + ":");
            etiqueta.setBounds(15, 5, 150, 25);
            etiqueta.setFont(new Font("Adamina", Font.BOLD, 18));
            filaPanel.add(etiqueta);

            JLabel valor = new JLabel(fila[1]);
            valor.setBounds(170, 5, 320, 25);
            valor.setFont(new Font("Adamina", Font.PLAIN, 17));
            filaPanel.add(valor);

            panel.add(filaPanel);
            y += 42;
        }

        JButton regresar = new JButton("Regresar");
        regresar.setBounds(40, 500, 180, 50);
        regresar.setBackground(Color.decode("#D81F10"));
        regresar.setForeground(Color.WHITE);
        regresar.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(regresar);

        regresar.addActionListener(e -> {
            ventana.dispose();
            PanelDuenos();
        });

        JButton botonMascota = new JButton("Ver mascota");
        botonMascota.setBounds(730, 500, 180, 50);
        botonMascota.setBackground(Color.decode("#14508C"));
        botonMascota.setForeground(Color.WHITE);
        botonMascota.setFont(new Font("Inter", Font.BOLD, 20));
        fondo.add(botonMascota);

        botonMascota.addActionListener(e -> {
            Paciente paciente = controller.obtenerPacientePorDueno(dueno.getId());
            if (paciente != null && paciente.getId() > 0) {
                ventana.dispose();
                DetallesPaciente(paciente);
            } else {
                JOptionPane.showMessageDialog(null, "Este dueño no tiene mascota registrada.");
            }
        });

        ventana.setVisible(true);
    }
}
