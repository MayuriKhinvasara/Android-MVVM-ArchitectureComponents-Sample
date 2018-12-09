package mk.android.com.livecurrencyconvertor.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mk.android.com.livecurrencyconvertor.R
import mk.android.com.livecurrencyconvertor.base.BaseViewModel
import mk.android.com.livecurrencyconvertor.model.CurrencyModel
import mk.android.com.livecurrencyconvertor.network.CurrencyAPI
import mk.android.com.livecurrencyconvertor.ui.post.adapter.CurrencyListAdapter
import javax.inject.Inject

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
class CurrencyListViewModel : BaseViewModel(){

    @Inject
    lateinit var currencyAPI: CurrencyAPI
    private lateinit var subscription: Disposable
    val currencyListAdapter: CurrencyListAdapter = CurrencyListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCurrencies() }

    init {
        loadCurrencies()
    }
    override fun onCleared() {
        super.onCleared()
        subscription.dispose();
    }


    private fun loadCurrencies() {
         subscription = currencyAPI.getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveCurrencyListStart() }
                .doOnTerminate { onRetrieveCurrencyListFinish() }
                .subscribe(
                        { result -> onRetrieveCurrencyListSuccess(result) },
                        { onRetrieveCurrencyListError() }
                )

    }

    private fun onRetrieveCurrencyListError() {
    errorMessage.value = R.string.post_error
    }


    private fun onRetrieveCurrencyListSuccess(currencyList:List<CurrencyModel>) {
        currencyListAdapter.updatePostList(currencyList)
    }

    private fun onRetrieveCurrencyListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCurrencyListStart() {
        loadingVisibility.value = View.VISIBLE;
        errorMessage.value = null
    }
}