package org.hbrs.se.ws20.prototype.uebung4.view;

import org.hbrs.se.ws20.prototype.uebung4.model.UserStory;

public class OutputDialog {

       public void dump(){
       /*         // Hier möchte Herr P. die Liste mit einem eigenen Sortieralgorithmus sortieren und dann
                // ausgeben. Allerdings weiss der Student hier nicht weiter

                // [Sortierung ausgelassen]
                java.util.Collections.sort( this.liste );

                // Klassische Ausgabe ueber eine For-Each-Schleife
                for (UserStory us : liste) {
                        System.out.println(us.toString());
                }

                // [Variante mit forEach-Methode / Streams (--> Kapitel 9)? Gerne auch mit Beachtung der neuen US1
                // (Filterung Aufwand > x)
                liste.stream().filter( userStory -> userStory.getAufwand() > 4  )   // Filter
                        .filter( userStory -> userStory.getPrio() < 2.0 )
                        .sorted(  (us1, us2)  -> Double.compare( us1.getPrio() , us2.getPrio() ) ) // MAP
                        .forEach( userStory -> System.out.println( userStory.toString() ) ); // Reduce */
        }
}
