package com.lifesum.domain.repository

import com.lifesum.data.remote.dto.FoodResponse

interface FoodRepository {

    suspend fun getFoodById(foodId: Int): FoodResponse

}