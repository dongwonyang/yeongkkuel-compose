package com.example.yeongkkuel.network.service

import com.example.yeongkkuel.network.response.Response
import project.compose.data.response.home.HomeResponse
import project.compose.data.response.home.RewardResponse
import retrofit2.http.GET

interface HomeApiService {
    @GET("api/home") // 홈 화면 데이터 조회 API
    suspend fun getHomeData(): Response<HomeResponse>

    @GET("/api/reward/yesterday")
    suspend fun getYesterdayReward(): Response<RewardResponse>
}
