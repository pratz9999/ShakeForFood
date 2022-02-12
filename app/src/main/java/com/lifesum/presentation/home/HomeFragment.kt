package com.lifesum.presentation.home

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lifesum.R
import com.lifesum.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.*
import kotlin.math.sqrt

/**
 * [HomeFragment]
 */
@AndroidEntryPoint
class HomeFragment : Fragment(), SensorEventListener, View.OnClickListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    private lateinit var sensorManager: SensorManager
    private var acceleration = 0f
    private var currentAcceleration = 0f
    private var lastAcceleration = 0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initViews()
    }

    private fun initViews() {
        binding.btnMore.setOnClickListener(this)
        initObserver()
        initSensor()
    }

    private fun initObserver() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.state.collect {
                when {
                    it.isLoading -> {
                        binding.progressBar.isVisible = true
                    }
                    it.error.isNotBlank() -> {
                        binding.progressBar.isVisible = false
                    }
                    it.item != null -> {
                        binding.progressBar.isVisible = false
                        binding.tvFoodName.text = it.item.title
                        binding.tvCalories.text = it.item.calories.toString()
                        binding.food = it.item
                    }
                }
            }
        }
    }

    private fun initSensor() {
        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Objects.requireNonNull(sensorManager).registerListener(
            this, sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL
        )
        acceleration = 10f
        currentAcceleration = SensorManager.GRAVITY_EARTH
        lastAcceleration = SensorManager.GRAVITY_EARTH
    }

    override fun onSensorChanged(event: SensorEvent) {
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]
        lastAcceleration = currentAcceleration
        currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
        val delta: Float = currentAcceleration - lastAcceleration
        acceleration = acceleration * 0.9f + delta
        if (acceleration > 12) {
            viewModel.startShake()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, p1: Int) {
    }

    override fun onResume() {
        sensorManager.registerListener(
            this, sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
            ), SensorManager.SENSOR_DELAY_NORMAL
        )
        super.onResume()
    }

    override fun onPause() {
        sensorManager.unregisterListener(this)
        super.onPause()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_more -> {
                showNutritionBottomSheet()
            }
        }
    }

    /**
     * Displaying Nutrition Bottom Sheet with remaining item information
     */
    private fun showNutritionBottomSheet() {
        viewModel.state.value.item?.let {
            val action =
                HomeFragmentDirections.actionHomeToNutritionBottomSheet(
                    it
                )
            navController.navigate(action)
        }
    }
}