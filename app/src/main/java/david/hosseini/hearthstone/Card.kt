package david.hosseini.hearthstone

data class Card(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
//	val faction : String?,
//  val rarity: String?,
//  val cost: Int?,
//  val attack: Int?,
//  val health: Int?,
    val text: String,
//	val flavor : String?,
//	val artist : String?,
//	val collectible : Boolean?,
//	val elite : Boolean?,
    val playerClass: String,
    val img: String?//,
//  val imgGold: String?,
//	val locale : String,
//	val mechanics : List<Mechanics>?
)

//data class Mechanics(val name: String)