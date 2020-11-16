package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: String, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {

    fun isIncomplete(): Boolean {
        if (name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty())
            return true
        return false
    }
}