package org.freedu.nsda_job1_jpc

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ProductItem(product: Product, onClick: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(product) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {

            val imageUrl = product.image?.takeIf { it.isNotBlank() }
                ?: "https://via.placeholder.com/150"

            AsyncImage(
                model = imageUrl,
                contentDescription = product.title,
                modifier = Modifier.size(90.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background)
            )


            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = product.title, fontWeight = FontWeight.Bold)
                Text(text = "৳${product.price}", color = Color.Gray)
            }
        }
    }
}



