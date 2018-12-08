package mk.android.com.livecurrencyconvertor.ui.post

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mk.android.com.livecurrencyconvertor.base.BaseViewModel
import mk.android.com.livecurrencyconvertor.network.CurrencyAPI
import javax.inject.Inject

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
class CurrencyLiveViewModel : BaseViewModel(){

    @Inject
    lateinit var currencyAPI: CurrencyAPI
    private lateinit var subscription: Disposable

    init {
        loadCurrencies()
    }

    private fun loadCurrencies() {
         subscription = currencyAPI.getCurrencies("EUR")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveCurrencyListStart() }
                .doOnTerminate { onRetrieveCurrencyListFinish() }
                .subscribe(
                        { onRetrieveCurrencyListSuccess() },
                        { onRetrieveCurrencyListError() }
                )

    }

    private fun onRetrieveCurrencyListError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyListSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyListFinish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyListStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}