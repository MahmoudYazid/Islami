package com.yazid.islami

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yazid.islami.fragments.MyProfileFragment
import com.yazid.islami.fragments.ahadeth_fragment
import com.yazid.islami.fragments.quran_fragment
import com.yazid.islami.fragments.radio_fragment
import com.yazid.islami.fragments.sebha_fragment

class FragmentContainterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragment_containter)
        val quranfragmentActivity= quran_fragment()
        val RadiofragmentActivity= radio_fragment()
        val sebhafragmentActivity= sebha_fragment()
        val ahadethfragmentActivity= ahadeth_fragment()
        val MyProfileFragmentActivity= MyProfileFragment()

        val NavigationBtms = findViewById<BottomNavigationView>(R.id.navigationView)
        supportFragmentManager.beginTransaction().

        replace(R.id.FragmentContainer,quranfragmentActivity)
            .commit()

        NavigationBtms.setOnItemSelectedListener {
            item->
            when(item.itemId){
                R.id.menu_item_1->{
                    supportFragmentManager.beginTransaction().
                    replace(R.id.FragmentContainer,RadiofragmentActivity)
                    .commit()
                    true


                }
                R.id.menu_item_2->{
                    supportFragmentManager.beginTransaction().

                    replace(R.id.FragmentContainer,sebhafragmentActivity)
                   .commit()
                    true
                }
                R.id.menu_item_3->{
                    supportFragmentManager.beginTransaction().

                    replace(R.id.FragmentContainer,ahadethfragmentActivity)
                    .commit()
                    true
                }

                R.id.menu_item_4->{
                    supportFragmentManager.beginTransaction().

                    replace(R.id.FragmentContainer,quranfragmentActivity)
                    .commit()
                    true
                }
                R.id.menu_item_5->{
                    val Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mahmoudyazid/"))
                    startActivity(Intent)
                    true
                }
                else -> {
                true
                }
            }
        }









    }

    public fun ChangeToQuranFragment(FragmentTrans:FragmentManager,quranfragmentActivity:Any){

    }
}