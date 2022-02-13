package com.lifesum.data.remote

import com.lifesum.common.Constants
import com.lifesum.data.remote.dto.FoodResponse
import com.lifesum.domain.repository.FoodRepository

class FakeFoodRepository : FoodRepository {
    override suspend fun getFoodById(foodId: Int): FoodResponse {
        return Constants.foodResponse
    }
}