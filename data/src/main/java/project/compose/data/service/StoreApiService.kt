package com.example.yeongkkuel.network.service

import com.example.yeongkkuel.network.response.Response
import project.compose.data.request.store.SkinEquipRequest
import project.compose.data.request.store.SkinPurchaseRequest
import project.compose.data.response.store.ShopResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface StoreApiService {
    @PUT("api/shop/myskin")// 스킨 착용 저장 API
    suspend fun saveEquippedSkins(@Body request: SkinEquipRequest): Response<String>

    @POST("api/shop/purchase") // 스킨 구매 API
    suspend fun purchaseSkin(@Body request: SkinPurchaseRequest): Response<String>

    @GET("api/shop") // 착용 스킨 + 보유 리워드 + 상점 뷰 API 추가
    suspend fun getShopData(@Query("itemType") itemType: String): Response<ShopResponse>
}