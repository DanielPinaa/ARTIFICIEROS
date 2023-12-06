import java.util.Comparator;

/* Esta clase sirve para comparar objetos de tipo Nodo por su coste total 
   para indicar a la PriorityQueue de la clase Algoritmo la prioridad a seguir
*/
public class ComparatorCosteTotal implements Comparator<Nodo>{

    // Compara los costes totales de los nodos n1 y n2
    @Override
    public int compare(Nodo n1, Nodo n2) {
        if(n1.coste_f() < n2.coste_f()) {
            return -1;
        }
        else if (n1.coste_f() > n2.coste_f()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}