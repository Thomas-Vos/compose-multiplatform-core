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

package androidx.wear.compose.material3

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

/**
 * Represents the colors used in [ConfirmationDialog], [SuccessConfirmationDialog] and
 * [FailureConfirmationDialog].
 *
 * @param iconColor Color used to tint the icon.
 * @param iconContainerColor The color of the container behind the icon.
 * @param textColor Color used to tint the text.
 */
public class ConfirmationDialogColors(
    public val iconColor: Color,
    public val iconContainerColor: Color,
    public val textColor: Color,
) {
    /**
     * Returns a copy of this ConfirmationColors, optionally overriding some of the values.
     *
     * @param iconColor Color used to tint the icon.
     * @param iconContainerColor The color of the container behind the icon.
     * @param textColor Color used to tint the text.
     */
    public fun copy(
        iconColor: Color = this.iconColor,
        iconContainerColor: Color = this.iconContainerColor,
        textColor: Color = this.textColor,
    ): ConfirmationDialogColors =
        ConfirmationDialogColors(
            iconColor = iconColor.takeOrElse { this.iconColor },
            iconContainerColor = iconContainerColor.takeOrElse { this.iconContainerColor },
            textColor = textColor.takeOrElse { this.textColor },
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ConfirmationDialogColors) return false

        if (iconColor != other.iconColor) return false
        if (iconContainerColor != other.iconContainerColor) return false
        if (textColor != other.textColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = iconColor.hashCode()
        result = 31 * result + iconContainerColor.hashCode()
        result = 31 * result + textColor.hashCode()
        return result
    }
}
