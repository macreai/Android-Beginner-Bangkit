package com.example.dicodingsubmission_basic

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingsubmission_basic.databinding.ActivityDetailBinding
import com.example.dicodingsubmission_basic.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    companion object {
        const val EXTRA_CHARACTER = "extra_character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chara = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_CHARACTER, Characters::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CHARACTER)
        }

        if (chara != null){
            binding.imgItemPhoto.setImageResource(chara.photo)
            binding.tvItemName.text = chara.name
            binding.tvItemDescription.text = chara.desc
            binding.tvNation.text = chara.nation
            binding.tvCons.text = chara.constellation
            binding.tvWeapon.text = chara.weapon
            binding.tvOccupation.text = chara.occupation
        }

        binding.actionShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Share Character")
                putExtra(Intent.EXTRA_TEXT, "Look at this character!")
            }
            startActivity(Intent.createChooser(intent, "SHARE"))
        }

    }
}