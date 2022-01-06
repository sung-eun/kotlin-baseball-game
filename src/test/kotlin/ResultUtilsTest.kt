import model.BaseballNumber
import model.GameResult
import org.junit.Test
import utils.ResultUtils
import kotlin.test.assertEquals

class ResultUtilsTest {
    @Test
    fun gameResultWin() {
        assertEquals(
            GameResult(3, 0),
            ResultUtils.getGameResult(BaseballNumber(arrayOf(1, 2, 3)), BaseballNumber(arrayOf(1, 2, 3)))
        )
    }

    @Test
    fun gameResultOut() {
        assertEquals(
            GameResult(0, 0),
            ResultUtils.getGameResult(BaseballNumber(arrayOf(4, 5, 6)), BaseballNumber(arrayOf(1, 2, 3)))
        )
    }

    @Test
    fun gameResultNormal() {
        assertEquals(
            GameResult(2, 0),
            ResultUtils.getGameResult(BaseballNumber(arrayOf(1, 2, 6)), BaseballNumber(arrayOf(1, 2, 3)))
        )
        assertEquals(
            GameResult(1, 1),
            ResultUtils.getGameResult(BaseballNumber(arrayOf(1, 3, 6)), BaseballNumber(arrayOf(1, 2, 3)))
        )
        assertEquals(
            GameResult(0, 2),
            ResultUtils.getGameResult(BaseballNumber(arrayOf(3, 5, 1)), BaseballNumber(arrayOf(1, 2, 3)))
        )
    }
}