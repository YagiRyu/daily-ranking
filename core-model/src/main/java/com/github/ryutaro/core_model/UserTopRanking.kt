package com.github.ryutaro.core_model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserTopRanking(
    val items: List<Item>
)

@JsonClass(generateAdapter = true)
data class Item(
    val album: Album,
    val artists: List<Artist>,
    val name: String,
    @Json(name = "preview_url")
    val previewUrl: String
)

@JsonClass(generateAdapter = true)
data class Album(
    @Json(name = "album_type")
    val albumType: String,
    val artists: List<Artist>,
    val id: String,
    val images: List<Image>,
    val name: String,
    @Json(name = "release_date")
    val releaseDate: String,
)

@JsonClass(generateAdapter = true)
data class Artist(
    @Json(name = "external_urls")
    val externalUrls: String,
    val href: String,
    val id: String,
    val name: String
)

@JsonClass(generateAdapter = true)
data class Image(
    val url: String
)
