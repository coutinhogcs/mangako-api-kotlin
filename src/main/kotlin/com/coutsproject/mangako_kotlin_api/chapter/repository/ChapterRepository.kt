package com.coutsproject.mangako_kotlin_api.chapter.repository

import com.coutsproject.mangako_kotlin_api.chapter.domain.Chapter
import org.springframework.data.jpa.repository.JpaRepository

interface ChapterRepository : JpaRepository<Chapter, Long> {
}