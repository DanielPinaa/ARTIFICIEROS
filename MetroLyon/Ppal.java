import java.util.HashMap;
import java.util.Map;

public class Ppal {
    public static void main(String[] args) {
        Map<String,Estacion>estaciones = new HashMap<String,Estacion>();

        //ESTACIONES LINEA A
        estaciones.put("Perrache", new Estacion( 642012.8, 5067725.7, new HashMap<String,Double>(){{put("Ampere Victor Hugo", 555.0);}}));
        estaciones.put("Ampere Victor Hugo", new Estacion( 642263, 5068219.3, new HashMap<String,Double>(){{put("Perrache",  555.0); put("Bellecour", 740.0);}}));
        estaciones.put("Bellecour", new Estacion( 642604.7, 5068776.8, new HashMap<String,Double>(){{put("Ampere Victor Hugo", 740.0);put("Cordeliers", 697.0);put("Vieux Lyon Cathedrale St. Jean", 660.0);put("Guillotiere", 720.0);}}));
        estaciones.put("Cordeliers", new Estacion( 642750.8, 5069382.2, new HashMap<String,Double>(){{put("Bellecour", 697.0);put("Hotel de Ville Louis Pradel", 479.0);}}));
        estaciones.put("Hotel de Ville Louis Pradel", new Estacion( 642783.4, 5069843, new HashMap<String,Double>(){{put("Foch", 754.0);put("Cordeliers", 479.0);put("Croix-Paquet", 434.0);}}));
        estaciones.put("Foch", new Estacion( 643395.7, 5069999.2, new HashMap<String,Double>(){{put("Hotel de Ville Louis Pradel", 754.0);put("Massena", 713.0);}}));
        estaciones.put("Massena", new Estacion( 644082.9, 5070092.3, new HashMap<String,Double>(){{put("Charpennes Charles Hernu", 913.0);put("Foch", 713.0);}}));
        estaciones.put("Charpennes Charles Hernu", new Estacion( 644850.9, 5070242.9, new HashMap<String,Double>(){{put("Massena", 913.0);put("Republique Villeurbanne", 777.0);put("Brotteaux", 455.0);}}));
        estaciones.put("Republique Villeurbanne", new Estacion( 645680, 5070268.5, new HashMap<String,Double>(){{put("Gratte-Ciel", 747.0);put("Charpennes Charles Hernu", 777.0);}}));
        estaciones.put("Gratte-Ciel", new Estacion( 646370.9, 5070111.8, new HashMap<String,Double>(){{put("Republique Villeurbanne", 747.0);put("Flachet", 644.0);}}));
        estaciones.put("Flachet", new Estacion( 646953.4, 5069971.1, new HashMap<String,Double>(){{put("Cusset", 869.0);put("Gratte-Ciel", 644.0);}}));
        estaciones.put("Cusset", new Estacion( 647762.2, 5069764.9, new HashMap<String,Double>(){{put("Flachet", 869.0);put("Laurent Bonnevay Astroballe", 767.0);}}));      
        estaciones.put("Laurent Bonnevay Astroballe", new Estacion( 648436.2, 5069688.3, new HashMap<String,Double>(){{put("Vaulx-en-Velin La Soie", 1170.0);put("Cusset", 767.0);}})); 
        estaciones.put("Vaulx-en-Velin La Soie", new Estacion( 649478.6, 5069296.4, new HashMap<String,Double>(){{put("Laurent Bonnevay Astroballe", 1170.0);}}));      

        //ESTACIONES LINEA B
        estaciones.put("Oullins Gare", new Estacion( 641232.8, 5064181.8, new HashMap<String,Double>(){{put("Stade de Gerland", 1830.0);}}));
        estaciones.put("Stade de Gerland", new Estacion( 642458.4, 5065349.1, new HashMap<String,Double>(){{put("Oullins Gare",  1830.0); put("Debourg", 530.0);}}));
        estaciones.put("Debourg", new Estacion( 642731.0, 5065818.5, new HashMap<String,Double>(){{put("Stade de Gerland",  530.0); put("Place Jean Jaures", 790.0);}}));
        estaciones.put("Place Jean Jaures", new Estacion( 642951.3, 5066580.1, new HashMap<String,Double>(){{put("Debourg",  790.0); put("Jean Mace", 950.0);}}));
        estaciones.put("Jean Mace", new Estacion( 643313.8, 5067459.1, new HashMap<String,Double>(){{put("Place Jean Jaures",  950.0); put("Saxe Gambetta", 960.0);}}));
        estaciones.put("Saxe Gambetta", new Estacion( 643649.8, 5068356.2, new HashMap<String,Double>(){{put("Jean Mace",  960.0); put("Place Guichard Bourse du Travail", 615.0); put("Guillotiere",405.0); put("Garibaldi",598.0);}}));
        estaciones.put("Place Guichard Bourse du Travail", new Estacion( 643689.5, 5068974.6, new HashMap<String,Double>(){{put("Saxe Gambetta",  615.0); put("Gare Part-Dieu Vivier Merle", 945.0);}}));
        estaciones.put("Gare Part-Dieu Vivier Merle", new Estacion( 644472.7, 5069221.3, new HashMap<String,Double>(){{put("Place Guichard Bourse du Travail",  945.0); put("Brotteaux", 605.0);}}));
        estaciones.put("Brotteaux", new Estacion( 644562.9, 5069803.9, new HashMap<String,Double>(){{put("Gare Part-Dieu Vivier Merle",  605.0); put("Charpennes Charles Hernu", 455.0);}}));
        
        //ESTACIONES LINEA C
        estaciones.put("Cuire", new Estacion( 642507.3, 5071893.2, new HashMap<String,Double>(){{put("Henon", 895.0);}}));
        estaciones.put("Henon", new Estacion( 642060.2, 5071135.7, new HashMap<String,Double>(){{put("Cuire", 895.0); put("Croix-Rousse", 630.0);}}));
        estaciones.put("Croix-Rousse", new Estacion( 642424.6, 5070603.7, new HashMap<String,Double>(){{put("Croix-Paquet", 645.0); put("Henon", 630.0);}}));
        estaciones.put("Croix-Paquet", new Estacion( 642770.0, 5070238.0, new HashMap<String,Double>(){{put("Croix-Rousse", 645.0); put("Hotel de Ville Louis Pradel", 434.0);}}));
        
        //ESTACIONES LINEA D
        estaciones.put("Gare de Vaise", new Estacion(640320.9,5071235.1, new HashMap<String,Double>(){{put("Valmy",702.0);}}));
        estaciones.put("Valmy", new Estacion(640378.7,5070588.0, new HashMap<String,Double>(){{put("Gare de Vaise",702.0); put("Gorge de Loup",950.0);}}));
        estaciones.put("Gorge de Loup", new Estacion(640361.3,5069636.6, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",1740.0); put("Valmy",950.0);}}));
        estaciones.put("Vieux Lyon Cathedrale St. Jean", new Estacion(641983.7,5069000.3, new HashMap<String,Double>(){{put("Gorge de Loup",1740.0); put("Bellecour",660.0); put("Fourviere",445.0); put("Minimes Theatres Romains",520.0);}}));
        estaciones.put("Gillotiere", new Estacion(643278.5,5068520.5, new HashMap<String,Double>(){{put("Bellecour",720.0); put("Saxe Gambetta",405.0);}}));
        estaciones.put("Garibaldi", new Estacion(644202.1,5068118.8, new HashMap<String,Double>(){{put("Saxe Gambetta",598.0); put("Sans-Souci",900.0);}}));
        estaciones.put("Sans-Souci", new Estacion(645017.4,5067736.4, new HashMap<String,Double>(){{put("Monplaisir-Lumiere",600.0); put("Garibaldi",900.0);}}));
        estaciones.put("Monplaisir-Lumiere", new Estacion(645561.7,5067477.4, new HashMap<String,Double>(){{put("Sans-Souci",600.0); put("Grange Blanche",650.0);}}));
        estaciones.put("Grange Blanche", new Estacion(646156.2,5067204.1, new HashMap<String,Double>(){{put("Laennec",1200.0); put("Monplaisir-Lumiere",650.0);}}));
        estaciones.put("Laennec", new Estacion(646756.1,5066702.6, new HashMap<String,Double>(){{put("Mermoz Pinel",540.0); put("Grange Blanche",1200.0);}}));
        estaciones.put("Mermoz Pinel",new Estacion(646849.2,5065871.1, new HashMap<String,Double>(){{put("Parilly",1240.0); put("Laennec",540.0);}}));
        estaciones.put("Parilly", new Estacion(646893.9,5064618.5, new HashMap<String,Double>(){{put("Gare de Venissieux",1590.0); put("Mermoz Pinel",1240.0);}}));
        estaciones.put("Gare de Venissieux", new Estacion(646963.8,5063029.9, new HashMap<String,Double>(){{put("Parilly",1590.0);}}));
        estaciones.put("Fourviere", new Estacion(641640.6,5069261.1, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",445.0);}}));
        estaciones.put("Minimes Theatres Romains", new Estacion(641635.5,5068819.4, new HashMap<String,Double>(){{put("Vieux Lyon Cathedrale St. Jean",520.0); put("Saint-Just",430.0);}}));
        estaciones.put("Saint-Just", new Estacion(641254.2,5068668.7, new HashMap<String,Double>(){{put("Minimes Theatres Romains",430.0);}}));
        
        
    }
}