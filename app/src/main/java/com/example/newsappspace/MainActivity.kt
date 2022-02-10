package com.example.newsappspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsappspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNav()
        listener()
    }
    private fun bottomNav(){
         navController = this.findNavController(R.id.fragmentHost)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
    private fun listener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashScreenFragment -> binding.bottomNavigationView.isVisible=false
                R.id.viewpagerHost -> binding.bottomNavigationView.isVisible=false
                R.id.newsDetailsFragment -> binding.bottomNavigationView.isVisible=false
                else -> binding.bottomNavigationView.isVisible=true
            }
        }
    }
}