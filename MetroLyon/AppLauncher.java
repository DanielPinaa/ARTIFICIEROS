import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class AppLauncher extends JFrame implements ActionListener{
    JLabel imagen;
    JTextField origen;
    JTextField destino;
    JButton botonFinalizar;
    JButton botonIniciar;
    JLabel caminoGUI;
    String camino;
  
    public void actionPerformed(ActionEvent e) {
      String estacionOrigen = origen.getText();
      String estacionDestino = destino.getText();
      if (e.getSource() == botonFinalizar) {
        System.exit(0);
      }
      else if(e.getSource() == botonIniciar){
        camino = Algoritmo.algoritmoAEstr(estacionOrigen, estacionDestino, Ppal.estaciones);
        add(caminoGUI);
        caminoGUI.setText(camino);
      }
    }

    AppLauncher(){
        
      setLayout(null);
  
      //Tamaño de la ventana
      setBounds(0,0,1000,1000);
  
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
      imagen.setBounds(200, 50,600,600);
      add(imagen);

      //TEXTFIELDS
      origen= new JTextField("Introduce origen");
      origen.setBounds(50, 310,100,30);
      destino= new JTextField("Introduce destino");
      destino.setBounds(50, 410,100,30);
      add(origen);
      add(destino);

      //TEXTO
      caminoGUI= new JLabel("<html>"+camino+"</html>");
      caminoGUI.setBounds(300, 300,1000,1000);
      //add(caminoGUI);
      
  
      //Botones
      botonIniciar=new JButton("Iniciar");
      botonIniciar.setBounds(600,700,100,30);
      add(botonIniciar);
      botonIniciar.addActionListener(this);

      botonFinalizar=new JButton("Finalizar");
      botonFinalizar.setBounds(600,800,100,30);
      add(botonFinalizar);
      botonFinalizar.addActionListener(this);
  
      //Muestro JFrame (lo último para que lo pinte todo correctamanete)
      setVisible(true);
  
    }
    
}