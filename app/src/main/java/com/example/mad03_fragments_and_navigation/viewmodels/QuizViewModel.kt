package com.example.mad03_fragments_and_navigation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mad03_fragments_and_navigation.models.Question
import com.example.mad03_fragments_and_navigation.models.QuestionCatalogue

class QuizViewModel: ViewModel() {
    val questions = QuestionCatalogue().defaultQuestions

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventQuizFinish = MutableLiveData<Boolean>()
    val eventQuizFinish: LiveData<Boolean>
        get() = _eventQuizFinish

    private var index = 0
    val indexToShow = MutableLiveData<Int>()

    init {
        indexToShow.value = 1
        questions.shuffle()
        _question.value = questions[index]
        _score.value = 0
    }

    private fun updateIndex(){
        indexToShow.value = index + 1
    }

    private fun onQuizFinish() {
        _eventQuizFinish.value = true
    }

    fun next(selectedIdx: Int){
        question.value?.answers?.get(selectedIdx)?.let { answer ->
            if(answer.isCorrectAnswer){
                _score.value = (score.value)?.plus(1)
            }
            nextQuestion()
        }
    }

    private fun nextQuestion(){
        index++
        updateIndex()
        if(index < questions.size){
            _question.value = questions[index]
        } else {
            onQuizFinish()
        }
    }
}