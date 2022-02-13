package com.lifesum.common

import com.lifesum.data.remote.dto.FoodResponse
import com.lifesum.data.remote.dto.Meta
import com.lifesum.data.remote.dto.Response
import com.lifesum.data.remote.dto.toFoodItem

object Constants {

    private val foodOne = Response(
        title = "Ricotta cheese",
        calories = 174,
        carbs = 3.04,
        protein = 11.26,
        fat = 12.98,
        saturatedfat = 8.295,
        unsaturatedfat = 4.012,
        fiber = 0.0,
        cholesterol = 0.051,
        sugar = 0.27,
        sodium = 0.084,
        potassium = 0.105,
        gramsperserving = 20.0,
        pcstext = "Whole cheese"
    )
    private val foodTwo = Response(
        title = "Feta cheese",
        calories = 274,
        carbs = 3.04,
        protein = 11.26,
        fat = 12.98,
        saturatedfat = 8.295,
        unsaturatedfat = 4.012,
        fiber = 0.0,
        cholesterol = 0.051,
        sugar = 0.27,
        sodium = 0.084,
        potassium = 0.105,
        gramsperserving = 20.0,
        pcstext = "Whole cheese"
    )

    private val foodThree = Response(
        title = "Cottage cheese",
        calories = 374,
        carbs = 3.04,
        protein = 11.26,
        fat = 12.98,
        saturatedfat = 8.295,
        unsaturatedfat = 4.012,
        fiber = 0.0,
        cholesterol = 0.051,
        sugar = 0.27,
        sodium = 0.084,
        potassium = 0.105,
        gramsperserving = 20.0,
        pcstext = "Whole cheese"
    )


    val foodItemOne = foodOne.toFoodItem()

    private val foodItemTwo = foodTwo.toFoodItem()

    private val foodItemThree = foodThree.toFoodItem()

    val foodResponse = FoodResponse(meta = Meta(200), foodOne)
}