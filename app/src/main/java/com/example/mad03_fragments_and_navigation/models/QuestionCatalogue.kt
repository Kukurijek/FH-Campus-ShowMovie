package com.example.mad03_fragments_and_navigation.models

class QuestionCatalogue {
    val defaultQuestions = exampleCatalogue

    companion object{
        val exampleCatalogue: MutableList<Question> = createStaticQuestionList()

        private fun createStaticQuestionList(): MutableList<Question> {
            val list: MutableList<Question> = mutableListOf()


            list.add(Question(
                "What was the first feature-length animated movie ever released?",
                listOf(
                    Answer("Snow White and the Seven Dwarfs", true),
                    Answer("Toy Story"),
                    Answer("101 Dalmatians"),
                    Answer("Finding Nemo")
                ))
            )

            list.add(Question(
                "What’s the name of the skyscraper in Die Hard?",
                listOf(
                    Answer("Burj Kalifa"),
                    Answer("Nakatomi Plaza", true),
                    Answer("Lakhta Center"),
                    Answer("The Shard")
                ))
            )

            list.add(Question(
                "What’s the name of the anthemic dance near the beginning of The Rocky Horror Picture Show?",
                listOf(
                    Answer("Jolly Holiday"),
                    Answer("Diamonds Are a Girl’s Best Friend"),
                    Answer("The Time of My Life"),
                    Answer("The Time Warp", true)
                ))
            )

            return list
        }
    }
}