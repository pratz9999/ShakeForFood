package com.lifesum.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifesum.common.AppUtility
import com.lifesum.common.Resource
import com.lifesum.domain.use_case.GetFoodItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodItemUseCase: GetFoodItemUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FoodState())
    val state: StateFlow<FoodState> = _state

    private val _foodId = MutableLiveData(1)
    val foodId: LiveData<Int> = _foodId

    init {
        getFoodById()
    }

    /**
     * Get food data by foodId
     */
    private fun getFoodById() {
        foodItemUseCase(
            foodId.value!!
        ).onEach {
            when (it) {
                is Resource.Loading -> {
                    _state.value = FoodState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FoodState(item = it.data)
                }
                is Resource.Error -> {
                    _state.value = FoodState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    /**
     * When the shake starts, it detects the current state, if it's loading do nothing else get a random number and make an API call.
     */
    fun startShake() {
        if (!state.value.isLoading) {
            _foodId.value = AppUtility.getRandomNumber()
            getFoodById()
        }
    }

}