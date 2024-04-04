package jlin2.examples.localtesting

import org.junit.Assert.*
import org.junit.Test

class EmailValiadatorTest {

    @Test
    fun validEmailFormatTest() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))

    }

}