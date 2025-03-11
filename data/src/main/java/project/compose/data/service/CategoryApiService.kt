package com.example.yeongkkuel.network.service

import com.example.yeongkkuel.network.response.Response
import project.compose.data.request.category.CategoryRequest
import project.compose.data.response.category.CategoryListResponse
import project.compose.data.response.category.CategoryResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CategoryApiService {

    // 🔹 카테고리 목록 조회
    @GET("/api/category/categories")
    suspend fun getCategories(): Response<CategoryListResponse>

    // 🔹 특정 카테고리 조회
    @GET("/api/category/{category_id}")
    suspend fun getCategoryDetail(
        @Path("category_id") categoryId: Int
    ): Response<CategoryResponse>

    // 🔹 카테고리 추가
    @POST("/api/category")
    suspend fun addCategory(
        @Body request: CategoryRequest
    ): Response<CategoryResponse>

    // 🔹 카테고리 수정
    @PATCH("/api/category/{category_id}")
    suspend fun updateCategory(
        @Path("category_id") categoryId: Int,
        @Body request: CategoryRequest
    ): Response<CategoryResponse>

    // 🔹 카테고리 삭제
    @DELETE("/api/category/{category_id}")
    suspend fun deleteCategory(
        @Path("category_id") categoryId: Int
    ): Response<CategoryResponse>
}