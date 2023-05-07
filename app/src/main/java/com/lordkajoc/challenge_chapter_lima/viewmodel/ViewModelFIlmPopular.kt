package com.lordkajoc.challenge_chapter_lima.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordkajoc.challenge_chapter_5.network.ApiClient
import com.lordkajoc.challenge_chapter_lima.model.PopularMovieItem
import com.lordkajoc.challenge_chapter_lima.model.PopularMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFIlmPopular : ViewModel() {
    var liveDataMovie: MutableLiveData<List<PopularMovieItem>?> = MutableLiveData()

    fun callTmdb() {
        ApiClient.instance.getPopularmovie().enqueue(object : Callback<PopularMovieResponse> {
            override fun onResponse(
                call: Call<PopularMovieResponse>,
                response: Response<PopularMovieResponse>
            ) {
                if (response.isSuccessful) {
                    liveDataMovie.postValue(response.body()?.results)
                } else {
                    liveDataMovie.postValue(null)
                }
            }

            override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {
                liveDataMovie.postValue(null)
            }

        })
    }
}
