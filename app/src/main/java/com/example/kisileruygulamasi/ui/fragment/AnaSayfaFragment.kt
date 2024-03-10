package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)
        binding.anaSayfaFragment = this
        binding.anaSayfaToolbarBaslik="Kişiler"

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter= kisilerAdapter


        }



        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                // fu fonk harf girdikce harf yazdıkca bize sonuc getiren fonk
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
               // arama ikonuna bastıgımzada bize sonuc getiren fonk
                viewModel.ara(query)
                return true
            }

        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
        // direk init edemedigimiz icin tempviewmodeli olusturup yaptık

    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }

    override fun onResume() {
        // sayfanın gorundugunuz algıladımız metotumuz
        // bir yeni kayıt yapıp tekrar anasayfaya döngümüzde son ekledigimiz de gozuksun diye yaptıuk
        super.onResume()
        viewModel.kisileriYukle()
    }


}