package com.coutsproject.mangako_kotlin_api.manga.controller

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaRequestDTO
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaResponseDTO
import com.coutsproject.mangako_kotlin_api.manga.service.MangaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/manga")
@Tag(name = "Manga", description = "Endpoints for manga management")
class MangaController(final val service: MangaService) {
    @GetMapping
    @Operation(summary = "List all", description = "Select all manga")
    fun getAllMangas(): ResponseEntity<List<Manga>>{
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/title/{title}")
    @Operation(summary = "List by id", description = "Selects sleeves from their id")
    fun getTitle(@PathVariable title: String): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.findByTitle(title))
    }

    @PostMapping
    @Operation(summary = "Add a new manga", description = "Creates a new manga ")
    fun create(@RequestBody data: MangaRequestDTO): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.insertManga(data))
    }

    @DeleteMapping("/title/{title}")
    @Operation(summary = "Delete a new manga", description = "Delete a manga from your id")
    fun delete(@PathVariable title: String): ResponseEntity<MangaResponseDTO>{
       val deleted = service.deleteByTitle(title)
        return ResponseEntity.notFound().build()
    }

    @PutMapping("/title/{id}/update")
    @Operation(summary = "Update a new manga", description = "Edit a manga from your id")
    fun updateManga( @RequestBody dto: MangaRequestDTO, @PathVariable id: Long): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.changeManga(dto, id))
    }

}