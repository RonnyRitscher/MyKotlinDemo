package de.ronnyritscher.mykotlindemo;

/**
 * zeigt das man auch Java in Kotlin verwenden kann
 */
public class JavaActivity {

    // 2 Personden (Java und Kotlin) über eine class.java
    PersonJ personJ = new PersonJ("Ronny", "Ritscher", "Musterstrasse", "Berlin", "01234", 80, 34);
    PersonK personK = new PersonK("Ronny", "Ritscher", "Musterstrasse", "Berlin", "01234", 80, 34, true);

    //Eigene Methode
    public  String doIt(){

        //KOTLIN verwenden der erstellten Daten in Kotlin in Java benutzen (aus einer Java Klasse heraus)
        return personK.toString();
    }


}
