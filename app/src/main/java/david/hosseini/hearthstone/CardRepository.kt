package david.hosseini.hearthstone

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import david.hosseini.hearthstone.http.HearthstoneApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardRepository(private val hearthstoneApi: HearthstoneApi) {

    private val _cardsLiveData = MutableLiveData<List<Card>>()
    val cardsLiveData: LiveData<List<Card>> = _cardsLiveData

    fun searchCards(keyword: String) {

        hearthstoneApi
            .searchCards(keyword)
            .enqueue(object : Callback<List<Card>> {

                override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                    Log.e(this@CardRepository.javaClass.simpleName, "search request field!")
                }

                override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {

                    if (response.isSuccessful) {

                        _cardsLiveData.value = response.body()
                    } else {
                        Log.e(this@CardRepository.javaClass.simpleName, "search request field!")
                    }
                }

            })
    }

}
