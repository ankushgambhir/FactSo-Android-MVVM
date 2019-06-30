package com.example.factso.facts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.factso.AppConstants


class FactsViewModel : ViewModel() {

    private lateinit var factList: MutableList<Facts>

    private val _fact = MutableLiveData<Facts>()
    val fact : LiveData<Facts>
        get() = _fact

    init {
        resetList()
        _fact.value = factList.removeAt(AppConstants.ZERO_INDEX)
    }

    /**
     * Create and shuffle the list
     *
     */
    private fun resetList(){
        factList = mutableListOf<Facts>(
            Facts("Ants work 24 * 7 till the day they die ", "Wow"),
            Facts("Jupiter has 79 Moons", "Awesome"),
            Facts("Art was offical discipline of Olympics", "Nice"),
            Facts("10% of all the photos in the world are taken in last 12 months", "No doubt"),
            Facts("Most diamonds are at least 3 billion years old", "Ohh! show me more"),
            Facts("Summer on Neptune is 40 years long", "Cool"))

        factList.shuffle()
    }

    /**
     * Displays next quote on next button click
     *
     */
     fun onShowNextClick(){
        if(factList.isEmpty()){
            resetList()
        }
        _fact.value = factList.removeAt(AppConstants.ZERO_INDEX)
    }
}