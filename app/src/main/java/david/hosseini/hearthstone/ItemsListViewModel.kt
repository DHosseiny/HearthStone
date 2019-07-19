package david.hosseini.hearthstone

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import david.hosseini.hearthstone.http.HttpManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsListViewModel : ViewModel() {

    val cardsLiveData = MutableLiveData<List<Card>>()

    fun search(keyword: String) {

        HttpManager.hearthstoneApi()
            .searchCards(keyword)
            .enqueue(object : Callback<List<Card>> {

                override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                    Log.e(
                        this@ItemsListViewModel.javaClass.simpleName,
                        "search request field!"
                    )
                }

                override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {

                    if (response.isSuccessful) {

                        cardsLiveData.value = response.body()
                    }
                }

            })
    }


}