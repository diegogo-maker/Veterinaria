package Model;

public class Dueno {

    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String mascota;
    private String colonia;
    private String direccion;
    private String foto;

    public Dueno() {
    	
    }

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }

    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }

    public String getApellidos() { 
    	return apellidos; 
    }
    public void setApellidos(String apellidos) { 
    	this.apellidos = apellidos; 
    }

    public String getTelefono() { 
    	return telefono; 
    }
    public void setTelefono(String telefono) { 
    	this.telefono = telefono; 
    }

    public String getCorreo() { 
    	return correo; 
    }
    public void setCorreo(String correo) { 
    	this.correo = correo; 
    }

    public String getMascota() { 
    	return mascota; 
    }
    public void setMascota(String mascota) { 
    	this.mascota = mascota; 
    }

    public String getColonia() { 
    	return colonia; 
    }
    public void setColonia(String colonia) { 
    	this.colonia = colonia; 
    }

    public String getDireccion() { 
    	return direccion; 
    }
    public void setDireccion(String direccion) { 
    	this.direccion = direccion; 
    }

    public String getFoto() { 
    	return foto; 
    }
    public void setFoto(String foto) { 
    	this.foto = foto; 
    }
}