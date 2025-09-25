package com.coutsproject.mangako_kotlin_api.chapter.controller

import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterRequestDTO
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterResponseDTO
import com.coutsproject.mangako_kotlin_api.chapter.service.ChapterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chapter")
class ChapterController(private val service: ChapterService) {

    @GetMapping
    fun findAll(): List<ChapterResponseDTO> = service.findAll()

    @PostMapping("/{id}")
    fun addingNewChapter(@PathVariable id: Long, @RequestBody dto: ChapterRequestDTO ): ResponseEntity<ChapterResponseDTO>{
        return ResponseEntity.ok(service.addNewChapter(id, dto))
    }

    @PutMapping("/manga/{id}")
    fun updateChapter(@PathVariable id:Long,@RequestBody dto: ChapterRequestDTO): ResponseEntity<ChapterResponseDTO>{
        return ResponseEntity.ok(service.changeChapter(id,dto))
    }
}