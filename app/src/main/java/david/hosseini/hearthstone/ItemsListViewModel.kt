package david.hosseini.hearthstone

import androidx.lifecycle.ViewModel

class ItemsListViewModel(private val repository: CardRepository) : ViewModel() {

    val cardsLiveData
        get() = repository.cardsLiveData


    fun search(keyword: String) {

        repository.searchCards(keyword)
    }
}