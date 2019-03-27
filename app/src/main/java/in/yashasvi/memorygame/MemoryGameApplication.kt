package `in`.yashasvi.memorygame

import `in`.yashasvi.memorygame.di.ApplicationComponent
import `in`.yashasvi.memorygame.di.ApplicationModule
import `in`.yashasvi.memorygame.di.DaggerApplicationComponent
import android.app.Application
import android.content.Context


class MemoryGameApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent


    companion object {

        val timeInSecondsToSolvePerLevel = mapOf(
                1 to 30
        )

        fun getInstance(context: Context): MemoryGameApplication {
            return context.applicationContext as MemoryGameApplication;
        }
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }


    private fun initializeDagger() {
        val applicationModule = ApplicationModule(this)
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(applicationModule)
                .build()
    }

    fun applicationComponent(): ApplicationComponent = applicationComponent;
}