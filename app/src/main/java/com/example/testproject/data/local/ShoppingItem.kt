package com.example.testproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
)
