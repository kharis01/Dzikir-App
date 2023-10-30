package com.idn.doadzikir.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.Model.DataDoaDzikir
import com.idn.doadzikir.R
import com.idn.doadzikir.UI.Detail.ActivityDzikirPagi
import com.idn.doadzikir.UI.Detail.Dzikir_Petang_Activity
import com.idn.doadzikir.databinding.ActivityDoaDzikirHarianBinding
import com.idn.doadzikir.databinding.ActivityDzikirPagiPetangBinding

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding : ActivityDzikirPagiPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this,ActivityDzikirPagi::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this,Dzikir_Petang_Activity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }


}