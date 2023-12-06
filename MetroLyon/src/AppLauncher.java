
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import java.util.*;


public class AppLauncher extends JFrame implements ActionListener{

    // Atributos
    JLabel imagen;
    JLabel imagen2;
    JLabel tren;
    JLabel logo;
    JButton botonFinalizar;
    JButton botonIniciar;
    JLabel caminoGUI;
    String camino;
    List<Nodo> nodos;
    JComboBox<String> comboBoxOrg;                  // Desplegable de la estación origen
    JComboBox<String> comboBoxDest;                 // Desplegable de la estación destino
    AutoComplete auto;                              // Para que los desplegables a usar sean autocompletables
    Set<String> claves = Ppal.estaciones.keySet();
    String nombres[]=new String[44];                // Array donde se guardan los nombres de las estaciones
    
    // Método para manejar eventos de acción
    public void actionPerformed(ActionEvent e) {
      // Se guarda en estacionOrigen la estacion origen seleccionada en el comboBox correspondiente
      String estacionOrigen = (String)comboBoxOrg.getSelectedItem();
      // Se guarda en estacionDestino la estacion destino seleccionada en el comboBox correspondiente
      String estacionDestino= (String)comboBoxDest.getSelectedItem();

      if (e.getSource() == botonFinalizar) {
        // Cerrar aplicación al pulsar botonFinalizar
        System.exit(0);
      }
      else if(e.getSource() == botonIniciar){ 
        // Al pulsar botonIniciar:
        //  - se hace la búsqueda con el algoritmo A*
        camino = Algoritmo.algoritmoAEstr(estacionOrigen, estacionDestino, Ppal.estaciones);

        //  - se añade un gif
        tren = new JLabel(new ImageIcon("tren.gif"));
        tren.setBounds(450,200,750,750);
        add(tren); 

        //  - se añade el recorrido más óptimo
        add(caminoGUI);
        caminoGUI.setText(camino);

        //  - se marcan sobre la imagen del mapa las estaciones a visitar lo proporciona una mejor visión del camino
        imagen.setIcon(new ImageIcon(Algoritmo.repaintMap(estacionOrigen, estacionDestino, Ppal.estaciones, Ppal.mapDots)));
      }
    }

    // Constructor
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

      //Imagen del metro
      try {
        imagen = new JLabel(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Lyon_-_Metro_network_map.png/600px-Lyon_-_Metro_network_map.png")));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      imagen.setBounds(25,25,700,700);
      add(imagen);
      
      //Imagen del logo del metro
      try {
        imagen2 = new JLabel(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Lyon_tcl_logo-metro-full.svg/56px-Lyon_tcl_logo-metro-full.svg.png")));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      imagen2.setBounds(25,10,50,50);
      add(imagen2);
      
      //Imagen del logo
      logo = new JLabel(new ImageIcon("LOGO.png"));
      logo.setBounds(350, 700, 500, 100);;
      add(logo);
  
 
      //Texto con el camino óptimo
      caminoGUI= new JLabel("<html>"+camino+"</html>");
      caminoGUI.setBounds(700, 0,700,700);
      
      //Botón iniciar 
      botonIniciar=new JButton("Iniciar");
      botonIniciar.setBounds(945,125,100,30);
      add(botonIniciar);
      botonIniciar.addActionListener(this);

      //Botón salir
      botonFinalizar=new JButton("Salir");
      botonFinalizar.setBounds(750,650,100,30);
      add(botonFinalizar);
      botonFinalizar.addActionListener(this);  

      //Caja opciones con autocompletado
      //Rellenamos el array nombres con los nombres de todas las estaciones
      Iterator<String> it = claves.iterator();
      nombres[0]="Introduce Origen";
      for(int i = 1; i<44;i++){
          nombres[i] = (String) it.next();
      }
      
      // Para elegir la estación origen
      comboBoxOrg = new JComboBox<String>(nombres);
      comboBoxOrg.setBounds(700,100,220,30);
      add(comboBoxOrg);
      setVisible(true);
      comboBoxOrg.addActionListener(this); 
      auto = new AutoComplete(comboBoxOrg);

      // Para elegir la estación destino
      nombres[0]="Introduce Destino";
      comboBoxDest = new JComboBox<String>(nombres);
      comboBoxDest.setBounds(700,150,220,30);
      add(comboBoxDest);
      setVisible(true);
      comboBoxDest.addActionListener(this); 
      auto = new AutoComplete(comboBoxDest);
      
    }
    
}
