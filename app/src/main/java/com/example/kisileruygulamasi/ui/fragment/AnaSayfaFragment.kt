package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasi.ui.Adapter.KisilerAdapter

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)

        binding.anaSayfaFragment = this
        binding.anaSayfaToolbarBaslik="Kişiler"



        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"ahmet","1111")
        val k2 = Kisiler(2,"sdsf","2222")
        val k3 = Kisiler(3,"asdasd","2143")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)


        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerAdapter= kisilerAdapter




        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                // fu fonk harf girdikce harf yazdıkca bize sonuc getiren fonk
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
               // arama ikonuna bastıgımzada bize sonuc getiren fonk
                ara(query)
                return true
            }

        })





        return binding.root
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }


    fun ara(aramaKelime :String){
        Log.e("Kişi Ara",aramaKelime)
    }

}