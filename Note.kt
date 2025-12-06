data class Note(
    var id: Int,
    var title: String,
    var content: String
) {
    override fun toString(): String {
        return "Id записи: $id\nНазвание: $title\nСодержание: $content"
    }
}
