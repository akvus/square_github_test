package com.waysnpaths.github.common.layer.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class MyViewModel<Model> : ViewModel() {
    protected val disposables = CompositeDisposable()

    protected val modelLiveData by lazy { MutableLiveData<Model>() }

    fun getModel(): LiveData<Model> = modelLiveData

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}
