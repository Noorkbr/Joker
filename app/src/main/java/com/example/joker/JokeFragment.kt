package com.example.joker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fitglow.base.BaseFragment
import com.example.joker.data.Joke
import com.example.joker.databinding.FragmentJokeBinding
import com.example.joker.network.RetrofitInstance
import com.example.joker.viewmodel.JokeViewModel
import kotlinx.coroutines.launch

class JokeFragment : BaseFragment<FragmentJokeBinding>(FragmentJokeBinding::inflate) {

    private lateinit var jokeViewModel: JokeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jokeViewModel = ViewModelProvider(this).get(JokeViewModel::class.java)

        binding.btnNewJoke.setOnClickListener {
            jokeViewModel.fetchRandomJoke()
        }

        binding.btnSaveFavorite.setOnClickListener {
            saveJokeToFavorites()
        }

        binding.btnViewFavorites.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_joke_to_fragment_favourites)
        }

      /*  jokeViewModel.joke.observe(viewLifecycleOwner, { jokeResponse ->
            binding.tvJoke.text = jokeResponse.formattedJoke
        })*/
    }

    override fun setListener() {
        // Setup any listeners, if needed
    }

    override fun allObserver() {
        // Setup any observers, if needed
    }

    private fun saveJokeToFavorites() {
        val jokeText = binding.tvJoke.text.toString()
        if (jokeText.isNotEmpty()) {
            val joke = Joke(0, jokeText)
            jokeViewModel.insert(joke)
            showToast("Joke saved!")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}