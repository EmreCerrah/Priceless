package com.emre.priceless.domain.model

// Kotlin tarafında Java ile tam uyum için basit bir domain sınıfı.
// Java kodu get/set ve çoklu kurucu beklediği için "var" kullanıyoruz.

data class Game(
    var id: String = "",
    var title: String = "",
    val sources: MutableList<GameSource> = mutableListOf()
) {
    constructor(title: String) : this(id = "", title = title, sources = mutableListOf())
    fun addOrUpdateSource(newSource: GameSource) {
        val existing = sources.find { it.provider == newSource.provider }
        if (existing != null) {
            existing.price = newSource.price
        } else {
            sources.add(newSource)
        }
    }
}