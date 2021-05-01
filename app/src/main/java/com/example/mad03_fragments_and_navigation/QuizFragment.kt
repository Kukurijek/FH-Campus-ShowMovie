package com.example.mad03_fragments_and_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mad03_fragments_and_navigation.databinding.FragmentQuizBinding
import com.example.mad03_fragments_and_navigation.viewmodels.QuizViewModel


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        with(binding){
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        subscribeUI()

        return binding.root
    }

    private fun subscribeUI(){
        binding.btnNext.setOnClickListener {
            next()
        }

        viewModel.eventQuizFinish.observe(viewLifecycleOwner, Observer { hasFinished ->
            if(hasFinished) quizFinished()
        })
    }

    private fun quizFinished(){
        viewModel.score.value?.let {
            findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToQuizEndFragment(
                viewModel.score.value!!, viewModel.questions.size
            ))
        }
    }

    fun next(){
        // check if answer selected - and get index
        getIndexOfRadioBtn()?.let{ selectedIdx ->
            viewModel.next(selectedIdx)
            binding.answerBox.clearCheck()  // remove radio button checks
        }
    }

    private fun getIndexOfRadioBtn(): Int?{
        return when(binding.answerBox.checkedRadioButtonId){
            R.id.answer1 -> 0
            R.id.answer2 -> 1
            R.id.answer3 -> 2
            R.id.answer4 -> 3
            else -> {
                Toast.makeText(requireContext(), "Please select an answer", Toast.LENGTH_SHORT).show()
                null
            }
        }
    }
}