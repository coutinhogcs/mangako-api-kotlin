package com.coutsproject.mangako_kotlin_api.chapter.controller

import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterRequestDTO
import com.coutsproject.mangako_kotlin_api.chapter.dto.ChapterResponseDTO
import com.coutsproject.mangako_kotlin_api.chapter.service.ChapterService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chapter")
class ChapterController(private val service: ChapterService) {

    @GetMapping
    @Operation(summary = "List all", description = "List all manga")
    fun findAll(): List<ChapterResponseDTO> = service.findAll()

    @PostMapping("/{id}")
    @Operation(summary = "Create a new chapter", description = "Create a new chapter by id")
    fun addingNewChapter(@PathVariable id: Long, @RequestBody dto: ChapterRequestDTO ): ResponseEntity<ChapterResponseDTO>{
        return ResponseEntity.ok(service.addNewChapter(id, dto))
    }

    @PutMapping("/manga/{id}")
    @Operation(summary = "Update a new chapter", description = "Update a new chapter by id")
    fun updateChapter(@PathVariable id:Long,@RequestBody dto: ChapterRequestDTO): ResponseEntity<ChapterResponseDTO>{
        return ResponseEntity.ok(service.changeChapter(id,dto))
    }
}