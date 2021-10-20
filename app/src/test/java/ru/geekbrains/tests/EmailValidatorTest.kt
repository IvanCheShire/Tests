package ru.geekbrains.tests

import org.junit.Assert
import org.junit.Test
import ru.geekbrains.tests.ui.EmailValidator

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }
    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        fun emailValidator_InvalidEmailNoPointAndTld_ReturnsFalse() {
            Assert.assertFalse(EmailValidator.isValidEmail("name@email"))
        }

        @Test
        fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
            Assert.assertFalse(EmailValidator.isValidEmail("name@email..com"))
        }
        @Test
        fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
            Assert.assertFalse(EmailValidator.isValidEmail("@email.com"))
        }
        @Test
        fun emailValidator_EmptyString_ReturnsFalse() {
            Assert.assertFalse(EmailValidator.isValidEmail(""))
        }
        @Test
        fun emailValidator_NullEmail_ReturnsFalse() {
            Assert.assertFalse(EmailValidator.isValidEmail(null))
        }

        @Test
        fun emailValidator_InvalidEmailNoDomainName_ReturnsFalse(){
            Assert.assertFalse(EmailValidator.isValidEmail("name@"))
        }

        @Test
        fun emailValidator_InvalidEmailNoAtSign_ReturnsFalse(){
            Assert.assertFalse(EmailValidator.isValidEmail("nameemail.com"))
        }

        @Test
        fun emailValidator_InvalidEmailNoTld_ReturnsFalse(){
            Assert.assertFalse(EmailValidator.isValidEmail("name@email."))
        }
    }