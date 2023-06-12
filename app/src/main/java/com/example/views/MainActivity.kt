package com.example.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//inicio de variables
        var numero1 = 0.0
        var numero2 = 0.0
        var operacion:String = ""

        //Inicio de elementos

        //Pantallas
        val screen1 = findViewById<TextView>(R.id.pantalla1)
        val screen2 = findViewById<TextView>(R.id.pantalla2)

        //Botones numéricos
        val button0 = findViewById<Button>(R.id.boton0)
        val button1 = findViewById<Button>(R.id.boton1)
        val button2 = findViewById<Button>(R.id.boton2)
        val button3 = findViewById<Button>(R.id.boton3)
        val button4 = findViewById<Button>(R.id.boton4)
        val button5 = findViewById<Button>(R.id.boton5)
        val button6 = findViewById<Button>(R.id.boton6)
        val button7 = findViewById<Button>(R.id.boton7)
        val button8 = findViewById<Button>(R.id.boton8)
        val button9 = findViewById<Button>(R.id.boton9)

        //botones operativos
        val buttonDot = findViewById<Button>(R.id.botonPunto)
        val buttonPlus = findViewById<Button>(R.id.botonMas)
        val buttonMinus = findViewById<Button>(R.id.botonMenos)
        val buttonTimes = findViewById<Button>(R.id.botonPor)
        val buttonBetween = findViewById<Button>(R.id.botonEntre)
        val buttonEquals =findViewById<Button>(R.id.equals)
        val switchToLine = findViewById<Switch>(R.id.interruptor)
        val bracketLeft = findViewById<Button>(R.id.parentesisIzq)
        val bracketRight = findViewById<Button>(R.id.parentesisDer)


        //funciones secundarias
        fun agregarDigito(digito:String){
            screen2.text = screen2.text as String + digito
        }

        fun limpiaPantalla(){
            screen2.text = ""
        }



        fun simboloPresionado(entrada1: Double, entrada2:Double, operacion: String): Double {

            limpiaPantalla()
            var resultado = 0.0
            when(operacion){
                "+" -> {
                    resultado = entrada1+entrada2
                }
                "-" -> {
                    resultado = entrada1-entrada2
                }

                "*" -> {
                    resultado = entrada1*entrada2
                }
                "/" -> {
                    resultado = entrada1/entrada2
                }
                "else" ->{
                    Log.d("Operaciones", "Operación no válida")
                    resultado=0.0
                }
            }
            return resultado
        }

        //listener de botones - agregar simbolos
        button0.setOnClickListener{ agregarDigito("0") }
        button1.setOnClickListener{ agregarDigito("1") }
        button2.setOnClickListener{ agregarDigito("2") }
        button3.setOnClickListener{ agregarDigito("3") }
        button4.setOnClickListener{ agregarDigito("4") }
        button5.setOnClickListener{ agregarDigito("5") }
        button6.setOnClickListener{ agregarDigito("6") }
        button7.setOnClickListener{ agregarDigito("7") }
        button8.setOnClickListener{ agregarDigito("8") }
        button9.setOnClickListener{ agregarDigito("9") }
        buttonDot.setOnClickListener { agregarDigito(".") }

        //switch
        switchToLine.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                bracketLeft.visibility = View.VISIBLE
                bracketRight.visibility = View.VISIBLE
            } else{
                bracketLeft.visibility = View.INVISIBLE
                bracketRight.visibility = View.INVISIBLE
            }
        }



        //funciones de botones de operacion
        buttonPlus.setOnClickListener {
            numero2 = screen2.text.toString().toDouble()

            Log.d("Variable guardada",numero2.toString())

            var result = simboloPresionado(numero1,numero2,"+")

            numero1=result
            screen1.text  = numero1.toString()
            limpiaPantalla()

        }

        buttonMinus.setOnClickListener {
            numero2 = screen2.text.toString().toDouble()

            Log.d("Variable guardada",numero2.toString())

            var result = simboloPresionado(numero1,numero2,"-")

            numero1=result
            screen1.text  = numero1.toString()
            limpiaPantalla()

        }
        buttonTimes.setOnClickListener {
            numero2 = screen2.text.toString().toDouble()

            Log.d("Variable guardada",numero2.toString())

            var result = simboloPresionado(numero1,numero2,"*")

            numero1=result
            screen1.text  = numero1.toString()
            limpiaPantalla()

        }
        buttonBetween.setOnClickListener {
            numero2 = screen2.text.toString().toDouble()

            Log.d("Variable guardada",numero2.toString())

            var result = simboloPresionado(numero1,numero2,"/")

            numero1=result
            screen1.text  = numero1.toString()
            limpiaPantalla()

        }

        buttonEquals.setOnClickListener {
            numero2 = screen2.text.toString().toDouble()
            var operacionFinal = operacion
            var result = simboloPresionado(numero1,numero2,operacionFinal)

            numero1=result
            screen1.text  = numero1.toString()
            limpiaPantalla()

        }



    }
}