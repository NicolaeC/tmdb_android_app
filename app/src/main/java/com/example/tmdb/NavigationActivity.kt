package com.example.tmdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController

class NavigationActivity : AppCompatActivity(), NavigationListener {
    private val navigationController by lazy { findNavController(R.id.navigation_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_navigation)
    }

    override fun navigate(resId: Int, navOptions: NavOptions) {
        navigationController.navigate(resId, null, navOptions)
    }

    override fun navigate(resId: Int, bundle: Bundle) {
        navigationController.navigate(resId, bundle)
    }

    override fun navigate(resId: Int) {
        navigationController.navigate(resId)
    }

    override fun popBackStack() {
        navigationController.popBackStack()
    }
}