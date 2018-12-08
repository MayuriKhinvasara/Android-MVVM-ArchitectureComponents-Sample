package mk.android.com.livecurrencyconvertor

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import mk.android.com.livecurrencyconvertor.databinding.ActivityCuurencyListBinding
import mk.android.com.livecurrencyconvertor.ui.post.CurrencyLiveViewModel

class CurrencyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCuurencyListBinding
    private lateinit var viewModel: CurrencyLiveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cuurency_list)
        binding.currencyList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(CurrencyLiveViewModel::class.java)
        binding.viewModel = viewModel

    }
}
