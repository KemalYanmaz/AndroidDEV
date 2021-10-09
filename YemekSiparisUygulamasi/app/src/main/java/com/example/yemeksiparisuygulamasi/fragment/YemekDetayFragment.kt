package com.example.yemeksiparisuygulamasi.fragment

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekDetayBinding
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.viewmodel.YemekDetayViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.card_tasarim.view.*
import kotlinx.android.synthetic.main.fragment_yemek_detay.view.*
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.adapter.YemekAdapter
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import com.squareup.picasso.Picasso


class YemekDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekDetayBinding
    private lateinit var viewModel:YemekDetayViewModel
    private var tempAdet=0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayNesnesi = this
        tasarim.viewModel = viewModel
        val bundle:YemekDetayFragmentArgs by navArgs()

        viewModel.yemek.value = bundle.yemek
        Log.e("yemekAdet","${bundle.yemek!!.adet}")
        tempAdet = viewModel.yemek.value!!.adet

        viewModel.sepetTutari.observe(viewLifecycleOwner,{sepetTutari->
            tasarim.sepetTutari = sepetTutari
        })

        viewModel.yemek.observe(viewLifecycleOwner,{yemek->
            tasarim.yemek=yemek
            tasarim.yemek!!.adet = yemek.adet
            viewModel.sepetTutari.value = tasarim.yemek!!.fiyat*yemek.adet.toInt()
            tasarim.tvCampaignInfo.text = yemek.adet.toString()
            tasarim.btnEksiBir.isEnabled = (yemek.adet.toInt()>=1)
            tasarim.btnEksiBes.isEnabled = (yemek.adet.toInt()>=5)
        })

        Picasso.get().load(ApiUtils.BASE_URL+ApiUtils.RESIMLER_URL+bundle.yemek.resimAd).into(tasarim.cardView.iv_urunResmi)
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekDetayViewModel by viewModels()
        viewModel = tempViewModel
    }


    override fun onPause() {
        super.onPause()
        viewModel.urunuSepeteEkle(tasarim.yemek!!)
        if(tempAdet!=tasarim.yemek!!.adet){
            if(tempAdet==0) {
                Snackbar.make(
                    tasarim.root,
                    "${tasarim.yemek!!.ad} sepete eklendi",
                    Snackbar.LENGTH_SHORT
                ).setBackgroundTint(Color.RED)
                    .show()
            }else {
                Snackbar.make(
                    tasarim.root,
                    "${tasarim.yemek!!.ad} siparişi güncellendi",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }
        }

    }
}