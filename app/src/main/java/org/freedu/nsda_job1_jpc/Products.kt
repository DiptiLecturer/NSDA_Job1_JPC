package org.freedu.nsda_job1_jpc

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String? // Fakestore API uses 'image' (single image)
)


