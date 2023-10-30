package com.idn.doadzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.Adapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadzikir.Adapter.ArtikelAdapter
import com.idn.doadzikir.Model.Artikel
import com.idn.doadzikir.UI.Detail.Detail_Artikel_Activity
import com.idn.doadzikir.UI.DoaDzikirHarian
import com.idn.doadzikir.UI.DzikirPagiPetangActivity
import com.idn.doadzikir.UI.DzikirSetiapSaat
import com.idn.doadzikir.UI.QauliyahSholatActivity
import com.idn.doadzikir.Utills.OnItemCallBack
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private var keep = true
    private val runner = Runnable { keep = false }

    private val listArtikel : ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for ( i in 0 until listArtikel.size){
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.dot_inactive)
                )
            }
            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.dot_active)
            )
        }
    }

    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array<ImageView?>

//    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
            .setKeepOnScreenCondition { keep }
        Handler().postDelayed(runner, 1280)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()

    }

    private fun setupViewPager() {
        val llsliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size){
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,R.drawable.dot_inactive
                )
            )

            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            param.setMargins(9, 0,8,0)

            param.gravity = Gravity.CENTER_VERTICAL
            llsliderDots.addView(sliderIndicator[i], param)
        }

        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,R.drawable.dot_active
            )
        )

    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val contentArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (i in titleArtikel.indices) {
            val data = Artikel(
                imageArtikel.getResourceId(i, 0),
                titleArtikel[i],
                contentArtikel[i]
            )
            listArtikel.add(data)

        }
        imageArtikel.recycle()
    }

    private fun initView() {
        val llDzikirDoaSholat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaSholat.setOnClickListener {
            startActivity(Intent(this, QauliyahSholatActivity::class.java))
        }

        val llDzikirSetiapSaat: LinearLayout = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, DzikirSetiapSaat::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, DoaDzikirHarian::class.java))
        }

        val llDzikirPagiPetang: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, DzikirPagiPetangActivity::class.java))
        }

        vpArtikel =  findViewById(R.id.vp_artikel)
        val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter

        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        mAdapter.setOnItemClickCallBack(object : OnItemCallBack{
            override fun onItemClicked(item: Artikel) {
                val intent = Intent(this@MainActivity,Detail_Artikel_Activity::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }
        })
    }

}