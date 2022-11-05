package bassem.udacity.session4.data.repo

import androidx.lifecycle.LiveData
import bassem.udacity.session4.data.database.WordDao
import bassem.udacity.session4.model.Word

class WordsRepository(private val dao: WordDao) {

    suspend fun addWord(word: Word) {
        dao.insert(word)
    }

    fun getWordsList(): LiveData<List<Word>> = dao.getAlphabetizedWords()

    suspend fun deleteAll() = dao.deleteAll()
}