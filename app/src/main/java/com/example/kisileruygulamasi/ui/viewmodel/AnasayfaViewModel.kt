package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel :ViewModel(){
    var krepo = KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    // live data olusturduk veri tabanından gelen verileri tutucak

    init {  // init demek bu class yani anasayfa viewmodel clasi olustugunu anda
            // kisileri yukle fonku calıssın yoksa veriler yuklenmez
        kisileriYukle()
    }

     fun sil(kisi_id : Int){
         CoroutineScope(Dispatchers.Main).launch {
             krepo.sil(kisi_id)
         }
    }

     fun kisileriYukle(){
         CoroutineScope(Dispatchers.Main).launch {
             kisilerListesi.value = krepo.kisileriYukle()
         }
     }




}