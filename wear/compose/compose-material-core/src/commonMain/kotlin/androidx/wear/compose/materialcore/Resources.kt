/*
 * Copyright 2023 The Android Open Source Project
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

package androidx.wear.compose.materialcore

import androidx.annotation.RestrictTo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
fun isLayoutDirectionRtl(): Boolean {
    val layoutDirection: LayoutDirection = LocalLayoutDirection.current
    return layoutDirection == LayoutDirection.Rtl
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
expect fun isRoundDevice(): Boolean

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
expect fun isLeftyModeEnabled(): Boolean

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
fun screenHeightDp(): Int {
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    return with(density) {
        windowInfo.containerSize.height.toDp().value.roundToInt()
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
fun screenWidthDp(): Int {
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    return with(density) {
        windowInfo.containerSize.width.toDp().value.roundToInt()
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Composable
fun isSmallScreen() =
    screenWidthDp() <= SMALL_SCREEN_WIDTH_DP

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
const val SMALL_SCREEN_WIDTH_DP = 225
