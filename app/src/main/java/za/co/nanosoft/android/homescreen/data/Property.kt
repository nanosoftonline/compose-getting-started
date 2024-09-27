import com.google.gson.annotations.SerializedName

data class Property(
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("property_name") val name: String,
    @SerializedName("cost_per_night") val price: Float,
    @SerializedName("property_rating") val rating: Float,
    @SerializedName("details") val description: String,
    @SerializedName("amenities") val amenities: List<String>
)
