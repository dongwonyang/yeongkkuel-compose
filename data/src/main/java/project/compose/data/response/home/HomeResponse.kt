package project.compose.data.response.home

data class HomeResponse(
    val myReward: Int, // 보유 리워드
    val mySkin: List<MySkin>, // 보유한 스킨 리스트
    val today: String, // 오늘 날짜
    val categories: List<HomeCategoryResponse> //  기존 List<Category> → List<CategoryResponse> 로 변경!
)

data class HomeCategoryResponse(
    val categoryId: Int,
    val categoryName: String,
    val expenses: List<Expense>
)
data class MySkin(
    val itemName: String,
    val itemType: String,
    val imgUrl: String
)

data class Category(
    val categoryId: Int, // 카테고리 ID 추가
    val categoryName: String,
    val expenses: List<Expense>
)

data class Expense(
    val expenseId: Int,
    val content: String,
    val amount: Int,
    val imgExist: Boolean,
    val imgUrl: String
)