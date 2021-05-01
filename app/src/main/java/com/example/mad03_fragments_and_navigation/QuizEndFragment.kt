package com.example.mad03_fragments_and_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mad03_fragments_and_navigation.databinding.FragmentQuizEndBinding


class QuizEndFragment : Fragment() {
    private lateinit var binding: FragmentQuizEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_end, container, false)

        val args = QuizEndFragmentArgs.fromBundle(requireArguments())
        val score = args.score
        val sum = args.sum
        binding.scoreText.text = "$score/$sum"

        binding.btnRestart.setOnClickListener{
            findNavController().navigate(QuizEndFragmentDirections.actionQuizEndFragmentToQuizFragment())
        }

        return binding.root
    }
}