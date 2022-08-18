package com.app.otakudesu.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimeResponse(

	@field:SerializedName("baseUrl")
	val baseUrl: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("home")
	val home: Home? = null
) : Parcelable

@Parcelize
data class OnGoingItem(

	@field:SerializedName("day_updated")
	val dayUpdated: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("uploaded_on")
	val uploadedOn: String? = null,

	@field:SerializedName("episode")
	val episode: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable

@Parcelize
data class Home(

	@field:SerializedName("on_going")
	val onGoing: List<OnGoingItem?>? = null,

	@field:SerializedName("complete")
	val complete: List<CompleteItem?>? = null
) : Parcelable

@Parcelize
data class CompleteItem(

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("uploaded_on")
	val uploadedOn: String? = null,

	@field:SerializedName("episode")
	val episode: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable
