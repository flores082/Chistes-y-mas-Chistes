package com.example.flores_Alvarado_Sepulveda.chistesymaschistes.apiClass

class ApiKeyManager {
    companion object {
        private val apiKeys = listOf("c8c056772f514c588bd3d690d7352d54",
            "0483ff33f77a4c77a7dbb9d1c407ca32",
            "e5978b4ec9864dc4a11cf79e47696e63")
        private var currentIndex = 0

        fun getApiKeys(): List<String> {
            return apiKeys
        }

        fun getCurrentApiKey(): String {
            return apiKeys[currentIndex]
        }

        fun getNextApiKey(): String {
            val apiKey = apiKeys[currentIndex]
            currentIndex = (currentIndex + 1) % apiKeys.size // Rotate to the next key
            return apiKey
        }
    }
}
