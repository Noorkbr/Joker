package com.example.joker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitglow.base.BaseFragment
import com.example.joker.Adapters.JokeAdapter
import com.example.joker.databinding.FragmentFavouritesBinding
import com.example.joker.viewmodel.JokeViewModel


class FavouritesFragment : BaseFragment<FragmentFavouritesBinding>(FragmentFavouritesBinding::inflate) {

    private lateinit var jokeViewModel: JokeViewModel
    private lateinit var jokeAdapter: JokeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFavorites.layoutManager = LinearLayoutManager(context)

        jokeAdapter = JokeAdapter { joke ->
            jokeViewModel.delete(joke)
        }
        binding.rvFavorites.adapter = jokeAdapter

        jokeViewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        jokeViewModel.allJokes.observe(viewLifecycleOwner, Observer { jokes ->
            jokes?.let { jokeAdapter.setJokes(it) }
        })
    }

    override fun setListener() {
        // Setup any listeners, if needed
    }

    override fun allObserver() {
        // Setup any observers, if needed
    }
}