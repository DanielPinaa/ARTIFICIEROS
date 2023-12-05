
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import java.util.*;


public class AppLauncher extends JFrame implements ActionListener{
    JLabel imagen;
    JLabel imagen2;
    JLabel tren;
    JLabel logo;
    JButton botonFinalizar;
    JButton botonIniciar;
    JLabel caminoGUI;
    String camino;
    List<Nodo> nodos;
    
    Set<String> claves = Ppal.estaciones.keySet();
    String nombres[]=new String[44];
    JComboBox<String> comboBoxOrg;
    JComboBox<String> comboBoxDest;
    AutoComplete auto; 
    
    public void actionPerformed(ActionEvent e) {

      String estacionOrigen = (String)comboBoxOrg.getSelectedItem();
      String estacionDestino= (String)comboBoxDest.getSelectedItem();
      if (e.getSource() == botonFinalizar) {
        
        System.exit(0);
      }
      else if(e.getSource() == botonIniciar){
        camino = Algoritmo.algoritmoAEstr(estacionOrigen, estacionDestino, Ppal.estaciones);
        
        tren = new JLabel(new ImageIcon("tren.gif"));
        tren.setBounds(450,200,750,750);
        add(tren); 
        add(caminoGUI);
        caminoGUI.setText(camino);
        imagen.setIcon(new ImageIcon(Algoritmo.repaintMap(estacionOrigen, estacionDestino, Ppal.estaciones, Ppal.mapDots)));

      }
    }


    AppLauncher(){
      
      setLayout(null);
  
      //Tamaño de la ventana
      setBounds(0,0,1200,900);
  
      //Título
      setTitle("Metro - Lyon");
  
      //No redimensionable
      setResizable(false);
  
      //Cerrar proceso al cerrar la ventana
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      //IMAGEN
      try {
        imagen = new JLabel(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Lyon_-_Metro_network_map.png/600px-Lyon_-_Metro_network_map.png")));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      imagen.setBounds(25,25,700,700);
      add(imagen);
      
      try {
        imagen2 = new JLabel(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Lyon_tcl_logo-metro-full.svg/56px-Lyon_tcl_logo-metro-full.svg.png")));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      imagen2.setBounds(25,10,50,50);
      add(imagen2);

      
      logo = new JLabel(new ImageIcon("LOGO.png"));
      logo.setBounds(350, 700, 500, 100);;
      add(logo);
  
 
      //TEXTO
      caminoGUI= new JLabel("<html>"+camino+"</html>");
      caminoGUI.setBounds(700, 0,700,700);
      
      //Botones
      botonIniciar=new JButton("Iniciar");
      botonIniciar.setBounds(945,125,100,30);
      add(botonIniciar);
      botonIniciar.addActionListener(this);

      botonFinalizar=new JButton("Salir");
      botonFinalizar.setBounds(750,650,100,30);
      add(botonFinalizar);
      botonFinalizar.addActionListener(this);  

      //CAJA OPCIONES CON AUTOCOMPLETADO
      //rellenamos el array nombres con los nombres de todas las estaciones
      Iterator<String> it = claves.iterator();
      nombres[0]="Introduce Origen";
      for(int i = 1; i<44;i++){
          nombres[i] = (String) it.next();
      }

      comboBoxOrg = new JComboBox<String>(nombres);
      comboBoxOrg.setBounds(700,100,220,30);
      add(comboBoxOrg);
      setVisible(true);
      comboBoxOrg.addActionListener(this); 
      auto = new AutoComplete(comboBoxOrg);

      nombres[0]="Introduce Destino";
      comboBoxDest = new JComboBox<String>(nombres);
      comboBoxDest.setBounds(700,150,220,30);
      add(comboBoxDest);
      setVisible(true);
      comboBoxDest.addActionListener(this); 
      auto = new AutoComplete(comboBoxDest);
      
    }
    
}
