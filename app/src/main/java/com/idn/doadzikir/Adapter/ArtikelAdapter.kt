package com.idn.doadzikir.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadzikir.Model.Artikel
import com.idn.doadzikir.Utills.OnItemCallBack
import com.idn.doadzikir.databinding.ItemArtikelBinding

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArticleViewHolder> () {

    private var listArticle = ArrayList<Artikel>()
    private var onItemCallBack : OnItemCallBack? = null

    fun setData(list: List<Artikel>){
        listArticle.clear()
        listArticle.addAll(list)
    }

    fun setOnItemClickCallBack(onItemCallBack: OnItemCallBack) {
        this.onItemCallBack = onItemCallBack
    }


    inner class ArticleViewHolder(val view:ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent,false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemCallBack?.onItemClicked(data)
        }
    }

}