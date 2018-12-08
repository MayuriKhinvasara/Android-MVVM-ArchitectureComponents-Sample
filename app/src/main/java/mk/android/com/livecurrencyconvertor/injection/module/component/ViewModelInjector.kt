package mk.android.com.livecurrencyconvertor.injection.module.component

import dagger.Component
import mk.android.com.livecurrencyconvertor.injection.module.NetworkModule
import mk.android.com.livecurrencyconvertor.ui.post.CurrencyLiveViewModel
import javax.inject.Singleton

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified CurrencyLiveViewModel
     * @param currencytlistviewModel   in which to inject the dependencies
     */

    fun inject(currencytlistviewModel: CurrencyLiveViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}