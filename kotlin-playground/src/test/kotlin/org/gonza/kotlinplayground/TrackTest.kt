package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Track
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TrackTest {
    @Test
    fun `트랙은 랩 수를 가질 수 있다`() {
        val rap = 5
        val track = Track(rap)

        assertEquals(rap, track.rap)
    }
}