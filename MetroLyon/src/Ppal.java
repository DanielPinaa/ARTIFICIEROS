import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Ppal {
    // Atributos
    public static Map<String,Estacion> estaciones;
    public static Map<String,Integer[]> mapDots;
    
    public static void main(String[] args) {
        estaciones = new HashMap<String,Estacion>(); 
        mapDots = new HashMap<String,Integer[]>();

        /* Para conocer el tiempo estimado entre transborodos, tenemos en cuenta el siguiente dato: 
            ----> La velocidad media de una persona al caminar: 4.5 Km/h = 75 m/min
        */
        
        //ESTACIONES LINEA A
        estaciones.put("Perrache", new Estacion( "Perrache",642012.8, 5067725.7, new HashMap<String,Double>(){{put("Ampere Victor Hugo", 555.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Ampere Victor Hugo", new Estacion("Ampere Victor Hugo", 642263, 5068219.3, new HashMap<String,Double>(){{put("Perrache",  555.0); put("Bellecour", 740.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Bellecour", new Estacion("Bellecour",  642604.7, 5068776.8, new HashMap<String,Double>(){{put("Ampere Victor Hugo", 740.0);put("Cordeliers", 697.0);put("Vieux Lyon Cathedrale St. Jean", 660.0);put("Guillotiere", 720.0);}},75,new LinkedList<String>(){{add("A");add("D");}}));
        estaciones.put("Cordeliers", new Estacion( "Cordeliers", 642750.8, 5069382.2, new HashMap<String,Double>(){{put("Bellecour", 697.0);put("Hotel de Ville Louis Pradel", 479.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Hotel de Ville Louis Pradel", new Estacion("Hotel de Ville Louis Pradel", 642783.4, 5069843, new HashMap<String,Double>(){{put("Foch", 754.0);put("Cordeliers", 479.0);put("Croix-Paquet", 434.0);}},300,new LinkedList<String>(){{add("A");add("C");}}));
        estaciones.put("Foch", new Estacion( "Foch",643395.7, 5069999.2, new HashMap<String,Double>(){{put("Hotel de Ville Louis Pradel", 754.0);put("Massena", 713.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Massena", new Estacion( "Massena",644082.9, 5070092.3, new HashMap<String,Double>(){{put("Charpennes Charles Hernu", 913.0);put("Foch", 713.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Charpennes Charles Hernu", new Estacion( "Charpennes Charles Hernu",644850.9, 5070242.9, new HashMap<String,Double>(){{put("Massena", 913.0);put("Republique Villeurbanne", 777.0);put("Brotteaux", 455.0);}},150,new LinkedList<String>(){{add("A"); add("B");}}));
        estaciones.put("Republique Villeurbanne", new Estacion( "Republique Villeurbanne", 645680, 5070268.5, new HashMap<String,Double>(){{put("Gratte-Ciel", 747.0);put("Charpennes Charles Hernu", 777.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Gratte-Ciel", new Estacion("Gratte-Ciel", 646370.9, 5070111.8, new HashMap<String,Double>(){{put("Republique Villeurbanne", 747.0);put("Flachet", 644.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Flachet", new Estacion("Flachet",  646953.4, 5069971.1, new HashMap<String,Double>(){{put("Cusset", 869.0);put("Gratte-Ciel", 644.0);}},0,new LinkedList<String>(){{add("A");}}));
        estaciones.put("Cusset", new Estacion( "Cusset",647762.2, 5069764.9, new HashMap<String,Double>(){{put("Flachet", 869.0);put("Laurent Bonnevay Astroballe", 767.0);}},0,new LinkedList<String>(){{add("A");}}));      
        estaciones.put("Laurent Bonnevay Astroballe", new Estacion("Laurent Bonnevay Astroballe", 648436.2, 5069688.3, new HashMap<String,Double>(){{put("Vaulx-en-Velin La Soie", 1170.0);put("Cusset", 767.0);}},0,new LinkedList<String>(){{add("A");}})); 
        estaciones.put("Vaulx-en-Velin La Soie", new Estacion("Vaulx-en-Velin La Soie",  649478.6, 5069296.4, new HashMap<String,Double>(){{put("Laurent Bonnevay Astroballe", 1170.0);}},0,new LinkedList<String>(){{add("A");}}));      

        //ESTACIONES LINEA B
        estaciones.put("Oullins Gare", new Estacion("Oullins Gare", 641232.8, 5064181.8, new HashMap<String,Double>(){{put("Stade de Gerland", 1830.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Stade de Gerland", new Estacion("Stade de Gerland", 642458.4, 5065349.1, new HashMap<String,Double>(){{put("Oullins Gare",  1830.0); put("Debourg", 530.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Debourg", new Estacion("Debourg", 642731.0, 5065818.5, new HashMap<String,Double>(){{put("Stade de Gerland",  530.0); put("Place Jean Jaures", 790.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Place Jean Jaures", new Estacion("Place Jean Jaures", 642951.3, 5066580.1, new HashMap<String,Double>(){{put("Debourg",  790.0); put("Jean Mace", 950.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Jean Mace", new Estacion("Jean Mace", 643313.8, 5067459.1, new HashMap<String,Double>(){{put("Place Jean Jaures",  950.0); put("Saxe Gambetta", 960.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Saxe Gambetta", new Estacion("Saxe Gambetta", 643649.8, 5068356.2, new HashMap<String,Double>(){{put("Jean Mace",  960.0); put("Place Guichard Bourse du Travail", 615.0); put("Guillotiere",405.0); put("Garibaldi",598.0);}},75,new LinkedList<String>(){{add("B");add("D");}}));
        estaciones.put("Place Guichard Bourse du Travail", new Estacion("Place Guichard Bourse du Travail", 643689.5, 5068974.6, new HashMap<String,Double>(){{put("Saxe Gambetta",  615.0); put("Gare Part-Dieu Vivier Merle", 945.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Gare Part-Dieu Vivier Merle", new Estacion("Gare Part-Dieu Vivier Merle", 644472.7, 5069221.3, new HashMap<String,Double>(){{put("Place Guichard Bourse du Travail",  945.0); put("Brotteaux", 605.0);}},0,new LinkedList<String>(){{add("B");}}));
        estaciones.put("Brotteaux", new Estacion("Brotteaux", 644562.9, 5069803.9, new HashMap<String,Double>(){{put("Gare Part-Dieu Vivier Merle",  605.0); put("Charpennes Charles Hernu", 455.0);}},0,new LinkedList<String>(){{add("B");}}));
        
        //ESTACIONES LINEA C
        estaciones.put("Cuire", new Estacion("Cuire", 642507.3, 5071893.2, new HashMap<String,Double>(){{put("Henon", 895.0);}},0,new LinkedList<String>(){{add("C");}}));
        estaciones.put("Henon", new Estacion("Henon", 642060.2, 5071135.7, new HashMap<String,Double>(){{put("Cuire", 895.0); put("Croix-Rousse", 630.0);}},0,new LinkedList<String>(){{add("C");}}));
        estaciones.put("Croix-Rousse", new Estacion("Croix-Rousse", 642424.6, 5070603.7, new HashMap<String,Double>(){{put("Croix-Paquet", 645.0); put("Henon", 630.0);}},0,new LinkedList<String>(){{add("C");}}));
        estaciones.put("Croix-Paquet", new Estacion( "Croix-Paquet", 642770.0, 5070238.0, new HashMap<String,Double>(){{put("Croix-Rousse", 645.0); put("Hotel de Ville Louis Pradel", 434.0);}},0,new LinkedList<String>(){{add("C");}}));
        
        //ESTACIONES LINEA D
        estaciones.put("Gare de Vaise", new Estacion("Gare de Vaise",640320.9,5071235.1, new HashMap<String,Double>(){{put("Valmy",702.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Valmy", new Estacion("Valmy",640378.7,5070588.0, new HashMap<String,Double>(){{put("Gare de Vaise",702.0); put("Gorge de Loup",950.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Gorge de Loup", new Estacion("Gorge de Loup",640361.3,5069636.6, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",1740.0); put("Valmy",950.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Vieux Lyon Cathedrale St. Jean", new Estacion("Vieux Lyon Cathedrale St. Jean", 641983.7,5069000.3, new HashMap<String,Double>(){{put("Gorge de Loup",1740.0); put("Bellecour",660.0); put("Fourviere",445.0); put("Minimes Theatres Romains",520.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Guillotiere", new Estacion("Guillotiere",643278.5,5068520.5, new HashMap<String,Double>(){{put("Bellecour",720.0); put("Saxe Gambetta",405.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Garibaldi", new Estacion("Garibaldi",644202.1,5068118.8, new HashMap<String,Double>(){{put("Saxe Gambetta",598.0); put("Sans-Souci",900.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Sans-Souci", new Estacion("Sans-Souci",645017.4,5067736.4, new HashMap<String,Double>(){{put("Monplaisir-Lumiere",600.0); put("Garibaldi",900.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Monplaisir-Lumiere", new Estacion("Monplaisir-Lumiere",645561.7,5067477.4, new HashMap<String,Double>(){{put("Sans-Souci",600.0); put("Grange Blanche",650.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Grange Blanche", new Estacion("Grange Blanche",646156.2,5067204.1, new HashMap<String,Double>(){{put("Laennec",1200.0); put("Monplaisir-Lumiere",650.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Laennec", new Estacion("Laennec",646756.1,5066702.6, new HashMap<String,Double>(){{put("Mermoz Pinel",540.0); put("Grange Blanche",1200.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Mermoz Pinel",new Estacion("Mermoz Pinel",646849.2,5065871.1, new HashMap<String,Double>(){{put("Parilly",1240.0); put("Laennec",540.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Parilly", new Estacion("Parilly",646893.9,5064618.5, new HashMap<String,Double>(){{put("Gare de Venissieux",1590.0); put("Mermoz Pinel",1240.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Gare de Venissieux", new Estacion("Gare de Venissieux",646963.8,5063029.9, new HashMap<String,Double>(){{put("Parilly",1590.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Fourviere", new Estacion("Fourviere",641640.6,5069261.1, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",445.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Minimes Theatres Romains", new Estacion("Minimes Theatres Romains",641635.5,5068819.4, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",520.0); put("Saint-Just",430.0);}},0,new LinkedList<String>(){{add("D");}}));
        estaciones.put("Saint-Just", new Estacion("Saint-Just",641254.2,5068668.7, new HashMap<String,Double>(){{put("Minimes Theatres Romains",430.0);}},0,new LinkedList<String>(){{add("D");}}));

        
      //MAPDOTS LINEA A
        mapDots.put("Perrache", new Integer[]{153, 317, 6, 6});
        mapDots.put("Ampere Victor Hugo", new Integer[]{164, 291, 6, 6});
        mapDots.put("Bellecour", new Integer[]{182, 265, 6, 6});
        mapDots.put("Cordeliers", new Integer[]{195, 228, 6, 6});
        mapDots.put("Hotel de Ville Louis Pradel", new Integer[]{190, 202, 13, 8});
        mapDots.put("Foch", new Integer[]{235, 194, 6, 6});
        mapDots.put("Massena", new Integer[]{272, 189, 6, 6});
        mapDots.put("Charpennes Charles Hernu", new Integer[]{302, 186, 7, 9});
        mapDots.put("Republique Villeurbanne", new Integer[]{357, 183, 6, 6});
        mapDots.put("Gratte-Ciel", new Integer[]{385, 191, 6, 6});
        mapDots.put("Flachet", new Integer[]{425, 202, 6, 6});
        mapDots.put("Cusset", new Integer[]{465, 213, 6, 6});
        mapDots.put("Laurent Bonnevay Astroballe", new Integer[]{505, 223, 6, 6});
        mapDots.put("Vaulx-en-Velin La Soie", new Integer[]{569, 237, 6, 6});

        //MAPDOTS LINEA B
        mapDots.put("Oullins Gare", new Integer[]{104, 523, 6, 6});
        mapDots.put("Stade de Gerland", new Integer[]{172, 460, 6, 6});
        mapDots.put("Debourg", new Integer[]{185, 429, 6, 6});
        mapDots.put("Place Jean Jaures", new Integer[]{206, 378, 6, 6});
        mapDots.put("Jean Mace", new Integer[]{221, 339, 6, 6});
        mapDots.put("Saxe Gambetta", new Integer[]{242, 286, 8, 9});
        mapDots.put("Place Guichard Bourse du Travail", new Integer[]{247, 255, 6, 6});
        mapDots.put("Gare Part-Dieu Vivier Merle", new Integer[]{286, 236, 6, 6});
        mapDots.put("Brotteaux", new Integer[]{296, 208, 6, 6});
     
        //MAPDOTS LINEA C
        mapDots.put("Cuire", new Integer[]{181, 82, 6, 6});
        mapDots.put("Henon", new Integer[]{157, 135, 6, 6});
        mapDots.put("Croix-Rousse", new Integer[]{176, 158, 6, 6});
        mapDots.put("Croix-Paquet", new Integer[]{192, 178, 6, 6});
        
        //MAPDOTS LINEA D
        mapDots.put("Gare de Vaise", new Integer[]{58, 120, 6, 6});
        mapDots.put("Valmy", new Integer[]{62, 155, 6, 6});
        mapDots.put("Gorge de Loup", new Integer[]{63, 207, 6, 6});
        mapDots.put("Vieux Lyon Cathedrale St. Jean", new Integer[]{150, 244, 7, 10});
        mapDots.put("Guillotiere", new Integer[]{225, 278, 6, 6});
        mapDots.put("Garibaldi",  new Integer[]{278, 305, 6, 6});
        mapDots.put("Sans-Souci", new Integer[]{320, 326, 6, 6});
        mapDots.put("Monplaisir-Lumiere", new Integer[]{347, 340, 6, 6});
        mapDots.put("Grange Blanche", new Integer[]{383, 357, 6, 6});
        mapDots.put("Laennec", new Integer[]{406, 376, 6, 6});
        mapDots.put("Mermoz Pinel", new Integer[]{415, 440, 6, 6});
        mapDots.put("Parilly", new Integer[]{417, 490, 6, 6});
        mapDots.put("Gare de Venissieux", new Integer[]{419, 581, 6, 6});
        mapDots.put("Fourviere", new Integer[]{136, 227, 4, 4});
        mapDots.put("Minimes Theatres Romains", new Integer[]{134, 256, 4, 4});
        mapDots.put("Saint-Just", new Integer[]{116, 262, 4, 4});
        
        //Lanzamos la interfaz gráfica
        new AppLauncher();
    }
}