package com.lifesum.data.repository

import com.lifesum.common.URLConstants
import com.lifesum.data.remote.ApiService
import com.lifesum.data.remote.dto.FoodResponse
import com.lifesum.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val api: ApiService
) : FoodRepository {
    override suspend fun getFoodById(foodId: Int): FoodResponse {
        return api.getFoodData(URLConstants.AUTH_TOKEN, foodId)
    }
}