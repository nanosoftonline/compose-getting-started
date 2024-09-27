package za.co.nanosoft.android.homescreen.data

import Property
import kotlinx.coroutines.delay

class PropertyRepository {
    suspend fun fetchProperties(): List<Property> {
        delay(1000) // Simulate network delay
        return listOf(
//            Property(
//                imageUrl = "https://sample-videos.com/img/Sample-png-image-100kb.png",
//                name = "Luxury Beach House",
//                price = "$350/night",
//                rating = 4.8f,
//                description = "Enjoy the beautiful sea view and luxury amenities.",
//                amenities = listOf("Wifi", "Pool", "Parking")
//            ),
//            Property(
//                imageUrl = "https://sample-videos.com/img/Sample-png-image-500kb.png" ,
//                name = "Cozy Mountain Cabin",
//                price = "$180/night",
//                rating = 4.7f,
//                description = "A peaceful retreat in the mountains.",
//                amenities = listOf("Wifi", "Fireplace", "Mountain View")
//            ),
//            Property(
//                imageUrl = "https://sample-videos.com/img/Sample-png-image-500kb.png" ,
//                name = "Cozy Mountain Cabin",
//                price = "$180/night",
//                rating = 4.7f,
//                description = "A peaceful retreat in the mountains.",
//                amenities = listOf("Wifi", "Fireplace", "Mountain View")
//            ),
//            Property(
//                imageUrl = "https://sample-videos.com/img/Sample-png-image-500kb.png" ,
//                name = "Cozy Mountain Cabin",
//                price = "$180/night",
//                rating = 4.7f,
//                description = "A peaceful retreat in the mountains.",
//                amenities = listOf("Wifi", "Fireplace", "Mountain View")
//            )
        )
    }
}