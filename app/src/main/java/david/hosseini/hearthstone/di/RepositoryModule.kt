package david.hosseini.hearthstone.di

import dagger.Module
import dagger.Provides
import david.hosseini.hearthstone.CardRepository
import david.hosseini.hearthstone.http.HearthstoneApi


@Module
class RepositoryModule {


    //not used constructor injection because we will extend this class to inject a mock repository for testing
    @Provides
    fun provideCardRepository(hearthstoneApi: HearthstoneApi): CardRepository {
        return CardRepository(hearthstoneApi)
    }
}
