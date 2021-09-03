package com.example.odev5

import android.os.Bundle
import android.transition.Slide
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_siparis.*
import kotlinx.android.synthetic.main.fragment_siparis.view.*

class Siparis_Fragment : Fragment() {
    private lateinit var tasarim:View;
    private lateinit var slideAdapter: SliderCampaignAdapter
    private lateinit var slideList:ArrayList<SliderCampaign>
    private lateinit var categoryAdapter:CategoryAdapter
    private lateinit var categoryList:ArrayList<Category>
    private lateinit var productDiscountAdapter:ProductWithDiscountAdapter
    private lateinit var productWithDiscountList:ArrayList<ProductWithDiscount>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = inflater.inflate(R.layout.fragment_siparis, container, false)

        slideList = ArrayList()

        slideList.add(SliderCampaign("kampanya"))
        slideList.add(SliderCampaign("kampanya2"))
        slideList.add(SliderCampaign("kampanya3"))

        slideAdapter = SliderCampaignAdapter(requireContext(),slideList)
        tasarim.vp_advertisement.adapter = slideAdapter

        tasarim.rv_category.layoutManager = StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL)

        categoryList = ArrayList()

        categoryList.add(Category("Su","water"))
        categoryList.add(Category("Meyve","lemon"))
        categoryList.add(Category("Kahvaltılık","kahvaltilik"))
        categoryList.add(Category("Atıştırma","cikolata"))
        categoryList.add(Category("İçecek","cola"))
        categoryList.add(Category("Yiyecek","cornet"))
        categoryList.add(Category("Evcil Hayvan","evcilhayvan"))
        categoryList.add(Category("Temel Gıda","ekmek"))
        categoryList.add(Category("Ev Bakım","deterjan"))
        categoryList.add(Category("Donuk","donuk"))
        categoryList.add(Category("Teknoloji","bilgisayar"))
        categoryList.add(Category("Giyim","giyim"))
        categoryList.add(Category("Kişisel Bakım","bakim"))

        categoryAdapter = CategoryAdapter(requireContext(),categoryList)
        tasarim.rv_category.adapter = categoryAdapter


        tasarim.rv_product.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        productWithDiscountList = ArrayList()

        productWithDiscountList.add(ProductWithDiscount("Cornetto","cornet",7.50,6.50))
        productWithDiscountList.add(ProductWithDiscount("Erikli Damacana","water",15.50,14.95))
        productWithDiscountList.add(ProductWithDiscount("Kedi Maması","kedimamasi",19.21,17.20))
        productWithDiscountList.add(ProductWithDiscount("Gofret","gofret",2.25,1.75))
        productWithDiscountList.add(ProductWithDiscount("CocaCola","cocacola",9.95,7.75))
        productWithDiscountList.add(ProductWithDiscount("Burçak","burcak",2.75,2.15))
        productWithDiscountList.add(ProductWithDiscount("Ruffles","cips",8.00,6.95))

        productDiscountAdapter = ProductWithDiscountAdapter(requireContext(),productWithDiscountList)
        tasarim.rv_product.adapter = productDiscountAdapter


        tasarim.tv_firsatReyonu.text = "Fırsat Reyonu(${productWithDiscountList.size} Ürün)"
        return tasarim
    }

}