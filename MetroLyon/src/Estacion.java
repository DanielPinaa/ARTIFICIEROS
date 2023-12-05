import java.util.List;
import java.util.Map;

public class Estacion {
    // Atributos
    private String nombre;
    private double coordenadaX;
    private double coordenadaY;
    private Map<String, Double> conexiones;
    private double metrosTransbordo;
    private List<String> lineas;

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
