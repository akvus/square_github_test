package com.waysnpaths.github.common.view.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

operator fun CompositeDisposable.plusAssign(disposable: Disposable?) {
    disposable?.let { add(disposable) }
}
