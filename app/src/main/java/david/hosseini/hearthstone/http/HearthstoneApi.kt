package david.hosseini.hearthstone.http

import david.hosseini.hearthstone.Card
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HearthstoneApi {

    @GET("cards/search/{name}")
    fun searchCards(@Path("name") name: String): Call<List<Card>>
}