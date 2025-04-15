/*
 * Copyright 2022 The Android Open Source Project
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
import androidx.compose.runtime.State

/**
 * A functional interface for providing the state of touch exploration services. It is strongly
 * discouraged to make logic conditional based on state of accessibility services. Please consult
 * with accessibility experts before making such change.
 */
public fun interface TouchExplorationStateProvider {

    /**
     * Returns the touch exploration service state wrapped in a [State] to allow composables to
     * attach the state to itself. This will allow composables to react to change in service state,
     * if required.
     */
    @Composable
    fun touchExplorationState(): State<Boolean>
}

/**
 * The default implementation of [TouchExplorationStateProvider]. It depends on the state of
 * accessibility services to determine the current state of touch exploration services.
 */
internal expect class DefaultTouchExplorationStateProvider() : TouchExplorationStateProvider
