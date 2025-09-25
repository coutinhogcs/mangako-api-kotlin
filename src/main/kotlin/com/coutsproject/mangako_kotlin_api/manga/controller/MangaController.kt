package com.coutsproject.mangako_kotlin_api.manga.controller

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaRequestDTO
import com.coutsproject.mangako_kotlin_api.manga.dto.MangaResponseDTO
import com.coutsproject.mangako_kotlin_api.manga.service.MangaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/manga")
class MangaController(final val service: MangaService) {
    @GetMapping
    fun getAllMangas(): ResponseEntity<List<Manga>>{
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/title/{title}")
    fun getTitle(@PathVariable title: String): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.findByTitle(title))
    }

    @PostMapping
    fun create(@RequestBody data: MangaRequestDTO): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.insertManga(data))
    }

    @DeleteMapping("/title/{title}")
    fun delete(@PathVariable title: String): ResponseEntity<MangaResponseDTO>{
       val deleted = service.deleteByTitle(title)
        return ResponseEntity.notFound().build()
    }

    @PutMapping("/title/{id}/update")
    fun updateManga( @RequestBody dto: MangaRequestDTO, @PathVariable id: Long): ResponseEntity<MangaResponseDTO>{
        return ResponseEntity.ok(service.changeManga(dto, id))
    }

}