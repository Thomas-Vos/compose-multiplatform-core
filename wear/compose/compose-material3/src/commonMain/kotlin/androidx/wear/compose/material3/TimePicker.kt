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
 * Represents the colors used by a [TimePicker].
 *
 * @param selectedPickerContentColor The content color of selected picker.
 * @param unselectedPickerContentColor The content color of unselected pickers.
 * @param separatorColor The color of separator between the pickers.
 * @param pickerLabelColor The color of the picker label.
 * @param confirmButtonContentColor The content color of the confirm button.
 * @param confirmButtonContainerColor The container color of the confirm button.
 */
@Immutable
public class TimePickerColors(
    public val selectedPickerContentColor: Color,
    public val unselectedPickerContentColor: Color,
    public val separatorColor: Color,
    public val pickerLabelColor: Color,
    public val confirmButtonContentColor: Color,
    public val confirmButtonContainerColor: Color,
) {
    /**
     * Returns a copy of this TimePickerColors( optionally overriding some of the values.
     *
     * @param selectedPickerContentColor The content color of selected picker.
     * @param unselectedPickerContentColor The content color of unselected pickers.
     * @param separatorColor The color of separator between the pickers.
     * @param pickerLabelColor The color of the picker label.
     * @param confirmButtonContentColor The content color of the confirm button.
     * @param confirmButtonContainerColor The container color of the confirm button.
     */
    public fun copy(
        selectedPickerContentColor: Color = this.selectedPickerContentColor,
        unselectedPickerContentColor: Color = this.unselectedPickerContentColor,
        separatorColor: Color = this.separatorColor,
        pickerLabelColor: Color = this.pickerLabelColor,
        confirmButtonContentColor: Color = this.confirmButtonContentColor,
        confirmButtonContainerColor: Color = this.confirmButtonContainerColor,
    ): TimePickerColors =
        TimePickerColors(
            selectedPickerContentColor =
                selectedPickerContentColor.takeOrElse { this.selectedPickerContentColor },
            unselectedPickerContentColor =
                unselectedPickerContentColor.takeOrElse { this.unselectedPickerContentColor },
            separatorColor = separatorColor.takeOrElse { this.separatorColor },
            pickerLabelColor = pickerLabelColor.takeOrElse { this.pickerLabelColor },
            confirmButtonContentColor =
                confirmButtonContentColor.takeOrElse { this.confirmButtonContentColor },
            confirmButtonContainerColor =
                confirmButtonContainerColor.takeOrElse { this.confirmButtonContainerColor },
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is TimePickerColors) return false

        if (selectedPickerContentColor != other.selectedPickerContentColor) return false
        if (unselectedPickerContentColor != other.unselectedPickerContentColor) return false
        if (separatorColor != other.separatorColor) return false
        if (pickerLabelColor != other.pickerLabelColor) return false
        if (confirmButtonContentColor != other.confirmButtonContentColor) return false
        if (confirmButtonContainerColor != other.confirmButtonContainerColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = selectedPickerContentColor.hashCode()
        result = 31 * result + unselectedPickerContentColor.hashCode()
        result = 31 * result + separatorColor.hashCode()
        result = 31 * result + pickerLabelColor.hashCode()
        result = 31 * result + confirmButtonContentColor.hashCode()
        result = 31 * result + confirmButtonContainerColor.hashCode()

        return result
    }
}
