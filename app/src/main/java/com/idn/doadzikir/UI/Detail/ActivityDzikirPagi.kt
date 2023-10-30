package com.idn.doadzikir.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.Model.DataDoaDzikir
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDzikirPagiBinding
import com.idn.doadzikir.databinding.ActivityDzikirPagiPetangBinding

class ActivityDzikirPagi : AppCompatActivity() {

    private var _binding : ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

}