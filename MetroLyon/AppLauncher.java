import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AppLauncher extends JFrame implements ActionListener{
    
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
      setResizable(true);
  
      //Cerrar proceso al cerrar la ventana
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      //TEXTFIELDS
      origen= new JTextField("Introduce origen");
      origen.setBounds(250, 110,300,30);
      destino= new JTextField("Introduce destino");
      destino.setBounds(250, 210,300,30);
      add(origen);
      add(destino);

      //TEXTO
      caminoGUI= new JLabel("<html>"+camino+"</html>");
      caminoGUI.setBounds(400, -100,1000,1000);
      add(caminoGUI);
      
  
      //Botones
      botonIniciar=new JButton("Iniciar");
      botonIniciar.setBounds(400,600,100,30);
      add(botonIniciar);
      botonIniciar.addActionListener(this);

      botonFinalizar=new JButton("Finalizar");
      botonFinalizar.setBounds(400,700,100,30);
      add(botonFinalizar);
      botonFinalizar.addActionListener(this);
  
      //Muestro JFrame (lo último para que lo pinte todo correctamanete)
      setVisible(true);
  
    }
    
}