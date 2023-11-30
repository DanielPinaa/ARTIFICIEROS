import java.util.Map;

public class Estacion{
    private double coordenadaX;
    private double coordenadaY;
    private Map<String, Double> conexiones;
    private double costeAcumulado;
    private Estacion predecesor;
    

    public Estacion(double coordenadaX, double coordenadaY, Map<String, Double>conexiones){
        this.coordenadaX= coordenadaX;
        this.coordenadaY= coordenadaY;
        this.conexiones= conexiones;
        this.predecesor= null;
        this.costeAcumulado = 0;
        
    }

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

    public void setPredecesor(Estacion padre){
        predecesor= padre;
    }

    public void setCoste(Double coste){
        costeAcumulado+=coste;
    }

    public double getCoste(){
        return costeAcumulado;
    }
}
