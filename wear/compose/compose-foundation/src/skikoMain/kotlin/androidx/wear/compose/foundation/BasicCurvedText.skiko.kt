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

package androidx.wear.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

/**
 * [basicCurvedText] is a component allowing developers to easily write curved text following the
 * curvature a circle (usually at the edge of a circular screen). [basicCurvedText] can be only
 * created within a [CurvedLayout] since it's not a composable.
 *
 * @sample androidx.wear.compose.foundation.samples.CurvedAndNormalText
 * @param text The text to display
 * @param modifier The [CurvedModifier] to apply to this curved text.
 * @param angularDirection Specify if the text is laid out clockwise or anti-clockwise, and if those
 *   needs to be reversed in a Rtl layout. If not specified, it will be inherited from the enclosing
 *   [curvedRow] or [CurvedLayout] See [CurvedDirection.Angular].
 * @param overflow How visual overflow should be handled.
 * @param style A @Composable factory to provide the style to use. This composable SHOULDN'T
 *   generate any compose nodes.
 */
public actual fun CurvedScope.basicCurvedText(
    text: String,
    modifier: CurvedModifier,
    angularDirection: CurvedDirection.Angular?,
    overflow: TextOverflow,
    style: @Composable () -> CurvedTextStyle,
) {
    // TODO
}
