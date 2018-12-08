package mk.android.com.livecurrencyconvertor.base

import io.reactivex.disposables.Disposable
import mk.android.com.livecurrencyconvertor.network.CurrencyAPI
import javax.inject.Inject

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
class CurrencyListViewModel:BaseViewModel() {
    @Inject
    lateinit var currencyAPI: CurrencyAPI

    private lateinit var subscription: Disposable

    override fun onCleared() {
        super.onCleared()
        subscription.dispose();

    }
}