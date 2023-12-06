import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import javax.imageio.ImageIO;

public class Algoritmo{

    //Devuelve un String con el camino óptimo entre origen y estacionFinal, tomando como parámetro todas las estaciones del metro
    public static String algoritmoAEstr(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        List<Nodo> camino = algoritmo(origen, estacionFinal, estaciones);
        String res = printCamino(camino, estaciones);
        return res;
    }

    //Devuelve un List<Nodo> con el camino óptimo entre origen y estacionFinal, tomando como parámetro todas las estaciones del metro 
	private static List<Nodo> algoritmo(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        //Lista abierta
        PriorityQueue<Nodo> listaAbierta = new PriorityQueue<Nodo>(new ComparatorCosteTotal()); 
        //Lista cerrada
        List<Nodo> listaCerrada = new LinkedList<>();
        
        String linea;
        //Si la estación tiene más de una línea la indicamos como null
        if(estaciones.get(origen).getLineas().size() > 1) {
            linea = null;
        }
        else {
            linea = estaciones.get(origen).getLineas().get(0);
        }
        //Metemos el nodo de la estación inicial a la lista abierta
        listaAbierta.add(new Nodo(estaciones.get(origen), null, 0, getDistHeur(estaciones.get(origen), estaciones.get(estacionFinal)), linea));

        List<Nodo>camino = null;
        //Mientras que no hayamos encontrado el camino optimo y queden nodos en la lista abierta seguimos explorando
        while(listaAbierta.size() > 0 && camino==null) {
            //Extraemos el nodo con más prioridad de la lista abierta
            Nodo nodoAExpandir = listaAbierta.poll();

            //Si el nodo no contiene a la estación destino seguimos explorando
            if(!nodoAExpandir.getEstacion().equals(estaciones.get(estacionFinal))) {

                // Añadimos a la lista cerrada el nodo con menor coste (f())
                listaCerrada.add(nodoAExpandir); 

                // Exploramos todas las estaciones que tienen conexión directa con la estación del nodo actual
                for(Entry<String, Double> conexion : nodoAExpandir.getEstacion().getConexiones().entrySet()) {
                    Estacion estacionConectada = estaciones.get(conexion.getKey());

                    //Si la estacion no está en la lista cerrada añadimos un nuevo nodo que la represente
                    if(!estaEnListaCerrada(estacionConectada,listaCerrada)) {

                        //Calculamos el coste real acumulado y el heurístico
                        double costeRealEstConect = nodoAExpandir.getCosteRealAcum() + nodoAExpandir.getEstacion().getConexiones().get(conexion.getKey());
                        double costeHeurEstConect = getDistHeur(estaciones.get(conexion.getKey()), estaciones.get(estacionFinal));
                        
                        String lineaEstacionConectada;
                        //Si la estación tiene más de una línea la indicamos como null
                        if(estaciones.get(estacionConectada.getNombre()).getLineas().size() > 1) {
                            lineaEstacionConectada = null;
                        }
                        else {
                            lineaEstacionConectada = estaciones.get(estacionConectada.getNombre()).getLineas().get(0);
                        }
                        
                        //Añadimos penalización de trasbordo (si tiene)
                        if(nodoAExpandir.getLinea()!=null && lineaEstacionConectada!=null && !nodoAExpandir.getLinea().equals( estacionConectada.getLineas().get(0) )){
                            costeRealEstConect+=estacionConectada.getMetrosTransbordo();
                        }

                        //Añadimos la línea del nodo anterior si el nuevo que se va a crear tiene más de una línea
                        if(lineaEstacionConectada == null && nodoAExpandir.getLinea() != null) {
                            lineaEstacionConectada = nodoAExpandir.getLinea();
                        }
                        
                        //Creamos el nuevo nodo
                        Nodo nuevoNodo = new Nodo(estaciones.get(conexion.getKey()), nodoAExpandir, costeRealEstConect, costeHeurEstConect,lineaEstacionConectada);

                        //Añadimos el nuevo nodo a la lista abierta si no estaba anteriormente
                        if(!listaAbierta.contains(nuevoNodo)) {
                            listaAbierta.add(nuevoNodo);
                        }
                    }
                }
            }
            //Si el nodo contiene a la estación destino devolvemos el camino
            else {
                camino = new LinkedList<>();
                while(nodoAExpandir != null) {
                    camino.add(nodoAExpandir);
                    nodoAExpandir = nodoAExpandir.getPadre();
                }
                Collections.reverse(camino);
            }
        }
        return camino;
    }

    //Comprueba que la estación no estaba en la lista cerrada
    private static boolean estaEnListaCerrada(Estacion estacionConectada, List<Nodo>listaCerrada) {
        boolean encontrado = false;
        int i = 0;
        for(;!encontrado && i<listaCerrada.size(); i++){
            encontrado= listaCerrada.get(i).getEstacion().equals(estacionConectada);
        }

        return encontrado;
    }

    //Genera un string en formato HTML con el camino óptimo para poder ser representado correctamente en la interfaz gráfica
    public static String printCamino(List<Nodo> camino, Map<String,Estacion>estaciones) {
        String res = "<html>";
        for(int i = 0; i < camino.size(); i++) {
            for(Entry<String, Estacion> est: estaciones.entrySet()) {
                if(est.getValue().equals(camino.get(i).getEstacion())) {
                    res += " [ " + camino.get(i).getLinea() + " ] - ";
                    res+=est.getKey();
                    res=res+"<br>";
                }
            }
        }
        res+="<br>Distancia total recorrida: " + camino.get(camino.size()-1).getCosteRealAcum() +"</html>";//System.out.println("Distancia total recorrida: " + camino.get(camino.size()-1).getCosteRealAcum());
        return res;
    }
    
    //Representa el camino óptimo con puntos negros en el mapa
    public static BufferedImage repaintMap(String origen, String estacionFinal, Map<String,Estacion>estaciones, Map<String,Integer[]> mapDots) {
    	List<Nodo> camino = algoritmo(origen, estacionFinal, estaciones);

        //Cargamos la imagen del mapa
    	BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Lyon_-_Metro_network_map.png/600px-Lyon_-_Metro_network_map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Pintamos los puntos del camino óptimo en el mapa
		BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(originalImage, 0, 0, null);
		g.setColor(Color.BLACK);

        //Recorremos todo el camino óptimo pintando los puntos negros en las estaciones que corresponda
    	for(int i = 0; i < camino.size(); i++) {
            for(Entry<String, Estacion> est: estaciones.entrySet()) {
                if(est.getValue().equals(camino.get(i).getEstacion())) {
                	Integer values[] = mapDots.get(est.getValue().getNombre());
                	g.fillOval(values[0], values[1], values[2], values[3]);
                }
            }
        }
		g.dispose();
		return newImage;
    }
    
    //Calcula la distancia heurística entre dos estaciones aplicando la fórmula de la distancia entre dos puntos cartesianos (Tma. Pitágoras)
    public static float getDistHeur(Estacion e1, Estacion e2){
        return (float) Math.sqrt(Math.pow(e2.getCoordenadaX()-e1.getCoordenadaX(), 2) + Math.pow(e2.getCoordenadaY()-e1.getCoordenadaY(), 2));
    }
}