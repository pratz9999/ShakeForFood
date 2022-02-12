package com.lifesum.presentation.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lifesum.R
import com.lifesum.databinding.NutriitionBottomSheetBinding


class NutritionBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: NutriitionBottomSheetBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contextThemeWrapper =
            ContextThemeWrapper(activity, R.style.Theme_ShakeForFood)
        val view = inflater.cloneInContext(contextThemeWrapper)
            .inflate(R.layout.nutriition_bottom_sheet, container, false)
        binding = NutriitionBottomSheetBinding.bind(view)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        initViews()
    }

    private fun initViews() {
        requireArguments().let {
            val args = NutritionBottomSheetArgs.fromBundle(requireArguments())
            binding.food = args.item
        }
    }
}