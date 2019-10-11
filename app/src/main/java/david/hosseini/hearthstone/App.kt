package david.hosseini.hearthstone

import android.app.Application
import david.hosseini.hearthstone.di.ApiModule
import david.hosseini.hearthstone.di.AppComponent
import david.hosseini.hearthstone.di.DaggerAppComponent


class App : Application() {

    companion object {
        lateinit var app: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        app = this
        appComponent = DaggerAppComponent.builder().apiModule(ApiModule).build()
    }
}
