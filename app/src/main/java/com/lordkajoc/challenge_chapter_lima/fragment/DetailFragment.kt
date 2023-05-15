package com.lordkajoc.challenge_chapter_lima.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.lordkajoc.challenge_chapter_lima.databinding.FragmentDetailBinding
import com.lordkajoc.challenge_chapter_lima.model.PopularMovieItem

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val getfilm = arguments?.getSerializable("BUNDEL") as PopularMovieItem
        Glide.with(view)
            .load("https://image.tmdb.org/t/p/w500${getfilm.posterPath}")
            .into(binding.ivFilmimagedetail)
        binding.tvNamafilmdetail.text = getfilm.title
        binding.tvReleasefilmdetail.text = "Release : ${getfilm.releaseDate}"
        binding.tvPopularitydetail.text = "Popularity : ${getfilm.popularity}"
        binding.tvSinopsisfilmdetail.text = """Overview:
            ${getfilm.overview}
        """.trimIndent()

        //test crashlytics
        binding.btnCrashdetail.setOnClickListener {
                throw RuntimeException("Test Crash") // Force a crash
        }
    }
}