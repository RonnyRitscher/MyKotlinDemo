package de.proneucon.mykotlindemo

/**
 * eine Kallse selbst angelegt...
 * ... erweitern von : AppCompatActivity()
 * ... bekanntgeben der NullSafety in der ManifestDatei
 * ... einfügen von onCreate()
 * ... setzen von setContentView(R.layout.activity_nullsavety)
 *
 * verwenden des ?
 */

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nullsavety.*
import kotlinx.android.synthetic.main.activity_nullsavety.view.*
import java.lang.IllegalArgumentException

class NullSafety : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nullsavety)

        //*******************************************************************
        //NULL ZUWEISEN ("?")
        var a:String = "abc"
        //a = null  //hier meckert der Compiler -> keine zuweisung möglich in KT -> keine NullpointerException

        var b:String? = "abc"
        b = null //mit dem "?" kann die  Variable null übergeben werden

        //ABFRAGE AUF NULL
        val lenghtA = a.length // ist möglich
        //val lenghtB = b.length // !* nicht möglich -> Compiler meckert...löst Laufzeitfehler aus

        //(*1)ABSICHERN wenn NULL
        //var lenghtB = if(b!=null) b.length else -1  //Abfrage ob Objekt null ist, dann ...lenghtB=b.length, ansonsten ...lenghtB=-1

        //ANDERE METHODEN UM NULL COMPILIERT ZU BEKOMMEN:
        var lenghtB :Int?= if(b!=null) b.length else -1  // sagt ihm der Int kann auch null sein ...VORSICHT!
        //lenghtB = b!!.length      // "!!" ist eine ASSERT/BEHAUPTUNG, dass b niemals null ist... VORSICHT!!!

        //NUR BEI SICHEREN/SICHER GESTELLTEN AUFRUFEN das lenghtB null sein darf
        lenghtB = b?.length   // nur wenn vorher sicher gestellt ist das b auch null sein kann
        lenghtB?.compareTo(2)   //reicht nur das Problem weiter, aber man kann mit nullObjekten umgehen...


        //********************************************************
        //ABSICHHERUNG FÜR NULLPOINTER_EXCEPTION:
        //Wir bauen uns eine Liste mit NullObjekten
        //val listWithNulls :List<String> = listOf("Hallo" , null , "WELT!")  //Geht nicht ohne weiteres, wenn <String> -> <String?>
        val listWithNulls :List<String?> = listOf("Hallo" , null , "WELT!")
        //prüfen/ABSICHERN und null vermeiden:
        val stringList :List<String> = listWithNulls.filterNotNull()


        for(item in listWithNulls){
            item?.let{ //führe die Zeile nur aus, wenn... auch wirklich ein Wert drin steht -> item?.let{} filtert sozusagen "null" heraus
                //tv_output_nullsavety.append("$item länge: ${item.length}")   //Problem: laufzeit kann zur Laufzeit abstürzen, da item null sein kann -> verwende item.let{}
                tv_output_nullsavety.append("$item länge: ${it?.length} \n")       //verwenden von " $it? "
            }
        }
        tv_output_nullsavety.append("\n")
        for(itm in stringList){
            tv_output_nullsavety.append("$itm mit länge ${itm.length}")
        }
        tv_output_nullsavety.append("\n")

        //*******************************************************************
        //EIGENE METHODE und ABFANGEN VON NULL
        //var b0 = foo(Node(null , "Ronny"))   // parent ist null  -> gibt null zurück
        //var b1 = foo(Node("A" , null))       // name ist null  -> gibt eine IllegalArgumentException
        var b2 = foo(Node("A" , "Ronny"))    // beides nicht null  -> Ausgabe: Ronny

        //val c0 : Int = b0?.length ?:-1  // ELVIS-OPERATOR(?:-1) -> b soll nur zurückgegeben werden wenn nicht null, ansonsten -1
        //val c1 : Int = b1?.length ?:-1
        val c2 : Int = b2?.length ?:-1

        //tv_output_nullsavety.append("\n\n $b0")
        //tv_output_nullsavety.append("\n\n $b1")
        tv_output_nullsavety.append("\n\nName: $b2")

        //*******************************************************************





        //BUTTON-WEITERLEITUNG
        btn_nullsavety.setOnClickListener {
            //startActivity(Intent(this@NullSafety , Nächste Activity eintragen))
        }

    }

    //EIGENE METHODEN/FUNKTIONEN**************************************************************************
    fun foo(node: Node):String?{   //foo(string:String):String soll einen String zurück geben
        val parent = node.parent ?: return null   // ?: return null -> wenn das null ist, dann soll er null zurück liefern
        val name = node.name ?: throw IllegalArgumentException() //?: throw IllegalArgumentException()  -> wenn null, dann wirf eine IAE()
        return name
    }


}

//EIGENE KLASSE **************************************************************************
class Node(
    val parent:String?,//darf null sein
    val name:String?   //darf null sein
    )