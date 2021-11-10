package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        variables()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun variables() {
        //Validar la edad de una persona
        val David = 21
        val Andres = 17
        val Juan = 30

        if (Andres > 18) {
            println("La persona es mayor de edad")
        } else {
            println("La persona es menor de edad")
        }
        // Tabla de multiplicar

        println("Tabla de multiplicar del 5 ascendente")
        for (x in 0..10) {
            val resultado = (x * 5)
            println("5 x ${x} = ${resultado} ")
        }
        println("Tabla de multiplicar del 5 descendente")
        for (x in 10 downTo 0) {
            val resultado2 = (x * 5)
            println("5 x ${x} = ${resultado2} ")
        }
        // Listado de clases


        var myMap = listOf(
            1 to "David", 2 to "Santiago", 1 to "Erick", 3 to "Juan", 3 to "Pedro",
            2 to "Alexander"
        )
        println("Todos los estudiantes")
        println(myMap)
        println("Todos los estudiantes por grupos")
        var grupos = myMap.groupBy({ it.first }, { it.second })
        println(grupos)

        //Vehículos
        println("Ejercicio de los vehiculos")

        val vehiculo1 = Vehiculos(
            traccion = "Delantera",
            motor = 2000,
            tipo = "Camioneta",
            capacidad = "4 personas"
        )
        println("La tracción del vehículo es ${vehiculo1.traccion} ")
        println("El motor del vehículo es ${vehiculo1.motor} ")
        println("El tipo de vehículo es ${vehiculo1.tipo} ")
        println("La capacidad que tiene el vehículo es de ${vehiculo1.capacidad} ")


        // Taller2
        //Declaracion de la lista a ordenar
        val listado = arrayListOf<Int>()
        //Agregacion de valores
        listado.add(3)
        listado.add(5)
        listado.add(6)
        listado.add(8)
        listado.add(9)
        listado.add(2)
        listado.add(1)

        println("Listado desordenado:\n$listado")

        var tmp = 0
        var cant = listado.size

        for (x in 0 until cant) {
            for (y in 0 until cant) {
                if (listado[x] > listado[y]) {
                    tmp = listado[x]
                    listado[x] = listado[y]
                    listado[y] = tmp
                }
            }
        }
        println("Lista ordenada:\n$listado")


        // Validacion de la cedula
        println("Ejercicio de la validacion de la cédula")
        val validador = arrayListOf<Int>(2, 1, 2, 1, 2, 1, 2, 1, 2)

        val cedula = "1104076797"
        val listaCedula = arrayListOf<Int>()
        for (x in cedula) {
            listaCedula.add(Character.getNumericValue(x))
        }

        println("Cedula ingresada:\n$listaCedula")
        var multplicacion = 0
        var cadena = ""
        var sumalist = arrayListOf<Int>()
        for (y in 0 until validador.size) {
            multplicacion = listaCedula[y] * validador[y]
            // sumalist.add(multplicacion)
            if (multplicacion >= 10) {
                cadena = multplicacion.toString()
                sumalist.add(Character.getNumericValue(cadena[0]) + Character.getNumericValue(cadena[1]))
            } else {
                sumalist.add(multplicacion)
            }
        }
        println("Lista a multiplicar:\n$validador")
        println("Resultado:\n$sumalist")

        //Suma de la lista

        var suma = 0
        for (n in sumalist){
            suma += n

        }
        println("Total de la suma $suma")

        // Validacion de casos para la resta del numero superior

        var total = 0
        if (suma <= 10 && suma > 0){
             total = (suma - 10)*-1
        }
            if(suma <= 20 && suma > 10){
            total = (suma - 20)*-1
        }
            if (suma <= 30 && suma > 20){
            total = (suma - 30)*-1
        }
            if (suma <= 40 && suma > 30){
            total = (suma - 40)*-1
        }
            if (suma <= 50 && suma > 40){
            total = (suma - 50)*-1
        }
        println("Resultado de la resta: $total")

        val ultPosicion = listaCedula[listaCedula.size-1]
        if(ultPosicion == total){
            println("Si es cédula")
        }else{
            println("No es cédula")
        }
}
}







