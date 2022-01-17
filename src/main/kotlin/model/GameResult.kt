package model

data class GameResult(
    val strikeCount: Int = 0,
    val ballCount: Int = 0
) {
    fun isWin(): Boolean {
        return strikeCount == 3
    }

    fun isOut(): Boolean {
        return strikeCount == 0 && ballCount == 0
    }
}
