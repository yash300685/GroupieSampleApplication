package com.test.groupiesample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class TVViewModel( repository: Repository):ViewModel() {

    val tvResult:LiveData<ShowResult<Any>> = liveData {
        emit(ShowResult.LOADING(true))
        emit(repository.getTVList())
    }
}