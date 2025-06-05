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

package androidx.wear.compose.material3.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import kotlin.jvm.JvmInline

@Composable
@ReadOnlyComposable
internal expect fun getString(string: Strings): String

@Composable
@ReadOnlyComposable
internal expect fun getString(string: Strings, vararg formatArgs: Any): String

@JvmInline
@Immutable
internal expect value class Strings(val value: Int) {
    companion object {
        val SliderDecreaseIconContentDescription: Strings
        val SliderIncreaseIconContentDescription: Strings
        val AlertDialogContentDescriptionConfirmButton: Strings
        val AlertDialogContentDescriptionDismissButton: Strings
        val OpenOnPhoneContentDescriptionIcon: Strings
    }
}
