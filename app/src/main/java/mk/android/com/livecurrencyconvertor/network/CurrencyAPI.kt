package mk.android.com.livecurrencyconvertor.network

import io.reactivex.Observable
import mk.android.com.livecurrencyconvertor.model.CurrencyModel
import retrofit2.http.GET

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
interface CurrencyAPI {
    @GET("/posts")
    fun getPosts(): Observable<List<CurrencyModel>>

}