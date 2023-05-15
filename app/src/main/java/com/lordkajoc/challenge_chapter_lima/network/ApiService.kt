package com.lordkajoc.challenge_chapter_lima.network


import com.lordkajoc.challenge_chapter_lima.model.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //GET digunakan untuk memanggil semua data yang terdapat pada server
//    @GET("news")
//    fun getAllNews(): Call<List<GetAllNewsResponesItem>>
//
//    @GET("film")
//    fun getAllFilm(): Call<List<GetAllFIlmResponseItem>>

//    @GET("movie/popular?")
//    fun getmovie(
//        @Query("api_key") APIKEY: String,
//        @Query("page") PAGE: Int
//    ): Call<GetAllFilmTMDB<com.lordkajoc.challenge_chapter_5.model.GetAllFilmResponse>>

    @GET("movie/popular?api_key=10082fe9fdfeefb6c73522a0a8d82266&language=en-US&page=1")
    fun getPopularmovie():Call<PopularMovieResponse>
}