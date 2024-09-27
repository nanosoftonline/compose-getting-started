package za.co.nanosoft.android.homescreen.data

import Property
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import retrofit2.http.GET

interface PropertyApiService {
    @GET("properties")  // Adjust this path based on your actual API
    suspend fun getProperties(): List<Property>
}

class Property_API_Repository {

    // Base URL for your API (replace with the actual one)
    private val BASE_URL = "https://2a2647d6-468b-463f-b3cc-a7437ca717b7.mock.pstmn.io/airbnb/"

    // Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Service to interact with the API
    private val propertyApiService = retrofit.create(PropertyApiService::class.java)

    // Function to fetch properties from API
    suspend fun fetchProperties(): List<Property> {
        return propertyApiService.getProperties() // Actual API call
    }
}