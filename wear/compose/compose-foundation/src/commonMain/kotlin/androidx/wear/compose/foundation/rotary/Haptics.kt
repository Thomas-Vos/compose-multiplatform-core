/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.wear.compose.foundation.rotary

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlin.jvm.JvmInline
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

/** Handles haptics for rotary usage */
interface RotaryHapticHandler {

    /** Handles haptics when scroll is used */
    fun handleScrollHaptic(timestamp: Long, deltaInPixels: Float, inputDeviceId: Int, axis: Int)

    /** Handles haptics when scroll with snap is used */
    fun handleSnapHaptic(timestamp: Long, deltaInPixels: Float, inputDeviceId: Int, axis: Int)

    /** Handles haptics when edge of the list is reached */
    fun handleLimitHaptic(isStart: Boolean, inputDeviceId: Int, axis: Int)
}

@Composable
internal expect fun rememberRotaryHapticHandler(
    scrollableState: ScrollableState,
    hapticsEnabled: Boolean,
): RotaryHapticHandler

/** Rotary haptic types */
@JvmInline
@VisibleForTesting
internal value class RotaryHapticsType(private val type: Int) {
    companion object {

        /**
         * A scroll ticking haptic. Similar to texture haptic - performed each time when a
         * scrollable content is scrolled by a certain distance
         */
        public val ScrollTick: RotaryHapticsType = RotaryHapticsType(1)

        /**
         * An item focus (snap) haptic. Performed when a scrollable content is snapped to a specific
         * item.
         */
        public val ScrollItemFocus: RotaryHapticsType = RotaryHapticsType(2)

        /**
         * A limit(overscroll) haptic. Performed when a list reaches the limit (start or end) and
         * can't scroll further
         */
        public val ScrollLimit: RotaryHapticsType = RotaryHapticsType(3)
    }
}

/** Remember disabled haptics handler */
@Composable
internal fun rememberDisabledRotaryHapticHandler(): RotaryHapticHandler = remember {
    object : RotaryHapticHandler {
        override fun handleScrollHaptic(
            timestamp: Long,
            deltaInPixels: Float,
            inputDeviceId: Int,
            axis: Int,
        ) {
            // Do nothing
        }

        override fun handleSnapHaptic(
            timestamp: Long,
            deltaInPixels: Float,
            inputDeviceId: Int,
            axis: Int,
        ) {
            // Do nothing
        }

        override fun handleLimitHaptic(isStart: Boolean, inputDeviceId: Int, axis: Int) {
            // Do nothing
        }
    }
}

/**
 * Throttling events within specified timeframe. Only first and last events will be received.
 *
 * For example, a flow emits elements 1 to 30, with a 100ms delay between them:
 * ```
 * val flow = flow {
 *     for (i in 1..30) {
 *         delay(100)
 *         emit(i)
 *     }
 * }
 * ```
 *
 * With timeframe=1000 only those integers will be received: 1, 10, 20, 30 .
 */
@VisibleForTesting
internal fun <T> Flow<T>.throttleLatest(timeframe: Long): Flow<T> = flow {
    conflate().collect {
        emit(it)
        delay(timeframe)
    }
}
