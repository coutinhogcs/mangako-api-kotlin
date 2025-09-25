package com.coutsproject.mangako_kotlin_api.manga.domain

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
data class Manga(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title")
    val title: String? = null,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "url_image")
    val urlImage: String? = null,

    @Column(name = "author")
    val author: String? = null,

    @Column(name = "gender")
    val gender: String? = null,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime? = null

)

