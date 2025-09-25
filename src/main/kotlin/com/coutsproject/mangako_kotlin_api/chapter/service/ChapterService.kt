package com.coutsproject.mangako_kotlin_api.chapter.service

import com.coutsproject.mangako_kotlin_api.chapter.domain.Chapter
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterRequestDTO
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterResponseDTO
import com.coutsproject.mangako_kotlin_api.chapter.mapper.ChapterMapper
import com.coutsproject.mangako_kotlin_api.chapter.repository.ChapterRepository
import com.coutsproject.mangako_kotlin_api.manga.repository.MangaRepository
import org.springframework.stereotype.Service

@Service
class ChapterService(private val repository: ChapterRepository, private val mapper: ChapterMapper, private val mangaRepository: MangaRepository) {

    fun findAll(): List<ChapterResponseDTO> {
        return repository.findAll().map(mapper::toResponse)
    }


    fun addNewChapter(id:Long, dto: ChapterRequestDTO): ChapterResponseDTO{
        val manga = mangaRepository.findById(id).orElseThrow { NoSuchElementException("Mangá com ID $id não encontrado") }
        var chapter: Chapter = mapper.toEntity(dto, manga)
        chapter = repository.save(chapter)
        return mapper.toResponse(chapter)
    }


    fun changeChapter(idChapter:Long, dto: ChapterRequestDTO): ChapterResponseDTO{
        val chapters = repository.findById(idChapter).orElseThrow { NoSuchElementException("Chapter com ID $idChapter não encontrado") }

        val updated = chapters.copy(
            numbers = dto.numbers,
            images = dto.images,
        )

        val saved = repository.save(updated)
        return mapper.toResponse(saved)
    }


}