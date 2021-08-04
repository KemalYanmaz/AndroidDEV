package com.example.homework2

fun main() {
    println(UcretHesapla(100))
}

fun DerecedenFahreneit(derece:Double):Double{
    return derece*1.8+32
}

fun DikdortgeninCevresi(uzunKenar:Double,kisaKenar:Double){
    println("Uzun kenar:$uzunKenar, Kısa Kenar:$kisaKenar\nÇevresi: ${2*(uzunKenar+kisaKenar)}")
}

fun faktoriyel(sayi:Int):Int{
    if(sayi==1){
        return 1
    }
    return sayi* faktoriyel(sayi)
}

fun harfSayisiBul(kelime:String,harf:Char){
    var sayi = 0
    for(h in kelime){
        if(h==harf){
            sayi+=1
        }
    }
    println("$kelime kelimesinde $sayi tane $harf harfi vardır.")
}

fun CokgeninIcAcisi(kenarSayisi:Int):Int{
    return (kenarSayisi-2)*180
}

fun MaasHesapla(gun:Int):Int{
    val saatlikUcret = 10
    val mesaiUcreti = 20
    var maas = 0
    val calisilanSaat = gun*8
    if(calisilanSaat>160){
        val mesai = calisilanSaat-160
        maas = 160*saatlikUcret + mesai*mesaiUcreti
    }else{
        maas = calisilanSaat*10
    }

    return maas
}

fun UcretHesapla(kota:Int):Int{
    var ucret = 100

    if(kota>50){
        ucret+=(kota-50)*4
    }
    return ucret
}