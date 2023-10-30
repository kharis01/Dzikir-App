package com.idn.doadzikir.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Artikel (
    val imageArtikel : Int,
    val titleArtikel : String,
    val descArtikel  : String
) : Parcelable