package jlin2.examples.localtesting

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun validEmailFormatTest() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun invalidEmailFormatTest() {
        assertFalse(EmailValidator.isValidEmail("123@abc")) // Incorrect domain
        assertFalse(EmailValidator.isValidEmail("123@abc..com")) // Double dots
        assertFalse(EmailValidator.isValidEmail("@abc.com")) // No username
        assertFalse(EmailValidator.isValidEmail("testing123")) // No domain
        assertFalse(EmailValidator.isValidEmail("")) // Empty string
        assertFalse(EmailValidator.isValidEmail(null)) // Null
    }
}