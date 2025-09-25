package com.coutsproject.mangako_kotlin_api.manga.repository

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MangaRepository : JpaRepository<Manga, Long> {
   fun findByTitle(title: String): Manga

}