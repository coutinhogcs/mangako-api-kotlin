package com.coutsproject.mangako_kotlin_api.manga.dto

import java.time.LocalDateTime

data class MangaResponseDTO(
    val title: String? = null,
    val description: String? = null,
    val urlImage: String? = null,
    val author: String? = null,
    val gender: String? = null,
    val createdAt: LocalDateTime? = null
)
