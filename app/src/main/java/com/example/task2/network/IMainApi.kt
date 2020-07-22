package com.example.task2.network

import com.example.task2.network.IMainApi.Companion.TEAM_PATH
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IMainApi {

    @GET(TEAM_PATH)
    fun getTeams(): Single<TeamsResponse>

    companion object {
        const val TEAM_PATH = "teams/"
    }

}