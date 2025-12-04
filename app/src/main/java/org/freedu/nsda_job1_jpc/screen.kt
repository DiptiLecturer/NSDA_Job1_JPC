package org.freedu.nsda_job1_jpc

sealed class Screen(val route: String) {
    object ProductList : Screen("product_list")
    object ProductDetail : Screen("product_detail/{productJson}") {
        fun createRoute(productJson: String) = "product_detail/$productJson"
    }
}

