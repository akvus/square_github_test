package com.waysnpaths.github_api_test.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class MyViewModel<Model>: ViewModel()  {
    protected val disposables = CompositeDisposable()

    protected val modelLiveData by lazy { MutableLiveData<Model>() }

    fun getModel(): LiveData<Model> {
        return modelLiveData
    }
    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}