package com.coutsproject.mangako_kotlin_api.manga.service

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaRequestDTO
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaResponseDTO
import com.coutsproject.mangako_kotlin_api.manga.mapper.MangaMapper
import com.coutsproject.mangako_kotlin_api.manga.repository.MangaRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MangaService(private  val repository: MangaRepository, private val mapper: MangaMapper) {

    fun getAll(): List<Manga> = repository.findAll()

    fun insertManga(data: MangaRequestDTO): MangaResponseDTO {
        var manga: Manga = mapper.toEntity(data)
        manga = repository.save(manga)
        return mapper.toResponse(manga)
    }

    fun findByTitle(title: String): MangaResponseDTO{
        val manga: Manga = repository.findByTitle(title)
        return mapper.toResponse(manga)
    }

    fun deleteByTitle(title: String){
        val manga = repository.findByTitle(title)
        repository.delete(manga)
    }
    @Transactional
    fun changeManga(data: MangaRequestDTO, id: Long): MangaResponseDTO{
        val existing = repository.findById(id)
            .orElseThrow { RuntimeException("Manga com id $id não encontrado") }

        val updated = existing.copy(
            title = data.title,
            description = data.description,
            urlImage = data.urlImage,
            author = data.author,
            gender = data.gender
        )
        val saved = repository.save(updated)
        return mapper.toResponse(updated)
    }
}