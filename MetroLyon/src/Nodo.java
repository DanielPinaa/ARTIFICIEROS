
public class Nodo {

    // Atributos
    private Estacion estacion;
    private Nodo padre;
    private String linea;
    private double costeRealAcum;
    private double costeHeuristico;

    // Constructor
    public Nodo(Estacion estacion, Nodo padre, double costeRealAcum, double costeHeuristico, String linea) {
        this.estacion = estacion;
        this.padre = padre;
        this.linea = linea;
        this.costeRealAcum = costeRealAcum;
        this.costeHeuristico = costeHeuristico;
    }

    public double coste_f() {
        return costeRealAcum + costeHeuristico;
    }

    // Getters
    public Estacion getEstacion() {
        return estacion;
    }

    public Nodo getPadre() {
        return padre;
    }

    public double getCosteRealAcum() {
        return costeRealAcum;
    }

    public double getCosteHeuristico() {
        return costeHeuristico;
    }
    
    public String getLinea(){
        return linea;
    }
}
