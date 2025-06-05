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

package androidx.wear.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.Navigator
import androidx.wear.compose.navigation.WearNavigator.Destination
import kotlinx.coroutines.flow.StateFlow

/**
 * Navigator that navigates through [Composable]s. Every destination using this Navigator must set a
 * valid [Composable] by setting it directly on an instantiated [Destination] or calling
 * [composable].
 */
public expect class WearNavigator() : Navigator<WearNavigator.Destination> {
    /** Get the map of transitions currently in progress from the [state]. */
    internal val transitionsInProgress: StateFlow<Set<NavBackStackEntry>>

    /** Get the back stack from the [state]. */
    internal val backStack: StateFlow<List<NavBackStackEntry>>

    /** Indicates if an entry is being popped from [backStack]. */
    internal val isPop: MutableState<Boolean>

    override fun createDestination(): Destination

    internal fun onTransitionComplete(entry: NavBackStackEntry)

    /** NavDestination specific to [WearNavigator] */
    public class Destination(
        navigator: WearNavigator,
        content: @Composable (NavBackStackEntry) -> Unit
    ) : NavDestination {
        internal val content: @Composable (NavBackStackEntry) -> Unit
    }

    internal companion object {
        internal val NAME: String
    }
}
