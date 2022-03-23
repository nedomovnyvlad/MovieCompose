package com.vnedomovnyi.moviecompose.network

import com.vnedomovnyi.moviecompose.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(".")
    suspend fun getMovies(@Query("s") query: String): MovieResponse

}