package com.example.dicodingsubmission_basic

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingsubmission_basic.databinding.ActivityAboutMeBinding
import com.example.dicodingsubmission_basic.databinding.ActivityMainBinding

class AboutMe : AppCompatActivity() {

    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGithub.setOnClickListener{
            val moveToGithub = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/macreai"))
            startActivity(moveToGithub)
        }

        binding.btnLinkedin.setOnClickListener{
            val moveToLinkedin = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/arda-ardiansyah-9253a71b4/"))
            startActivity(moveToLinkedin)
        }
    }
}