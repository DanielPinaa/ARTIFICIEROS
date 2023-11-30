import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Algoritmo{
    private List<Estacion>camino;
    private Map<String,Estacion>estaciones;
    private float distanciaMin;
    

    public Algoritmo(Map<String,Estacion>estaciones){
        this.estaciones= estaciones;
        camino= new LinkedList<Estacion>();
    }

    


    public float getDistHeur(Estacion e1, Estacion e2){
        return (float) Math.sqrt(Math.pow(e2.getCoordenadaX()-e1.getCoordenadaX(), 2) + Math.pow(e2.getCoordenadaY()-e1.getCoordenadaY(), 2));
    }
}