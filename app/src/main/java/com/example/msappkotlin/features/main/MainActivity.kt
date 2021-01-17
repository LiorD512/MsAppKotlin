package com.example.msappkotlin.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.msappkotlin.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObservers()
    }


    private fun initObservers(){
        viewModel.navigationEvent.observe(this, Observer { navDirections ->
            handleNavigationEvent(navDirections)
        })
    }

    private fun handleNavigationEvent(navDirections: NavDirections){
//        when(navDirections){
//            is MainFragmentDirections.ActionMainToDetail -> {
                findNavController(R.id.mainScreenNavigation).navigate(navDirections)
//            }
        //todo :No need for this check, navDirections is all you need to navigate
        }

    }
