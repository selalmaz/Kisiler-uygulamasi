package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragment.AnaSayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context,var kisilerListesi:List<Kisiler>)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent ,false)
        return CardTasarimTutucu(binding)

    }

    override fun onBindViewHolder(holder:CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.kisiNesnesi=kisi

        // card a tıklayınca detay sayfasnıa gider
        t.CardViewSatir.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    sil(kisi.kisi_id)
                }
                .show()
        }


    }



    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    fun sil(kisi_id : Int){
        Log.e("Kişi Sil","$kisi_id silindi")
    }

}

