package david.hosseini.hearthstone.http

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpManager {


    private val addHeadersInterceptor = Interceptor {

        val original = it.request()

        val request = original
            .newBuilder()
            .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "945260df1cmsh148ce89da8e7f90p1a39cajsndac4b404b239")
            .build()

        it.proceed(request)
    }


    private val client = OkHttpClient.Builder()
        .addInterceptor(addHeadersInterceptor)
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
//      .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()


    fun hearthstoneApi(): HearthstoneApi = retrofit.create(
        HearthstoneApi::class.java
    )

}


const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"