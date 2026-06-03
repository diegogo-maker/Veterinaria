package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoCitas {
	
    private Map<Integer, NodoCita> nodos;
    private List<NodoCita> ordenTopologico;
    
    public GrafoCitas() {
        this.nodos = new HashMap<>();
        this.ordenTopologico = new ArrayList<>();
    }
    
    public void agregarCita(Object[] cita) {
        int idCita = Integer.parseInt(cita[0].toString());
        NodoCita nodo = new NodoCita(cita);
        nodos.put(idCita, nodo);
    }
    
    public void construirAristas() {

        List<NodoCita> listaOrdenada = new ArrayList<>(nodos.values());
        
        listaOrdenada.sort((a, b) -> {
            if (a.getUrgenciaValor() != b.getUrgenciaValor()) {
                return Integer.compare(b.getUrgenciaValor(), a.getUrgenciaValor());
            }
            return a.getFecha().compareTo(b.getFecha());
        });
        
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
        	
            NodoCita actual = listaOrdenada.get(i);
            NodoCita siguiente = listaOrdenada.get(i + 1);
            actual.agregarAdyacente(siguiente);
        }
        
        ordenTopologico = listaOrdenada;
    }
    
    public List<Object[]> obtenerCitasOrdenadas() {
    	
        List<Object[]> citasOrdenadas = new ArrayList<>();
        for (NodoCita nodo : ordenTopologico) {
            citasOrdenadas.add(nodo.getCita());
        }
        return citasOrdenadas;
    }
}