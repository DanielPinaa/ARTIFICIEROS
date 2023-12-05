import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
public class AutoComplete extends javax.swing.JFrame{
    public AutoComplete(JComboBox jComboBox1){
        AutoCompleteDecorator.decorate(jComboBox1);
    }
}
