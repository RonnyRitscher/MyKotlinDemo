package de.ronnyritscher.mykotlindemo

/**
 *  PROGRAMIERSPRACHE KOTLIN
 *
 *  kleine Einblicke in die Programmiersprache Kotlin
 *  -> weniger Code als in Java
 *  -> kann auf alle Funktionalitäten aus Java zugreifen (bis auf einige Außnahmen...)
 *  -> baut auf Java6 auf, nicht alle Funktionen aus Java8 verwendbar
 *
 *  UNERSCHIEDE von KOTLIN zu JAVA
 *  keine Methoden
 *  kein ; zum Abschluss einer CodeZeile
 *  kein defaultSichtbarkeit -> immer publicSichtbarkeit
 *  kein "null" in Kotlin  -> mit ? fragt K ob Element-Inhalt existent/vorhanden oder nicht existent ist
 *
 *  val -> value ist final
 *  var -> vatiable ist public
 *  fun -> function
 *
 *  -> schnelleres Hinzufügen von Elementen in einer Klasse (kein Anpassen in den Methoden notwendig
 */
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {  //statt "extends" oder "implements" in K nur ein ":"

    //Der Override ist explizit wichtig/vorausgesetzt/verbindlichkeit
    override fun onCreate(savedInstanceState: Bundle?) {            //?
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //einfache deklarierung und implemenierung von Elementen in Kotlin mit Java-Code
        tv.text = "Hallo Kotlin - Zeige mir die Unterschiede"


        //JAVA: PersonJ
        tv.append("\nJAVA:")
        val p = PersonJ("Ronny", "Ritscher", "Musterstrasse", "Berlin", "01234", 80, 34)
        tv.append("\n")
        tv.append("\n" + p.alter)   //


        tv.append("\n-----------------------------")
        //KOTLIN: PersonK
        tv.append("\nKOTLIN:")
        val p2 = PersonK("Ronny","Ritscher","Musterstrasse","Berlin","01234",80,34,true)
        tv.append("\n" + p2.alter)


        tv.append("\ndoit():\n" + JavaActivity().doIt())    //ruft die Methode aus der JavaActivity auf
        //wenn "data class" wird auch die toString richtig angezeigt


        //COPY - einfaches Kopieren von Objekten in Kotlin möglich(p2->p3)
        val p3 = p2.copy()

    }


    //schreiben einer eigenen Methode (muss noch manuell hinzugefügt werden)
    fun senden(view : View){
        //Intent
        //val intent = Intent(this , OutputActivity.class) -> geht nicht in Kotlin!!!
        val intent = Intent(this , OutputActivity::class.java)       //-> (ohne new-operator)
        intent.putExtra("value" , tv.text.toString())                       //-> Hinzufügen eines Extras für den Intent

        //AUFRUF DER SELBST-ERSTELLTEN KLASSE test()
        test()

        startActivity(intent)       //-> startet die Actiyity

        //AUSGEBEN IN DER OUTPUT-ACTIVITY
    }
}

//EIGENE KLASSE IN KT ERSTELLEN
fun test(){
    print("Hallo")
}
