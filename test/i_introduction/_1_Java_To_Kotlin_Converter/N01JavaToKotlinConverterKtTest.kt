package i_introduction._1_Java_To_Kotlin_Converter

import org.junit.Assert.assertEquals
import org.junit.Test

class N01JavaToKotlinConverterKtTest {
    @Test fun collection() {
        assertEquals("{}", task1(listOf()))
		assertEquals("{3}", task1(listOf(3)))
        assertEquals("{1, 2, 3, 42, 555}", task1(listOf(1, 2, 3, 42, 555)))
    }
}
