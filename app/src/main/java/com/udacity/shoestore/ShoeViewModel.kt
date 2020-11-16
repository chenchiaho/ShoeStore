package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    var shoeItem: Shoe? = null
    private var shoes = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _formIncomplete = MutableLiveData<Boolean>()
    val formIncomplete: LiveData<Boolean>
        get() = _formIncomplete

    private val _detailReturnToList = MutableLiveData<Boolean>()
    val detailReturnToList: LiveData<Boolean>
        get() = _detailReturnToList


    fun addShoe() {
        shoeItem?.let { shoe ->
            if (shoe.isIncomplete()) {
                _formIncomplete.value = true
            } else {
                shoes.add(shoe)
                returnToList()
                _shoeList.value = shoes

            }

        }
    }
    fun returnToList() {
        _detailReturnToList.value = true
    }

    fun clearInventory() {
        shoes.clear()
    }
}