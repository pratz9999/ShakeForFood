package com.lifesum.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.collect.Range
import com.google.common.truth.Truth
import com.lifesum.MainCoroutineRule
import com.lifesum.common.Constants
import com.lifesum.data.remote.FakeFoodRepository
import com.lifesum.domain.use_case.GetFoodItemUseCase
import com.lifesum.presentation.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var getFoodItemUseCase: GetFoodItemUseCase
    private lateinit var fakeRepository: FakeFoodRepository

    @Before
    fun setUp() {
        fakeRepository = FakeFoodRepository()
        getFoodItemUseCase = GetFoodItemUseCase(fakeRepository)
        homeViewModel = HomeViewModel(getFoodItemUseCase)
    }

    @Test
    fun `Check food response, success`() = runBlocking {
        Truth.assertThat(homeViewModel.state.value.item).isEqualTo(Constants.foodItemOne)
    }

    @Test
    fun `Check food id, success`() = runBlocking {
        Truth.assertThat(homeViewModel.foodId.value).isIn(Range.closed(1,200))
    }

    @Test
    fun `Check shake food item, success`() = runBlocking {
        homeViewModel.startShake()
        Truth.assertThat(homeViewModel.state.value.item).isEqualTo(Constants.foodItemOne)
    }

    @Test
    fun `Check shake food id, success`() = runBlocking {
        homeViewModel.startShake()
        Truth.assertThat(homeViewModel.foodId.value).isIn(Range.closed(1,200))
    }
}