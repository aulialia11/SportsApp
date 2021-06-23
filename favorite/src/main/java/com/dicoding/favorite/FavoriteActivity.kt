package com.dicoding.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.ui.SportAdapter
import com.dicoding.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.sportsapp.detail.ActivityDetailSport
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoritViewModel: FavoriteViewModel by viewModel()
    private var _binding: ActivityFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoritviewModelModule)

        supportActionBar?.title = "Sports Favorite"

        getTourismData()
    }

    private fun getTourismData() {
        if (this != null) {

            val tourismAdapter = SportAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(this, ActivityDetailSport::class.java)
                intent.putExtra(ActivityDetailSport.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoritViewModel.favoriteTourism.observe(this, { dataTourism ->
                tourismAdapter.setData(dataTourism)
                binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }

}