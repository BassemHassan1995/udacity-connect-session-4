package bassem.udacity.session4.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import bassem.udacity.session4.data.repo.WordsRepository
import bassem.udacity.session4.model.Word
import kotlinx.coroutines.launch

class WordsViewModel constructor(private val repository: WordsRepository) : ViewModel() {

    val words: LiveData<List<Word>> = repository.getWordsList()

    fun addWord(word: Word) = viewModelScope.launch {
        repository.addWord(word)
    }

    //TODO: Add later
    fun deleteAll(){


    }

}

class WordViewModelFactory(private val repository: WordsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}