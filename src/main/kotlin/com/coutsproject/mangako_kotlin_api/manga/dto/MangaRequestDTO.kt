package com.coutsproject.mangako_kotlin_api.manga.dto


data class MangaRequestDTO(
    val title: String,
    val description: String,
    val urlImage: String? = null,
    val author: String? = null,
    val gender: String? = null,
)