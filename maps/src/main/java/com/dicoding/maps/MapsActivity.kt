package com.dicoding.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.core.Resource
import com.dicoding.maps.databinding.ActivityMapsBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private val mapsViewModel: MapsViewModel by viewModel()
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(mapsModule)

        supportActionBar?.title = "Sport Map"

        getTourismData()
    }

    private fun getTourismData() {
        mapsViewModel.tourism.observe(this, { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is map of ${tourism.data?.get(0)?.strSport}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = tourism.message
                    }
                }
            }
        })
    }
}