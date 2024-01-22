package com.yazid.islami.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("reference")
	val reference: String? = null,

	@field:SerializedName("hadeeth")
	val hadeeth: String? = null,

	@field:SerializedName("words_meanings")
	val wordsMeanings: List<WordsMeaningsItem?>? = null,

	@field:SerializedName("hints")
	val hints: List<String?>? = null,

	@field:SerializedName("translations")
	val translations: List<String?>? = null,

	@field:SerializedName("grade")
	val grade: String? = null,

	@field:SerializedName("attribution")
	val attribution: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("explanation")
	val explanation: String? = null
)

data class WordsMeaningsItem(

	@field:SerializedName("meaning")
	val meaning: String? = null,

	@field:SerializedName("word")
	val word: String? = null
)
