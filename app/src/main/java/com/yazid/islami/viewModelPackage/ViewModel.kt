package com.yazid.islami.viewModelPackage
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    val mutableLiveDataInt: MutableLiveData<Int> = MutableLiveData(0)

// Set a value for the MutableLiveData
   public fun IncreaseCount(){
       mutableLiveDataInt.value= mutableLiveDataInt.value?.plus(1)

   }
    public fun reset(){
        mutableLiveDataInt.value= 0

    }
}