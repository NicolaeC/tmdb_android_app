package com.example.tmdb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected lateinit var navigationListener: NavigationListener

    abstract fun getLayoutResId(): Int

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigationListener = context as NavigationListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }
}