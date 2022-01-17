package utils

import model.BaseballNumberFormatException
import model.BaseballNumber
import kotlin.random.Random
import kotlin.random.nextInt

private const val NUMBER_COUNT = 3
private val NUMBER_RANGE = 0..9

object NumberUtils {
    fun generateNumber(): BaseballNumber {
        val array = Array(NUMBER_COUNT) { -1 }
        for (i in 0 until NUMBER_COUNT) {
            while (true) {
                val random = Random.nextInt(NUMBER_RANGE)
                if (!array.contains(random)) {
                    array[i] = random
                    break
                }
            }
        }
        return BaseballNumber(array)
    }

    fun convertStringToNumber(s: String?): BaseballNumber {
        if (s.isNullOrEmpty() || s.length != NUMBER_COUNT) {
            throw BaseballNumberFormatException()
        }

        val array = Array(NUMBER_COUNT) { -1 }

        s.forEachIndexed { index, c ->
            if (c.isDigit().not()) {
                throw BaseballNumberFormatException()
            }
            val number = c.digitToIntOrNull() ?: throw BaseballNumberFormatException()
            if (array.contains(number) || number !in NUMBER_RANGE) {
                throw BaseballNumberFormatException()
            }

            array[index] = c.digitToInt()
        }

        return BaseballNumber(array)
    }
}