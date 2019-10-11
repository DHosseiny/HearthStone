package david.hosseini.hearthstone.di

import dagger.Component
import david.hosseini.hearthstone.ItemListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoryModule::class])
interface AppComponent {

    fun injectItemListActivity(itemListActivity: ItemListActivity)
}