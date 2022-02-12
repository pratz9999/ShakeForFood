package com.lifesum.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodItem(
    val fiber: String,
    val unSaturatedFat: String,
    val potassium: String,
    val carbs: String,
    val calories: String,
    val title: String,
    val gramsPerServing: String,
    val sodium: String,
    val saturatedFat: String,
    val protein: String,
    val fat: String,
    val pcsText: String,
    val cholesterol: String,
    val sugar: String
) : Parcelable
