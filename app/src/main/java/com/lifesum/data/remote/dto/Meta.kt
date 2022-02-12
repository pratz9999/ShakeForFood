package com.lifesum.data.remote.dto

import com.squareup.moshi.Json

data class Meta(

	@Json(name="code")
	val code: Int?
)