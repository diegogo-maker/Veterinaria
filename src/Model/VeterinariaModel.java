package Model;

import java.sql.*;
import java.util.ArrayList;

public class VeterinariaModel {

    private Connection con;

    public VeterinariaModel() {
        con = Conexion.getConnection();
    }

    public boolean insertarDueno(String nombre, String apellidos,
                                 String telefono, String correo,
                                 String mascota, String colonia,
                                 String direccion, String foto) {

        String sql = "INSERT INTO duenos(nombre, apellidos, telefono, correo, mascota, colonia, direccion, foto) " +
                     "VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, mascota);
            ps.setString(6, colonia);
            ps.setString(7, direccion);
            ps.setString(8, foto);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarDueno(int id, String nombre, String apellidos,
                                   String telefono, String correo,
                                   String mascota, String colonia,
                                   String direccion, String foto) {

        String sql = "UPDATE duenos SET nombre=?, apellidos=?, telefono=?, correo=?, mascota=?, colonia=?, direccion=?, foto=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, mascota);
            ps.setString(6, colonia);
            ps.setString(7, direccion);
            ps.setString(8, foto);
            ps.setInt(9, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDueno(int id) {
        String sql = "DELETE FROM duenos WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Dueno obtenerDuenoPorId(int id) {
        String sql = "SELECT * FROM duenos WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Dueno d = new Dueno();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                d.setMascota(rs.getString("mascota"));
                d.setColonia(rs.getString("colonia"));
                d.setDireccion(rs.getString("direccion"));
                d.setFoto(rs.getString("foto"));
                return d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Dueno> obtenerDuenos() {
        ArrayList<Dueno> lista = new ArrayList<>();
        String sql = "SELECT * FROM duenos";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Dueno d = new Dueno();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                d.setMascota(rs.getString("mascota"));
                d.setColonia(rs.getString("colonia"));
                d.setDireccion(rs.getString("direccion"));
                d.setFoto(rs.getString("foto"));
                lista.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Dueno obtenerUltimoDueno() {
        String sql = "SELECT * FROM duenos ORDER BY id DESC LIMIT 1";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                Dueno d = new Dueno();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                d.setMascota(rs.getString("mascota"));
                d.setColonia(rs.getString("colonia"));
                d.setDireccion(rs.getString("direccion"));
                d.setFoto(rs.getString("foto"));
                return d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertarPaciente(String nombre, String especie, String raza,
                                    String edad, String sexo, String fecha,
                                    String doctor, String diagnostico,
                                    String historial, String foto,
                                    int idDueno, String urgencia,
                                    String tipoCita, String medicamento,
                                    double costo) {

        String sql = "INSERT INTO pacientes(nombre, especie, raza, edad, sexo, fecha, doctor, diagnostico, historial, foto, id_dueno, urgencia, tipo_cita, medicamento, costo) " +
                     "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, especie);
            ps.setString(3, raza);
            ps.setString(4, edad);
            ps.setString(5, sexo);
            ps.setString(6, fecha);
            ps.setString(7, doctor);
            ps.setString(8, diagnostico);
            ps.setString(9, historial);
            ps.setString(10, foto);
            ps.setInt(11, idDueno);
            ps.setString(12, urgencia);
            ps.setString(13, tipoCita);
            ps.setString(14, medicamento);
            ps.setDouble(15, costo);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarPaciente(int id, String nombre, String especie,
                                      String raza, String edad, String sexo,
                                      String fecha, String doctor,
                                      String diagnostico, String historial,
                                      String foto, String urgencia,
                                      String tipoCita) {

        String sql = "UPDATE pacientes SET nombre=?, especie=?, raza=?, edad=?, sexo=?, fecha=?, doctor=?, diagnostico=?, historial=?, foto=?, urgencia=?, tipo_cita=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, especie);
            ps.setString(3, raza);
            ps.setString(4, edad);
            ps.setString(5, sexo);
            ps.setString(6, fecha);
            ps.setString(7, doctor);
            ps.setString(8, diagnostico);
            ps.setString(9, historial);
            ps.setString(10, foto);
            ps.setString(11, urgencia);
            ps.setString(12, tipoCita);
            ps.setInt(13, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Paciente> obtenerPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEspecie(rs.getString("especie"));
                p.setRaza(rs.getString("raza"));
                p.setEdad(rs.getString("edad"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha(rs.getString("fecha"));
                p.setDoctor(rs.getString("doctor"));
                p.setDiagnostico(rs.getString("diagnostico"));
                p.setHistorial(rs.getString("historial"));
                p.setFoto(rs.getString("foto"));
                p.setIdDueno(rs.getInt("id_dueno"));
                p.setUrgencia(rs.getString("urgencia"));
                p.setTipoCita(rs.getString("tipo_cita"));
                p.setMedicamento(rs.getString("medicamento"));
                p.setCosto(rs.getDouble("costo"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Paciente obtenerPacientePorDueno(int idDueno) {
        String sql = "SELECT * FROM pacientes WHERE id_dueno=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
        	
            ps.setInt(1, idDueno);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEspecie(rs.getString("especie"));
                p.setRaza(rs.getString("raza"));
                p.setEdad(rs.getString("edad"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha(rs.getString("fecha"));
                p.setDoctor(rs.getString("doctor"));
                p.setDiagnostico(rs.getString("diagnostico"));
                p.setHistorial(rs.getString("historial"));
                p.setFoto(rs.getString("foto"));
                p.setIdDueno(rs.getInt("id_dueno"));
                p.setUrgencia(rs.getString("urgencia"));
                p.setTipoCita(rs.getString("tipo_cita"));
                p.setMedicamento(rs.getString("medicamento"));
                p.setCosto(rs.getDouble("costo"));
                return p;
            }          
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminarPaciente(int id) {
        String sql = "DELETE FROM pacientes WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> obtenerDoctores() {
        ArrayList<String> doctores = new ArrayList<>();
        String sql = "SELECT DISTINCT doctor FROM pacientes WHERE doctor IS NOT NULL AND doctor != ''";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                doctores.add(rs.getString("doctor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (doctores.isEmpty()) {
            doctores.add("Dr. Pérez");
            doctores.add("Dra. García");
            doctores.add("Dr. López");
            doctores.add("Dra. Martínez");
        }
        return doctores;
    }

    public String login(String email, String password) {
 
        String sql = "SELECT nombre FROM users WHERE correo = ? AND password = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("nombre");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}