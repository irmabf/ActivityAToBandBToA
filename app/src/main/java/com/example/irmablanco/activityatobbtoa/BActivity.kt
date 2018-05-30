package com.example.irmablanco.activityatobbtoa

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {
    //Creo el companion object que me permitirá referirme a la actividadB dentro del resto de actividades
    companion object {
        //Keys para el diccionario de data que pasaremos al returnIntent
        val EXTRA_NUMBER = "EXTRA NUMBER"
        val EXTRA_STRING = "EXTRA STRING"
        /*fun intent(context: Context): Intent {
            return Intent(context, BActivity::class.java)
        }*/
        //Esto equivale a lo de arriba y es más corto
        fun intent(context: Context) = Intent(context, BActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        /*Llegamos aquí desde la actividad a tras el primer paso de la app en el que
        se pulsa ir a b.
        Veremos un botón ok y un boton cancel.
        Si pulsamos ok se debe pasar informacion a la actividad a y volver a dicha
        actividad donde se podra leer la informacion pasada.
        Si pusamos cancel se debe volver a la actividad a sin pasar nada.
        * */

        cancel_btn.setOnClickListener {
            //Respuesta prefijada para CANCEL btn
            setResult(Activity.RESULT_CANCELED)
            //Volver a la pantalla anterior
            finish()
        }
        ok_btn.setOnClickListener {
            //Creamos un intent de retorno para poder devolver data
            val returnIntent = Intent()
            //Cargamos los datos a devolver en el returnIntent
            returnIntent.putExtra(EXTRA_NUMBER, 42)
            returnIntent.putExtra(EXTRA_STRING, "El universo y todo lo demás")
            //En este result ok tenemos que pasar el returnIntent ademas del Result_ok para poder pasar datos
            setResult(Activity.RESULT_OK, returnIntent)
            //Volvemos a la pantalla anterior
            finish()
            //Ahora ya solo nos queda recibir esos datos en la actividad a
        }
    }
}
