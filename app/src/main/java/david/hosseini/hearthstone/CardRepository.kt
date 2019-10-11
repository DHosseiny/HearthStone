package david.hosseini.hearthstone

import android.util.Log
import androidx.lifecycle.MutableLiveData
import david.hosseini.hearthstone.http.HearthstoneApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardRepository(private val hearthstoneApi: HearthstoneApi) {

    val cardsLiveData = MutableLiveData<List<Card>>()

    fun searchCards(keyword: String) {

        hearthstoneApi
            .searchCards(keyword)
            .enqueue(object : Callback<List<Card>> {

                override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                    Log.e(this@CardRepository.javaClass.simpleName, "search request field!")
                }

                override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {

                    if (response.isSuccessful) {

                        cardsLiveData.value = response.body()
                    } else {
                        Log.e(this@CardRepository.javaClass.simpleName, "search request field!")
                    }
                }

            })
    }

}
