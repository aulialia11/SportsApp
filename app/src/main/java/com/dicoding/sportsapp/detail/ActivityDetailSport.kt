package com.dicoding.sportsapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.core.data.Sport
import com.dicoding.sportsapp.R
import com.dicoding.sportsapp.databinding.ActivityDetailSportBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ActivityDetailSport : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTourismViewModel: DetailSportViewModel by viewModel()
    private lateinit var binding: ActivityDetailSportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTourism = intent.getParcelableExtra<Sport>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: Sport?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.strSport
            binding.content.tvDetailDescription.text = detailTourism.strSportDescription
            Glide.with(this@ActivityDetailSport)
                .load(detailTourism.strSportThumb)
                .into(binding.ivDetailImage)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.ic_baseline_favorite_24
            ))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.ic_baseline_favorite_border_24
            ))
        }
    }
}
