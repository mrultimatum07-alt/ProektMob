fun main() {
    val noteManager = NoteManager()
    var choice: Int

    do {
        println("\nОглавление")
        println("1. Добавить запись")
        println("2. Редактировать запись")
        println("3. Удалить запись")
        println("4. Поиск записи")
        println("5. Все записи")
        println("0. Выход")
        print("Выберете вариант: ")
        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> {
                print("Введите название: ")
                val title = readLine() ?: ""
                print("Содержание: ")
                val content = readLine() ?: ""
                noteManager.addNote(title, content)
            }
            2 -> {
                print("Введите ID заметки для редактирования: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    print("Введите новое название: ")
                    val newTitle = readLine() ?: ""
                    print("Новое содержание: ")
                    val newContent = readLine() ?: ""
                    noteManager.editNote(id, newTitle, newContent)
                }
            }
            3 -> {
                print("Введите Id заметки для удаления: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    noteManager.deleteNote(id)
                }
            }
            4 -> {
                print("Введите ключевое слово для поиска: ")
                val keyword = readLine() ?: ""
                val results = noteManager.searchNotes(keyword)
                if (results.isEmpty()) {
                    println("Не найдено заметок с ключевым словом '$keyword'.")
                } else {
                    results.forEach { println(it) }
                }
            }
            5 -> noteManager.listNotes()
            0 -> println("Выход...")
            else -> println("Неверный выбор. Пожалуйста, попробуйте снова")
        }
    } while (choice != 0)
}