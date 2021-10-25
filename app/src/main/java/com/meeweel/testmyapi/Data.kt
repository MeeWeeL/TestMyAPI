package com.meeweel.testmyapi

private var repo: MutableList<Anime> = mutableListOf()

fun insertAnime(anime: Anime) {

}
fun getRepo() = repo

fun convertDTOToAnime(animeDTO: AnimeDTO): Anime {
    val fact = animeDTO.fact!!
    return Anime(fact.title!!,fact.description!!,fact.image!!)
}