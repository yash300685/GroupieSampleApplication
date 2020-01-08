package com.test.groupiesample

class RepositoryImpl(val networkAPI: NetworkAPI):Repository {
    override suspend fun getTVList(): ShowResult<Any> {

        try {
           return ShowResult.Success(networkAPI.getTvShows().toTVUIMOdel())
        }
      catch (e:Exception)
      {
         return ShowResult.Failure(e.toString())
      }


    }
}