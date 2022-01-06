import model.BaseballNumber
import model.BaseballNumberFormatException
import org.junit.Test
import utils.NumberUtils
import kotlin.test.assertEquals

class NumberUtilsTest {
    @Test
    fun generatedNumbersCount() {
        val number = NumberUtils.generateNumber()
        val array = number.array
        assertEquals(3, array.size)
    }

    @Test
    fun generatedNumbersRange() {
        val number = NumberUtils.generateNumber()
        val array = number.array
        assertEquals(true, array[0] in 0..9)
        assertEquals(true, array[1] in 0..9)
        assertEquals(true, array[2] in 0..9)
    }

    @Test
    fun generatedNumbersIsUnique() {
        val number = NumberUtils.generateNumber()
        val array = number.array
        assertEquals(3, array.toSet().size)
    }

    @Test(expected = BaseballNumberFormatException::class)
    fun stringConvertedNumberCountError() {
        NumberUtils.convertStringToNumber("12")
        NumberUtils.convertStringToNumber("1")
        NumberUtils.convertStringToNumber("1234")
    }

    @Test(expected = BaseballNumberFormatException::class)
    fun stringConvertedNumberTypeError() {
        NumberUtils.convertStringToNumber("")
        NumberUtils.convertStringToNumber("abc")
        NumberUtils.convertStringToNumber("12v")
    }

    @Test(expected = BaseballNumberFormatException::class)
    fun stringConvertedNumberNotUniqueError() {
        NumberUtils.convertStringToNumber("112")
        NumberUtils.convertStringToNumber("000")
    }

    @Test
    fun stringConvertedNumberCorrectCase() {
        assertEquals(BaseballNumber(arrayOf(1, 2, 3)), NumberUtils.convertStringToNumber("123"))
        assertEquals(BaseballNumber(arrayOf(3, 2, 1)), NumberUtils.convertStringToNumber("321"))
    }
}