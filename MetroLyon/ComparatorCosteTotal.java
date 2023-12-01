import java.util.Comparator;

public class ComparatorCosteTotal implements Comparator<Nodo>{

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