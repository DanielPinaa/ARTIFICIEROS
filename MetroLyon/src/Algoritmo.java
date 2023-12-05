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

    public static String algoritmoAEstr(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        List<Nodo> camino = algoritmo(origen, estacionFinal, estaciones);
        String res = printCamino(camino, estaciones);
        return res;
    }

	private static List<Nodo> algoritmo(String origen, String estacionFinal, Map<String,Estacion>estaciones) {
        PriorityQueue<Nodo> listaAbierta = new PriorityQueue<Nodo>(new ComparatorCosteTotal()); //opciones no visitadas
        List<Nodo> listaCerrada = new LinkedList<>();
        
        String linea;
        if(estaciones.get(origen).getLineas().size() > 1) {
            linea = null;
        }
        else {
            linea = estaciones.get(origen).getLineas().get(0);
        }
        listaAbierta.add(new Nodo(estaciones.get(origen), null, 0, getDistHeur(estaciones.get(origen), estaciones.get(estacionFinal)), linea));
        
        while(listaAbierta.size() > 0) {
            Nodo nodoAExpandir = listaAbierta.poll();

            if(!nodoAExpandir.getEstacion().equals(estaciones.get(estacionFinal))) {
                listaCerrada.add(nodoAExpandir); // añadimos a la lista cerrada el nodo con menor f

                for(Entry<String, Double> conexion : nodoAExpandir.getEstacion().getConexiones().entrySet()) {
                    Estacion estacionConectada = estaciones.get(conexion.getKey());
                    if(!estaEnListaCerrada(estacionConectada,listaCerrada)/* listaCerrada.contains(estacionConectada) */) {

                        //CALCULAMOS EL COSTE//
                        double costeRealEstConect = nodoAExpandir.getCosteRealAcum() + nodoAExpandir.getEstacion().getConexiones().get(conexion.getKey());
                        double costeHeurEstConect = getDistHeur(estaciones.get(conexion.getKey()), estaciones.get(estacionFinal));
                        //---------------------//
                        
                        String lineaEstacionConectada;
                        if(estaciones.get(estacionConectada.getNombre()).getLineas().size() > 1) {
                            lineaEstacionConectada = null;
                        }
                        else {
                            lineaEstacionConectada = estaciones.get(estacionConectada.getNombre()).getLineas().get(0);
                        }
                        
                        if(nodoAExpandir.getLinea()!=null && lineaEstacionConectada!=null && !nodoAExpandir.getLinea().equals( estacionConectada.getLineas().get(0) )){
                            costeRealEstConect+=estacionConectada.getMetrosTransbordo();
                        }
                        if(lineaEstacionConectada == null && nodoAExpandir.getLinea() != null) {
                            lineaEstacionConectada = nodoAExpandir.getLinea();
                        }
                        
                        Nodo nuevoNodo = new Nodo(estaciones.get(conexion.getKey()), nodoAExpandir, costeRealEstConect, costeHeurEstConect,lineaEstacionConectada);

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

    private static boolean estaEnListaCerrada(Estacion estacionConectada, List<Nodo>listaCerrada) {
        boolean encontrado = false;
        int i = 0;
        for(;!encontrado && i<listaCerrada.size(); i++){
            encontrado= listaCerrada.get(i).getEstacion().equals(estacionConectada);
        }

        return encontrado;
    }

    public static String printCamino(List<Nodo> camino, Map<String,Estacion>estaciones) {
        String res = "<html>";
        for(int i = 0; i < camino.size(); i++) {
            for(Entry<String, Estacion> est: estaciones.entrySet()) {
                if(est.getValue().equals(camino.get(i).getEstacion())) {
                    res += " [ " + camino.get(i).getLinea() + " ] - ";
                    res+=est.getKey();//System.out.println(est.getKey());
                    res=res+"<br>";
                }
            }
        }
        res+="<br>Distancia total recorrida: " + camino.get(camino.size()-1).getCosteRealAcum() +"</html>";//System.out.println("Distancia total recorrida: " + camino.get(camino.size()-1).getCosteRealAcum());
        return res;
    }
    
    public static BufferedImage repaintMap(String origen, String estacionFinal, Map<String,Estacion>estaciones, Map<String,Integer[]> mapDots) {
    	List<Nodo> camino = algoritmo(origen, estacionFinal, estaciones);
    	BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Lyon_-_Metro_network_map.png/600px-Lyon_-_Metro_network_map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(originalImage, 0, 0, null);
		g.setColor(Color.BLACK);
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
    
    public static float getDistHeur(Estacion e1, Estacion e2){
        return (float) Math.sqrt(Math.pow(e2.getCoordenadaX()-e1.getCoordenadaX(), 2) + Math.pow(e2.getCoordenadaY()-e1.getCoordenadaY(), 2));
    }
}