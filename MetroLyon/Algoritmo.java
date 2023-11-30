import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/* 
ABIERTOS := [INICIAL] //inicialización 
CERRADOS := [] 
f'(INICIAL) := h'(INICIAL) 
repetir 
si ABIERTOS = [] entonces FALLO 
si no // quedan nodos 
extraer MEJORNODO de ABIERTOS con f' mí­nima 
// cola de prioridad 
mover MEJORNODO de ABIERTOS a CERRADOS 
si MEJORNODO contiene estado_objetivo entonces 
SOLUCION_ENCONTRADA := TRUE 
si no 
generar SUCESORES de MEJORNODO 
para cada SUCESOR hacer TRATAR_SUCESOR 
hasta SOLUCION_ENCONTRADA o FALLO */


public class Algoritmo{
    private List<String>camino;
    private Map<String,Estacion>estaciones;
    private float distanciaMin;
    
    private Map<String,Integer>listaCerrada;
    private PriorityQueue<Estacion> listaAbierta;
    
  

    public <T> Algoritmo(Map<String,Estacion>estaciones){
        this.estaciones= estaciones;
        camino= new LinkedList<String>();

        listaCerrada= new HashMap<>();
        listaAbierta = new PriorityQueue<>();
    }


    public List<String> algoritmo(Estacion origen, Estacion destino){
        Estacion actual = origen;
        actual.setCoste(0.0);

        while(actual.equals(null) || !actual.equals(destino)){
            for(Entry<String, Double> entry : actual.getConexiones().entrySet()){
                if(listaCerrada.get(entry.getKey())==null){
                    Estacion a = estaciones.get(entry.getKey());
                    a.setCoste(actual.getCoste());




                    listaAbierta.add(estaciones.get(entry.getKey()));
                }

            }

            actual = listaAbierta.poll();
        }
        
        return camino;
    }
    


    public double getDistHeur(Estacion e1, Estacion e2){
        return (double) Math.sqrt(Math.pow(e2.getCoordenadaX()-e1.getCoordenadaX(), 2) + Math.pow(e2.getCoordenadaY()-e1.getCoordenadaY(), 2));
    }
}