package Model;

public class Paciente {

    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private String edad;
    private String sexo;
    private String fecha;
    private String doctor;
    private String diagnostico;
    private String historial;
    private String foto;
    private int idDueno;
    private String urgencia;
    private String tipoCita;
    private String medicamento;
    private double costo;

    public Paciente() {
    	
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

    public String getEspecie() { 
    	return especie; 
    }
    public void setEspecie(String especie) { 
    	this.especie = especie; 
    }

    public String getRaza() { 
    	return raza; 
    }
    public void setRaza(String raza) { 
    	this.raza = raza; 
    }

    public String getEdad() { 
    	return edad; 
    }
    public void setEdad(String edad) { 
    	this.edad = edad; 
    }

    public String getSexo() { 
    	return sexo; 
    }
    public void setSexo(String sexo) { 
    	this.sexo = sexo; 
    }

    public String getFecha() { 
    	return fecha; 
    }
    
    public void setFecha(String fecha) { 
    	this.fecha = fecha; 
    }

    public String getDoctor() { 
    	return doctor; 
    }
    
    public void setDoctor(String doctor) { 
    	this.doctor = doctor; 
    }

    public String getDiagnostico() { 
    	return diagnostico; 
    }
    public void setDiagnostico(String diagnostico) { 
    	this.diagnostico = diagnostico; 
    }

    public String getHistorial() { 
    	return historial; 
    }
    public void setHistorial(String historial) { 
    	this.historial = historial; 
    }

    public String getFoto() { 
    	return foto; 
    }
    public void setFoto(String foto) { 
    	this.foto = foto; 
    }

    public int getIdDueno() { 
    	return idDueno; 
    }
    public void setIdDueno(int idDueno) { 
    	this.idDueno = idDueno; 
    }

    public String getUrgencia() { 
    	return urgencia; 
    }
    public void setUrgencia(String urgencia) { 
    	this.urgencia = urgencia; 
    }

    public String getTipoCita() { 
    	return tipoCita; 
    }
    public void setTipoCita(String tipoCita) { 
    	this.tipoCita = tipoCita; 
    }

    public String getMedicamento() { 
    	return medicamento; 
    }
    public void setMedicamento(String medicamento) { 
    	this.medicamento = medicamento; 
    }

    public double getCosto() { 
    	return costo; 
    }
    public void setCosto(double costo) { 
    	this.costo = costo; 
    }
}