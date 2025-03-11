package project.compose.data.response.expense


data class ExpenseResponse(
    val createdAt: String,      // 생성일
    val updatedAt: String,      // 수정일
    val id: Int,                // 지출 ID
    val day: String,            // 날짜
    val content: String,        // 지출 내용
    val amount: Int,            // 지출 금액
    val isNoSpending: Boolean,  // 무지출 여부 (API 응답 반영)
    val imageUrl: String?,      // 이미지 URL
    val isSend: Boolean         // 자동 전송 여부
)


data class ExpenseUpdateResponse(
    val createdAt: String,      // 생성일
    val updatedAt: String,      // 수정일
    val id: Int,                // 지출 ID
    val day: String,            // 날짜
    val content: String,        // 지출 내용
    val amount: Int,            // 지출 금액
    val isNoSpending: Boolean,  // 무지출 여부 (API 응답 반영)
    val imageUrl: String?,      // 이미지 URL
    val isSend: Boolean         // 자동 전송 여부
)

data class ExpenseDeleteResponse(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: Any? = null // 삭제 요청 시 반환 데이터가 없는 경우 고려
)
