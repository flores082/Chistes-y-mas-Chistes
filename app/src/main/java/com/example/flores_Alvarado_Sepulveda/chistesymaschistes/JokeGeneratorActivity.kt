package com.example.flores_Alvarado_Sepulveda.chistesymaschistes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiCallback
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiKeyManager
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass.ApiRequestTask
import org.json.JSONException
import org.json.JSONObject

class JokeGeneratorActivity : AppCompatActivity(), ApiCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llamar_chistes)

        // Initial API request
        requestRandomJoke()

        // Set up the button click listener
        val refreshButton: Button = findViewById(R.id.button)
        refreshButton.setOnClickListener {
            // Trigger API request when the button is clicked
            requestRandomJoke()
        }
    }

    private fun requestRandomJoke() {
        // Get the list of API keys
        val apiKeys = ApiKeyManager.getApiKeys()

        // Iterate through the keys and try each one until success or no more keys
        for (apiKey in apiKeys) {
            // Construct the URL with the API key
            val apiUrl = "https://api.humorapi.com/jokes/random?api-key=$apiKey"

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
    }

    override fun onApiResult(result: String) {
        // Handle the API response in the UI thread
        if (result.isNotBlank()) {
            Log.d("ApiRequestTask; Raw API response: %s", result)  // Add this line for logging
            try {
                // Assuming the response is in JSON format, parse it and extract the joke
                val jsonResponse = JSONObject(result)
                val joke = jsonResponse.getString("joke")

                // Update the UI with the new joke
                val jokeTextView: TextView = findViewById(R.id.jokeTextView)
                jokeTextView.text = joke
            } catch (e: JSONException) {
                e.printStackTrace()
                // Handle the case where JSON parsing failed
            }
        } else {
            // Handle the case where the API request failed
        }
    }
}