package mk.android.com.livecurrencyconvertor.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import mk.android.com.livecurrencyconvertor.network.CurrencyAPI
import mk.android.com.livecurrencyconvertor.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule{
    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */


    @Provides
    @Reusable
    @JvmStatic

internal fun provideCurrencyAPI(retrofit: Retrofit) : CurrencyAPI{
        return retrofit.create(CurrencyAPI::class.java)
    }


/**
 * Provides the Retrofit object.
 * @return the Retrofit object
 */
@Provides
@Reusable
@JvmStatic
internal fun provideRetrofitInterface(): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
}
}
