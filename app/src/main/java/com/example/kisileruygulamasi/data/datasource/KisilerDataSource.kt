package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kisileriYukle(): List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"ahmet","1111")
            val k2 = Kisiler(2,"sdsf","2222")
            val k3 = Kisiler(3,"asdasd","2143")
            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)
            return@withContext kisilerListesi
            // burda olusturdugumuz verileri anasayfadan erişicez
        }

    suspend fun kaydet(kisi_ad : String,kisi_tel : String){
        Log.e("Kişi Kaydet","$kisi_ad- $kisi_tel")
    }

    suspend fun guncelle(kisi_id: Int,kisi_ad : String,kisi_tel : String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
        // en son burda güncelle işlemi oluyor
        // calısma sıralaması-> fragment--viewmodel--repository--data source
    }
    suspend fun sil(kisi_id : Int){
        Log.e("Kişi Sil","$kisi_id silindi")
    }





}