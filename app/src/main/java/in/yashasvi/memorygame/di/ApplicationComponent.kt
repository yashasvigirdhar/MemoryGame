package `in`.yashasvi.memorygame.di

import `in`.yashasvi.memorygame.ui.CardsActivity
import `in`.yashasvi.memorygame.ui.viewmodel.CardsViewModel
import dagger.Component
import javax.inject.Singleton


@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(cardsActivity: CardsActivity)
    fun inject(cardsViewModel: CardsViewModel)
}