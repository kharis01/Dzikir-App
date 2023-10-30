package com.idn.doadzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.Model.DataDoaDzikir
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDzikirSetiapSaatBinding

class DzikirSetiapSaat : AppCompatActivity() {

    private var _binding : ActivityDzikirSetiapSaatBinding? = null

    private val  binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir)
        binding.rvDzikirSetiapSaat.adapter = mAdapter
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }



}