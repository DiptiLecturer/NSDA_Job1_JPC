package org.freedu.nsda_job1_jpc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun ProductDetailScreen(
    product: Product,
    navController: NavController = rememberNavController() // pass navController from NavHost
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = product.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageUrl = product.image?.takeIf { it.isNotBlank() }
                ?: "https://via.placeholder.com/300"

            AsyncImage(
                model = imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(product.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Price: ৳${product.price}", color = Color.Gray, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(product.description)
        }
    }
}


