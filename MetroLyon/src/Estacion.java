import java.util.List;
import java.util.Map;

public class Estacion {
    // Atributos
    private String nombre;
    private double coordenadaX;
    private double coordenadaY;
    private Map<String, Double> conexiones; //  Nombre y distancia de todas las estaciones que tienen conexión directa con this
    private double metrosTransbordo;        // Distancia en metros al hacer un transbordo de una línea a otra, en caso de que exista
    private List<String> lineas;            // Letra de todas las lineas de this

    // Constructor
    public Estacion(String nombre, double coordenadaX, double coordenadaY, Map<String, Double>conexiones, double metrosTransbordo, List<String>lineas){
        this.nombre = nombre;
        this.coordenadaX= coordenadaX;
        this.coordenadaY= coordenadaY;
        this.conexiones= conexiones;
        this.metrosTransbordo= metrosTransbordo;
        this.lineas= lineas;
    }

    // Getters
    public double getCoordenadaX(){
        return this.coordenadaX;
    }
    public double getCoordenadaY(){
        return this.coordenadaY;
    }

    public Map<String, Double> getConexiones(){
        return this.conexiones;
    }

    public Double getDistEntreEstaciones(String e){
        return conexiones.get(e);
    }

    public List<String> getLineas(){
        return lineas;
    }

    public Double getMetrosTransbordo() {
        return metrosTransbordo;
    }
    public String getNombre(){
        return this.nombre;
    }
   

}
