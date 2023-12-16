package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter.Lista_Adapter
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Adapter.mostrado
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiCallback
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiKeyManager
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiRequestTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

class JokeGeneratorActivity : AppCompatActivity(), ApiCallback {

    private var nombresList = mutableListOf<mostrado>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Lista_Adapter
    private lateinit var mediaPlayer:MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar_chistes)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)

        mediaPlayer = MediaPlayer.create(this, R.raw.precionar_boton)

        recyclerView = findViewById(R.id.lista_creada)
        adapter = Lista_Adapter(nombresList,applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Initial API request
        //requestRandomJoke()

        // Set up the button click listener
        val refreshButton: Button = findViewById(R.id.button)
        refreshButton.setOnClickListener {
            mediaPlayer.start()
            // Trigger API request when the button is clicked
            //lista_agregada("nombre")
            requestRandomJoke()
        }


        // Configurar el botón de retorno (flecha)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            mediaPlayer.start()
            // Acciones al presionar la flecha de retorno
            onBackPressed()
        }
    }

    private fun requestRandomJoke() {
        // Get the list of API keys
        val apiKeys = ApiKeyManager.getApiKeys()

        // Iterate through the keys and try each one until success or no more keys
        for (apiKey in apiKeys) {
            // Construct the URL with the API key
            val apiUrl = "https://api.humorapi.com/jokes/random?api-key=$apiKey&exclude-tags=nsfw,dark"

            // Execute the API request task
            val apiRequestTask = ApiRequestTask(this)
            val result = apiRequestTask.execute(apiUrl).get()

            // Check if the result indicates a quota error
            if (result.startsWith("HTTP Error: 402")) {
                // Handle quota error, log or do any additional logic
                // You may want to switch to the next key or take other actions
                continue
            }

            // Break the loop if the request was successful
            break
        }
        lista_agregada("nombre")
    }

    override fun onApiResult(result: String) {
        // Handle the API response in the UI thread
        if (result.isNotBlank()) {
            Log.d("ApiRequestTask", "Raw API response: $result")  // Log the raw response

            try {
                // Assuming the response is in JSON format, parse it and extract the joke and id
                val jsonResponse = JSONObject(result)
                val id = jsonResponse.optInt("id", -1) // Replace -1 with a default value if "id" is not present
                val joke = jsonResponse.optString("joke", "")

                // Log the id and joke text
                Log.d("ApiRequestTask", "ID: $id, Joke: $joke")

                // Update the UI or perform any other actions with the id and joke
                // val jokeTextView: TextView = findViewById(R.id.lista_creada)
                // jokeTextView.text = joke
                lista_agregada(joke)
            } catch (e: JSONException) {
                e.printStackTrace()
                // Handle the case where JSON parsing failed
            }
        } else {
            // Handle the case where the API request failed
        }
    }

    fun lista_agregada(chiste:String){
        val nombreEntity = mostrado(c = chiste )
        nombresList.add(nombreEntity)
        adapter.notifyItemInserted(nombresList.size - 1)

        GlobalScope.launch(Dispatchers.IO) {
            nombreEntity
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_inicio, menu)
        return true
    }
}