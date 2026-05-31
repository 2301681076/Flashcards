package com.example.flashcards

object DataManager {
    // Тук променихме listOf на mutableListOf
    val decks = mutableListOf(
        Deck(
            id = "1",
            name = "Програмиране (Kotlin)",
            cards = mutableListOf(
                Flashcard(id = "c1", question = "Какво е Variable (Променлива)?", answer = "Контейнер за съхранение на данни."),
                Flashcard(id = "c2", question = "Каква е разликата между val и var?", answer = "val е непроменяема (read-only), а var може да се променя."),
                Flashcard(id = "c3", question = "Какво е String?", answer = "Текстов тип данни, ограден в кавички."),
                Flashcard(id = "c4", question = "Какво прави операторът % (модул)?", answer = "Връща остатъка от деление на две числа."),
                Flashcard(id = "c5", question = "Какво е функция (fun)?", answer = "Блок от код, който изпълнява конкретна задача."),
                Flashcard(id = "c6", question = "Какво е Array (Масив)?", answer = "Структура, която съхранява множество елементи от един тип."),
                Flashcard(id = "c7", question = "Какво означава 'null' в Kotlin?", answer = "Липса на стойност или празна референция."),
                Flashcard(id = "c8", question = "Какво е OOP?", answer = "Обектно-Ориентирано Програмиране."),
                Flashcard(id = "c9", question = "Какво е Class?", answer = "Шаблон или чертеж за създаване на обекти."),
                Flashcard(id = "c10", question = "Какво е компилатор?", answer = "Програма, която превръща кода в машинален език.")
            )
        ),
        Deck(
            id = "2",
            name = "Английски език (Думи)",
            cards = mutableListOf(
                Flashcard(id = "e1", question = "Apple", answer = "Ябълка"),
                Flashcard(id = "e2", question = "Book", answer = "Книга"),
                Flashcard(id = "e3", question = "Water", answer = "Вода"),
                Flashcard(id = "e4", question = "Computer", answer = "Компютър"),
                Flashcard(id = "e5", question = "Developer", answer = "Програмист"),
                Flashcard(id = "e6", question = "Language", answer = "Език"),
                Flashcard(id = "e7", question = "Learning", answer = "Учене / Обучение"),
                Flashcard(id = "e8", question = "Success", answer = "Успех"),
                Flashcard(id = "e9", question = "Challenge", answer = "Предизвикателство"),
                Flashcard(id = "e10", question = "Finished", answer = "Завършено / Готово")
            )
        )
    )
}