package com.idn.doadzikir.UI.Detail

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.doadzikir.Model.Artikel
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDetailArtikelBinding

class Detail_Artikel_Activity : AppCompatActivity() {

    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

//
//    companion object {
//        const val DATA_TITLE = "title"
//        const val DATA_DESC = "data"
//        const val DATA_IMAGE = "image"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as? Artikel
        }


//       val dataTitle = intent.getStringExtra(DATA_TITLE)

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDecs.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }
        }
        
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

}

