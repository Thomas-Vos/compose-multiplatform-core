/*
 * Copyright 2025 The Android Open Source Project
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

package androidx.compose.ui.backhandler

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.ui.ExperimentalComposeUiApi

/**
 * Object used to report back gesture progress.
 * Holds information about the touch event, swipe direction and the animation progress
 * that predictive back animations should seek to.
 */
@ExperimentalComposeUiApi
expect class BackEventCompat {

    /**
     * Absolute X location of the touch point of this event in the coordinate space of the view that
     * * received this back event.
     */
    val touchX: Float

    /**
     * Absolute Y location of the touch point of this event in the coordinate space of the view that
     * received this back event.
     */
    val touchY: Float

    /** Value between 0 and 1 on how far along the back gesture is. */
    @get:FloatRange(from = 0.0, to = 1.0)
    val progress: Float

    /** Indicates which edge the swipe starts from. */
    @get:IntRange(from = 0, to = 1)
    val swipeEdge: Int

    companion object {
        /** Indicates that the edge swipe starts from the left edge of the screen  */
        val EDGE_LEFT: Int

        /** Indicates that the edge swipe starts from the right edge of the screen  */
        val EDGE_RIGHT: Int
    }
}
