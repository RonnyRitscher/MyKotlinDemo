package de.ronnyritscher.mykotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_output.*

class OutputActivity : AppCompatActivity() {

    //ZUM RÜCKGÄNGIG MACHEN
    var tmpText =
        ""    //!IMMER EINE INITALISIERUNG NOTWENDIG...  :String ist nicht nötig, da wir ihm bereits ein String initialisieren

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)


        //HIER WIRD DER ÜBERGEBENE CONTENT AUS DER MAIN-ACTIVITY ANGEZEIGT

        //BESCHAFFEN DES INHALTES AUS DEM INITENT DER MAIN
        val value = intent.getStringExtra("value")

        // über das $ können Elemente direkt in den Text eingefügt werden
        tv_outputActivity.text = "Sie Ausgabe von Seite 1 ist:\n $value, fertig ist der Text"
    }

    //CLEAR-METHODE des BUTTONS
    fun clear(view: View) {

        tmpText = tv_outputActivity.text.toString()  //speichert den Inhalt
        tv_outputActivity.text = ""  //löscht den Inhalt des outputs

        //SNACKBAR   -> Layout Id mitgeben   (Layout, Text, Anzeigelänge)
        val msb = Snackbar.make(constraintLayout, "Löschen Rückgängig machen", Snackbar.LENGTH_LONG)
        msb.setAction("Undo", MyUndoListener())            //Action definieren wenn gedrückt wird
        msb.show()  //Anzeigen der Snackbar
    }


    //INNERE KLASSE ONCLICKLISTENER
    // -> Muss als "inner" definiert sein, damit die Member/Elemente erreichbar/verwendbar sind
    // -> erreichbarkeit bei "class" und "inner class"
    // -> class -> ihm fehlt jedoch die Berechtigung auf äußere Klassen/Member zuzugreifen
    // -> inner class kann auch die Elemente von inneren und äußeren Klassen zuzugreifen
    inner class MyUndoListener : View.OnClickListener {
        override fun onClick(view: View?) {
          tv_outputActivity.text = tmpText
            Toast.makeText(this@OutputActivity , "Löschen wurde rückgängig gemacht" , Toast.LENGTH_LONG).show()
        }
    }

    fun next(view: View?){
        startActivity(Intent(this , ShowListeActivity::class.java))  //Intent
    }
}
