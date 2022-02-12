package com.lifesum.data.remote


import com.lifesum.common.URLConstants
import com.lifesum.data.remote.dto.FoodResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Defines the abstract methods used for interacting with the API
 */
interface ApiService {

    @GET(URLConstants.FOOD_URL)
    suspend fun getFoodData(
        @Header(URLConstants.AUTHORIZATION) auth: String,
        @Query(URLConstants.QUERY_FOOD_ID) foodId: Int
    ): FoodResponse

}

