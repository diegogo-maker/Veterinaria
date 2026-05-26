package Controller;

import Model.*;
import java.util.ArrayList;

public class AuthController {

    private VeterinariaModel modelo = new VeterinariaModel();

    public boolean crearDueno(String nombre, String apellidos, String telefono,
                              String correo, String mascota, String colonia,
                              String direccion, String foto) {
        return modelo.insertarDueno(nombre, apellidos, telefono, correo, 
        		mascota, colonia, direccion, foto);
    }

    public boolean actualizarDueno(int id, String nombre, String apellidos,
                                   String telefono, String correo,
                                   String mascota, String colonia,
                                   String direccion, String foto) {
        return modelo.actualizarDueno(id, nombre, apellidos, telefono, correo, mascota, colonia, direccion, foto);
    }

    public boolean eliminarDueno(int id) {
        return modelo.eliminarDueno(id);
    }

    public ArrayList<Dueno> listarDuenos() {
        return modelo.obtenerDuenos();
    }

    public Dueno obtenerDuenoPorId(int id) {
        return modelo.obtenerDuenoPorId(id);
    }

    public Dueno obtenerUltimoDueno() {
        return modelo.obtenerUltimoDueno();
    }

    public boolean crearPaciente(String nombre, String especie, String raza,
                                 String edad, String sexo, String fecha,
                                 String doctor, String diagnostico,
                                 String historial, String foto, int idDueno,
                                 String urgencia, String tipoCita,
                                 String medicamento, double costo) {
        return modelo.insertarPaciente(nombre, especie, raza, edad, sexo, fecha,
                                       doctor, diagnostico, historial, foto,
                                       idDueno, urgencia, tipoCita, medicamento, costo);
    }

    public boolean actualizarPaciente(int id, String nombre, String especie,
            String raza, String edad, String sexo,
            String fecha, String doctor,
            String diagnostico, String historial,
            String foto, String urgencia,
            String tipoCita) {
	
    	return modelo.actualizarPaciente(id, nombre, especie, raza, edad, sexo,
	               fecha, doctor, diagnostico, historial,
	               foto, urgencia, tipoCita);
	}

    public ArrayList<Paciente> listarPacientes() {
        return modelo.obtenerPacientes();
    }

    public Paciente obtenerPacientePorDueno(int idDueno) {
        return modelo.obtenerPacientePorDueno(idDueno);
    }

    public boolean eliminarPaciente(int id) {
        return modelo.eliminarPaciente(id);
    }

    public ArrayList<String> listarDoctores() {
        return modelo.obtenerDoctores();
    }

    public String login(String email, String password) {
        return modelo.login(email, password);
    }
}