import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/* Esta clase sirve para porder usar AutoCompleteDecorator y que los 
desplegables (JComboBox)usados en la herramienta gráfica sean autocompletables*/
public class AutoComplete extends javax.swing.JFrame{

    //Constructor
    public AutoComplete(JComboBox jComboBox1){
        // Aplica la decoración de autocompletar al JComboBox proporcionado
        AutoCompleteDecorator.decorate(jComboBox1);
    }
}
