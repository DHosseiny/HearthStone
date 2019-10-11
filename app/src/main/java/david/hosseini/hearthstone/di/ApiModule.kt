package david.hosseini.hearthstone.di

import dagger.Module
import dagger.Provides
import david.hosseini.hearthstone.http.HearthstoneApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(): Retrofit {


        val addHeadersInterceptor = Interceptor {

            val original = it.request()

            val request = original
                .newBuilder()
                .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                .addHeader(
                    "X-RapidAPI-Key",
                    "945260df1cmsh148ce89da8e7f90p1a39cajsndac4b404b239"
                )
                .build()

            it.proceed(request)
        }


        val client = OkHttpClient.Builder()
            .addInterceptor(addHeadersInterceptor)
            .build()


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideApiService(retrofit: Retrofit): HearthstoneApi {

        return retrofit.create(HearthstoneApi::class.java)
    }
}

private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"