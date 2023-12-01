public class Nodo {
    private Estacion estacion;
    private Nodo padre;
    private double costeRealAcum;
    private double costeHeuristico;

    public Nodo(Estacion estacion, Nodo padre, double costeRealAcum, double costeHeuristico) {
        this.estacion = estacion;
        this.padre = padre;
        this.costeRealAcum = costeRealAcum;
        this.costeHeuristico = costeHeuristico;
    }

    public double coste_f() {
        return costeRealAcum + costeHeuristico;
    }

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

    
}
