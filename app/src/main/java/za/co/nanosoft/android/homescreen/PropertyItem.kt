package za.co.nanosoft.android.homescreen

import Property
import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PropertyItem(property: Property) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Load image using Coil
            val painter = rememberAsyncImagePainter(property.imageUrl)
            Image(
                painter = painter,
                contentDescription = property.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp), // Set a fixed height for the image
                contentScale = ContentScale.Crop // Crop the image to fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = property.name, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${NumberFormat.getCurrencyInstance(Locale.US).format(property.price)}")
                Row {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                    Text(text =property.rating.toString(), modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
        }
    }
}