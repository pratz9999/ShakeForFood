package com.lifesum.data.remote.dto

import com.squareup.moshi.Json

data class FoodResponse(

	@Json(name="meta")
	val meta: Meta?,

	@Json(name="response")
	val response: Response
)