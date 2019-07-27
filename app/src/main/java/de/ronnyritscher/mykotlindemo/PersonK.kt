package de.ronnyritscher.mykotlindemo
/**
 * Beispiel unterschied der Klassen PersonJ.java und PersonK.kt
 * Angelegte PERSON in KOTLIN
 *
 * val value ist wie eine final Variable in java
 * var variable ist eine veränderbare Variable
 *
 * Der Konstruktor kommt in die Signatur/Parameter der Klasse selbst
 *
 * primitive int gibt es nicht, nur Int
 *
 * implementieren von EQUALS und HASHCODE -> ändern von  "class" zu "data class"
 * data class brauch/beinhaltet equals, hashcode toString und CopyOperator
 */


data class PersonK (var vName:String,
               var nName:String,
               var stasse:String,
               var ort:String,
               var plz:String,
               var hnr:Int,
               var alter:Int,
               var istMitarbeiter:Boolean //in Kotlin: hinzufügen neuer Elemente nur in einer Zeile ändern/anpassen (keine primitiven Datentypen)
               )