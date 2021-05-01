package com.example.mad03_fragments_and_navigation.models

import com.example.mad03_fragments_and_navigation.R

data class MovieStore(val myMovies: MutableList<Movie> = mutableListOf()){

    val defaultMovies = exampleMovies

    fun findMovieByUUID(uuid: String): Movie? {
        return defaultMovies.find { movie -> movie.id.toString() == uuid }
    }

    companion object{
        val exampleMovies: MutableList<Movie> = createStaticMovieList()

        private fun createStaticMovieList(): MutableList<Movie> {
            val list: MutableList<Movie> = mutableListOf()


            val movie1 = Movie("The Queen's Gambit", "The Queen\'s Gambit follows the life of an orphan chess prodigy, Elizabeth Harmon, during her quest to become the world\'s greatest chess player while struggling with emotional problems and drug and alcohol dependency. The title of the series refers to a chess opening of the same name. The story begins in the mid-1950s and proceeds into the 1960s.[5]\n\n" + "The story begins in Lexington, Kentucky, where a nine-year-old Beth, having lost her mother in a car crash, is taken to an orphanage where she is taught chess by the building\'s custodian, Mr. Shaibel. As was common during the 1950s, the orphanage dispenses daily tranquilizer pills to the girls,[6][7] which turns into an addiction for Beth. She quickly becomes a strong chess player due to her visualization skills, which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and wins despite having no prior experience in competitive chess. She develops friendships with several people, including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her success, her drug and alcohol dependency becomes worse.")
            movie1.actors.addAll(listOf("Anya Taylor-Joy", "Chloe Pirrie"))
            movie1.genres = listOf("Drama", "Sport")
            movie1.creators.addAll(listOf("Scott Frank", "Alan Scott"))
            movie1.rating = 4.5F
            movie1.imageId = R.drawable.queensgambit

            val movie2 = Movie("Knives Out", "Nothing could blemish the otherwise lavish birthday party at the palatial estate of the acclaimed crime/mystery novelist, Harlan Thrombey, except for his strange and unaccountable death. Now, the sharp knife in the silver-haired deceased's hand is a dead giveaway that something, or someone, had been bothering Harlan; nevertheless, the cryptic detective, Benoit Blanc, is not entirely sure. Indeed, there is more than one member of the successful author's clingy family who has been economical with the truth so far--and as Blanc struggles to shed light on a tangled mess of half-baked leads and little white lies--all eyes are on the grand prize: Harlan's magnificent legacy. Can Benoit get to the bottom of this perplexing case before someone else dies, too?")
            movie2.actors.addAll(listOf("Daniel Craig", "Toni Collette", "Ana de Armas"))
            movie2.genres = listOf("Comedy", "Crime", "Drama")
            movie2.creators.add("Rian Johnson")
            movie2.rating = 4.0F
            movie2.imageId = R.drawable.knivesout

            val movie3 = Movie("Parasite", "Jobless, penniless, and, above all, hopeless, the unmotivated patriarch, Ki-taek, and his equally unambitious family--his supportive wife, Chung-sook; his cynical twentysomething daughter, Ki-jung, and his college-age son, Ki-woo--occupy themselves by working for peanuts in their squalid basement-level apartment. Then, by sheer luck, a lucrative business proposition will pave the way for an ingeniously insidious scheme, as Ki-woo summons up the courage to pose as an English tutor for the teenage daughter of the affluent Park family. Now, the stage seems set for an unceasing winner-take-all class war. How does one get rid of a parasite?")
            movie3.actors.addAll(listOf("Kang-ho Song", "Lee Sun-kyun", "Yeo-jeong Cho"))
            movie3.genres = listOf("Comedy", "Thriller", "Drama")
            movie3.creators.add("Bong Joon Ho")
            movie3.rating = 5.0F
            movie3.imageId = R.drawable.parasite

            list.add(movie1)
            list.add(movie2)
            list.add(movie3)
            
            return list
        }
    }
}