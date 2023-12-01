import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Algoritmo{

    public static void algoritmoAEstr(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        List<Nodo> camino = algoritmo(origen, estacionFinal, estaciones);
        printCamino(camino, estaciones);
    }

	private static List<Nodo> algoritmo(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        PriorityQueue<Nodo> listaAbierta = new PriorityQueue<Nodo>(new ComparatorCosteTotal()); //opciones no visitadas
        List<Nodo> listaCerrada = new LinkedList<>();
        
        listaAbierta.add(new Nodo(estaciones.get(origen), null, 0, getDistHeur(estaciones.get(origen), estaciones.get(estacionFinal))));
        
        while(listaAbierta.size() > 0) {
            Nodo nodoAExpandir = listaAbierta.poll();

            if(!nodoAExpandir.getEstacion().equals(estaciones.get(estacionFinal))) {
                listaCerrada.add(nodoAExpandir); // añadimos a la lista cerrada el nodo con menor f

                for(Entry<String, Double> conexion : nodoAExpandir.getEstacion().getConexiones().entrySet()) {
                    Estacion estacionConectada = estaciones.get(conexion.getKey());
                    if(!listaCerrada.contains(estacionConectada)) {

                        //CALCULAMOS EL COSTE//
                        double costeRealEstConect = nodoAExpandir.getCosteRealAcum() + nodoAExpandir.getEstacion().getConexiones().get(conexion.getKey());
                        double costeHeurEstConect = getDistHeur(estaciones.get(conexion.getKey()), estaciones.get(estacionFinal));
                        //---------------------//

                        Nodo nuevoNodo = new Nodo(estaciones.get(conexion.getKey()), nodoAExpandir, costeRealEstConect, costeHeurEstConect);

                        if(!listaAbierta.contains(nuevoNodo)) {
                            listaAbierta.add(nuevoNodo);
                        }
                    }
                }
            }
            else {
                List<Nodo> camino = new LinkedList<>();
                while(nodoAExpandir != null) {
                    camino.add(nodoAExpandir);
                    nodoAExpandir = nodoAExpandir.getPadre();
                }
                Collections.reverse(camino);
                return camino;
            }
        }
        return null;
    }

    public static void printCamino(List<Nodo> camino, Map<String,Estacion>estaciones) {
        for(int i = 0; i < camino.size(); i++) {
            for(Entry<String, Estacion> est: estaciones.entrySet()) {
                if(est.getValue().equals(camino.get(i).getEstacion())) {
                    System.out.println(est.getKey());
                }
            }
        }
        System.out.println("Distancia total recorrida: " + camino.get(camino.size()-1).getCosteRealAcum());
    }
    
    public static float getDistHeur(Estacion e1, Estacion e2){
        return (float) Math.sqrt(Math.pow(e2.getCoordenadaX()-e1.getCoordenadaX(), 2) + Math.pow(e2.getCoordenadaY()-e1.getCoordenadaY(), 2));
    }
}