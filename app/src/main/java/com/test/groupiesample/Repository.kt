package com.test.groupiesample

interface Repository {

    suspend fun getTVList():ShowResult<Any>
}