package com.example.projectrumba

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.projectrumba.fragments.InicioFragment
import com.example.projectrumba.fragments.PlanesFragment
import com.example.projectrumba.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_menu)

            val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNav.setOnNavigationItemSelectedListener(navListener);

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, InicioFragment()).commit()
        }

        private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_home -> InicioFragment()
                R.id.nav_search -> PlanesFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> InicioFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            true
        }
}