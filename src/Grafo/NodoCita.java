package Grafo;

import java.text.SimpleDateFormat;
import java.util.*;

class NodoCita {
	
    private Object[] cita;
    private int urgenciaValor;
    private Date fecha;
    private List<NodoCita> adyacentes;
    
    public NodoCita(Object[] cita) {
        this.cita = cita;
        this.adyacentes = new ArrayList<>();
        this.urgenciaValor = convertirUrgenciaAValor((String) cita[4]);
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.fecha = sdf.parse(cita[1].toString());
        } 
        catch (Exception e) {
            this.fecha = new Date();
        }
    }
    
    private int convertirUrgenciaAValor(String urgencia) {
        switch(urgencia) {
            case "Alta": return 3;
            case "Media": return 2;
            case "Baja": return 1;
            default: return 0;
        }
    }
    
    public int getUrgenciaValor() { 
    	return urgenciaValor; 
    }
    
    public Date getFecha() { 
    	return fecha; 
    }
    
    public Object[] getCita() { 
    	return cita; 
    }
    public List<NodoCita> getAdyacentes() { 
    	return adyacentes; 
    }
    
    public void agregarAdyacente(NodoCita nodo) {
        adyacentes.add(nodo);
    }
}

