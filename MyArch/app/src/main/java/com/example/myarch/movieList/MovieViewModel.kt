package com.example.myarch.movieList

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.circadia.cpro_2.core.NetworkResult
import com.example.myarch.core1.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    private var _movieLiveData = MutableStateFlow<List<Result>>(arrayListOf())
    val movieLiveData: StateFlow<List<Result>> = _movieLiveData

    private var _errorFlow = MutableStateFlow<String>("")
    val errorFlow: Flow<String> = _errorFlow


    fun getPopularMovies() {
        viewModelScope.launch {
            when (val response = repository.getMoviesList()) {
                is NetworkResult.Success -> {
                    _movieLiveData.emit(response.data.results)
                }

                is NetworkResult.Error -> { _errorFlow.emit("${response.code}  ${response.message}")  }
                is NetworkResult.Exception -> { _errorFlow.emit(response.e.message.toString())  }
            }
        }
    }
}
