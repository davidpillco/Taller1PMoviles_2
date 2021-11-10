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

    private fun variables (){
        //Validar la edad de una persona
        val David = 21
        val Andres = 17
        val Juan = 30

        if (Andres > 18){
            println("La persona es mayor de edad")
        }else{
            println("La persona es menor de edad")
        }
        // Tabla de multiplicar

        println("Tabla de multiplicar del 5 ascendente")
        for (x in 0..10){
            val resultado = (x*5)
            println("5 x ${x} = ${resultado} ")
        }
        println("Tabla de multiplicar del 5 descendente")
        for (x in 10 downTo 0){
            val resultado2 = (x*5)
            println("5 x ${x} = ${resultado2} ")
        }
        // Listado de clases


        var myMap= listOf(1 to "David", 2 to "Santiago",1 to "Erick",3 to "Juan",3 to "Pedro",
                            2 to "Alexander")
        println("Todos los estudiantes")
        println(myMap)
        println("Todos los estudiantes por grupos")
        var grupos = myMap.groupBy({it.first}, {it.second})
        println(grupos)

        //Vehículos
        println("FSDFSD")

        val vehiculo1 = Vehiculos(traccion= "Delantera", motor = 2000, tipo = "Camioneta", capacidad = "4 personas")
        println("La tracción del vehículo es ${vehiculo1.traccion} ")
        println("El motor del vehículo es ${vehiculo1.motor} ")
        println("El tipo de vehículo es ${vehiculo1.tipo} ")
        println("La capacidad que tiene el vehículo es de ${vehiculo1.capacidad} ")

    }
}


