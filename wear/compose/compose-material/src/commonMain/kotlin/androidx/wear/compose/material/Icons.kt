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

package androidx.wear.compose.material

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.DefaultFillType
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal object Icons {
    internal object Filled {
        internal val Add: ImageVector
            get() {
                if (_add != null) {
                    return _add!!
                }
                _add = materialIcon(name = "Filled.Add") {
                    materialPath {
                        moveTo(19.0f, 13.0f)
                        horizontalLineToRelative(-6.0f)
                        verticalLineToRelative(6.0f)
                        horizontalLineToRelative(-2.0f)
                        verticalLineToRelative(-6.0f)
                        horizontalLineTo(5.0f)
                        verticalLineToRelative(-2.0f)
                        horizontalLineToRelative(6.0f)
                        verticalLineTo(5.0f)
                        horizontalLineToRelative(2.0f)
                        verticalLineToRelative(6.0f)
                        horizontalLineToRelative(6.0f)
                        verticalLineToRelative(2.0f)
                        close()
                    }
                }
                return _add!!
            }

        private var _add: ImageVector? = null
    }

    internal object Outlined {
        internal val Delete: ImageVector
            get() {
                if (_delete != null) {
                    return _delete!!
                }
                _delete = materialIcon(name = "Outlined.Delete") {
                    materialPath {
                        moveTo(16.0f, 9.0f)
                        verticalLineToRelative(10.0f)
                        horizontalLineTo(8.0f)
                        verticalLineTo(9.0f)
                        horizontalLineToRelative(8.0f)
                        moveToRelative(-1.5f, -6.0f)
                        horizontalLineToRelative(-5.0f)
                        lineToRelative(-1.0f, 1.0f)
                        horizontalLineTo(5.0f)
                        verticalLineToRelative(2.0f)
                        horizontalLineToRelative(14.0f)
                        verticalLineTo(4.0f)
                        horizontalLineToRelative(-3.5f)
                        lineToRelative(-1.0f, -1.0f)
                        close()
                        moveTo(18.0f, 7.0f)
                        horizontalLineTo(6.0f)
                        verticalLineToRelative(12.0f)
                        curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                        horizontalLineToRelative(8.0f)
                        curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                        verticalLineTo(7.0f)
                        close()
                    }
                }
                return _delete!!
            }

        private var _delete: ImageVector? = null

        internal val MoreVert: ImageVector
            get() {
                if (_moreVert != null) {
                    return _moreVert!!
                }
                _moreVert = materialIcon(name = "Outlined.MoreVert") {
                    materialPath {
                        moveTo(12.0f, 8.0f)
                        curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                        reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
                        reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f)
                        reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
                        close()
                        moveTo(12.0f, 10.0f)
                        curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
                        reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
                        reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f)
                        reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
                        close()
                        moveTo(12.0f, 16.0f)
                        curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
                        reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
                        reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f)
                        reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
                        close()
                    }
                }
                return _moreVert!!
            }

        private var _moreVert: ImageVector? = null
    }
}

internal inline fun materialIcon(
    name: String,
    block: ImageVector.Builder.() -> ImageVector.Builder
): ImageVector =
    ImageVector.Builder(
        name = name,
        defaultWidth = MaterialIconDimension.dp,
        defaultHeight = MaterialIconDimension.dp,
        viewportWidth = MaterialIconDimension,
        viewportHeight = MaterialIconDimension
    )
        .block()
        .build()

internal inline fun ImageVector.Builder.materialPath(
    fillAlpha: Float = 1f,
    strokeAlpha: Float = 1f,
    pathFillType: PathFillType = DefaultFillType,
    pathBuilder: PathBuilder.() -> Unit
) =
    path(
        fill = SolidColor(Color.Black),
        fillAlpha = fillAlpha,
        stroke = null,
        strokeAlpha = strokeAlpha,
        strokeLineWidth = 1f,
        strokeLineCap = StrokeCap.Butt,
        strokeLineJoin = StrokeJoin.Bevel,
        strokeLineMiter = 1f,
        pathFillType = pathFillType,
        pathBuilder = pathBuilder
    )

// All Material icons (currently) are 24dp by 24dp, with a viewport size of 24 by 24.
private const val MaterialIconDimension = 24f
