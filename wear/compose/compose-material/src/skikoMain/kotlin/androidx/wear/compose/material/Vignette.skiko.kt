/*
 * Copyright 2021 The Android Open Source Project
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
package androidx.wear.compose.material

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn

/**
 * Vignette is whole screen decoration used to blur the top and bottom of the edges of a wearable
 * screen when scrolling content is displayed. The vignette is split between a top and bottom image
 * which can be displayed independently depending on the use case.
 *
 * The vignette is designed to be used as an overlay, typically in the [Scaffold].
 *
 * Simple example of a Vignette with a [ScalingLazyColumn] as the main application content where the
 * top/bottom vignette images can be turned on/off can be found at
 *
 * @sample androidx.wear.compose.material.samples.SimpleScaffoldWithScrollIndicator
 * @param vignettePosition whether to draw top and/or bottom images for this [Vignette]
 * @param modifier optional Modifier for the root of the [Vignette]
 */
@Composable
public actual fun Vignette(
    vignettePosition: VignettePosition,
    modifier: Modifier,
) {
    // TODO: Implement this
}
