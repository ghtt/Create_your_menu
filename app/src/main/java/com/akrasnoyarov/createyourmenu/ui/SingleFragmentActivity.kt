package com.akrasnoyarov.createyourmenu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.akrasnoyarov.createyourmenu.R
import com.akrasnoyarov.createyourmenu.databinding.ActivityMainBinding

abstract class SingleFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, createFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}