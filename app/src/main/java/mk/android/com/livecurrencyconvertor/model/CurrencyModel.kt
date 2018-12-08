package mk.android.com.livecurrencyconvertor.model

import java.util.*

/**
 * Created by Mayuri Khinvasara on 08,December,2018
 */
data class CurrencyModel(

        val base: String,

        val date: Date,

        val rates : Double

)