package project.compose.data.request.category

import com.google.gson.annotations.SerializedName

data class CategoryRequest(
    @SerializedName("categoryName") val name: String,  // 카테고리 이름
    @SerializedName("red") val red: Int,               // RGB 값
    @SerializedName("green") val green: Int,           // RGB 값
    @SerializedName("blue") val blue: Int,             // RGB 값
)