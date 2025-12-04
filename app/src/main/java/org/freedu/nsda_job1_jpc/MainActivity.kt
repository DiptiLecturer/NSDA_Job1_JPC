package org.freedu.nsda_job1_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import org.freedu.nsda_job1_jpc.ui.theme.NSDA_Job1_JPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NSDA_Job1_JPCTheme {
                val navController = rememberNavController()
                val viewModel: ProductViewModel = viewModel() // single instance

                NavHost(
                    navController = navController,
                    startDestination = Screen.ProductList.route
                ) {
                    composable(Screen.ProductList.route) {
                        ProductListScreen(navController, viewModel)
                    }

                    composable(
                        route = Screen.ProductDetail.route,
                        arguments = listOf(navArgument("productJson") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val json = backStackEntry.arguments?.getString("productJson")
                        val product = Gson().fromJson(json, Product::class.java)
                        ProductDetailScreen(product = product, navController = navController)
                    }

                }
            }
        }
    }
}


