package project.compose.presentation.screen.home

import java.util.Date

data class HomeUiState(
    val spendingList: List<Spending>,
    val date: Date
) {
    data class Spending(
        val categoryId: Int,
        val kind: String,
        val history: List<History>
    ) {
        data class History(
            val id: Int,
            val name: String,       // 지출 이름
            val price: Int,         // 금액
            val imgExist: String   // 사진 URL 추가
        )
    }

    companion object {
        fun init() = HomeUiState(
            spendingList = emptyList(), // 초기 상태는 빈 리스트
            date = Date()
        )
    }
}