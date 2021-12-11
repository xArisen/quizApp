package com.example.quizapp

//Klasa ze stałymi - przechowuje pytania
object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "Ile stopni wynosi pole widzenia kotów?",
            "200",
            "180",
            "190",
            "210",
            1
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "Ile ważyła największa wyhodowana cebula?",
            "8,25 kg",
            "10,23 kg",
            "7,03 kg",
            "6,81 kg",
            3
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "Jak nazywa się najdroższa kawa na świecie?",
            "Sanden-Sa",
            "Kopi-Luwak",
            "Coffee to remember",
            "Last dream",
            2
        )
        questionsList.add(question3)

        val question4 = Question(
            4,
            "Którą markę samochodów najczęściej wybierają Polacy?",
            "Skoda",
            "BMW",
            "Volkswagen",
            "Toyota",
            1
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "Jak w dawnej Polsce nazywano liczby ujemne?",
            "Liczby minusowe",
            "Liczby względne",
            "Liczby niskie",
            "Liczby poniżej zera",
            2
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "Ile metrów wysokości ma Piramida Cheopsa?",
            "254 m",
            "137 m",
            "129 m",
            "222 m",
            2
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "Ile procent populacji świata ma niebieskie oczy?",
            "16%",
            "39%",
            "78%",
            "8%",
            4
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "Na jakiej wysokości (od górnej taśmy do parkietu) jest zawieszona siatka w meczu siatkówki kobiet?",
            "2,13 m",
            "2,28 m",
            "2,00 m",
            "2,24 m",
            4
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "Ile jest kilometrów od Pragi do Budapesztu?",
            "525 km",
            "423 km",
            "480 km",
            "400 km",
            1
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "W jakich kolorach świat widzą psy?",
            "Fioletowo-niebiesko",
            "Zielono-żółto",
            "Żółto-niebiesko",
            "Czerwono-żółto",
            3
        )
        questionsList.add(question10)
        return questionsList
    }
}