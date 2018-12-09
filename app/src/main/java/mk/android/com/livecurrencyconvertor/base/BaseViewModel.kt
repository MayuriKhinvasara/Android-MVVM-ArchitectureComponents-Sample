package mk.android.com.livecurrencyconvertor.base

import android.arch.lifecycle.ViewModel
import mk.android.com.livecurrencyconvertor.injection.module.NetworkModule
import mk.android.com.livecurrencyconvertor.injection.module.component.DaggerViewModelInjector
import mk.android.com.livecurrencyconvertor.injection.module.component.ViewModelInjector
import mk.android.com.livecurrencyconvertor.ui.post.CurrencyListViewModel

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
abstract class BaseViewModel : ViewModel(){
    private val injector:ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init{
        inject()
    }

    private fun inject()
    {
        when(this){
            is CurrencyListViewModel -> injector.inject(this)
        }
    }

}