import model.BaseballNumber
import model.BaseballNumberFormatException
import utils.*

private const val MAX_TRIAL = 12
private const val EXIT = "EXIT"

class GameMachine {
    fun play() {
        println("Game Start!")

        val correctAnswer = NumberUtils.generateNumber()
        var isWin = false

        for (i in 1..MAX_TRIAL) {
            print("Try $i: ")
            val input = readLine()

            if (input == EXIT) break

            val convertedBaseballNumber = convertInputString(input) ?: continue
            val result = ResultUtils.getGameResult(correctAnswer, convertedBaseballNumber)

            print("Result: ")
            if (result.isWin()) {
                println("WIN!")
                isWin = true
                break
            } else if (result.isOut()) {
                println("OUT")
            } else {
                println("${result.strikeCount}S ${result.ballCount}B")
            }
        }

        printGameOverMessage(correctAnswer, isWin)
    }

    private fun convertInputString(s: String?): BaseballNumber? {
        return try {
            NumberUtils.convertStringToNumber(s)
        } catch (e: BaseballNumberFormatException) {
            println("Invalid Input! Enter 0~9 digit only.")
            null
        }
    }

    private fun printGameOverMessage(correctAnswer: BaseballNumber, isWin: Boolean) {
        println("Correct Answer is ${correctAnswer.array[0]}${correctAnswer.array[1]}${correctAnswer.array[2]}")
        if (isWin.not()) {
            println("LOSE..")
        }
    }
}