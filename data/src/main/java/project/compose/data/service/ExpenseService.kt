package com.example.yeongkkuel.network.service

import com.example.yeongkkuel.network.response.Response
import okhttp3.MultipartBody
import okhttp3.RequestBody
import project.compose.data.response.expense.ExpenseResponse
import project.compose.data.response.expense.ExpenseUpdateResponse
import retrofit2.http.DELETE
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ExpenseService {

    @Multipart
    @POST("/api/expense")
    suspend fun createExpense(
        @Part("request") request: RequestBody, // JSON 변환된 request 추가
        @Part expenseImage: MultipartBody.Part? // 선택적 이미지 첨부
    ): Response<ExpenseResponse>


    @Multipart
    @PATCH("/api/expense/{expenseId}")
    suspend fun updateExpense(
        @Part("expenseId") expenseId: Int,
        @Part("request") request: RequestBody,
        @Part expenseImage: MultipartBody.Part? // 파일 첨부 (선택사항)
    ): Response<ExpenseUpdateResponse>

    @DELETE("/api/expense/{expenseId}")
    suspend fun deleteExpense(
        @Path("expenseId") expenseId: Int
    ): Response<Any?> // 응답을 처리할 데이터 클래스 사용
}
