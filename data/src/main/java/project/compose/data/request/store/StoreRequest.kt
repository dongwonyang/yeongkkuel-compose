package project.compose.data.request.store

data class SkinEquipRequest(
    val userItem: List<SkinEquipItem>
)

data class SkinEquipItem(
    val purchaseId: Int
)

data class SkinPurchaseRequest(
    val itemId: Int,
    val itemType: String,
    val itemName: String,
    val reward: Int
)

