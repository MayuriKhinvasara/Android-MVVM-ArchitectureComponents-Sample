package mk.android.com.livecurrencyconvertor.network

import io.reactivex.Observable
import mk.android.com.livecurrencyconvertor.model.CurrencyModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
interface CurrencyAPI {
    @GET("latest")
    fun getCurrencies(
            @Query("base") base : String
        //  ,  @Query("amount") amount : Double

    ): Observable<List<CurrencyModel>>



}