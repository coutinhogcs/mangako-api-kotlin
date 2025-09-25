package com.coutsproject.mangako_kotlin_api.chapter.domain

import com.coutsproject.mangako_kotlin_api.manga.domain.Manga
import jakarta.persistence.*
import java.time.LocalDateTime
@Entity
@Table(name = "chapter")
data class Chapter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id", nullable = false)
    val manga: Manga?= null,

    @Column(name = "numbers")
    val numbers:Integer?= null,

    @Column(name = "title")
    val titleChapter: String?= null,

    @Column(name = "images")
    val images: String?= null,

    @Column(name = "publication_date")
    val  publicationDate: LocalDateTime?= null
)
