package com.example.bottomnavigation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView
            .setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, HomeFragment()).commit()
                        return@setOnItemSelectedListener true
                    }
                    R.id.info -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.frameLayout, AboutFragment()).commit()
                        return@setOnItemSelectedListener true
                    }
                    R.id.share -> {
                        ShareCompat.IntentBuilder.from(this)
                            .setType("text/plain")
                            .setChooserTitle("Chooser title")
                            .setText("http://play.google.com/store/apps/details?id=" + this.packageName)
                            .startChooser();
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
    }
}