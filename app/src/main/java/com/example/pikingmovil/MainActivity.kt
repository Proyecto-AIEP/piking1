package com.example.pikingmovil

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pikingmovil.databinding.MainActivityBinding
import com.google.android.material.badge.BadgeDrawable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        if(navHostFragment != null){
            navController = navHostFragment.navController
            setupActionBarWithNavController(navController)
        }
        else{
            throw RuntimeException("NavHostfragment no fun")
        }
    }
    private fun setupDestinationChangedListener(){
        navController.addOnDestinationChangedListener{_,destination,_ ->
            Log.d("MainActivity","Navigate to ${destination.label}")
            when (destination.id){
                R.id.adminFragment ->{
                    supportActionBar?.title = "Administrador"
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
                R.id.loginFragment ->{
                    supportActionBar?.title ="Homeapp"
                }
                else -> {
                    supportActionBar?.title = "login"
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.exit -> {
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }






}

