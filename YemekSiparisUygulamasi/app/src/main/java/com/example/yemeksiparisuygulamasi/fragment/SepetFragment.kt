package com.example.yemeksiparisuygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.adapter.SepetAdapter
import com.example.yemeksiparisuygulamasi.adapter.YemekAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentSepetBinding
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.viewmodel.AnasayfaViewModel
import com.example.yemeksiparisuygulamasi.viewmodel.SepetViewModel
import kotlinx.android.synthetic.main.fragment_sepet.view.*
import java.util.*

class SepetFragment : Fragment() {
    private lateinit var adapter: SepetAdapter
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel:SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)
        tasarim.sepetFragmentNesnesi = this
        viewModel.yemekleriGetir()
        viewModel.sepettekiUrunlerListesi.observe(viewLifecycleOwner,{yemekListesi->
            Log.e("HATA16","${yemekListesi.toString()} sd")
            adapter = SepetAdapter(requireContext(), ArrayList(yemekListesi.values),viewModel)
            tasarim.sepetAdapter = adapter
        })

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel =tempViewModel
    }

}