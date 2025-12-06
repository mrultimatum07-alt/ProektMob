class NoteManager {
    private val notes = mutableListOf<Note>()
    private var nextId = 1

    fun addNote(title: String, content: String) {
        val note = Note(nextId, title, content)
        notes.add(note)
        nextId++
        println("Заметка добавлена успешно!")
    }

    fun editNote(id: Int, newTitle: String, newContent: String) {
        val note = notes.find { it.id == id }
        if (note != null) {
            note.title = newTitle
            note.content = newContent
            println("Заметка успешно обновлена!")
        } else {
            println("Заметка не найдена!")
        }
    }

    fun deleteNote(id: Int) {
        val note = notes.find { it.id == id }
        if (note != null) {
            notes.remove(note)
            println("Заметка успешно удалена!")
        } else {
            println("Заметка не найдена!")
        }
    }

    fun searchNotes(keyword: String): List<Note> {
        return notes.filter { it.title.contains(keyword, ignoreCase = true) ||
                it.content.contains(keyword, ignoreCase = true) }
    }

    fun listNotes() {
        if (notes.isEmpty()) {
            println("Заметок нет.")
        } else {
            notes.forEach { println(it) }
        }
    }
}
