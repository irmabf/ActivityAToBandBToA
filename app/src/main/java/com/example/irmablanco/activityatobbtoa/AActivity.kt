package com.example.irmablanco.activityatobbtoa

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity() {

    val REQUEST_B = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        //La actividad A llama a la actividad B, primer paso en la app
        //Comenzar la actividad esperando un resultado
        button.setOnClickListener {
            startActivityForResult(BActivity.intent(this), REQUEST_B)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Si hay requestCode DEVOLVEMOS LOS DATOS PASADOS POR B
        when (requestCode) {
            //En caso de que sea == a Request_b
            REQUEST_B -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    val number = data.getIntExtra(BActivity.EXTRA_NUMBER, 0)
                    val string = data.getStringExtra(BActivity.EXTRA_STRING)
                    result.text = "He recibido esto de B: ${number}-${string}"
                }else {
                    result.text = "Oops... B no me ha enviado nada"
                }
            }
        }
    }
}
