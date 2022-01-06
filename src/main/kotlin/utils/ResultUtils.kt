package utils

import model.BaseballNumber
import model.GameResult

object ResultUtils {
    fun getGameResult(correctNumber: BaseballNumber, inputNumber: BaseballNumber): GameResult {
        var strikeCount = 0
        var ballCount = 0
        correctNumber.array.forEachIndexed { index, i ->
            if (inputNumber.array.contains(i)) {
                if (inputNumber.array[index] == i) {
                    strikeCount++
                } else {
                    ballCount++
                }
            }
        }
        return GameResult(strikeCount, ballCount)
    }
}