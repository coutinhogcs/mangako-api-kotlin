package com.coutsproject.mangako_kotlin_api.manga.mapper

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaRequestDTO
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaResponseDTO
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class MangaMapper {

    fun toEntity(dto: MangaRequestDTO): Manga{
       return Manga(
           title = dto.title,
           description = dto.description,
           urlImage = dto.urlImage,
           author = dto.author,
           gender = dto.gender
       )
    }

    fun toResponse(manga: Manga): MangaResponseDTO{
        return MangaResponseDTO(
            title = manga.title,
            description = manga.description,
            urlImage = manga.urlImage,
            author = manga.author,
            gender = manga.gender,
            createdAt = manga.createdAt
        )
    }
}