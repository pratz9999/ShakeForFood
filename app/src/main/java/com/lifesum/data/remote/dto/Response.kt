package com.lifesum.data.remote.dto

import com.lifesum.common.AppUtility
import com.lifesum.common.Constants
import com.lifesum.domain.model.FoodItem
import com.squareup.moshi.Json

data class Response(

    @Json(name = "fiber")
    val fiber: Double?,

    @Json(name = "unsaturatedfat")
    val unsaturatedfat: Double?,

    @Json(name = "potassium")
    val potassium: Double?,

    @Json(name = "carbs")
    val carbs: Double?,

    @Json(name = "calories")
    val calories: Int?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "gramsperserving")
    val gramsperserving: Double?,

    @Json(name = "sodium")
    val sodium: Double?,

    @Json(name = "saturatedfat")
    val saturatedfat: Double?,

    @Json(name = "protein")
    val protein: Double?,

    @Json(name = "fat")
    val fat: Double?,

    @Json(name = "pcstext")
    val pcstext: String?,

    @Json(name = "cholesterol")
    val cholesterol: Double?,

    @Json(name = "sugar")
    val sugar: Double?
)

fun Response.toFoodItem(): FoodItem {
    return FoodItem(
        fiber = AppUtility.getDoubleToSingleDecimalString(fiber),
        unSaturatedFat = AppUtility.getDoubleToSingleDecimalString(
            unsaturatedfat
        ),
        potassium = AppUtility.getDoubleToSingleDecimalString(potassium),
        carbs = AppUtility.getDoubleToSingleDecimalString(carbs),
        calories = (calories ?: Constants.ZERO).toString(),
        title = title ?: Constants.EMPTY_STRING,
        gramsPerServing = AppUtility.getDoubleToSingleDecimalString(gramsperserving),
        sodium = AppUtility.getDoubleToSingleDecimalString(sodium),
        saturatedFat = AppUtility.getDoubleToSingleDecimalString(
            saturatedfat
        ),
        protein = AppUtility.getDoubleToSingleDecimalString(protein),
        fat = AppUtility.getDoubleToSingleDecimalString(fat),
        pcsText = pcstext ?: Constants.EMPTY_STRING,
        cholesterol = AppUtility.getDoubleToSingleDecimalString(
            cholesterol
        ),
        sugar = AppUtility.getDoubleToSingleDecimalString(sugar)
    )
}