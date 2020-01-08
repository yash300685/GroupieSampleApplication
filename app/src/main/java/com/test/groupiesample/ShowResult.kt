package com.test.groupiesample

sealed class ShowResult<Any>(val value:Any,val status:Status){
    data class Success(val result:TvUiModel):ShowResult<Any>(result,Status.SUCCESS)
    data class Failure(val exception:String):ShowResult<Any>(exception,Status.FAILURE)
    data class LOADING(val isLoading:Boolean):ShowResult<Any>(isLoading,Status.LOADING)
}