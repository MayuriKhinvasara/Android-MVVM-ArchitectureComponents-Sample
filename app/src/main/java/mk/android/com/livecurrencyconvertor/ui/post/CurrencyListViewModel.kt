package mk.android.com.livecurrencyconvertor.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
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
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        subscription.dispose();
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
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyListSuccess() {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCurrencyListStart() {
        loadingVisibility.value = View.VISIBLE;
    }
}