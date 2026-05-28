package Controller;

import Model.VeterinariaModel;
import Model.Dueno;
import Model.Paciente;
import java.util.List;
import java.util.Map;

public class AuthController {
    
    private VeterinariaModel model;
    
    public AuthController() {
        model = new VeterinariaModel();
    }
    
    public boolean validarLogin(String correo, String password) {
        return model.validarLogin(correo, password);
    }
    
    public List<String> listarDoctores() {
        return model.listarDoctores();
    }
    
    public Map<Integer, String> listarDoctoresConId() {
        return model.listarDoctoresConId();
    }
    
    public int obtenerDoctorIdPorNombre(String nombreDoctor) {
        return model.obtenerDoctorIdPorNombre(nombreDoctor);
    }
    
    public List<Dueno> listarDuenos() {
        return model.obtenerTodosLosDuenos();
    }
    
    public Dueno obtenerDuenoPorId(int id) {
        return model.obtenerDuenoPorId(id);
    }
    
    public Dueno obtenerUltimoDueno() {
        return model.obtenerUltimoDueno();
    }
    
    public boolean crearDueno(Dueno dueno) {
        return model.insertarDueno(dueno);
    }
    
    public boolean actualizarDueno(Dueno dueno) {
        return model.actualizarDueno(dueno);
    }
    
    public boolean eliminarDueno(int id) {
        return model.eliminarDueno(id);
    }
    
    public List<Paciente> listarPacientes() {
        return model.obtenerTodosLosPacientes();
    }
    
    public Paciente obtenerPacientePorId(int id) {
        return model.obtenerPacientePorId(id);
    }
    
    public Paciente obtenerPacientePorDueno(int duenoId) {
        return model.obtenerPacientePorDueno(duenoId);
    }
    
    public boolean crearPaciente(Paciente paciente) {
        return model.insertarPaciente(paciente);
    }
    
    public boolean actualizarPaciente(Paciente paciente) {
        return model.actualizarPaciente(paciente);
    }
    
    public boolean eliminarPaciente(int id) {
        return model.eliminarPaciente(id);
    }
   
    public List<Object[]> listarCitas() {
        return model.obtenerTodasLasCitas();
    }
    
    public boolean crearCita(int idPaciente, int idDoctor, String fecha, String hora, 
                             String tipoCita, String urgencia, String medicamento, 
                             double costo, String estado, String diagnostico) {
        return model.insertarCita(idPaciente, idDoctor, fecha, hora, tipoCita, 
                                   urgencia, medicamento, costo, estado, diagnostico);
    }
    
    public boolean actualizarCita(int id, int idDoctor, String fecha, String hora, 
                                  String tipoCita, String urgencia, String medicamento, 
                                  double costo, String estado, String diagnostico) {
        return model.actualizarCita(id, idDoctor, fecha, hora, tipoCita, 
                                     urgencia, medicamento, costo, estado, diagnostico);
    }
    
    public boolean eliminarCita(int id) {
        return model.eliminarCita(id);
    }
    
    public boolean actualizarEstadoCita(int id, String estado) {
        return model.actualizarEstadoCita(id, estado);
    }

    public String obtenerNombreUsuario(String correo) {
        return model.obtenerNombreUsuario(correo);
    }
    
    public List<Object[]> listarCitasPorPaciente(int idPaciente) {
        return model.obtenerCitasPorPaciente(idPaciente);
    }
    
    public List<Object[]> listarCitasConDoctor(int idPaciente) {
        return model.obtenerCitasConDoctor(idPaciente);
    }   
}