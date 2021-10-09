package com.example.yemeksiparisuygulamasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val yemekAdetleri = HashMap<Int, Int>()
        var kullanici=""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_host_fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNav,nav_host_fragment.navController)

        val sp = getSharedPreferences("kullaniciBilgileri", Context.MODE_PRIVATE)

        val edit = sp.edit()
        edit.putString("kullaniciAdi","kemalyanmaz")
        edit.apply()

        kullanici = sp.getString("kullaniciAdi","defaultUsername").toString()
        Log.e("OKS", kullanici)

        
    }
}