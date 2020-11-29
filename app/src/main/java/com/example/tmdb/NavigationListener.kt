package com.example.tmdb

import android.os.Bundle
import androidx.navigation.NavOptions

interface NavigationListener {
    fun navigate(resId : Int, navOptions: NavOptions)

    fun navigate(resId: Int, bundle: Bundle)

    fun navigate(resId: Int)

    fun popBackStack()
}