package com.lifesum.domain.use_case

import com.lifesum.common.Resource
import com.lifesum.data.remote.dto.toFoodItem
import com.lifesum.domain.model.FoodItem
import com.lifesum.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFoodItemUseCase @Inject constructor(private val repository: FoodRepository) {
    operator fun invoke(
        foodId: Int
    ): Flow<Resource<FoodItem>> = flow {
        try {
            emit(Resource.Loading())
            val positionResponse = repository.getFoodById(
                foodId
            ).response.toFoodItem()
            emit(Resource.Success(positionResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}