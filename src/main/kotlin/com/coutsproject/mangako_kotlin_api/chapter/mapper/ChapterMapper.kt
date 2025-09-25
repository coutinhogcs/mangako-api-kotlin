package com.coutsproject.mangako_kotlin_api.chapter.mapper

import com.coutsproject.mangako_kotlin_api.chapter.domain.Chapter
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterRequestDTO
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterResponseDTO
import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import org.springframework.stereotype.Component

@Component
class ChapterMapper {

    fun toEntity(dto: ChapterRequestDTO, manga: Manga): Chapter{
        return Chapter(
            manga = manga,
            numbers = dto.numbers,
            titleChapter = dto.titleChapter,
            images = dto.images
        )
    }

    fun toResponse(data: Chapter): ChapterResponseDTO{
        return ChapterResponseDTO(
            id = data.id,
            mangaTitle = data.manga?.title,
            mangaDescriptor = data.manga?.description,
            numbers = data.numbers,
            titleChapter = data.titleChapter,
            images = data.images,
            publicationDate = data.publicationDate
        )
    }
}