package com.coutsproject.mangako_kotlin_api.chapter.dto

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import java.time.LocalDateTime
import javax.management.Descriptor

data class ChapterResponseDTO(
    var id: Long? = null,
    var mangaTitle: String? = null,
    var mangaDescriptor: String? = null,
    var numbers:Integer? = null,
    var titleChapter: String? = null,
    var images: String? = null,
    var publicationDate: LocalDateTime? = null
)
