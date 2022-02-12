package com.lifesum.presentation.home

import com.lifesum.domain.model.FoodItem

data class FoodState(
    val isLoading: Boolean = false,
    val item: FoodItem ?= null,
    val error: String = ""
)