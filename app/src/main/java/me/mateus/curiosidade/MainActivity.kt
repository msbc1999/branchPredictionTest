package me.mateus.curiosidade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.activityMain_btnTestar).setOnClickListener {
            testar()
        }
    }
}

fun testar() {
    val rand = Random()
    val tamanho = 25_000
    val data = IntArray(tamanho) {
        (rand.nextDouble() * 100).toInt()
    }

    unsorted(data, 25_000)

    sorted(data, 25_000)

}


fun unsorted(array: IntArray, quant: Int) {
    Log.i("MainActivity", "Iniciando medição (unsorted)...")
    val inicio = System.nanoTime()

    processarArray(array, quant)

    val duracao = (System.nanoTime() - inicio) / 1_000_000_000.0;
    Log.i("MainActivity", "Tempo necessário: $duracao")
}

fun sorted(array: IntArray, quant: Int) {
    Log.i("MainActivity", "Iniciando medição (sorted)...")
    val inicio = System.nanoTime()

    array.sort()

    processarArray(array, quant)

    val duracao = (System.nanoTime() - inicio) / 1_000_000_000.0;
    Log.i("MainActivity", "Tempo necessário: $duracao")
}

fun processarArray(array: IntArray, quant: Int) {
    var contador = 0L
    (1..quant).forEach {
        for (i in 0 until array.size) {
            if (array[i] >= 50) {
                contador += array[i]
            }
        }
    }
}