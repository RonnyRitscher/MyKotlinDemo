package de.proneucon.mykotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_lists.*


class ShowListeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lists)

        //************************************************************
        //ARRAY anlegen
        val numbers = intArrayOf(1,2,3,4,5,6,7,8,9,10)   //numbers:Array wird nicht benötigt, da er bereits weis welches Format (intArray) numbers besitzt
        val numbers2 = arrayOf<Int>(1,2,3,4,5)  //definiert direkt ein IntArray   -> String hier nicht möglich
        val numbers3 = IntArray(10){i -> -1}   //Initialisiert ein IntArray mit der größe 10 *+* jeder Inhalt wird mit -1 belegt  (kein Default mit 0, denn 0 kann ein gültiger wert sein)
        val numbers4 = IntArray(5 , {i -> i*10} )

        val strings = arrayOf<String>("Hallo,", " ich", " bin", " ein", " StringArray", ".")  // definiert ein StringArray
        val values = arrayOf(1 , "Hallo") //definiert ein ObjektArray (Alle Typen möglich)

        val twoDimArray = Array(10 ,{i-> IntArray(10 , {it-> it+1})})      //Mehrdimensionales Arrays
        val twoDimArray2 = Array(10 ,{i-> IntArray(10 , {it+1})})      //Mehrdimensionales Array


        //************************************************************
        //Daten Auslesen von Arrays:
        numbers.get(0)   //beschafft den Wert index
        numbers[0]

        //************************************************************
        //Daten setzen in Arrays
        numbers.set(5, 100) //Setz den wert des Elements pos 5 auf 100
        numbers.size   // gibt die Größe des Arrays an

        //************************************************************
        //ITTRIEREN UND AUSGABE DER ARRAYs
        for (array in twoDimArray){   //Durchlaufen des äüßeren Arrays
            for(i in array){
                tv_output_showList.append(i.toString() + "\t" )
            }
            tv_output_showList.append("\n")
        }
        tv_output_showList.append("\n")

        //************************************************************
        //ITTRIEREN UND AUSGABE DER ARRAYs mit dem Index:
        for (array in twoDimArray){   //Durchlaufen des äüßeren Arrays
            for((index, it)  in array.withIndex()){          //Index ist das erste in der Reihenfolge - in sollte nicht verwendet werden
                tv_output_showList.append("$index: $it ")
            }
            tv_output_showList.append("\n")
        }
        tv_output_showList.append("\n")

        //************************************************************
        //MAX-VALUE ERMITTELN:
        val zahl1 = 123
        val zahl2 = 234                             // wir wollen die maximal Zahl ermitteln über if()

        val max = if(zahl1 > zahl2){                // if bedingung liefert automatisch die Werte zurück (statt nur true)
            zahl1
        }else{
            zahl2
        }
        //Kann auch verkürzt werden als Einzeiler
        val max2 = if(zahl1 > zahl2) zahl1 else zahl2   //Vereinfachte Schreibweise
        val max3 = maxValue( zahl1,  zahl2)             //Aufruf über eine externe Methode/Funktion (maxValue)
        tv_output_showList.append("MAX-VALUE von $zahl1 und $zahl2: " +max.toString())

    }

    //Eigene Funktion/Methode:
    //MAX-VALUE ERMITTELN:
    fun maxValue(zahl1:Int , zahl2:Int)= if(zahl1 > zahl2) zahl1 else zahl2

    //VariantenMöglichkeit ähnlich wie Java:
    fun maxValueJ(zahl1:Int , zahl2:Int):Int{   // das ":Int" kann ersetzt werden durch "="
       return if(zahl1 > zahl2){                // if bedingung liefert automatisch die Werte zurück (statt nur true)
            zahl1                               // "return" kann weggelassen werden, wenn er vor dem if() platziert wird
        }else{
            zahl2
        }
    }
}
