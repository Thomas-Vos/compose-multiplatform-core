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

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

/**
 * Colors for [DatePicker].
 *
 * @param activePickerContentColor The content color of the currently active picker, that is, the
 *   picker currently being changed, such as the day, month or year.
 * @param inactivePickerContentColor The content color of an inactive picker.
 * @param invalidPickerContentColor The content color of invalid picker options. Picker options can
 *   be invalid when minValidDate or maxValidDate are specified for the [DatePicker].
 * @param pickerLabelColor The color of the picker label.
 * @param nextButtonContentColor The content color of the next button.
 * @param nextButtonContainerColor The container color of the next button.
 * @param confirmButtonContentColor The content color of the confirm button.
 * @param confirmButtonContainerColor The container color of the confirm button.
 */
@Immutable
public class DatePickerColors(
    public val activePickerContentColor: Color,
    public val inactivePickerContentColor: Color,
    public val invalidPickerContentColor: Color,
    public val pickerLabelColor: Color,
    public val nextButtonContentColor: Color,
    public val nextButtonContainerColor: Color,
    public val confirmButtonContentColor: Color,
    public val confirmButtonContainerColor: Color,
) {
    /**
     * Returns a copy of this DatePickerColors, optionally overriding some of the values.
     *
     * @param activePickerContentColor The content color of the currently active picker, that is,
     *   the picker currently being changed, such as the day, month or year.
     * @param inactivePickerContentColor The content color of an inactive picker.
     * @param invalidPickerContentColor The content color of invalid picker options.
     * @param pickerLabelColor The color of the picker label.
     * @param nextButtonContentColor The content color of the next button.
     * @param nextButtonContainerColor The container color of the next button.
     * @param confirmButtonContentColor The content color of the confirm button.
     * @param confirmButtonContainerColor The container color of the confirm button.
     */
    public fun copy(
        activePickerContentColor: Color = this.activePickerContentColor,
        inactivePickerContentColor: Color = this.inactivePickerContentColor,
        invalidPickerContentColor: Color = this.invalidPickerContentColor,
        pickerLabelColor: Color = this.pickerLabelColor,
        nextButtonContentColor: Color = this.nextButtonContentColor,
        nextButtonContainerColor: Color = this.nextButtonContainerColor,
        confirmButtonContentColor: Color = this.confirmButtonContentColor,
        confirmButtonContainerColor: Color = this.confirmButtonContainerColor,
    ): DatePickerColors =
        DatePickerColors(
            activePickerContentColor =
                activePickerContentColor.takeOrElse { this.activePickerContentColor },
            inactivePickerContentColor =
                inactivePickerContentColor.takeOrElse { this.inactivePickerContentColor },
            invalidPickerContentColor =
                invalidPickerContentColor.takeOrElse { this.invalidPickerContentColor },
            pickerLabelColor = pickerLabelColor.takeOrElse { this.pickerLabelColor },
            nextButtonContentColor =
                nextButtonContentColor.takeOrElse { this.nextButtonContentColor },
            nextButtonContainerColor =
                nextButtonContainerColor.takeOrElse { this.nextButtonContainerColor },
            confirmButtonContentColor =
                confirmButtonContentColor.takeOrElse { this.confirmButtonContentColor },
            confirmButtonContainerColor =
                confirmButtonContainerColor.takeOrElse { this.confirmButtonContainerColor },
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is DatePickerColors) return false

        if (activePickerContentColor != other.activePickerContentColor) return false
        if (inactivePickerContentColor != other.inactivePickerContentColor) return false
        if (invalidPickerContentColor != other.invalidPickerContentColor) return false
        if (pickerLabelColor != other.pickerLabelColor) return false
        if (nextButtonContentColor != other.nextButtonContentColor) return false
        if (nextButtonContainerColor != other.nextButtonContainerColor) return false
        if (confirmButtonContentColor != other.confirmButtonContentColor) return false
        if (confirmButtonContainerColor != other.confirmButtonContainerColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = activePickerContentColor.hashCode()
        result = 31 * result + inactivePickerContentColor.hashCode()
        result = 31 * result + invalidPickerContentColor.hashCode()
        result = 31 * result + pickerLabelColor.hashCode()
        result = 31 * result + nextButtonContentColor.hashCode()
        result = 31 * result + nextButtonContainerColor.hashCode()
        result = 31 * result + confirmButtonContentColor.hashCode()
        result = 31 * result + confirmButtonContainerColor.hashCode()

        return result
    }
}
