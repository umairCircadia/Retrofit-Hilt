package com.circadia.cpro_2.core

sealed class UIState<T> {
    class IsLoading<T:Any> : UIState<T>()
    class Success<T : Any>(val data: T) : UIState<T>()
    class Error<T : Any>(val message: String?) : UIState<T>()
}
