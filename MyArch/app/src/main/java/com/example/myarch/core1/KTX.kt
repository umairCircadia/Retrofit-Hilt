package com.example.myarch.core1

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class KTX {
    inline fun <reified T : ViewModel> Fragment.viewModelsFactory(crossinline viewModelInitialization : () -> T): Lazy<T>{
        return viewModels{
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return viewModelInitialization.invoke() as T
                }
            }
        }
    }

}