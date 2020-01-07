package lib.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HashGenerationUtilTest {
    @Test
    fun `hashMap with multiple values correctly generates the expected hashMap`() {
        for (x in 1..6) {
            val multiple = 3
            val generatedHash = hashMapWithMultipleValues(x, multiple)
            assertEquals(multiple, generatedHash[x])
        }
    }

    @Test
    fun `hashMap can accept a hash and generate a hash with varying multiples`() {
        val generatedHash = hashMapWithMultipleValues(3, 3)
        val modifiedHash = hashMapWithMultipleValues(4, 2, generatedHash)
        assertEquals(3, generatedHash[3])
        assertEquals(3, modifiedHash[3])
        assertEquals(2, generatedHash[4]) // pass by reference, modifies the original hash
        assertEquals(2, modifiedHash[4])
    }
}
