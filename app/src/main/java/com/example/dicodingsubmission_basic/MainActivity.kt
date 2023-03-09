package com.example.dicodingsubmission_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingsubmission_basic.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCharacters: RecyclerView
    private val list = ArrayList<Characters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.darkLight.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }

        binding.aboutPage.setOnClickListener {
            val moveAbtMe = Intent(this@MainActivity,AboutMe::class.java)
            startActivity(moveAbtMe)
        }

        rvCharacters = findViewById(R.id.rv_chara)
        rvCharacters.setHasFixedSize(true)


        list.addAll(getListChara())
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listCharaAdapter = ListCharaAdapter(list)
        rvCharacters.adapter = listCharaAdapter
    }

    private fun getListChara(): ArrayList<Characters> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNation = resources.getStringArray(R.array.data_nation)
        val dataCons = resources.getStringArray(R.array.data_cons)
        val dataWeapon = resources.getStringArray(R.array.data_weapon)
        val dataOccupation = resources.getStringArray(R.array.data_occupation)
        val listChara = ArrayList<Characters>()
        for (i in dataName.indices){
            val chara = Characters(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1),
                dataNation[i], dataCons[i], dataWeapon[i], dataOccupation[i])
            listChara.add(chara)
        }
        return listChara
    }
}