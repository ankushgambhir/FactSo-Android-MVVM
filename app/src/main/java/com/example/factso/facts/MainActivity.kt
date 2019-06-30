package com.example.factso.facts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.factso.R
import com.example.factso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: FactsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(FactsViewModel::class.java)

        mViewModel.fact.observe(this, Observer { newFact ->
            binding.myFact = newFact
        })

        binding.buttonShowNewFact.setOnClickListener {
            mViewModel.onShowNextClick()
        }

    }
}
