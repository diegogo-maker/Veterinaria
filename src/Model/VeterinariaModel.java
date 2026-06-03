package Model;

import Model.Dueno;
import Model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeterinariaModel {
    
    private Connection conn;
    
    public VeterinariaModel() {
        conn = Conexion.getConnection();
    }
  
    public boolean validarLogin(String correo, String password) {
        boolean valido = false;
        try {
            String sql = "SELECT * FROM users WHERE correo = ? AND password = ? AND activo = "
            		+ "TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valido = true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valido;
    }
    
    public List<String> listarDoctores() {
        List<String> doctores = new ArrayList<>();
        try {
            String sql = "SELECT CONCAT(nombre, ' ', apellidos) AS doctor FROM users WHERE "
            		+ "activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doctores.add(rs.getString("doctor"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctores;
    }
    
    public Map<Integer, String> listarDoctoresConId() {
        Map<Integer, String> doctores = new HashMap<>();
        try {
            String sql = "SELECT id, CONCAT(nombre, ' ', apellidos) AS nombre FROM "
            		+ "users WHERE activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doctores.put(rs.getInt("id"), rs.getString("nombre"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctores;
    }
    
    public int obtenerDoctorIdPorNombre(String nombreDoctor) {
        int idDoctor = -1;
        try {
            String sql = "SELECT id FROM users WHERE CONCAT(nombre, ' ', apellidos) = ? "
            		+ "AND activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombreDoctor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idDoctor = rs.getInt("id");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idDoctor;
    }

    public List<Dueno> obtenerTodosLosDuenos() {
        List<Dueno> duenos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM duenos ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dueno dueno = new Dueno();
                dueno.setId(rs.getInt("id"));
                dueno.setNombre(rs.getString("nombre"));
                dueno.setApellidos(rs.getString("apellidos"));
                dueno.setTelefono(rs.getString("telefono"));
                dueno.setCorreo(rs.getString("correo"));
                dueno.setMascota(rs.getString("mascota"));
                dueno.setColonia(rs.getString("colonia"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setFoto(rs.getString("foto"));
                duenos.add(dueno);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return duenos;
    }
    
    public Dueno obtenerDuenoPorId(int id) {
        Dueno dueno = null;
        try {
            String sql = "SELECT * FROM duenos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dueno = new Dueno();
                dueno.setId(rs.getInt("id"));
                dueno.setNombre(rs.getString("nombre"));
                dueno.setApellidos(rs.getString("apellidos"));
                dueno.setTelefono(rs.getString("telefono"));
                dueno.setCorreo(rs.getString("correo"));
                dueno.setMascota(rs.getString("mascota"));
                dueno.setColonia(rs.getString("colonia"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setFoto(rs.getString("foto"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dueno;
    }
    
    public Dueno obtenerUltimoDueno() {
        Dueno dueno = null;
        try {
            String sql = "SELECT * FROM duenos ORDER BY id DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dueno = new Dueno();
                dueno.setId(rs.getInt("id"));
                dueno.setNombre(rs.getString("nombre"));
                dueno.setApellidos(rs.getString("apellidos"));
                dueno.setTelefono(rs.getString("telefono"));
                dueno.setCorreo(rs.getString("correo"));
                dueno.setMascota(rs.getString("mascota"));
                dueno.setColonia(rs.getString("colonia"));
                dueno.setDireccion(rs.getString("direccion"));
                dueno.setFoto(rs.getString("foto"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dueno;
    }
    
    public boolean insertarDueno(Dueno dueno) {
        boolean exito = false;
        try {
            String sql = "INSERT INTO duenos (nombre, apellidos, telefono, correo, "
            		+ "mascota, colonia, direccion, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dueno.getNombre());
            ps.setString(2, dueno.getApellidos());
            ps.setString(3, dueno.getTelefono());
            ps.setString(4, dueno.getCorreo());
            ps.setString(5, dueno.getMascota());
            ps.setString(6, dueno.getColonia());
            ps.setString(7, dueno.getDireccion());
            ps.setString(8, dueno.getFoto());
            exito = ps.executeUpdate() > 0;
            if (exito) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    dueno.setId(rs.getInt(1));
                }
                rs.close();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean actualizarDueno(Dueno dueno) {
        boolean exito = false;
        try {
            String sql = "UPDATE duenos SET nombre=?, apellidos=?, telefono=?, "
            		+ "correo=?, mascota=?, colonia=?, direccion=?, foto=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dueno.getNombre());
            ps.setString(2, dueno.getApellidos());
            ps.setString(3, dueno.getTelefono());
            ps.setString(4, dueno.getCorreo());
            ps.setString(5, dueno.getMascota());
            ps.setString(6, dueno.getColonia());
            ps.setString(7, dueno.getDireccion());
            ps.setString(8, dueno.getFoto());
            ps.setInt(9, dueno.getId());
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean eliminarDueno(int id) {
        boolean exito = false;
        try {
            String sql = "DELETE FROM duenos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
 
    public List<Paciente> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String sql = "SELECT p.*, d.nombre AS dueno_nombre, d.apellidos AS dueno_apellidos FROM pacientes p LEFT JOIN duenos d ON p.id_dueno = d.id ORDER BY p.id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEspecie(rs.getString("especie"));
                paciente.setRaza(rs.getString("raza"));
                paciente.setEdad(rs.getString("edad"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDiagnostico(rs.getString("diagnostico"));
                paciente.setHistorial(rs.getString("historial"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setIdDueno(rs.getInt("id_dueno"));
                pacientes.add(paciente);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
    
    public Paciente obtenerPacientePorId(int id) {
        Paciente paciente = null;
        try {
            String sql = "SELECT * FROM pacientes WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEspecie(rs.getString("especie"));
                paciente.setRaza(rs.getString("raza"));
                paciente.setEdad(rs.getString("edad"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDiagnostico(rs.getString("diagnostico"));
                paciente.setHistorial(rs.getString("historial"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setIdDueno(rs.getInt("id_dueno"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
    
    public Paciente obtenerPacientePorDueno(int duenoId) {
        Paciente paciente = null;
        try {
            String sql = "SELECT * FROM pacientes WHERE id_dueno = ? "
            		+ "ORDER BY id DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, duenoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEspecie(rs.getString("especie"));
                paciente.setRaza(rs.getString("raza"));
                paciente.setEdad(rs.getString("edad"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDiagnostico(rs.getString("diagnostico"));
                paciente.setHistorial(rs.getString("historial"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setIdDueno(rs.getInt("id_dueno"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
    
    public boolean insertarPaciente(Paciente paciente) {
        boolean exito = false;
        try {
            String sql = "INSERT INTO pacientes (nombre, especie, raza, "
            		+ "edad, sexo, diagnostico, historial, foto, id_dueno) "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getEspecie());
            ps.setString(3, paciente.getRaza());
            ps.setString(4, paciente.getEdad());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getDiagnostico());
            ps.setString(7, paciente.getHistorial());
            ps.setString(8, paciente.getFoto());
            ps.setInt(9, paciente.getIdDueno());
            exito = ps.executeUpdate() > 0;
            if (exito) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    paciente.setId(rs.getInt(1));
                }
                rs.close();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean actualizarPaciente(Paciente paciente) {
        boolean exito = false;
        try {
            String sql = "UPDATE pacientes SET nombre=?, especie=?, raza=?, edad=?, sexo=?, diagnostico=?, "
            		+ "historial=?, foto=?, id_dueno=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getEspecie());
            ps.setString(3, paciente.getRaza());
            ps.setString(4, paciente.getEdad());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getDiagnostico());
            ps.setString(7, paciente.getHistorial());
            ps.setString(8, paciente.getFoto());
            ps.setInt(9, paciente.getIdDueno());
            ps.setInt(10, paciente.getId());
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean eliminarPaciente(int id) {
        boolean exito = false;
        try {
            String sql = "DELETE FROM pacientes WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
 
    public List<Object[]> obtenerTodasLasCitas() {
        List<Object[]> citas = new ArrayList<>();
        try {
            String sql = "SELECT c.id, p.nombre AS mascota, CONCAT(u.nombre, ' ', u.apellidos) AS doctor, c.fecha, "
            		+ "c.hora, c.tipo_cita, c.urgencia, c.costo, c.estado FROM citas c LEFT JOIN "
            		+ "pacientes p ON c.id_paciente = p.id LEFT JOIN users u ON c.id_doctor = u.id ORDER BY c.fecha DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] cita = new Object[9];
                cita[0] = rs.getInt("id");
                cita[1] = rs.getString("mascota");
                cita[2] = rs.getString("doctor");
                cita[3] = rs.getString("fecha");
                cita[4] = rs.getString("hora");
                cita[5] = rs.getString("tipo_cita");
                cita[6] = rs.getString("urgencia");
                cita[7] = rs.getDouble("costo");
                cita[8] = rs.getString("estado");
                citas.add(cita);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }
    
    public boolean insertarCita(int idPaciente, int idDoctor, String fecha, String hora, String tipoCita, 
    		String urgencia, String medicamento, double costo, String estado, 
    		String diagnostico) {
        boolean exito = false;
        try {
            String sql = "INSERT INTO citas (id_paciente, id_doctor, fecha, hora, tipo_cita, "
            		+ "urgencia, medicamento, costo, estado, diagnostico) "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setInt(2, idDoctor);
            ps.setString(3, fecha);
            ps.setString(4, hora);
            ps.setString(5, tipoCita);
            ps.setString(6, urgencia);
            ps.setString(7, medicamento);
            ps.setDouble(8, costo);
            ps.setString(9, estado);
            ps.setString(10, diagnostico);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean actualizarCita(int id, int idDoctor, String fecha, String hora, 
    		String tipoCita, String urgencia, String medicamento, double costo, 
    		String estado, String diagnostico) {
    	
        boolean exito = false;
        try {
            String sql = "UPDATE citas SET id_doctor=?, fecha=?, hora=?, tipo_cita=?, "
            		+ "urgencia=?, medicamento=?, costo=?, estado=?, diagnostico=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDoctor);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            ps.setString(4, tipoCita);
            ps.setString(5, urgencia);
            ps.setString(6, medicamento);
            ps.setDouble(7, costo);
            ps.setString(8, estado);
            ps.setString(9, diagnostico);
            ps.setInt(10, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean eliminarCita(int id) {
        boolean exito = false;
        try {
            String sql = "DELETE FROM citas WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean actualizarEstadoCita(int id, String estado) {
        boolean exito = false;
        try {
            String sql = "UPDATE citas SET estado = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public String obtenerNombreUsuario(String correo) {
        String nombreCompleto = null;
        try {
            String sql = "SELECT CONCAT(nombre, ' ', apellidos) AS nombre FROM users WHERE correo = ? AND activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreCompleto = rs.getString("nombre");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreCompleto;
    }
    
    public List<Object[]> obtenerCitasPorPaciente(int idPaciente) {
        List<Object[]> citas = new ArrayList<>();
        try {
            String sql = "SELECT c.id, c.fecha, c.hora, c.tipo_cita, c.urgencia,"
            		+ " c.medicamento, c.costo, c.estado FROM citas c "
            		+ "WHERE c.id_paciente = ? ORDER BY c.fecha DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Object[] cita = new Object[8];
            	cita[0] = rs.getInt("id");
            	cita[1] = rs.getString("fecha");
            	cita[2] = rs.getString("hora");
            	cita[3] = rs.getString("tipo_cita");
            	cita[4] = rs.getString("urgencia");
            	cita[5] = rs.getString("medicamento"); 
            	cita[6] = rs.getDouble("costo");
            	cita[7] = rs.getString("estado");
                citas.add(cita);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }
    
    public List<Object[]> obtenerCitasConDoctor(int idPaciente) {
        List<Object[]> citas = new ArrayList<>();
        try {
            String sql = "SELECT c.id, CONCAT(u.nombre, ' ', u.apellidos) AS doctor, "
            		+ "c.fecha, c.tipo_cita, c.urgencia FROM citas c LEFT JOIN "
            		+ "users u ON c.id_doctor = u.id WHERE c.id_paciente = ? ORDER BY c.fecha DESC";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Object[] cita = new Object[5];
                cita[0] = rs.getInt("id");
                cita[1] = rs.getString("doctor");
                cita[2] = rs.getString("fecha");
                cita[3] = rs.getString("tipo_cita");
                cita[4] = rs.getString("urgencia");
                citas.add(cita);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }
    
    public List<Medicamento> obtenerTodosLosMedicamentos() {
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicamentos WHERE activo = TRUE ORDER BY nombre";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento m = new Medicamento();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setPrecio(rs.getDouble("precio"));
                m.setStock(rs.getInt("stock"));
                m.setStockMinimo(rs.getInt("stock_minimo"));
                m.setRequiereReceta(rs.getBoolean("requiere_receta"));
                m.setCategoria(rs.getString("categoria"));
                m.setProveedor(rs.getString("proveedor"));
                m.setLote(rs.getString("lote"));
                m.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                m.setLaboratorio(rs.getString("laboratorio"));
                m.setActivo(rs.getBoolean("activo"));
                m.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                medicamentos.add(m);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamentos;
    }

    public Medicamento obtenerMedicamentoPorId(int id) {
        Medicamento m = null;
        try {
            String sql = "SELECT * FROM medicamentos WHERE id = ? AND activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Medicamento();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setPrecio(rs.getDouble("precio"));
                m.setStock(rs.getInt("stock"));
                m.setStockMinimo(rs.getInt("stock_minimo"));
                m.setRequiereReceta(rs.getBoolean("requiere_receta"));
                m.setCategoria(rs.getString("categoria"));
                m.setProveedor(rs.getString("proveedor"));
                m.setLote(rs.getString("lote"));
                m.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                m.setLaboratorio(rs.getString("laboratorio"));
                m.setActivo(rs.getBoolean("activo"));
                m.setFechaRegistro(rs.getTimestamp("fecha_registro"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public Medicamento obtenerMedicamentoPorNombre(String nombre) {
        Medicamento m = null;
        try {
            String sql = "SELECT * FROM medicamentos WHERE nombre = ? AND activo = TRUE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Medicamento();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setPrecio(rs.getDouble("precio"));
                m.setStock(rs.getInt("stock"));
                m.setStockMinimo(rs.getInt("stock_minimo"));
                m.setRequiereReceta(rs.getBoolean("requiere_receta"));
                m.setCategoria(rs.getString("categoria"));
                m.setProveedor(rs.getString("proveedor"));
                m.setLote(rs.getString("lote"));
                m.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                m.setLaboratorio(rs.getString("laboratorio"));
                m.setActivo(rs.getBoolean("activo"));
                m.setFechaRegistro(rs.getTimestamp("fecha_registro"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public List<String> obtenerCategoriasMedicamentos() {
        List<String> categorias = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT categoria FROM medicamentos WHERE activo = TRUE AND categoria IS NOT NULL ORDER BY categoria";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categorias.add(rs.getString("categoria"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public List<Medicamento> obtenerMedicamentosConStockBajo() {
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicamentos WHERE activo = TRUE AND stock <= stock_minimo ORDER BY stock ASC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento m = new Medicamento();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setStock(rs.getInt("stock"));
                m.setStockMinimo(rs.getInt("stock_minimo"));
                m.setPrecio(rs.getDouble("precio"));
                m.setCategoria(rs.getString("categoria"));
                medicamentos.add(m);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamentos;
    }

    public boolean insertarMedicamento(Medicamento medicamento) {
        boolean exito = false;
        try {
            String sql = "INSERT INTO medicamentos (nombre, descripcion, precio, stock, stock_minimo, "
                    + "requiere_receta, categoria, proveedor, lote, fecha_vencimiento, laboratorio, activo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medicamento.getNombre());
            ps.setString(2, medicamento.getDescripcion());
            ps.setDouble(3, medicamento.getPrecio());
            ps.setInt(4, medicamento.getStock());
            ps.setInt(5, medicamento.getStockMinimo());
            ps.setBoolean(6, medicamento.isRequiereReceta());
            ps.setString(7, medicamento.getCategoria());
            ps.setString(8, medicamento.getProveedor());
            ps.setString(9, medicamento.getLote());
            ps.setDate(10, medicamento.getFechaVencimiento());
            ps.setString(11, medicamento.getLaboratorio());
            ps.setBoolean(12, medicamento.isActivo());
            
            exito = ps.executeUpdate() > 0;
            if (exito) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    medicamento.setId(rs.getInt(1));
                }
                rs.close();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean actualizarMedicamento(Medicamento medicamento) {
        boolean exito = false;
        try {
            String sql = "UPDATE medicamentos SET nombre=?, descripcion=?, precio=?, stock=?, "
                    + "stock_minimo=?, requiere_receta=?, categoria=?, proveedor=?, lote=?, "
                    + "fecha_vencimiento=?, laboratorio=?, activo=? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, medicamento.getNombre());
            ps.setString(2, medicamento.getDescripcion());
            ps.setDouble(3, medicamento.getPrecio());
            ps.setInt(4, medicamento.getStock());
            ps.setInt(5, medicamento.getStockMinimo());
            ps.setBoolean(6, medicamento.isRequiereReceta());
            ps.setString(7, medicamento.getCategoria());
            ps.setString(8, medicamento.getProveedor());
            ps.setString(9, medicamento.getLote());
            ps.setDate(10, medicamento.getFechaVencimiento());
            ps.setString(11, medicamento.getLaboratorio());
            ps.setBoolean(12, medicamento.isActivo());
            ps.setInt(13, medicamento.getId());
            
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean actualizarStock(int id, int cantidad) {
        boolean exito = false;
        try {
            String sql = "UPDATE medicamentos SET stock = stock + ? WHERE id = ? AND (stock + ?) >= 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, id);
            ps.setInt(3, cantidad);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean eliminarMedicamento(int id) {
        boolean exito = false;
        try {
            String sql = "UPDATE medicamentos SET activo = FALSE WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            exito = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
}