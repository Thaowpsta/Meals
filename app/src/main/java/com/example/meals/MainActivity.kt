package com.example.meals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.meals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private val phoneNumber = "tel:+201000000000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = fragHost.navController

        setupWithNavController(binding.bottomNavigation, navController)

        binding.floatingActionButton.setOnClickListener {
            openDialer()
        }

    }
    private fun openDialer() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(phoneNumber)
        startActivity(intent)
    }
}