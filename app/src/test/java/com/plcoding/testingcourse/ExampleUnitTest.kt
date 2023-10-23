package com.plcoding.testingcourse

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    // Run before the test case everytime. Fresh states or classes for the tests.
    // Clear prefs, re-initialise variables
    @BeforeEach
    fun setUp() {
        // Setup code for test
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isCorrectK() {
        assertThat(2 + 2).isEqualTo(4)
        assertEquals(4, 2 + 2)
    }

    // Free up resources after tests, clear prefs. Stuff to do after the test.
    @AfterEach
    fun tearDown() {
        // TearDown code after for test
    }
}