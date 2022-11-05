package bassem.udacity.session4

import android.app.Application
import bassem.udacity.session4.data.database.WordDatabase
import bassem.udacity.session4.data.repo.WordsRepository

class WordsApplication : Application() {

    private val database by lazy { WordDatabase.getInstance(this) }
    val repository by lazy { WordsRepository(database.dao) }

}